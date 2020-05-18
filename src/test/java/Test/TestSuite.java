package Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ConfigValuesTest.class,
        ReaderFactoryTest.class,
        YamlParserTest.class
})

public class TestSuite {
}