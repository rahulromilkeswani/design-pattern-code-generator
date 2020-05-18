package Test;
import Factory.InputReaderFactory;
import InputReader.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReaderFactoryTest {
    InputReaderFactory inputReaderFactory = new InputReaderFactory();
    InputReader inputReader;
    @Test
    public void testReaderFactory(){
        inputReader = inputReaderFactory.createReader(22);
        StateInputReader object = new StateInputReader();
        assertSame(object.getClass(),inputReader.getClass());
    }
    @Test
    public void testIncorrectFactory(){
        inputReader = inputReaderFactory.createReader(22);
        StrategyInputReader object = new StrategyInputReader();
        assertNotSame(object.getClass(),inputReader.getClass());
    }

}
