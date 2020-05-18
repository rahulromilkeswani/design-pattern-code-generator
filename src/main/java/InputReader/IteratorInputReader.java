package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class IteratorInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the iterator interface's name ");
            String iteratorInterfaceName = sc.next();
            generatorFacade.createFiles(iteratorInterfaceName, new HashSet<>(), new HashSet<>(), null, config.getString("path.iterator-interface-ftl"));

            System.out.println("Enter the aggregate interface's name ");
            String aggregateInterfaceName = sc.next();
            generatorFacade.createFiles(aggregateInterfaceName, new HashSet<>(Arrays.asList(Helper.toMemberString(iteratorInterfaceName))), new HashSet<>(), null, config.getString("path.aggregate-interface-ftl"));

            System.out.println("Enter the aggregate concrete class' name ");
            String aggregateConcreteName = sc.next();
            System.out.println("Enter the iterator concrete class' name ");
            String iteratorConcreteName = sc.next();
            generatorFacade.createFiles(aggregateConcreteName, new HashSet<>(Arrays.asList(Helper.toMemberString(iteratorConcreteName))), new HashSet<>(), Helper.toParentString(aggregateInterfaceName, iteratorInterfaceName), config.getString("path.aggregate-concrete-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
