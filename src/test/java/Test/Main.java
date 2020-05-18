package Test;
import Facade.GeneratorFacade;
import Parser.YamlParser;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String args[]) {
        Logger logger = LoggerFactory.getLogger(TestSuite.class);
        Result result = JUnitCore.runClasses(TestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            logger.info(failure.toString());
        }

        if(result.wasSuccessful()){
            logger.info("All tests passed successfully");
            System.out.println("All tests passed successfully");
        }
    }

}
