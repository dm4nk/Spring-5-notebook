package beans;

import beans.Oracle;
import common.Constants;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactory {

	public static void main(String... args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
		rdr.loadBeanDefinitions(new ClassPathResource(Constants.XML_BEAN_FACTORY_CONFIG));
		Oracle oracle = factory.getBean(Constants.ORACLE, Oracle.class);
		System.out.println(oracle.defineMeaningOfLife());
	}
}
