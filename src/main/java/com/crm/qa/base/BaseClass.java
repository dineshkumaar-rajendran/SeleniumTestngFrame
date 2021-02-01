package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.*;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/com/crm/qa/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void initialize_driver() {
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.contains("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
