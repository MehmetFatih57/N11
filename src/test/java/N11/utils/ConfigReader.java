package N11.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    .properties uzantılı dosyaya erişebilmemiz için Properties class'ından obje oluşturmamız gerekir.
    bu oluşturduğumuz obje ile akışa aldığımız dosya yolunu load(fis) methodu ile properties dosyasındaki
    key değerini return edebiliriz
     */
    static Properties properties;
    static {
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fis);//--> fis'in okuduğu bilgileri properties'e yükler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);//-->getProperty(key) methodu properties dosyasındaki key'in değerini verir

    }
}