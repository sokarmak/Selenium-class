package selenium.tech;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddLeadTest {
	@Test
	public void test() {

		System.setProperty("webdriver.chrome.driver", "artifacts/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://crm.techcanvass.co.in/");
		String userName = "techcanvassuser@techcanvass.co.in", password = "user1234";
		driver.get("http://crm.techcanvass.co.in/");
		driver.findElement(By.id("btnlogin")).click();
		driver.findElement(By.name("txtuname")).sendKeys(userName);
		driver.manage().window().maximize();
		driver.findElement(By.name("txtpwd")).sendKeys(password);
		driver.findElement(By.id("loginbtn")).click();

		WebElement table = driver
				.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_panalcouncellor']/table[1]"));
		List<WebElement> th = table.findElements(By.tagName("th"));
		for (int i = 1; i <= th.size(); i++) {
			System.out.println("Header # " + i + " = " + th.get(i - 1).getText());
		}
		
		driver.quit();
	}
}
