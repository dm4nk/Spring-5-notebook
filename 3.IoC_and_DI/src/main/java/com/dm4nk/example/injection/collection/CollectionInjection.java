package com.dm4nk.example.injection.collection;

import com.dm4nk.common.Constants;
import com.dm4nk.common.Files;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
@Getter
@Setter
public class CollectionInjection {
    @Autowired
    @Qualifier("map") // коллекции можно внедрять или комбинацией этих двух аннотаций (нежелательно)
    private Map<String, Object> map;

    @Resource(name = "props") // или одной вот этой
    private Properties props;

    @Resource(name = "set")
    private Set<Object> set;

    @Resource(name = "list")
    private List<Object> list;

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(Files.COLLECTIONS_CTX);
        ctx.refresh();

        CollectionInjection instance = ctx.getBean(Constants.INJECT_COLLECTION, CollectionInjection.class);
        instance.displayInfo();

        ctx.close();
    }

    public void displayInfo() {
        System.out.println("Map contents:\n");
        map.forEach((key, value) -> System.out.println("Key: " + key + " - Value: " + value));

        System.out.println("\nProperties contents:\n");
        props.forEach((key, value) -> System.out.println("Key: " + key + " - Value: " + value));

        System.out.println("\nSet contents:\n");
        set.forEach(obj -> System.out.println("Value: " + obj));

        System.out.println("\nList contents:\n");
        list.forEach(obj -> System.out.println("Value: " + obj));
    }

}
