package test;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Pages.FlipkatMobilePage;
import Pages.Phones;

public class Selenium10 {
	public static FlipkatMobilePage mobilePage;
	
		//open Flipkart and go to Mobile section
		public static void step1() throws Exception {
			mobilePage= new FlipkatMobilePage();
			mobilePage.openWebsite();
			Assert.assertEquals(true,mobilePage.clickOnMobile());
			Thread.sleep(5000); 
		}
		
		//Apply filter for desired phone
		public static void step2() throws Exception {
			mobilePage.scrolltoBrands();
			mobilePage.selectPhoneBrand("APPLE");
			mobilePage.selectPriceRange("30000");
			mobilePage.sortbyPrice();
		}
		
		//Get List of Phones and store in CSV
		public static void step3() throws Exception {
			List<Phones> phones =mobilePage.getPhoneList();
			mobilePage.writeInCSV(phones);
			System.out.println("Done");
		}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Test Case 
		//find List of Apple phones on Flipkart within price range of 30000
		try {
			step1();
			step2();
			step3();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
