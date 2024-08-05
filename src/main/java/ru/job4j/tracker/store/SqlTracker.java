package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author artem.polschak@gmail.com on 30.06.2022.
 * @project job4j_tracker
 */

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    /**
     * Method connection to DB
      */
    public void init() {
        try (InputStream in =
                     SqlTracker.class.getClassLoader()
                             .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw  new IllegalArgumentException();
        }
    }

    /**
     * Method add new Item to DB
     * @param item which adding to DB
     * @return item
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement(
                             "insert into items(name, created) values (?, ?) returning id;")) {
            Timestamp timestamp = Timestamp.valueOf(item.getCreated());
            statement.setString(1, item.getName());
            statement.setTimestamp(2, timestamp);
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                if (resultSet.next()) {
                    item.setId(resultSet.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Method replace old item to new one
     * @param id from old item
     * @param item which will be added to replace the old
     */
    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement(
                             "update items set name = ?, created = ? where id = ?")) {
            Timestamp timestamp = Timestamp.valueOf(item.getCreated());
            statement.setString(1, item.getName());
            statement.setTimestamp(2, timestamp);
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }

    /**
     * Method delete item by id
     * @param id for item which has to be deleted
     * @return true if item deleted
     */
    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method takes data from the DB to create an item
     * @param resultSet DB
     * @return item with data
     */
    private Item extracted(ResultSet resultSet) throws SQLException {
        
        return new Item(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("created").toLocalDateTime()
        );
    }

    /**
     * Method finding all items in DB
     * @return List with all items from DB
     */
    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(extracted(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Method find an item by Name <key>
     * @param key name of item
     * @return List with all items to meets the condition
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(extracted(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Method find an item by id
     * @param id for searching item in DB
     * @return new Item from DB
     */
    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = extracted(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Method closing DB connection
     */
    @Override
    public void close() throws Exception {
        cn.close();
    }
}
