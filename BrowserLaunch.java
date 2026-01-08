package test.day1;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
class BrowserLaunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ecommerce-playground.lambdatest.io/");
		WebElement list=driver.findElement( By.className("search"));
		list.sendKeys("iphone", Keys.ENTER);
		List<WebElement> prices = driver.findElements(By.className("price"));

        System.out.println("Product Prices:");
		for(int i=0;i<prices.size();i++) {
			
		System.out.println(prices.get(i).getText());
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("https://ecommerce-playground.lambdatest.io/")) {
			System.out.println("The link is verified");
		}
		else {
			System.out.println("The link is not verified");
		}
		String title=driver.getTitle();
		if(title.equals("your Store")) {
			System.out.println("The Title is verified");
		}
		else {
			System.out.println("The title is not verified");
		}
		driver.quit();
		
		

	}

}
}
