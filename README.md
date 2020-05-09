# streameast-Jtoolkit

Esta es una libreria para uso genera de Java, con clases 
de ayuda para control de configuraciones por YML y uso de 
la consola.

## Agregar dependencia

```
repositories {
    maven {
        url 'https://maven.pkg.github.com/esturafd/Jtoolkit'
    }
}

dependencies {
    implementation 'com.esturafd.toolkit:esturafd-Jtoolkit:2.2.0'
}
```

## Ejemplo de configuracion de conexiones

#### conections.yml
```yaml
data-base: !!org.apache.commons.dbcp.BasicDataSource
    username: user
    password: pass
    driverClassName: com.mysql.jdbc.Driver 
    url: jdbc:mysql://localhost/test
```

#### Main.java
```java
import java.sql.Connection;
import java.util.Map;

import javax.sql.DataSource;

import com.streameast.toolkit.yml.MapProperties;

public class Main() {
    public static void main(String... args) {
        Map<String, DataSource> conections = new MapProperties("conections.yml");
        try {
            try (Connection con = conections.get("data-base").getConnection()) {
                // Connect to data base...
            }
        } catch (Exception e) {
            //...
        }
    }
}
```

## JavaDocs

https://esturafd.github.io/Jtoolkit/
