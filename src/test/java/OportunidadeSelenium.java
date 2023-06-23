import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class OportunidadeSelenium {

  private WebDriver browser = new ChromeDriver ();

    @Test
    public void OportunidadeSelenium () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");

        navegar("https://www.google.com.br/");
        pesquisar("nttdata");
        clicarBotaoPesquisar();
        clicarPrimeiroLink();
        clicarBotaoCarreira();
        clicarBotaoJobOportunities();
        pesquisarPerfil("PESSOA ENGENHEIRA DE DADOS");
        browser.quit();

                      }

    public void navegar (String url){
        browser.navigate().to(url);
    }
    public void pesquisar (String texto){
        browser.findElement(By.id("APjFqb")).sendKeys(texto);
    }
    public void clicarBotaoPesquisar (){
        browser.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
    }
    public void clicarPrimeiroLink() {
        browser.findElement(By.xpath("//*[@href=\"https://br.nttdata.com/\"]")).click();
    }

    public void clicarBotaoCarreira() throws InterruptedException {
        Thread.sleep(3000);
        browser.switchTo().frame("ifrmCookieBanner");
        browser.findElement(By.xpath("//*[@class=\"intro-banner-btn save-consents evSpAcceptBtn\"]")).click();
        browser.switchTo().defaultContent();
        browser.findElement(By.xpath("//*[@id=\"navbarLevel0Collapse\"]/div[2]/ul/li[2]/a")).click();
    }

    public void clicarBotaoJobOportunities(){
         browser.findElement(By.xpath("//*[@id=\"collapseRight1\"]/ul/li[2]/a")).click();
    }
        public void pesquisarPerfil (String texto) throws InterruptedException {
            List<String> abas = new ArrayList<>(browser.getWindowHandles());
            browser.switchTo().window(abas.get(1));
            Thread.sleep(4000);
            browser.switchTo().frame("ifrmCookieBanner");
            browser.findElement(By.xpath("//*[@class=\"intro-banner-btn save-consents evSpAcceptBtn\"]")).click();

            browser.switchTo().defaultContent();
            browser.findElement(By.id("sGlobal")).sendKeys(texto);
            browser.findElement(By.id("sGlobal")).sendKeys(Keys.ENTER);
    }

    }


