package com.esturafd.jtoolkit.yml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import net.xrrocha.yamltag.DefaultYamlFactory;

/**
 * This class is a map of properties yaml
 * 
 * @author esturafd
 */
public class MapProperties<K, V> extends HashMap<K, V> {
    
    private static final long serialVersionUID = 1L;
    private static final String READING_ERROR = "Error reading file %s sent as parameter";
    private static final String FINDING_ERROR = "File %s not found";
    private static final String TYPE_ERROR = "Argument %s is not a Map";
    
    @SuppressWarnings("unchecked")
    public MapProperties(String path) {
        Object foo = findProperties(path);
        if (foo instanceof Map<?, ?>) {
            this.putAll((Map<K, V>) foo);
        } else {
            throw new IllegalArgumentException(String.format(TYPE_ERROR, path));
        }
    }
    
    /**
     * This method return a map properties yaml
     * 
     * @return Map properties
     */
    public static Object findProperties(String path) {
        ClassLoader loader = MapProperties.class.getClassLoader();
        File file = new File(loader.getResource(path).getFile());
        Object foo = null;
        if (file.exists()) {
            foo = findProperties(file);
        } else {
            file = new File(path);
            if (file.exists()) {
                foo = findProperties(file);
            } else {
                throw new IllegalArgumentException(String.format(FINDING_ERROR, path));
            }
        }
        return foo;
    }
    
    /**
     * This method return a map properties yaml
     * 
     * @return Map properties
     */
    public static Object findProperties(File file) {
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
            throw new IllegalArgumentException(String.format(READING_ERROR, file.getName()), e);
        }
        return foo;
    }
}
