package flipkart.automation.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileData implements AutoConstants{
	public String getPropertiesFileData(String keyname) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(propertiesfilepath));
		return p.getProperty(keyname);
	}

}
