package Utility;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {


        private static Properties prop = new Properties();

        static {
            try (FileInputStream fis = new FileInputStream("/Users/softsuave/Desktop/Recovary_Reel/Config.properties")) {
                prop.load(fis);
                System.out.println("Config file loaded successfully");
            } catch (IOException e) {
                throw new RuntimeException("Could not load Config.properties : " + e);
            }
        }

        public static String getProperty(String key) {
            String value = prop.getProperty(key);
            if (value == null) {
                throw new RuntimeException("Property '" + key + "' not found in Config.properties");
            }
            return value;
        }
    }




