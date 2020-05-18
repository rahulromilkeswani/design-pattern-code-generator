package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class BuilderInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            HashSet<String> objectsType = new HashSet<>();
            HashSet<String> builderMethods = new HashSet<>();
            System.out.println("Enter the interface name which the independent classes implement ");
            String objectInterface = sc.nextLine();
            HashSet<String> interfaceMethods = getMethodsInput();
            generatorFacade.createFiles(objectInterface, new HashSet<>(), interfaceMethods, null, config.getString("path.interface-ftl"));


            System.out.println("Enter the number of classes which implement interface ");
            int numberOfClasses = sc.nextInt();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for class " + (i + 1));
                String className = sc.next();
                builderMethods.add(Helper.toMemberString(className));
                generatorFacade.createFiles(className, new HashSet<>(), interfaceMethods, objectInterface, config.getString("path.implementor-class-ftl"));
            }

            System.out.println("Enter the complex object name ");
            String complexObjectName = sc.next();
            generatorFacade.createFiles(complexObjectName, new HashSet<>(Arrays.asList(Helper.toMemberString(objectInterface))), new HashSet<>(), null, config.getString("path.builder-complex-object-ftl"));

            System.out.println("Enter the builder interface name ");
            String builderInterfaceName = sc.next();
            generatorFacade.createFiles(builderInterfaceName, new HashSet<>(Arrays.asList(Helper.toMemberString(complexObjectName))), builderMethods, null, config.getString("path.builder-interface-ftl"));

            System.out.println("Enter the builder class name ");
            String builderClassName = sc.next();
            generatorFacade.createFiles(builderClassName, new HashSet<>(Arrays.asList(Helper.toMemberString(complexObjectName))), builderMethods, builderInterfaceName, config.getString("path.builder-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}


