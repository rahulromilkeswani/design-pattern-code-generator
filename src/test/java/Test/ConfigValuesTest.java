package Test;
import com.typesafe.config.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigValuesTest {
    Config config = ConfigFactory.parseResources("ConfigFiles/Values.conf");
    @Test
    public void testConfigValues(){
        assertEquals(config.getString("string.execution-message"),"Program execution finished. Check logs for run details.");
        assertNotEquals(config.getString("string.execution-message"),"Hello world");
    }
}
