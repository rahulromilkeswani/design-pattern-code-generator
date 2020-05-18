package Facade;

import Generator.*;
import com.typesafe.config.*;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Facade class to communicate with the generators
public class GeneratorFacade {
    static Config config = ConfigFactory.parseResources("ConfigFiles/Values.conf");
    static final String yamlPath = config.getString("path.yaml-input");
    Logger logger = LoggerFactory.getLogger(GeneratorFacade.class);

    YamlGenerator yamlGenerator = new YamlGenerator();
    ClassGenerator classGenerator = new ClassGenerator();

    public GeneratorFacade() {
        logger.info("Generator Facade created");
    }

    //method to invoke creation of .yaml and then the .java files
    public void createFiles(String className, HashSet<String> fieldList, HashSet<String> methodList, String parentName, String ftlPath)
            throws Exception {
        logger.info("Creating .yaml file for " + className);
        if (yamlGenerator.createFile(className, fieldList, methodList, parentName)) {
            logger.info("Creating .java file for " + className);
            classGenerator.createFile(ftlPath);
        }
    }
}
