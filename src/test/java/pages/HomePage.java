package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import runner.RunCucumberTest;

public class HomePage{

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarAplicacao(){
        driver.get("https://qazando.com.br/curso.html");
        driver.manage().window().maximize();
        Assert.assertEquals("Não acessou a aplicação",true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(5000);
    }

    public void preencheEmail(){
        driver.findElement(By.id("email")).sendKeys("emailteste@gmail.com");
    }

    public void clicarGanharDesconto() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("button")).click();
    }

    public void verificarCupomDesconto(){
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        Assert.assertEquals("O cupom está errado","QAZANDO15OFF", texto_cupom);
    }
}
