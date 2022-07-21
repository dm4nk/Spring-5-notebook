package example.methodreplacement;

import common.Constants;
import common.Files;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementDemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(Files.REPLACEMENT_CTX);
        ctx.refresh();

        ReplacementTarget replacementTarget = ctx.getBean(Constants.REPLACEMENT_TARGET, ReplacementTarget.class);
        ReplacementTarget standardTarget = ctx.getBean(Constants.STANDARD_TARGET, ReplacementTarget.class);

        displayInfo(replacementTarget);
        displayInfo(standardTarget);

        ctx.close();
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Thanks for playing, try again!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int x = 0; x < 1000000; x++) {
            target.formatMessage("No filter in my head");
        }

        stopWatch.stop();

        System.out.println("1000000 invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
