package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class VisitorInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the abstract class name which the visitor class extends ");
            String visitorAbstractName = sc.next();

            System.out.println("Enter the abstract class name which the element(s) class extend ");
            String elementAbstractName = sc.next();
            generatorFacade.createFiles(elementAbstractName, new HashSet<>(Arrays.asList(Helper.toMemberString(visitorAbstractName))), new HashSet<>(), null, config.getString("path.element-abstract-class-ftl"));

            System.out.println("Enter the number of element classes ");
            int numberOfClasses = sc.nextInt();
            HashSet<String> classNames = new HashSet<>();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for class " + (i + 1));
                String className = sc.next();
                classNames.add(Helper.toMemberString(className));
                generatorFacade.createFiles(className, new HashSet<>(Arrays.asList(Helper.toMemberString(visitorAbstractName))), new HashSet<>(), elementAbstractName, config.getString("path.element-concrete-class-ftl"));

            }

            generatorFacade.createFiles(visitorAbstractName, new HashSet<>(classNames), new HashSet<>(), null, config.getString("path.visitor-abstract-class-ftl"));

            System.out.println("Enter the visitor class name  ");
            String visitorClassName = sc.next();
            generatorFacade.createFiles(visitorClassName, new HashSet<>(classNames), new HashSet<>(), visitorAbstractName, config.getString("path.visitor-concrete-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
