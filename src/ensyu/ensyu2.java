package ensyu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ensyu2 {

	public static void main(String[] args) {
		// rakus+にアクセス
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rakuplus.jp/");
		
		// ID,PWを指定、入力、ログイン
		WebElement user = driver.findElement(By.id("user_login"));
		user.sendKeys("dummy_id");
		WebElement pw = driver.findElement(By.id("user_pass"));
		pw.sendKeys("dummy_pw");
		WebElement login = driver.findElement(By.id("wp-submit"));
		login.submit();
		
		// スクリーショット撮影・任意の場所に保存
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file.toPath(), new File("dummy" + file.getName()).toPath());
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("スクショ撮影が失敗しました");
		}
		System.out.println("一連の処理が完了しました");
	}

}
