package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FactoryMethodInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the interface name which the factory creates");
            String interfaceName = sc.next();
            HashSet<String> interfaceMethods = getMethodsInput();
            generatorFacade.createFiles(interfaceName, new HashSet<>(), interfaceMethods, null, config.getString("path.interface-ftl"));

            HashSet<String> classNames = new HashSet<>();
            System.out.println("Enter the number of classes which implement interface ");
            int numberOfClasses = sc.nextInt();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for class " + (i + 1));
                String className = sc.next();
                classNames.add(className);
                generatorFacade.createFiles(className, new HashSet<>(), interfaceMethods, interfaceName, config.getString("path.implementor-class-ftl"));
            }

            System.out.println("Enter the abstract class' name which the factory extends");
            String abstractClassName = sc.next();
            String methodName = "factoryMethod " + interfaceName;
            generatorFacade.createFiles(abstractClassName, new HashSet<>(), new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.factory-method-text"), interfaceName))),
                    null, config.getString("path.abstract-class-ftl"));


            System.out.println("Enter the factory class' name ");
            String factoryClassName = sc.next();
            System.out.println("Which object does the factory method create? ");
            for (String name : classNames) {
                System.out.println(name);
            }
            String createdClass = sc.next();
            generatorFacade.createFiles(factoryClassName, new HashSet<>(Arrays.asList(Helper.toMemberString(createdClass))),
                    new HashSet<>(Arrays.asList(methodName)), abstractClassName, config.getString("path.factory-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
