package InputReader;

import java.util.HashSet;

public class TemplateInputReader extends InputReader {
    protected void getInput() {
        try {
            System.out.println("Enter the abstract class name ");
            String abstractClassName = sc.next();
            HashSet<String> abstractMethodsList = getMethodsInput();

            System.out.println("Enter the class name which extends the given abstract class");
            String concreteClassName = sc.nextLine();
            generatorFacade.createFiles(abstractClassName, new HashSet<>(), abstractMethodsList, null, config.getString("path.template-abstract-class-ftl"));
            generatorFacade.createFiles(concreteClassName, new HashSet<>(), abstractMethodsList, abstractClassName, config.getString("path.template-concrete-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

}
