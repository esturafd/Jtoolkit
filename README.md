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

## Ejemplos

### Configuracion de conexiones

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

import com.streameast.toolkit.yml.PropertyMap;

public class Main() {
    public static void main(String... args) {
        Map<String, DataSource> conections = new PropertyMap("conections.yml");
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

### Creacion de menu

#### menu.yml
```yaml
--- !!com.esturafd.jtoolkit.console.Menu
title: "Titulo de menu principal"
text: "texto de presentacion del menu"
options:
    - !!com.esturafd.jtoolkit.console.Menu
        option: "opcion de menu 1"
        exec: com.esturafd.jtoolkit.demo.Option
```

#### Main.java
```java
import com.streameast.toolkit.console.Menu;

public class Main() {
    public static void main(String... args) {
        Menu menu = Menu.getMenu("menu.yml");
        menu.run();
    }
}
```

#### Option.java
```java
public class Option implements MenuExcutable {
    public void run() {
        System.out.println("Hello World!");
    }
}
```

## JavaDocs

https://esturafd.github.io/Jtoolkit/
