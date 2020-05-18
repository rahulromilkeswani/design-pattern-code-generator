package Generator;

import Factory.InputReaderFactory;
import com.typesafe.config.*;
import freemarker.template.*;
import Model.*;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import Parser.*;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;


//handles the creation of the source java file
public class ClassGenerator {
    static Config config = ConfigFactory.parseResources("ConfigFiles/Values.conf");
    static final File outputDirectory = new File(config.getString("path.output-directory"));
    final String yamlPath = config.getString(FilenameUtils.separatorsToSystem("path.yaml-input"));
    Configuration freemarkerConfig = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    static Logger logger = LoggerFactory.getLogger(ClassGenerator.class);

    //parses the ftl file and maps the elements to create the .java file
    public void createFile(String ftlPath) throws Exception {
        final File yamlFile = new File(yamlPath);
        YamlParser yamlParser = new YamlParser();
        ClassModel classModel = yamlParser.readFile(yamlFile);
        ClassGenerator classGenerator = new ClassGenerator();
        classGenerator.generateSourceFile(classModel, outputDirectory, (ftlPath));
        logger.info("Created .java file for " + classModel.getClassName());
    }

    //creates the filename.java using the FreeMarker Library
    public void generateSourceFile(ClassModel classModel, File yamlFileDirectory, String ftlPath) throws Exception {
        Map<String, Object> freemarkerDataModel = new HashMap<>();
        freemarkerConfig.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "");
        Template template = freemarkerConfig.getTemplate(ftlPath);
        freemarkerDataModel.put(config.getString(("string.class-model-string")), classModel);
        File sourceFile = new File(yamlFileDirectory, classModel.getClassName() + config.getString("string.java-extension"));
        Writer sourceFileWriter = new FileWriter(sourceFile);
        template.process(freemarkerDataModel, sourceFileWriter);
    }
}