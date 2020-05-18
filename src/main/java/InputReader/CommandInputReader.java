package InputReader;

import Utility.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CommandInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the receiver's name ");
            String receiverName = sc.nextLine();
            HashSet<String> classMethods = getMethodsInput();
            generatorFacade.createFiles(receiverName, new HashSet<>(), classMethods, null, config.getString("path.class-ftl"));

            System.out.println("Enter the interface's name which the command class implements ");
            String interfaceName = sc.nextLine();
            generatorFacade.createFiles(interfaceName, new HashSet<>(), classMethods, null, config.getString("path.interface-ftl"));

            System.out.println("Enter command class' name ");
            String commandName = sc.nextLine();
            generatorFacade.createFiles(commandName, new HashSet<>(Arrays.asList(Helper.toMemberString(receiverName))), classMethods, interfaceName, config.getString("path.command-concrete-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
