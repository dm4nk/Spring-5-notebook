package example.defaultbeanusage;

import common.Constants;
import common.Files;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactory {

    public static void main(String... args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new ClassPathResource(Files.XML_BEAN_FACTORY_CTX));
        Oracle oracle = factory.getBean(Constants.ORACLE, Oracle.class);
        System.out.println(oracle.defineMeaningOfLife());
    }
}
