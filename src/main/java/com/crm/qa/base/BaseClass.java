package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		 prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/com/crm/qa/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialize_driver() {
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/java/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.contains("firfox")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/java/drivers");
		}

		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
