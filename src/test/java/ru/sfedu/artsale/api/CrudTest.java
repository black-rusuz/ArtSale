package ru.sfedu.artsale.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sfedu.artsale.utils.TestData;

import java.io.IOException;
import java.util.List;

abstract class CrudTest extends TestData {
    AbstractDataProvider dataProvider;
    Logger log = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() throws IOException {
        dataProvider.insertUser(u1);
        dataProvider.insertUser(u2);

        dataProvider.insertProduct(p1);
        dataProvider.insertProduct(p2);
        dataProvider.insertProduct(p3);
        dataProvider.insertProduct(p4);

        dataProvider.insertCreationKit(ck1);
        dataProvider.insertCreationKit(ck2);
        dataProvider.insertCreationKit(ck3);
        dataProvider.insertCreationKit(ck4);

        dataProvider.insertEndProduct(ep1);
        dataProvider.insertEndProduct(ep2);
        dataProvider.insertEndProduct(ep3);
        dataProvider.insertEndProduct(ep4);

        dataProvider.insertOrder(o1);
        dataProvider.insertOrder(o2);
    }

    @AfterEach
    void tearDown() {
        dataProvider.deleteUser(u1.getId());
        dataProvider.deleteUser(u2.getId());

        dataProvider.deleteProduct(p1.getId());
        dataProvider.deleteProduct(p2.getId());
        dataProvider.deleteProduct(p3.getId());
        dataProvider.deleteProduct(p4.getId());

        dataProvider.deleteCreationKit(ck1.getId());
        dataProvider.deleteCreationKit(ck2.getId());
        dataProvider.deleteCreationKit(ck3.getId());
        dataProvider.deleteCreationKit(ck4.getId());

        dataProvider.deleteEndProduct(ep1.getId());
        dataProvider.deleteEndProduct(ep2.getId());
        dataProvider.deleteEndProduct(ep3.getId());
        dataProvider.deleteEndProduct(ep4.getId());

        dataProvider.deleteOrder(o1.getId());
        dataProvider.deleteOrder(o2.getId());
    }

    @Test
    void test() {
        log.info(dataProvider.insertUser(u1));
    }

    @Test
    void getUsers() {
        Assertions.assertEquals(List.of(u1, u2), dataProvider.getUsers());
    }

    @Test
    void getUser() {
    }

    @Test
    void insertUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getOrders() {
    }

    @Test
    void getOrder() {
    }

    @Test
    void insertOrder() {
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void updateOrder() {
    }

    @Test
    void getProducts() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void insertProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void getCreationKits() {
    }

    @Test
    void getCreationKit() {
    }

    @Test
    void insertCreationKit() {
    }

    @Test
    void deleteCreationKit() {
    }

    @Test
    void updateCreationKit() {
    }

    @Test
    void getEndProducts() {
    }

    @Test
    void getEndProduct() {
    }

    @Test
    void insertEndProduct() {
    }

    @Test
    void deleteEndProduct() {
    }

    @Test
    void updateEndProduct() {
    }
}