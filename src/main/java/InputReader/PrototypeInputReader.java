package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PrototypeInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the object interface's name ");
            String objectInterfaceName = sc.next();
            HashSet<String> methodsList = getMethodsInput();
            generatorFacade.createFiles(objectInterfaceName, new HashSet<>(), methodsList, null, config.getString("path.interface-ftl"));

            System.out.println("Enter the prototype interface name");
            String prototypeInterfaceName = sc.next();
            generatorFacade.createFiles(prototypeInterfaceName, new HashSet<>(), new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.clone-text"), objectInterfaceName))), null, config.getString("path.interface-ftl"));

            System.out.println("Enter the class name which implements the interface");
            String className = sc.next();
            generatorFacade.createFiles(className, new HashSet<>(), methodsList, Helper.toParentString(objectInterfaceName, prototypeInterfaceName), config.getString("path.prototype-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

}
