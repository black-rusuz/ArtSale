package ru.sfedu.artsale.utils;

import com.opencsv.bean.AbstractBeanField;
import ru.sfedu.artsale.model.bean.Product;
import ru.sfedu.artsale.model.bean.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter extends AbstractBeanField<Product, String> {
    public static final String fieldsDelimiter = "::";

    @Override
    protected Object convert(String s) {
        String[] parsed = s.split(fieldsDelimiter);
        return new User(Long.parseLong(parsed[0]), parsed[1], parsed[2], parsed[3], parsed[4]);
    }

    @Override
    public String convertToWrite(Object object) {
        User user = (User) object;
        List params = List.of(user.getId(),
                user.getName(),
                user.getPhone(),
                user.getEmail(),
                user.getAddress());
        return (String) params.stream().map(Object::toString).collect(Collectors.joining(fieldsDelimiter));
        //return String.join(fieldsDelimiter, params);
    }
}
