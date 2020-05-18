package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class StrategyInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the interface name which the strategy classes implement ");
            String objectInterface = sc.nextLine();
            HashSet<String> interfaceMethods = getMethodsInput();
            generatorFacade.createFiles(objectInterface, new HashSet<>(), interfaceMethods, null, config.getString("path.interface-ftl"));


            System.out.println("Enter the number of classes which implement the interface");
            int numberOfClasses = sc.nextInt();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for class " + (i + 1));
                String className = sc.next();
                generatorFacade.createFiles(className, new HashSet<>(), interfaceMethods, objectInterface, config.getString("path.implementor-class-ftl"));
            }
            System.out.println("Enter the context class' name ");
            String contextClass = sc.next();
            generatorFacade.createFiles(contextClass, new HashSet<>(Arrays.asList(Helper.toMemberString(objectInterface))), interfaceMethods, null, config.getString("path.strategy-context-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}

