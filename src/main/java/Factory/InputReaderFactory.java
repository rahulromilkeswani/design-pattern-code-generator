package Factory;

import InputReader.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputReaderFactory {
    static Logger logger = LoggerFactory.getLogger(InputReaderFactory.class);

    //instantiates the reader for invoked pattern
    public static InputReader createReader(int option) {
        switch (option) {
            case 1:
                logger.info("Singleton pattern invoked");
                return new SingletonInputReader();
            case 2:
                logger.info("Abstract Factory pattern invoked");
                return new AbstractFactoryInputReader();
            case 3:
                logger.info("Builder pattern invoked");
                return new BuilderInputReader();
            case 4:
                logger.info("Factory Method pattern invoked");
                return new FactoryMethodInputReader();
            case 5:
                logger.info("Facade pattern invoked");
                return new FacadeInputReader();
            case 6:
                logger.info("Chain of Responsibility pattern invoked");
                return new CorInputReader();
            case 7:
                logger.info("Mediator pattern invoked");
                return new MediatorInputReader();
            case 8:
                logger.info("Visitor pattern invoked");
                return new VisitorInputReader();
            case 9:
                logger.info("Template pattern invoked");
                return new TemplateInputReader();
            case 10:
                logger.info("Prototype pattern invoked");
                return new PrototypeInputReader();
            case 11:
                logger.info("Adapter pattern invoked");
                return new AdapterInputReader();
            case 12:
                logger.info("Bridge pattern invoked");
                return new BridgeInputReader();
            case 13:
                logger.info("Composite pattern invoked");
                return new CompositeInputReader();
            case 14:
                logger.info("Decorator pattern invoked");
                return new DecoratorInputReader();
            case 15:
                logger.info("Flyweight pattern invoked");
                return new FlyweightInputReader();
            case 16:
                logger.info("Proxy pattern invoked");
                return new ProxyInputReader();
            case 17:
                logger.info("Command pattern invoked");
                return new CommandInputReader();
            case 18:
                logger.info("Interpreter pattern invoked");
                return new InterpreterInputReader();
            case 19:
                logger.info("Iterator pattern invoked");
                return new IteratorInputReader();
            case 20:
                logger.info("Memento pattern invoked");
                return new MementoInputReader();
            case 21:
                logger.info("Observer pattern invoked");
                return new ObserverInputReader();
            case 22:
                logger.info("State pattern invoked");
                return new StateInputReader();
            case 23:
                logger.info("Strategy pattern invoked");
                return new StrategyInputReader();
            default:
                logger.info("Invalid pattern option entered");
                return null;

        }
    }

}
