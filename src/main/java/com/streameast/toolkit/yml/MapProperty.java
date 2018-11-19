package com.streameast.toolkit.yml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.xrrocha.yamltag.DefaultYamlFactory;

import org.yaml.snakeyaml.Yaml;

/**
 * This class is a map of properties yaml
 * 
 * @author streameast
 */
public class MapProperty<K, V> extends HashMap<K, V> {
    
    private static final long serialVersionUID = 1L;
    
    @SuppressWarnings("unchecked")
    public MapProperty(String path) {
        Object foo = null;
        ClassLoader loader = getClass().getClassLoader();
        File file = new File(loader.getResource(path).getFile());
        if (file.exists()) {
            foo = getObjectProperties(file);
        } else {
            file = new File(path);
            if (file.exists()) {
                foo = getObjectProperties(file);
            }
        }
        if (foo instanceof Map<?, ?>) {
            this.putAll((Map<K, V>) foo);
        }
    }
    
    /**
     * This method return a map properties yaml
     * 
     * @return Map properties
     */
    public static Object getObjectProperties(File file) {
        Yaml parser = new DefaultYamlFactory().newYaml();
        Object foo = null;
        try {
            if (file.exists()) {
                FileInputStream streamin = new FileInputStream(file);
                try {
                    foo = parser.load(streamin);
                } finally {
                    streamin.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foo;
    }
}
