package ensyu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ensyu0 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //ChromeDriver�̍쐬
		driver.get("http://www.google.com/xhtml");	//get()�Ńu���E�U�N��
		Thread.sleep(5000); //�������~(����m�F�̈�)
	
		//�u���E�U�̗v�f���w��@���\�b�h�����킩��₷���ł���ˁB
		WebElement	searchBox	=	driver.findElement(By.name("q"));
		searchBox.sendKeys("ChromeDriver");
		searchBox.submit();
		Thread.sleep(5000);		
		driver.quit();	//�u���E�U�����

	}

}
