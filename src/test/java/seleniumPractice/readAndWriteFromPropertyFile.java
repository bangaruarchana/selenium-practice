package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class readAndWriteFromPropertyFile {

	@Test
	public void readDataFromPropertyFile() throws IOException {
		FileInputStream fis = new FileInputStream("./propertyData.prop");
		Properties prop = new Properties();
		prop.load(fis);
		String un = prop.getProperty("username");
		String pswd = prop.getProperty("password");
		String bro = prop.getProperty("browser");

		System.out.println(un);
		System.out.println(pswd);
		System.out.println(bro);
	}
	
	@Test
	public void writeDataInPropertyFile() throws IOException {
		FileInputStream fis= new FileInputStream("./propertyData.prop");
		Properties prop=new Properties();
		prop.setProperty("brows", "firefox");
		prop.setProperty("brow", "opera");
		
		FileOutputStream fos=new FileOutputStream("./propertyData.prop");
	//	prop.store(fos, "entered");
		prop.store(fos, null);
		

		System.out.println("Enter the data into the property file");
	}
}
