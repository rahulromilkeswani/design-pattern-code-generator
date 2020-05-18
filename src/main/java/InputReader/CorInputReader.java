package InputReader;

import Utility.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Handler;

public class CorInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the handler class' name ");
            String handlerName = sc.nextLine();
            HashSet<String> classMethods = getMethodsInput();
            generatorFacade.createFiles(handlerName, new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.successor-text"), handlerName))), classMethods, null, config.getString("path.cor-abstract-class-ftl"));

            System.out.println("Enter the number of receivers ");
            int numberOfReceivers = sc.nextInt();

            for (int i = 0; i < numberOfReceivers; i++) {
                System.out.println("Enter the name for receiver " + (i + 1));
                String receiverName = sc.next();
                String ftlPath = config.getString("path.cor-receiver-class-ftl");
                if (i == (numberOfReceivers - 1)) {
                    ftlPath = config.getString("path.cor-final-receiver-class-ftl");
                }
                generatorFacade.createFiles(receiverName, new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.successor-text"), handlerName))), classMethods, handlerName, ftlPath);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
