package InputReader;

import Utility.Helper;

import java.util.HashSet;
import java.util.Scanner;

public class AbstractFactoryInputReader extends InputReader {
    @Override
    protected void getInput() {
        HashSet<String> objectsType = new HashSet<>();
        try {
            System.out.println("Enter the number of objects the Abstract Factory creates ");
            int numberOfObjects = sc.nextInt();

            for (int i = 0; i < numberOfObjects; i++) {
                System.out.println("Enter the interface name for Object " + (i + 1));
                String objectInterfaceName = sc.next();
                HashSet<String> interfaceMethods = getMethodsInput();
                generatorFacade.createFiles(objectInterfaceName, new HashSet<>(), interfaceMethods, null, config.getString("path.interface-ftl"));

                System.out.println("Enter the class name which implements this interface");
                String className = sc.nextLine();
                objectsType.add(Helper.toFieldString(className, objectInterfaceName));
                generatorFacade.createFiles(className, new HashSet<>(), interfaceMethods, objectInterfaceName, config.getString("path.implementor-class-ftl"));
            }

            System.out.println("Enter the Abstract Factory interface name ");
            String abstractFactoryInterfaceName = sc.next();
            generatorFacade.createFiles(abstractFactoryInterfaceName, new HashSet<>(), objectsType, null, config.getString("path.abstract-factory-interface-ftl "));


            System.out.println("Enter the Abstract Factory class name ");
            String abstractFactoryClassName = sc.next();
            generatorFacade.createFiles(abstractFactoryClassName, new HashSet<>(), objectsType, abstractFactoryInterfaceName, config.getString("path.abstract-factory-concrete-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
