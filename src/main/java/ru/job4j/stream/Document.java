package ru.job4j.stream;

import java.util.Objects;

public class Document {
    private String nameOfDocument;
    private int numberOfOrder;
    private String nameOfProduct;
    private String mailOfClient;
    private boolean orderStatus;
    private String nameOfClient;
    private String phoneNumber;

    static class Builder {
        private String nameOfDocument;
        private int numberOfOrder;
        private String nameOfProduct;
        private String mailOfClient;
        private boolean orderStatus;
        private String nameOfClient;
        private String phoneNumber;

        Builder buildNameOfDocument(String nameOfDocument) {
            this.nameOfDocument = nameOfDocument;
            return this;
        }

        Builder buildNumberOfOrder(int numberOfOrder) {
            this.numberOfOrder = numberOfOrder;
            return this;
        }

        Builder buildNameOfProduct(String nameOfProduct) {
            this.nameOfProduct = nameOfProduct;
            return this;
        }

        Builder buildMailOfClient(String mailOfClient) {
            this.mailOfClient = mailOfClient;
            return this;
        }

        Builder buildOrderStatus(boolean orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        Builder buildNameOfClient(String nameOfClient) {
            this.nameOfClient = nameOfClient;
            return this;
        }

        Builder buildPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        Document build() {
            Document document = new Document();
            document.nameOfDocument = nameOfDocument;
            document.numberOfOrder = numberOfOrder;
            document.nameOfProduct = nameOfProduct;
            document.mailOfClient = mailOfClient;
            document.orderStatus = orderStatus;
            document.nameOfClient = nameOfClient;
            document.phoneNumber = phoneNumber;
            return document;
        }
    }

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(String nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getMailOfClient() {
        return mailOfClient;
    }

    public void setMailOfClient(String mailOfClient) {
        this.mailOfClient = mailOfClient;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNameOfClient() {
        return nameOfClient;
    }

    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Document document)) {
            return false;
        }
        return getNumberOfOrder() == document.getNumberOfOrder()
                && isOrderStatus() == document.isOrderStatus()
                && getPhoneNumber() == document.getPhoneNumber()
                && Objects.equals(getNameOfDocument(), document.getNameOfDocument())
                && Objects.equals(getNameOfProduct(), document.getNameOfProduct())
                && Objects.equals(getMailOfClient(), document.getMailOfClient())
                && Objects.equals(getNameOfClient(), document.getNameOfClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfDocument(),
                getNumberOfOrder(), getNameOfProduct(),
                getMailOfClient(), isOrderStatus(),
                getNameOfClient(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Document{" + "nameOfDocument='" + nameOfDocument
                + '\'' + ", numberOfOrder=" + numberOfOrder
                + ", nameOfProduct='" + nameOfProduct
                + '\'' + ", mailOfClient='" + mailOfClient
                + '\'' + ", orderStatus=" + orderStatus
                + ", nameOfClient='" + nameOfClient
                + '\'' + ", phoneNumber=" + phoneNumber + '}';
    }

    public static void main(String[] args) {
        Document document = new Builder().buildNameOfDocument("Factura for client")
                .buildNumberOfOrder(234)
                .buildNameOfProduct("TV SAMSUNG QE55Q60")
                .buildMailOfClient("clientName@gmail.com")
                .buildOrderStatus(true)
                .buildNameOfClient("Nikolay Churin")
                .buildPhoneNumber("3 8064 854 78 56")
                .build();
        System.out.println(document);
    }
}
