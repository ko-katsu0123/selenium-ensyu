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
		// �T�C�g�A�N�Z�X
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.e-procurement.metro.tokyo.jp/index.jsp");
		
		// �J�ڑO�̃y�[�W��WindowHandle���擾
		String currentWindow = driver.getWindowHandle();
		System.out.println("������Ώۉ�ʂ̊m�F�@�ŏ��̉�� : " + currentWindow);
		
		// ���D���T�[�r�X���N���b�N
		WebElement element = driver.findElement(By.className("cat_name"));
		element.click();
		
		// �y�[�W�J�ڂ���܂�5�b�͑҂�
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		
		// ����Ώۂ̃y�[�W�؂�ւ�
		Set<String> windowList = driver.getWindowHandles();
		for(String newHandle : windowList) {
			if (!currentWindow.equals(newHandle)) {
		        driver.switchTo().window(newHandle); //�e��ʈȊO��handle�Ȃ�ؑ�
		        System.out.println("������Ώۉ�ʂ̊m�F�@2�ڂ̉�� : " + newHandle);
		    }
		}
		
		// �����\������N���b�N
		WebElement element1 = driver.findElement(By.cssSelector("#topMenuBtn03 > a"));
		element1.click();
		
		// ��]�\����t���Ԃɏ�����͂��������s
		// �ߘa�I��
		WebElement nowEra = driver.findElement(By.name("Era_StartDate"));
		int indexnum = 1;
		Select select = new Select(nowEra);
		select.selectByIndex(indexnum);
		
		// �N���� ����
		WebElement currentYear = driver.findElement(By.name("StartDateYY"));
		currentYear.sendKeys("3");
		WebElement currentMonth = driver.findElement(By.name("StartDateMM"));
		currentMonth.sendKeys("5");
		WebElement currentDay = driver.findElement(By.name("StartDateDD"));
		currentDay.sendKeys("21");
		
		// �\����t���ԁE���ߐ؂�
		WebElement endEra = driver.findElement(By.name("Era_EndDate"));
		int indexera = 1;
		Select select2 = new Select(endEra);
		select2.selectByIndex(indexera);
		
		// �N���� ����
		WebElement endYear = driver.findElement(By.name("EndDateYY"));
		endYear.sendKeys("3");
		WebElement endMonth = driver.findElement(By.name("EndDateMM"));
		endMonth.sendKeys("6");
		WebElement endDay = driver.findElement(By.name("EndDateDD"));
		endDay.sendKeys("30");
		
		// �����{�^���N���b�N
		WebElement search = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"));
		search.click();
		
		
		//�ȉ��A�L���Q�Ƃ̂��ߗ�������
		//�s�����擾
        int row = driver.findElement(By.className("list-data")).findElements(By.tagName("tr")).size();
		
        //row(�s)�̐������J��Ԃ��B(1�s�ڂ�th�Ȃ̂ŏȂ�)
        for(int i = 2; i <= row; i++)
        {
            String xpath = "/html/body/div[3]/div/form/table[5]/tbody/";
            
            //XPath�쐬�̂��߂�i��string�֕ϊ�
            String istring = String.valueOf(i);

            String xp = xpath + "tr[" + istring + "]/";
            
        
            //���o���������3��Ȃ̂�1�`3�����o��
            for(int j = 1; j <= 3; j++){
                String text = xp + "td[" + j + "]";
                    
            //�R���\�[���ւ̏����o��
                System.out.println(driver.findElement(By.xpath(text)).getText());
            }
            //1�s���I���������s
            System.out.println("\n");
        }
		
	}

}
