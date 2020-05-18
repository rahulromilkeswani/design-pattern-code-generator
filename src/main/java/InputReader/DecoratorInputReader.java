package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class DecoratorInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the abstract class name which the component class extends ");
            String componentAbstractClass = sc.next();
            HashSet<String> classMethods = getMethodsInput();
            generatorFacade.createFiles(componentAbstractClass, new HashSet<>(), classMethods, null, config.getString("path.abstract-class-ftl"));

            System.out.println("Enter the component class name ");
            String componentClassName = sc.next();
            generatorFacade.createFiles(componentClassName, new HashSet<>(), classMethods, componentAbstractClass, config.getString("path.concrete-class-ftl"));

            System.out.println("Enter the abstract class' name which the decorator extends ");
            String decoratorAbstractClass = sc.next();
            generatorFacade.createFiles(decoratorAbstractClass, new HashSet<>(), classMethods, componentAbstractClass, config.getString("path.decorator-abstract-class-ftl"));

            System.out.println("Enter the number of decorator classes ");
            int numberOfClasses = sc.nextInt();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for class " + (i + 1));
                String receiverName = sc.next();
                generatorFacade.createFiles(receiverName, new HashSet<>(), classMethods, Helper.toParentString(decoratorAbstractClass, componentAbstractClass), config.getString("path.decorator-concrete-class-ftl"));
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
