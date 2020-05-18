package Parser;

import static java.util.stream.Collectors.toMap;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import Model.*;
import org.apache.commons.io.FilenameUtils;
import org.yaml.snakeyaml.Yaml;


public class YamlParser {
    static Config config = ConfigFactory.parseResources(("ConfigFiles/Values.conf"));

    //reads the .yaml file and returns a ClassModel object
    public ClassModel readFile(File yamlFile) throws FileNotFoundException {
        return read(new FileReader(yamlFile));
    }

    public ClassModel read(Reader reader) {
        Map<String, Map<String, String>> yamlModel = readYamlModel(reader);
        ClassModel classSpecifications = createClassModel(yamlModel);
        return classSpecifications;
    }


    protected Map<String, Map<String, String>> readYamlModel(Reader reader) {
        Yaml yaml = new Yaml();
        Map<String, Map<String, String>> yamlClassModel =
                (Map<String, Map<String, String>>) yaml.load(reader);
        return yamlClassModel;
    }

    //assembles the Method and Field models with the parent to give a ClassModel object
    protected ClassModel createClassModel(Map<String, Map<String, String>> yamlClassModel) {
        final Map<String, List<FieldModel>> fieldsMap
                = createFieldsMap(yamlClassModel);
        final Map<String, List<MethodModel>> methodsMap
                = createMethodsMap(yamlClassModel);
        List<List<MethodModel>> methodsList = methodsMap.values().stream().collect(Collectors.toList());
        List<List<FieldModel>> fieldsList = fieldsMap.values().stream().collect(Collectors.toList());
        String className = fieldsMap.keySet().iterator().next();
        String interfaceName = getInterfaceName(yamlClassModel);
        ClassModel classModel = new ClassModel(className, fieldsList.get(0), methodsList.get(0));
        if (interfaceName != null) {
            classModel.setInterfaceName(interfaceName);
        }
        return classModel;
    }

    //extracts the fields list from the map structure
    protected Map<String, List<FieldModel>> createFieldsMap(
            Map<String, Map<String, String>> classModel) {
        if (classModel == null) return new HashMap<>();
        Map<String, List<FieldModel>> fieldsMap = classModel.entrySet().stream().collect(toMap(this::className, this::getFields));
        return fieldsMap;

    }

    //extracts the fields list from the map structure
    protected Map<String, List<MethodModel>> createMethodsMap(
            Map<String, Map<String, String>> classModel) {
        if (classModel == null) return new HashMap<>();
        Map<String, List<MethodModel>> methodsMap = classModel.entrySet().stream().collect(toMap(this::className, this::getMethods));
        return methodsMap;

    }

    //extracts the class name from the map structure
    protected String className(Map.Entry<String, Map<String, String>> classModel) {
        return classModel.getKey();
    }

    //maps the fields list into a list of FieldModel objects
    private List<FieldModel> getFields(Map.Entry<String, Map<String, String>> classModel) {
        Map<String, String> fieldsModel = classModel.getValue();
        List<FieldModel> returnList = new ArrayList<>();
        if (fieldsModel == null) return new ArrayList<>();
        HashMap<String, String> tempFieldMap = (LinkedHashMap) ((LinkedHashMap) fieldsModel).get(config.getString("string.field-text"));
        for (Map.Entry<String, String> entry : tempFieldMap.entrySet()) {
            returnList.add(new FieldModel(entry.getKey(), entry.getValue()));
        }
        return returnList;
    }

    //maps the fields list into a list of MethodModel objects
    private List<MethodModel> getMethods(Map.Entry<String, Map<String, String>> classModel) {
        Map<String, String> methodsModel = classModel.getValue();
        List<MethodModel> returnList = new ArrayList<>();
        if (methodsModel == null) return new ArrayList<>();
        HashMap<String, String> tempFieldMap = (LinkedHashMap) ((LinkedHashMap) methodsModel).get(config.getString("string.method-text"));
        for (Map.Entry<String, String> entry : tempFieldMap.entrySet()) {
            returnList.add(new MethodModel(entry.getKey(), entry.getValue()));
        }
        return returnList;
    }

    //extracts the interface name from the map structure
    private String getInterfaceName(Map<String, Map<String, String>> classModel) {
        String interfaceName = null;
        LinkedHashMap tempMap = (LinkedHashMap) ((LinkedHashMap) classModel).values().iterator().next();
        Map<String, String> tempInterfaceMap = (Map<String, String>) tempMap.get(config.getString("string.interface-text"));
        if (tempInterfaceMap.size() > 0) {
            interfaceName = tempInterfaceMap.keySet().iterator().next();
        }
        return interfaceName;
    }

}