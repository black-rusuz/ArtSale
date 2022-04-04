package ru.sfedu.artsale.model.bean;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Element
public class Order implements Serializable {

    @Attribute
    @CsvBindByPosition(position = 0)
    private long id;

    @Element
    @CsvBindByPosition(position = 1)
    private User customer = new User();

    @Element
    @CsvBindByPosition(position = 2)
    private Product product = new Product();

    public Order() {
    }

    public Order(long id, User customer, Product product) {
        setId(id);
        setCustomer(customer);
        setProduct(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId() == order.getId()
                && Objects.equals(getCustomer(), order.getCustomer())
                && Objects.equals(getProduct(), order.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer(), getProduct());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", customer=" + getCustomer() +
                ", product=" + getProduct() +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
