package example.constructorconfusion;

import common.Constants;
import common.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("constructorConfusion")
public class ConstructorConfusion {

	private String someValue;

	public ConstructorConfusion(String someValue) {
		System.out.println("ConstructorConfusion(String) called");
		this.someValue = someValue;
	}

	@Autowired
	public ConstructorConfusion(@Value("90") int someValue) {
		System.out.println("ConstructorConfusion(int) called");
		this.someValue = "Number: " + someValue;
	}

	public String toString() {
		return someValue;
	}

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:" + Files.CONSTRUCTOR_CONFUSION_CTX);
		ctx.refresh();

		ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean(Constants.CONSTRUCTOR_CONFUSION);
		System.out.println(cc);
		ctx.close();
	}
}
