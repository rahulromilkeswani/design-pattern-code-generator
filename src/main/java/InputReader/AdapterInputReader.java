package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class AdapterInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the adaptee class name ");
            String adapteeName = sc.nextLine();
            HashSet<String> adapteeMethods = getMethodsInput();
            generatorFacade.createFiles(adapteeName, new HashSet<>(), adapteeMethods, null, config.getString("path.class-ftl"));


            System.out.println("Enter the target interface name");
            String targetInterfaceName = sc.nextLine();
            generatorFacade.createFiles(targetInterfaceName, new HashSet<>(), adapteeMethods, null, config.getString("path.interface-ftl"));


            System.out.println("Enter the object adapter name");
            String objectAdapterName = sc.nextLine();
            generatorFacade.createFiles(objectAdapterName, new HashSet<>(Arrays.asList(Helper.toMemberString(adapteeName))), adapteeMethods, targetInterfaceName, config.getString("path.object-adapter-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
