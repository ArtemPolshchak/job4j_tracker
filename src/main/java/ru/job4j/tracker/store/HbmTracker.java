package ru.job4j.tracker.store;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@AllArgsConstructor
public class HbmTracker implements Store {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean success = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            int updatedCount = session.createQuery(
            "UPDATE Item i SET i.name = :name, i.created = :created WHERE i.id = :id")
            .setParameter("name", item.getName())
                    .setParameter("created", item.getCreated())
                    .setParameter("id", id)
                    .executeUpdate();

            session.getTransaction().commit();

            success = updatedCount > 0;

        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return success;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE from Item where id = :fid ")
                    .setParameter("fid", id)
                    .executeUpdate();
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> result = new ArrayList<>();
        try {
            session.beginTransaction();
            result = session.createQuery("from Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> result = new ArrayList<>();
        try {
            session.beginTransaction();
            result = session.createQuery("from Item where name = :fkey", Item.class)
                    .setParameter("fkey", key)
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item result = new Item();
        try {
            session.beginTransaction();
            result = session.get(Item.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }
}
