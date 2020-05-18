package InputReader;

import Utility.Helper;

import java.util.Arrays;
import java.util.HashSet;

public class InterpreterInputReader extends InputReader {
    @Override
    protected void getInput() {
        try {
            System.out.println("Enter the context class name ");
            String contextName = sc.next();
            generatorFacade.createFiles(contextName, new HashSet<>(), new HashSet<>(), null, config.getString("path.class-ftl"));

            System.out.println("Enter the abstract class name ");
            String abstractClassName = sc.next();
            generatorFacade.createFiles(abstractClassName, new HashSet<>(Arrays.asList(Helper.toMemberString(contextName))), new HashSet<>(), null,
                    config.getString("path.interpreter-abstract-class-ftl"));

            System.out.println("Enter the non-terminal class name ");
            String nonTerminalClassName = sc.next();
            generatorFacade.createFiles(nonTerminalClassName, new HashSet<>(Arrays.asList(Helper.toMemberString(contextName))),
                    new HashSet<>(), abstractClassName, config.getString("path.interpreter-nonterminal-class-ftl"));

            System.out.println("Enter the terminal class name ");
            String terminalClassName = sc.next();
            generatorFacade.createFiles(terminalClassName, new HashSet<>(Arrays.asList(Helper.toMemberString(contextName))), new HashSet<>(), abstractClassName, config.getString("path.interpreter-terminal-class-ftl"));
        } catch (Exception e) {
            logger.error(e.toString());
        }

    }
}
