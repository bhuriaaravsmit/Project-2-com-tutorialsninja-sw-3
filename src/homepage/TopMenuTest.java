package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        WebElement desktops = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']/li/a)[1]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(desktops).click().build().perform();

        selectMenu("Show AllDesktops");
        verifyText(By.xpath("//h2[text()='Desktops']"), "Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        WebElement laptops = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']/li/a)[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptops).click().build().perform();

        selectMenu("Show AllLaptops & Notebooks");
        verifyText(By.xpath("//h2[text()='Laptops & Notebooks']"), "Laptops & Notebooks");

    }


    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        WebElement components = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']/li/a)[3]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(components).click().build().perform();
        selectMenu("Show AllComponents");
        verifyText(By.xpath("//h2[text()='Components']"), "Components");

    }


    @After
    public void tearDown() {
        //closeBrowser();
    }

}
