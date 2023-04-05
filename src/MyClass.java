import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyClass {

	WebDriver driver = new ChromeDriver();
	SoftAssert s = new SoftAssert();

	@BeforeTest
	public void Start() {
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@id=\"SIvCob\"]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
				.sendKeys("Mahdi Tawalbeh" + Keys.RETURN);
	}

	@Test()
	public void testResult() {
		int exp = 10;
		String act = driver.findElement(By.className("LHJvCe")).getText();
		
		String [] arrayx=act.split(" ");

		System.out.println(act);
		System.out.println(arrayx[1]);


		s.assertEquals(arrayx[1], exp);
		s.assertAll();

	}

	@AfterTest
	public void End() {

	}

}
