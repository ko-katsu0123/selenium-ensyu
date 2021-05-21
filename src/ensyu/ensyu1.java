package ensyu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ensyu1 {

	public static void main(String[] args) {
		// googleにアクセス
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/xhtml");
		
		// seleniumと検索
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
		
		// 検索結果一番上のサイトURLを取得（Xpathで検索結果のh3まで移動→h3タグの親（aタグ）を探して取得
		WebElement elemh3 = driver.findElement(By.xpath("//a/h3"));
		WebElement elema = elemh3.findElement(By.xpath(".."));
		
		// →aタグ内で属性名hrefを指定してコンソール出力
		System.out.println(elema.getAttribute("href"));

	}

}
