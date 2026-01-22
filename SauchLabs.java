package automate.testing;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauchLabs{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.sauchdemo.com/v1/");
		driver.findElement(By.xpath("//input[@id='idToken1']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='idToken2']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='loginButton_0]")).click();
		
		
		

	}

