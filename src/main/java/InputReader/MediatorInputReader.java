package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class MediatorInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the mediator abstract class name ");
            String mediatorAbstractName = sc.nextLine();

            System.out.println("Enter the colleague abstract class name ");
            String colleagueAbstractName = sc.nextLine();
            generatorFacade.createFiles(colleagueAbstractName, new HashSet<>(Arrays.asList(Helper.toMemberString(mediatorAbstractName))), new HashSet<>(), null, config.getString("path.mediator-abstract-class-ftl"));

            System.out.println("Enter the number of colleague classes ");
            int numberOfClasses = sc.nextInt();
            HashSet<String> classNames = new HashSet<>();
            for (int i = 0; i < numberOfClasses; i++) {
                System.out.println("Enter the name for class " + (i + 1));
                String className = sc.next();
                classNames.add(Helper.toMemberString(className));
                generatorFacade.createFiles(className, new HashSet<>(Arrays.asList(Helper.toMemberString(mediatorAbstractName))), new HashSet<>(), colleagueAbstractName, config.getString("path.mediator-concrete-class-ftl"));
            }

            generatorFacade.createFiles(mediatorAbstractName, new HashSet<>(Arrays.asList(Helper.toMemberString(colleagueAbstractName))), new HashSet<>(), null, config.getString("path.colleague-abstract-class-ftl"));

            System.out.println("Enter the mediator class name ");
            String mediatorClassName = sc.next();
            generatorFacade.createFiles(mediatorClassName, classNames, new HashSet<>(), Helper.toParentString(mediatorAbstractName, colleagueAbstractName), config.getString("path.colleague-concrete-class-ftl"));
        } catch (Exception e) {
            logger.info("Input type mismatch occurred ");
            logger.error(e.toString());
        }
    }
}
