package ensyu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ensyu1 {

	public static void main(String[] args) {
		// google�ɃA�N�Z�X
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/xhtml");
		
		// selenium�ƌ���
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
		
		// �������ʈ�ԏ�̃T�C�gURL���擾�iXpath�Ō������ʂ�h3�܂ňړ���h3�^�O�̐e�ia�^�O�j��T���Ď擾
		WebElement elemh3 = driver.findElement(By.xpath("//a/h3"));
		WebElement elema = elemh3.findElement(By.xpath(".."));
		
		// ��a�^�O���ő�����href���w�肵�ăR���\�[���o��
		System.out.println(elema.getAttribute("href"));

	}

}
