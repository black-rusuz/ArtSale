package ru.sfedu.artsale.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;
import ru.sfedu.artsale.model.bean.CreationKit;
import ru.sfedu.artsale.model.bean.EndProduct;
import ru.sfedu.artsale.model.bean.Order;
import ru.sfedu.artsale.model.bean.User;

import java.io.Serializable;
import java.util.List;

@Root(name = "List")
public class XmlWrapper<T> implements Serializable {

    @ElementListUnion({
            @ElementList(entry = "Balance", inline = true, required = false, type = User.class),
            @ElementList(entry = "Plan", inline = true, required = false, type = Order.class),
            @ElementList(entry = "Income", inline = true, required = false, type = CreationKit.class),
            @ElementList(entry = "Outcome", inline = true, required = false, type = EndProduct.class),
    })
    private List<T> list;

    public XmlWrapper() {
    }

    public XmlWrapper(List<T> list) {
        setList(list);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
