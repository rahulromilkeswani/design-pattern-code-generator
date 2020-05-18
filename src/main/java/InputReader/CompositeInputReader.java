package InputReader;

import java.util.Arrays;
import java.util.HashSet;

public class CompositeInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the abstract component class' name ");
            String componentAbstractClass = sc.next();
            generatorFacade.createFiles(componentAbstractClass, new HashSet<>(), new HashSet<>(), null, config.getString("path.component-abstract-class-ftl"));

            System.out.println("Enter the child class name ");
            String childClassName = sc.next();
            generatorFacade.createFiles(childClassName, new HashSet<>(), new HashSet<>(), componentAbstractClass, config.getString("path.component-child-class-ftl"));

            System.out.println("Enter the composite class name ");
            String compositeClassName = sc.next();
            generatorFacade.createFiles(compositeClassName, new HashSet<>(), new HashSet<>(), componentAbstractClass, config.getString("path.composite-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
