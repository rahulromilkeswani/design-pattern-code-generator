package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class StateInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the context class name ");
            String contextName = sc.next();
            System.out.println("Enter the interface name which the state class implements ");
            String stateInterfaceName = sc.next();
            HashSet<String> methodsList = getMethodsInput();
            generatorFacade.createFiles(stateInterfaceName, new HashSet<>(Arrays.asList(Helper.toMemberString(contextName))), methodsList, null, config.getString("path.state-interface-ftl"));
            generatorFacade.createFiles(contextName, new HashSet<>(Arrays.asList(Helper.toMemberString(stateInterfaceName))), methodsList, null, config.getString("path.state-context-class-ftl"));

            System.out.println("Enter the number of state classes ");
            int numberOfClasses = sc.nextInt();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for state " + (i + 1));
                String observerName = sc.next();
                generatorFacade.createFiles(observerName, new HashSet<>(Arrays.asList(Helper.toMemberString(contextName))), methodsList, stateInterfaceName, config.getString("path.state-concrete-class-ftl"));
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
