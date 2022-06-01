import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Domaći:
//Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru,
//izabrati opciju Lukovi - Bows iz leve navigacije,
//potom kliknuti na luk koji se zove Samick Sage,
//i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mlade\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://www.strela.co.rs/");

        WebElement shop = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span"));
        shop.click();
        WebElement bows = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div"));
        bows.click();

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // WebElement sage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_RadAjaxPanel1\"]/div[2]"));
        //WebElement samick = driver.findElement(By.xpath("// span[contains(@id, 'ct100_MainContent_ListView1_ctr135_Panel11')and text()= 'Bow Samick Sage]"));
        //samick.submit();

        WebElement samick = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure"));
        samick.click();
        WebElement title = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));
        String samickTitle = title.getText();
         if (samickTitle.contains("Samick")){
             System.out.println("Nice.");
         }else {
             System.err.println("Not nice.");
         }

         driver.close();



    }
}
