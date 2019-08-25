package com.demo.test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class amazon_demo {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\libs\\chromedriver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
	    driver.manage().window().maximize();        
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
	    System.setOut(out);
	    System.out.println("<=====================================>");
	    System.out.println("\n");
	    java.util.Date date=new java.util.Date();  
	    System.out.println("\n \t Testing Time Start At :- > \t"+date);  
	    System.out.println("\n");
	    System.out.println("<=====================================>");
	    
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books");
	    driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
	    
	    
	    
	    java.util.List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println("\n \t Total Links Available in Webpage :--> "+link.size());
		
		for(WebElement link2: link) {
			
			
			System.out.println("<=====================================>");
			System.out.println(link2.getText());
			System.out.println(link2.getAttribute("href"));
			
			System.out.println("<=====================================>");
	       }
	   // driver.findElement(By.className("nav-search-submit nav-sprite")).click();

	    String result = driver.findElement(By.xpath("//*[@id=\"search\"]/span/h1/div/div[1]/div/div/span[1]")).getText();
	    System.out.println(result);
	    System.out.println("\n \t");
	    System.out.println("\n \t");
	    System.out.println(result.replaceAll("[a-z,A-Z]", "")); 
	    System.out.println("\n \t");
	    System.out.println("\n \t");
	    System.out.println(result.replaceAll("[^a-z,A-Z]", ""));
	    System.out.println("\n \t");
	    System.out.println("\n \t");
	    System.out.println(result.replaceAll("[^0-9]", ""));
	  
	    System.out.println("\n \t");
	    System.out.println("\n \t");
	    System.out.println(result.replaceAll("[0-9]", ""));
	    System.out.println("\n Testing Time Ends At :- > \t"+date);
	    driver.close();
	    driver.quit();
		
	
	}

}
