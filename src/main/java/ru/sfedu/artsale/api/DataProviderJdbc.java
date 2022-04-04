package ru.sfedu.artsale.api;

import ru.sfedu.artsale.model.bean.*;

import java.io.IOException;
import java.util.List;

public class DataProviderJdbc extends AbstractDataProvider{

    protected DataProviderJdbc() throws IOException {
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public long insertUser(User user) {
        return 0;
    }

    @Override
    public boolean deleteUser(long id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public Order getOrder(long id) {
        return null;
    }

    @Override
    public long insertOrder(Order order) {
        return 0;
    }

    @Override
    public boolean deleteOrder(long id) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(long id) {
        return null;
    }

    @Override
    public long insertProduct(Product product) {
        return 0;
    }

    @Override
    public boolean deleteProduct(long id) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public List<CreationKit> getCreationKits() {
        return null;
    }

    @Override
    public CreationKit getCreationKit(long id) {
        return null;
    }

    @Override
    public long insertCreationKit(CreationKit creationKit) {
        return 0;
    }

    @Override
    public boolean deleteCreationKit(long id) {
        return false;
    }

    @Override
    public boolean updateCreationKit(CreationKit creationKit) {
        return false;
    }

    @Override
    public List<EndProduct> getEndProducts() {
        return null;
    }

    @Override
    public EndProduct getEndProduct(long id) {
        return null;
    }

    @Override
    public long insertEndProduct(EndProduct endProduct) {
        return 0;
    }

    @Override
    public boolean deleteEndProduct(long id) {
        return false;
    }

    @Override
    public boolean updateEndProduct(EndProduct endProduct) {
        return false;
    }
}
