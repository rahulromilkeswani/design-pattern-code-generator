package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class ProxyInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the abstract class name the proxy extends ");
            String abstractClassName = sc.next();
            HashSet<String> classMethods = getMethodsInput();
            generatorFacade.createFiles(abstractClassName, new HashSet<>(), classMethods, null, config.getString("path.abstract-class-ftl"));

            System.out.println("Enter the real class' name ");
            String realClassName = sc.next();
            generatorFacade.createFiles(realClassName, new HashSet<>(), classMethods, abstractClassName, config.getString("path.concrete-class-ftl"));

            System.out.println("Enter the proxy class' name ");
            String proxyClassName = sc.next();
            generatorFacade.createFiles(proxyClassName, new HashSet<>(Arrays.asList(Helper.toMemberString(realClassName))), classMethods, abstractClassName, config.getString("path.proxy-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
