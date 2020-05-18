package InputReader;

import Utility.Helper;

import java.util.HashSet;

public class FacadeInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the number of classes in the subsystem ");
            HashSet<String> classNames = new HashSet<>();
            int numberOfClasses = sc.nextInt();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for Class " + (i + 1));
                String className = sc.next();
                classNames.add(Helper.toMemberString(className));
                HashSet<String> classMethods = getMethodsInput();
                generatorFacade.createFiles(className, new HashSet<>(), classMethods, null, config.getString("path.class-ftl"));
            }
            System.out.println("Enter the abstract class name the facade extends ");
            String facadeAbstractClass = sc.next();
            HashSet<String> classMethods = getMethodsInput();
            generatorFacade.createFiles(facadeAbstractClass, new HashSet<>(), classMethods, null, config.getString("path.abstract-class-ftl"));

            System.out.println("Enter the facade class' name ");
            String facadeClassName = sc.next();
            generatorFacade.createFiles(facadeClassName, classNames, classMethods, facadeAbstractClass, config.getString("path.facade-concrete-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

}
