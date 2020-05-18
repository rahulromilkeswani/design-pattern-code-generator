package Generator;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.*;
import java.io.*;
import java.io.IOException;
import java.util.*;

public class YamlGenerator {
    static Config config = ConfigFactory.parseResources("ConfigFiles/Values.conf");
    public static final String yamlPath = config.getString("path.yaml-input");
    static Logger logger = LoggerFactory.getLogger(YamlGenerator.class);

    //creates the .yaml from the input obtained from the user
    public boolean createFile(String className, HashSet<String> fieldNames, HashSet<String> methodNames, String parentName) throws IOException {
        HashMap<String, HashMap<String, HashMap<String, String>>> inputMap = parseInput(className, fieldNames, methodNames, parentName);
        if (inputMap != null) {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true);
            Yaml yaml = new Yaml(options);
            String output = yaml.dump(inputMap);
            File file = new File(yamlPath);
            FileWriter writer = new FileWriter(file);
            writer.write(output);
            writer.close();
            logger.info("Created .yaml file for " + className);
            return true;
        }
        return false;
    }

    //creates a Map hierarchy from the given inputs
    public HashMap<String, HashMap<String, HashMap<String, String>>> parseInput(String className, HashSet<String> fieldNames, HashSet<String> methodNames, String interfaceName) {
        try {
            HashMap<String, String> fieldsMap = new HashMap<>();
            HashMap<String, String> methodsMap = new HashMap<>();
            HashMap<String, String> interfaceMap = new HashMap<>();
            for (String field : fieldNames) {
                String[] signature = field.split(config.getString("string.space-text"));
                fieldsMap.put(signature[0], signature[1]);
            }
            for (String method : methodNames) {
                String[] signature = method.split(config.getString("string.space-text"));
                methodsMap.put(signature[0], signature[1]);
            }
            if (interfaceName != null) {
                interfaceMap.put(interfaceName, config.getString("string.empty-text"));
            }
            HashMap<String, HashMap<String, String>> allFields = new HashMap<>();
            allFields.put(config.getString("string.field-text"), fieldsMap);
            allFields.put(config.getString("string.method-text"), methodsMap);
            allFields.put(config.getString("string.interface-text"), interfaceMap);
            HashMap<String, HashMap<String, HashMap<String, String>>> classMap = new HashMap<>();
            classMap.put(className, allFields);
            return classMap;
        } catch (Exception e) {
            logger.info("Error occurred creating the .yaml file " + className + ". Inputs may not be in the right format");
            logger.error(e.toString());
            return null;
        }
    }

}
