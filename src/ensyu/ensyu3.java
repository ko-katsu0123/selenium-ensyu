package ensyu;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ensyu3 {

	public static void main(String[] args) {
		// サイトアクセス
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.e-procurement.metro.tokyo.jp/index.jsp");
		
		// 遷移前のページのWindowHandleを取得
		String currentWindow = driver.getWindowHandle();
		System.out.println("■操作対象画面の確認　最初の画面 : " + currentWindow);
		
		// 入札情報サービスをクリック
		WebElement element = driver.findElement(By.className("cat_name"));
		element.click();
		
		// ページ遷移するまで5秒は待つ
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		
		// 操作対象のページ切り替え
		Set<String> windowList = driver.getWindowHandles();
		for(String newHandle : windowList) {
			if (!currentWindow.equals(newHandle)) {
		        driver.switchTo().window(newHandle); //親画面以外のhandleなら切替
		        System.out.println("■操作対象画面の確認　2つ目の画面 : " + newHandle);
		    }
		}
		
		// 発注予定情報をクリック
		WebElement element1 = driver.findElement(By.cssSelector("#topMenuBtn03 > a"));
		element1.click();
		
		// 希望申請受付期間に情報を入力し検索実行
		// 令和選択
		WebElement nowEra = driver.findElement(By.name("Era_StartDate"));
		int indexnum = 1;
		Select select = new Select(nowEra);
		select.selectByIndex(indexnum);
		
		// 年月日 入力
		WebElement currentYear = driver.findElement(By.name("StartDateYY"));
		currentYear.sendKeys("3");
		WebElement currentMonth = driver.findElement(By.name("StartDateMM"));
		currentMonth.sendKeys("5");
		WebElement currentDay = driver.findElement(By.name("StartDateDD"));
		currentDay.sendKeys("21");
		
		// 申請受付期間・締め切り
		WebElement endEra = driver.findElement(By.name("Era_EndDate"));
		int indexera = 1;
		Select select2 = new Select(endEra);
		select2.selectByIndex(indexera);
		
		// 年月日 入力
		WebElement endYear = driver.findElement(By.name("EndDateYY"));
		endYear.sendKeys("3");
		WebElement endMonth = driver.findElement(By.name("EndDateMM"));
		endMonth.sendKeys("6");
		WebElement endDay = driver.findElement(By.name("EndDateDD"));
		endDay.sendKeys("30");
		
		// 検索ボタンクリック
		WebElement search = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"));
		search.click();
		
		
		//以下、記事参照のため理解が浅い
		//行数を取得
        int row = driver.findElement(By.className("list-data")).findElements(By.tagName("tr")).size();
		
        //row(行)の数だけ繰り返す。(1行目はthなので省く)
        for(int i = 2; i <= row; i++)
        {
            String xpath = "/html/body/div[3]/div/form/table[5]/tbody/";
            
            //XPath作成のためにiをstringへ変換
            String istring = String.valueOf(i);

            String xp = xpath + "tr[" + istring + "]/";
            
        
            //取り出したい列は3列なので1～3を取り出す
            for(int j = 1; j <= 3; j++){
                String text = xp + "td[" + j + "]";
                    
            //コンソールへの書き出し
                System.out.println(driver.findElement(By.xpath(text)).getText());
            }
            //1行分終わったら改行
            System.out.println("\n");
        }
		
	}

}
