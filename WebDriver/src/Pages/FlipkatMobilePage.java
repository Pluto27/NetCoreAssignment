package Pages;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlipkatMobilePage {
	
	public WebDriver driver;
	JavascriptExecutor js;
	
	//Initialize the driver in constructor
	public FlipkatMobilePage() throws Exception {
		// We initiate the chrome browser in the POM class cosntructer
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		driver=new ChromeDriver();
		 js= (JavascriptExecutor) driver;
		
	}
	
	//Open Flipkart
	public void openWebsite() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.sendKeys(Keys.ESCAPE).perform();
	}
	
	//Select Mobiles section
	public Boolean clickOnMobile() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement e =driver.findElement(By.partialLinkText("Mobiles"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		e.click();
		return true;
	}
	
	//Scroll down to brands
	public Boolean scrolltoBrands() throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Brand')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 
		return true;
	}
	
	//Select Phone Brand
	public Boolean selectPhoneBrand(String phoneBrand) throws Exception {
		driver.findElement(By.xpath("//*[@class='QvtND5 _2w_U27']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='" + phoneBrand + "']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='THxusM _3yuvK8']")).click();
		
		Thread.sleep(5000); 
		return true;
	}
	
	//Select Price Range
	public Boolean selectPriceRange(String phoneRange) throws Exception {
		WebElement s= driver.findElement(By.xpath("//div[@class='_3uDYxP']"));
		Select objSelect =new Select(s.findElement(By.className("_2YxCDZ")));
		Thread.sleep(5000);
		objSelect.selectByValue(phoneRange);
		Thread.sleep(5000);
		return true;
	}
	
	//Sort Phones by Price
	public void sortbyPrice() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Price -- Low to High')]")).click();;
		Thread.sleep(3000);
	}
	
	//Get List of available phones
	public List<Phones> getPhoneList() throws Exception {
		List<Phones> phoneList= new ArrayList<Phones>();
		int i=0;
		Phones per;
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Operating System')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		By mySelector = By.xpath("//*[@class='_1fQZEK']");
		List<WebElement> myElements = driver.findElements(mySelector);
		for(WebElement e : myElements) {
				
	        	
				//phone=phone.substring(0, phone.indexOf("M"));
				
				phoneList.add(new Phones(e.findElement(By.xpath("//*[@class='_4rR01T']")).getText(),e.findElement(By.xpath("//*[@class='_30jeq3 _1_WHN1']")).getText(),e.findElement(By.xpath("//*[@class='_3LWZlK']")).getText()));
			}
		mySelector = By.xpath("//*[@class='_4rR01T']");
		myElements = driver.findElements(mySelector);
		for(WebElement e : myElements) {
				
	        	per=phoneList.get(i);
	        	per.setDeviceDetails(e.getText());
	        	phoneList.set(i, per);
	        	i++;
				//phone=phone.substring(0, phone.indexOf("M"));
			}
		i=0;
		mySelector = By.xpath("//*[@class='_30jeq3 _1_WHN1']");
		myElements = driver.findElements(mySelector);
		for(WebElement e : myElements) {
				
	        	per=phoneList.get(i);
	        	per.setPrice(e.getText());
	        	phoneList.set(i, per);
	        	i++;
				//phone=phone.substring(0, phone.indexOf("M"));
			}
		i=0;
		mySelector = By.xpath("//*[@class='_3LWZlK']");
		myElements = driver.findElements(mySelector);
		for(WebElement e : myElements) {
				
	        	per=phoneList.get(i);
	        	per.setRatings(e.getText());
	        	phoneList.set(i, per);
	        	i++;
				//phone=phone.substring(0, phone.indexOf("M"));
			}
		Thread.sleep(3000);
		return phoneList;
	}
	
	//Enter available phones in CSV file
	public void writeInCSV(List<Phones> phones) throws Exception {
		
		try {
			File file = new File("E:\\test.csv");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Device Details,Price,Ratings");
			bw.newLine();
			
			for(Phones p:phones) {
				System.out.println(p.deviceDetails.toString()+","+p.price.toString()+","+p.ratings.toString());
				bw.write(p.deviceDetails.replaceAll(",", "").toString()+","+p.price.replaceAll(",", "").toString()+","+p.ratings.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.close();
	}
	 

}
