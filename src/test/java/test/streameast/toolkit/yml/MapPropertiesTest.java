package test.streameast.toolkit.yml;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.streameast.toolkit.yml.MapProperty;

public class MapPropertiesTest {
    
    @Test
    public void testCargaProperties() {
        Map<String, String> properties = new MapProperty<String, String>("properties.yml");
        String version = properties.get("version");
        System.out.println(properties.toString());
        assertEquals("La propiedad no es la esperada " + version, "1.0", version);
    }
}
