package Test;

import Model.ClassModel;
import Model.FieldModel;
import Model.MethodModel;
import Parser.YamlParser;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YamlParserTest {
    static Config config = ConfigFactory.parseResources("ConfigFiles/Values.conf");
    static final String yamlPath = config.getString("path.yaml-test");
    YamlParser yamlParser = new YamlParser();
    File file = new File(yamlPath);
    @Test
    public void testClassModelName() throws FileNotFoundException {

        ClassModel model  = yamlParser.readFile(file);
        String className = model.getClassName();
        assertEquals(className,"MyClass");
    }
    @Test
    public void testClassModelInterface() throws FileNotFoundException {
        ClassModel model  = yamlParser.readFile(file);
        String className = model.getInterfaceName();
        assertEquals(className,null);
    }

    @Test
    public void testClassModelFields() throws FileNotFoundException {
        ClassModel model  = yamlParser.readFile(file);
        List<FieldModel> fieldsList = model.getFieldsList();
        List<FieldModel> actualList = new ArrayList<>();
        for(int i = 0 ;i<fieldsList.size();i++) {
            assertEquals(actualList.get(i).getName(), fieldsList.get(i).getName());
        }
    }
    @Test
    public void testClassModelMethods() throws FileNotFoundException {
        ClassModel model = yamlParser.readFile(file);
        List<MethodModel> methodsList = model.getMethodsList();
        List<MethodModel> actualList = new ArrayList<>();
        actualList.add(new MethodModel("getName", "String"));
        actualList.add(new MethodModel("getPrice", "Float"));
        for (int i = 0; i < methodsList.size(); i++) {
            assertEquals(actualList.get(i).getName(), methodsList.get(i).getName());
        }
    }
}
