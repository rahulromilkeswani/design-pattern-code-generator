package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class ObserverInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the observer abstract class' name ");
            String observerAbstractName = sc.next();
            generatorFacade.createFiles(observerAbstractName, new HashSet<>(), new HashSet<>(), null, config.getString("path.observer-abstract-class-ftl"));

            System.out.println("Enter the subject abstract class' name ");
            String subjectAbstractName = sc.next();
            generatorFacade.createFiles(subjectAbstractName, new HashSet<>(), new HashSet<>(), observerAbstractName, config.getString("path.subject-abstract-class-ftl"));

            System.out.println("Enter the subject concrete class' name ");
            String subjectConcreteName = sc.next();
            generatorFacade.createFiles(subjectConcreteName, new HashSet<>(), new HashSet<>(), subjectAbstractName, config.getString("path.subject-concrete-class-ftl"));

            System.out.println("Enter the number of observer classes ");
            int numberOfClasses = sc.nextInt();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for observer " + (i + 1));
                String observerName = sc.next();
                generatorFacade.createFiles(observerName, new HashSet<>(Arrays.asList(Helper.toMemberString(subjectConcreteName))), new HashSet<>(), observerAbstractName, config.getString("path.observer-concrete-class-ftl"));
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
