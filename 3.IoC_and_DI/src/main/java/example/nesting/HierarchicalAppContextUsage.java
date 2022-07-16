package example.nesting;

import common.Constants;
import common.Files;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {

	public static void main(String... args) {
		GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
		parent.load("classpath:" + Files.PARENT_CTX);
		parent.refresh();

		GenericXmlApplicationContext child = new GenericXmlApplicationContext();
		child.load("classpath:" + Files.CHILD_CTX);
		child.setParent(parent);
		child.refresh();

		Song song1 = child.getBean(Constants.SONG_1, Song.class);
		Song song2 = child.getBean(Constants.SONG_2, Song.class);
		Song song3 = child.getBean(Constants.SONG_3, Song.class);

		System.out.println("from parent ctx: " + song1);
		System.out.println("from child ctx: " + song2);
		System.out.println("from parent ctx: " + song3);

		child.close();
		parent.close();
	}
}
