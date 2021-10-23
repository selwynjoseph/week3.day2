package week3.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.name("searchVal")).sendKeys("bags",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Men']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(1000);
		
		//print the count of items found
		String itemsfound = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println(itemsfound);

		//get the list of all the bag brand names
		//driver.findElement(By.xpath("//span[text()='brands']")).click();
		List<WebElement> bagbrandlist=driver.findElements(By.className("brand"));
		System.out.println("Brand names of the bags are:");
		for (WebElement elementbag : bagbrandlist) {
			
			String text=elementbag.getText();
			System.out.println(text);
		}
		
		//get the list of the bag names
		List<WebElement> bagbrandname=driver.findElements(By.className("name"));
		System.out.println("Bag names are:");
		for (WebElement elementbag2 : bagbrandname) {
			
			String text=elementbag2.getText();
			System.out.println(text);
		}
		
		
		driver.close();
		
	}

}
