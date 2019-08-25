package com.demo.test;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BSS_Demo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.hivebariatrics.com/lp/landing-page-test-v3.html");
		PrintStream out = new PrintStream(new FileOutputStream("D:\\test\\output.txt"));
	    System.setOut(out);
		System.out.println("\n \t \n");
		 System.out.println("<=====================================>");
		    System.out.println("\n");
		    java.util.Date date=new java.util.Date();  
		    System.out.println("\n \t Testing Time Start At :- > \t"+date);  
		    System.out.println("\n");
		    System.out.println("\n");
			System.out.println("\n");
		    System.out.println("<=====================================>");
		   
	    WebElement username = driver.findElement(By.id("first-name"));
		username.clear();
		username.sendKeys("Mitesh");
		String time = driver.findElement(By.id("first-name")).getAttribute("value");
		System.out.println("\n \t Get Value from First Name :-> "+time);
		
		
		WebElement last = driver.findElement(By.id("last-name"));
		last.clear();
		last.sendKeys("Testing");
		Thread.sleep(2000);
		String tim = driver.findElement(By.id("last-name")).getAttribute("value");
		System.out.println("\n \t Get Value from Last Name :-> "+tim);
		
		WebElement height = driver.findElement(By.id("height"));
		height.clear();
		height.sendKeys("5");
		Thread.sleep(2000);
		String hei = driver.findElement(By.id("height")).getAttribute("value");
		System.out.println("\n \t Get Value from Height :-> "+hei);
		
		
		WebElement inch = driver.findElement(By.id("height_inch"));
		inch.clear();
		inch.sendKeys("8");
		Thread.sleep(2000);
		String hein = driver.findElement(By.id("height_inch")).getAttribute("value");
		System.out.println("\n \t Get Value from Height_Inch :-> "+hein);
		
		
		
		WebElement weight = driver.findElement(By.id("weight"));
		weight.clear();
		weight.sendKeys("280");
		Thread.sleep(2000);
		String wein = driver.findElement(By.id("weight")).getAttribute("value");
		System.out.println("\n \t Get Value from Height_Inch :-> "+wein);
		
		
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement in = driver.findElement(By.id("interested-in-a-specific-procedure"));
	    in.sendKeys("Gastric Sleeve");
		
	    WebElement iin = driver.findElement(By.id("interested-in-a-specific-insurance"));
	    
	    iin.sendKeys("4. HMO");
	    
		WebElement radio = driver.findElement(By.id("subscriber_radio"));
		
		radio.click();
		
		
		
		WebElement phy  = driver.findElement(By.id("primary-physician-name"));
		phy.clear();
		phy.sendKeys("jayesh");
		
		Select oth = new Select(driver.findElement(By.id("insurance-company-input")));
		oth.selectByValue("Other");
		
		
		
		
		Select pay = new Select(driver.findElement(By.id("pay-for-procedure")));
		pay.selectByValue("I need financing (e.g., a loan with an affordable monthly payment)");
		
	
		
		Select sco = new Select(driver.findElement(By.id("credit-score")));
		sco.selectByValue("700 - 749 (“Good”)");
		
		
		WebElement dat  = driver.findElement(By.id("date-picker"));
		dat.clear();
		dat.sendKeys("11/11/2000");
		
		
		WebElement adio = driver.findElement(By.id("surgery_before"));
		adio.click();
		
		
		WebElement mail  = driver.findElement(By.id("email"));
		mail.clear();
		mail.sendKeys("test@test.com");
		
		
		
		
		WebElement phone  = driver.findElement(By.id("phone"));
		phone.clear();
		phone.sendKeys("9560551451");
		
		
		WebElement btn  = driver.findElement(By.id("maxicali-submit-button"));
      btn.click();
		
      Thread.sleep(5000);
      System.out.println("\n \t \n");
      System.out.println("\n \t \n");
      System.out.println("\n \t <------------- TEST RESULT -------------> \n ");
      String text = driver.findElement(By.id("res_msg")).getText();
      Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
      Matcher reMatcher = re.matcher(text);
      while (reMatcher.find()) {
          System.out.println(reMatcher.group());
      }
      System.out.println("\n \t \n");
      System.out.println("\n \t \n");
      System.out.println("\n \t MESSAGE TO BE DISPLAYED :=> \n ");
      System.out.println("\n \t \n");
      System.out.println("\n "+text);
      
      
		
     Thread.sleep(5000);
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//     Now you can do whatever you need to do with it, for example copy somewhere
     FileUtils.copyFile(scrFile, new File("D:\\test\\TestResult.png"));
     System.out.println("\n \t \n");
	 System.out.println("<=====================================>");
	 System.out.println("\n");
	 Date date1 = new Date();
	 System.out.println("\n \t Testing Time Ends At :- > \t"+date1.toString());
	 System.out.println("\n");
	 System.out.println("\n");
	 System.out.println("<=====================================>");
	 System.out.println("\n");
	 System.out.println("\n");
	 System.out.println("\n \t <------------- TEST END -------------> \n \t ");	
     
     
	    driver.close();
	    driver.quit();
	
	
	
	
	
	}

}
