package example.beaninit.context;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

import static common.Constants.*;


public class SingerConfigDemo {

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);

        Singer.getBean(SINGER_ONE, ctx);
        Singer.getBean(SINGER_TWO, ctx);
        Singer.getBean(SINGER_THREE, ctx);

        ctx.close();
    }

    @Configuration
    @NoArgsConstructor
    private static class SingerConfig {

        @Lazy
        @Bean(name = SINGER_ONE, initMethod = "init")
        Singer singerOne() {
            Singer singerOne = new Singer();
            singerOne.setName("John Mayer");
            singerOne.setAge(39);
            return singerOne;
        }

        @Lazy
        @Bean(name = SINGER_TWO, initMethod = "init")
        Singer singerTwo() {
            Singer singerTwo = new Singer();
            singerTwo.setAge(72);
            return singerTwo;
        }

        @Lazy
        @Bean(name = SINGER_THREE, initMethod = "init")
        Singer singerThree() {
            Singer singerThree = new Singer();
            singerThree.setName("John Butler");
            return singerThree;
        }
    }
}
