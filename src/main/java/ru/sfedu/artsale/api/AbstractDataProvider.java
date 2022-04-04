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
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractDataProvider {
    protected final Logger log = LogManager.getLogger(this.getClass());
    private final boolean MONGO_ENABLE = Boolean.parseBoolean(ConfigurationUtil.getConfigurationEntry(Constants.MONGO_ENABLE));
    private final String MONGO_ACTOR = ConfigurationUtil.getConfigurationEntry(Constants.MONGO_ACTOR);

    protected AbstractDataProvider() throws IOException {
    }

    /**
     * Показать доступные товары и заказать выбранный
     *
     * @param filter    Товары без категории, наборы для творчества, готовые произведения искусства или всё подряд (Products/CreationKits/EndProducts/Any)
     * @param productId ID товара для заказа
     * @return Список доступных товаров
     */
    public List<Product> viewProducts(String filter, long productId) {
        return null;
    }

    /**
     * Фильтр товаров
     *
     * @param filter Товары без категории, наборы для творчества, готовые произведения искусства или всё подряд (Products/CreationKits/EndProducts/Any)
     * @return Отфильтрованнный список доступных товаров
     */
    public List<Product> filterView(String filter) {
        return null;
    }

    /**
     * Заказ выбранного товара
     *
     * @param productId ID товара
     * @return Сформированный заказ для пользователя, чьи контактные данные были оставлены последними
     */
    public Optional<Order> orderProduct(long productId) {
        return Optional.empty();
    }

    /**
     * Оставить контактные данные для заказов
     *
     * @param name    имя
     * @param phone   телефон
     * @param email   почта
     * @param address адрес доставки
     * @return Созданный пользователь
     */
    public Optional<User> leaveUserData(String name, String phone, String email, String address) {
        return Optional.empty();
    }

    /**
     * Оставить контактные данные для связи
     *
     * @param name  имя
     * @param phone телефон
     * @param email почта
     * @return Созданные пользовательские данные
     */
    public Optional<User> leaveContactDetails(String name, String phone, String email) {
        return Optional.empty();
    }

    /**
     * Оставить контактные данные для доставки
     *
     * @param name    имя
     * @param address телефон
     * @return Созданные пользовательские данные
     */
    public Optional<User> leaveAddress(String name, String address) {
        return Optional.empty();
    }

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


    public abstract List<Order> getOrders();

    public abstract Order getOrder(long id);

    public abstract long insertOrder(Order order);

    public abstract boolean deleteOrder(long id);

    public abstract boolean updateOrder(Order order);
}
