package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class MementoInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the originator class name ");
            String orignatorName = sc.next();
            System.out.println("Enter the memento class name ");
            String mementoName = sc.next();
            generatorFacade.createFiles(orignatorName, new HashSet<>(), new HashSet<>(), mementoName, config.getString("path.memento-class-ftl"));
        } catch (Exception e) {
            logger.info("Input type mismatch occurred ");
            logger.error(e.toString());
        }
    }
}
