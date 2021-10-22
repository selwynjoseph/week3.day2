package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		Thread.sleep(2000);
		
		//uncheck sort on date
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		Thread.sleep(2000);
		
		//clear and enter source station
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("Bangalore");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='Bangalore East']")).click();
		Thread.sleep(1000);
		
		
		//clear and enter destination station
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("Hyderabad");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='Hyderabad Decan']")).click();
		Thread.sleep(2000);
		
		//get list of trains
		List<WebElement> element1=driver.findElements(By.xpath("(//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]/a)"));
		List<String> TrainList = new ArrayList<String>(); 
		
		//List<WebElement> element1=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		for (WebElement trains : element1) {

			String trainnames=trains.getText();
			//System.out.println(trainnames);
			TrainList.add(trainnames);
			
		}
		
		//sort the list of train names
		Collections.sort(TrainList);
		System.out.println("Sorted train list is");
		System.out.println(TrainList);
		
		driver.close();

	}

}
