import java.util.Scanner;
import InputReader.*;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import Factory.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Config config = ConfigFactory.parseResources("ConfigFiles/Values.conf");
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String args[]) throws Exception {
        try {
            logger.info("Main method called");
            System.out.println(config.getString("string.menu-text"));
            int option = sc.nextInt();

            //initialize input reader object using the Factory Method pattern
            InputReaderFactory inputReaderFactory = new InputReaderFactory();
            InputReader inputReader = inputReaderFactory.createReader(option);

            //template method
            inputReader.getPatternInput();
            System.out.println(config.getString("string.execution-message"));
            logger.info("Main method ended");

        } catch (Exception e) {
            logger.error(e.toString());
            logger.info("Program terminated abruptly");
        }
    }

}
