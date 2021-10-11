package org.company.utilities;

import java.io.File;

public class Constants {
	
	public static final String APPLICATION_PROPERTIES = "properties" + File.separator + "application.properties";
	public static final String USER_DIR = System.getProperty("user.dir");
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT     = 10;
}
