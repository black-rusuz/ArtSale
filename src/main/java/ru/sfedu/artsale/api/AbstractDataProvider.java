package ru.sfedu.artsale.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.artsale.Constants;
import ru.sfedu.artsale.model.HistoryContent;
import ru.sfedu.artsale.model.Result;
import ru.sfedu.artsale.model.bean.*;
import ru.sfedu.artsale.utils.ConfigurationUtil;
import ru.sfedu.artsale.utils.MongoUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDataProvider {
    protected final Logger log = LogManager.getLogger(this.getClass());
    private final boolean MONGO_ENABLE = Boolean.parseBoolean(ConfigurationUtil.getConfigurationEntry(Constants.MONGO_ENABLE));
    private final String MONGO_ACTOR = ConfigurationUtil.getConfigurationEntry(Constants.MONGO_ACTOR);

    protected AbstractDataProvider() throws IOException {
    }

    // TODO: UseCases

    // Service
    protected void sendLogs(String methodName, Object bean, Result result) {
        HistoryContent historyContent = new HistoryContent(
                UUID.randomUUID(),
                this.getClass().getSimpleName(),
                LocalDateTime.now().toString(),
                MONGO_ACTOR,
                methodName,
                MongoUtil.objectToString(bean),
                result);
        if (MONGO_ENABLE) MongoUtil.saveToLog(historyContent);
    }

    // CRUD
    public abstract List<User> getUsers();
    public abstract User getUser(long id);
    public abstract long insertUser(User user);
    public abstract boolean deleteUser(long id);
    public abstract boolean updateUser(User user);

    public abstract List<Order> getOrders();
    public abstract Order getOrder(long id);
    public abstract long insertOrder(Order order);
    public abstract boolean deleteOrder(long id);
    public abstract boolean updateOrder(Order order);

    public abstract List<Product> getProducts();
    public abstract Product getProduct(long id);
    public abstract long insertProduct(Product product);
    public abstract boolean deleteProduct(long id);
    public abstract boolean updateProduct(Product product);

    public abstract List<CreationKit> getCreationKits();
    public abstract CreationKit getCreationKit(long id);
    public abstract long insertCreationKit(CreationKit creationKit);
    public abstract boolean deleteCreationKit(long id);
    public abstract boolean updateCreationKit(CreationKit creationKit);

    public abstract List<EndProduct> getEndProducts();
    public abstract EndProduct getEndProduct(long id);
    public abstract long insertEndProduct(EndProduct endProduct);
    public abstract boolean deleteEndProduct(long id);
    public abstract boolean updateEndProduct(EndProduct endProduct);
}
