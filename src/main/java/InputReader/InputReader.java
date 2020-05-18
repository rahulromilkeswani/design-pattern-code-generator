package InputReader;

import Facade.GeneratorFacade;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import org.apache.commons.io.FileUtils;
import Utility.Helper;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;


public abstract class InputReader {
    static Config config = ConfigFactory.parseResources("ConfigFiles/Values.conf");
    final File outputDirectory = new File(config.getString("path.output-directory"));
    Logger logger = LoggerFactory.getLogger(InputReader.class);
    static final Scanner sc = new Scanner(System.in);
    //Facade object to communicate with the file generators
    GeneratorFacade generatorFacade = new GeneratorFacade();

    //uses the Template design pattern to call deleteFiles() and getInput()
    public final boolean getPatternInput() throws Exception {
        if (deleteFiles()) {
            getInput();
            return true;
        }
        return false;
    }

    protected abstract void getInput() throws Exception;

    //deletes the files in the output directory if any
    protected boolean deleteFiles() throws IOException {
        try {
            FileUtils.cleanDirectory(outputDirectory);
            logger.info("Output directory cleared");
            return true;
        } catch (Exception e) {
            logger.info("Output directory does not exist");
            logger.error(e.getMessage());
            return false;
        }
    }

    // method to get input for the method types and names
    HashSet<String> getMethodsInput() {
        System.out.println("Enter the number of methods ");
        int methodsCount = sc.nextInt();
        HashSet<String> methodsList = new HashSet<>();
        System.out.println("Enter the method name and its return type");
        for (int j = 0; j <= methodsCount; j++) {
            String method = sc.nextLine();
            if (j != 0) {
                methodsList.add(method);
            }
        }
        return methodsList;
    }
}

