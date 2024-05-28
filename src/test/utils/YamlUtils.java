package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class YamlUtils {
    public static Map getConfig(String pathOfYaml) {
        try {
            FileInputStream file = new FileInputStream(pathOfYaml);
            return new Yaml().load(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
