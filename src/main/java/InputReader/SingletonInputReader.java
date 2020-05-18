package InputReader;

import java.util.*;

public class SingletonInputReader extends InputReader {
    protected void getInput() {
        try {
            System.out.println("Enter the singleton class name");
            String className = sc.nextLine();
            System.out.println("Enter the field name");
            String fieldName = sc.nextLine();
            HashSet<String> fields = new HashSet<>();
            fields.add(fieldName + " " + className);
            generatorFacade.createFiles(className, fields, new HashSet<>(), null, config.getString("path.singleton-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

}
