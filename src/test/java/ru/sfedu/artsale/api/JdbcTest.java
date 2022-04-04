package ru.sfedu.artsale.api;

import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class JdbcTest extends CrudTest {

    @BeforeEach
    void setUp() throws IOException {
        dataProvider = new DataProviderJdbc();
    }
}
