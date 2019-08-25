package com.demo.test;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class BSS_jf {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		
		System.setProperty("webdriver.chrome.driver","C:\\libs\\chromedriver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://dev.hivebariatrics.com/lp/landing-page-test-v3.html");
		driver.findElement(By.id("first-name")).sendKeys(person.getFirstName());
		
		Thread.sleep(2000);
		String time = driver.findElement(By.id("first-name")).getAttribute("value");
		System.out.println("\n \t Get Value from First Name :-> "+time);
		
		
		
		driver.findElement(By.id("last-name")).sendKeys(person.getLastName());
		Thread.sleep(2000);
		String tim = driver.findElement(By.id("last-name")).getAttribute("value");
		System.out.println("\n \t Get Value from Last Name :-> "+tim);
		
		
		driver.findElement(By.id("height")).sendKeys("5");
		driver.findElement(By.id("height_inch")).sendKeys("8");
		driver.findElement(By.id("weight")).sendKeys("280");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("interested-in-a-specific-procedure")).sendKeys("Gastric Sleeve");
		driver.findElement(By.id("interested-in-a-specific-insurance")).sendKeys("4. HMO");
		driver.findElement(By.id("subscriber_radio")).click();
		driver.findElement(By.id("primary-physician-name")).sendKeys(person.getFirstName());
		Select oth = new Select(driver.findElement(By.id("insurance-company-input")));
		oth.selectByValue("Other");
		
		
		
		
		Select pay = new Select(driver.findElement(By.id("pay-for-procedure")));
		pay.selectByValue("I need financing (e.g., a loan with an affordable monthly payment)");
		
	
		
		Select sco = new Select(driver.findElement(By.id("credit-score")));
		sco.selectByValue("700 - 749 (“Good”)");
		
		
		driver.findElement(By.id("date-picker")).sendKeys("11/11/2000");
		
		driver.findElement(By.id("surgery_before")).click();
		driver.findElement(By.id("email")).sendKeys(person.getEmail());
		
		driver.findElement(By.id("phone")).sendKeys(person.getTelephoneNumber());
		
		driver.findElement(By.id("maxicali-submit-button")).click();
		Thread.sleep(5000);
	      System.out.println("\n \t \n");
	      System.out.println("\n \t \n");
	      System.out.println("\n \t <------------- TEST RESULT -------------> \n ");
	      Thread.sleep(2000);
	      String text = driver.findElement(By.id("res_msg")).getText();
	      
	      Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
	      Matcher reMatcher = re.matcher(text);
	      while (reMatcher.find()) {
	          System.out.println(reMatcher.group());
	      }
	     
	      Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		     ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D:\\test\\FullPageScreenshot.png"));
		driver.close();
		driver.quit();
	}

}
