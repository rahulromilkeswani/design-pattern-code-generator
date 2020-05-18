package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class FlyweightInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the flyweight interface name ");
            String interfaceName = sc.next();
            HashSet<String> classMethods = getMethodsInput();
            generatorFacade.createFiles(interfaceName, new HashSet<>(), classMethods, null, config.getString("path.interface-ftl"));

            System.out.println("Enter the flyweight class name ");
            String className = sc.next();
            generatorFacade.createFiles(className, new HashSet<>(), classMethods, interfaceName, config.getString("path.flyweight-concrete-class-ftl"));

            System.out.println("Enter the flyweight factory name ");
            String factoryName = sc.next();
            generatorFacade.createFiles(factoryName, new HashSet<>(Arrays.asList(Helper.toMemberString(className))), new HashSet<>(), interfaceName, config.getString("path.flyweight-factory-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

}
