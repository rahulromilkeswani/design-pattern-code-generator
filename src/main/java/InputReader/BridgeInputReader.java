package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class BridgeInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the abstraction interface name ");
            String interfaceName = sc.nextLine();
            HashSet<String> interfaceMethods = getMethodsInput();
            generatorFacade.createFiles(interfaceName, new HashSet<>(), interfaceMethods, null, config.getString("path.interface-ftl"));

            System.out.println("Enter the class name which implements the interface ");
            String concreteName = sc.nextLine();
            generatorFacade.createFiles(concreteName, new HashSet<>(), interfaceMethods, interfaceName, config.getString("path.implementor-class-ftl"));

            System.out.println("Enter the interface name which the bridge class implements ");
            String bridgeInterfaceName = sc.nextLine();
            generatorFacade.createFiles(bridgeInterfaceName, new HashSet<>(), interfaceMethods, null, config.getString("path.interface-ftl"));

            System.out.println("Enter the bridge class name ");
            concreteName = sc.nextLine();
            generatorFacade.createFiles(concreteName, new HashSet<>(Arrays.asList(Helper.toMemberString(bridgeInterfaceName))), interfaceMethods, bridgeInterfaceName, config.getString("path.bridge-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
