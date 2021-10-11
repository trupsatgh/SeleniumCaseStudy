package org.company.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.company.utilities.Constants.USER_DIR;
import static org.company.utilities.Constants.APPLICATION_PROPERTIES;

public class CommonUtilities {
    public  String getApplicationProperty(String key) {
        Properties properties = new Properties();
        String filePath = USER_DIR + File.separator + APPLICATION_PROPERTIES;
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(filePath);
            properties.load(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  properties.getProperty(key);
    }
}
