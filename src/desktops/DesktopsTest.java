package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

      @Test

    public void verifyProductArrangeInAlphabeticalOrder() {
//Mouse hover on Desktops Tab.and click
          WebElement desktops = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']/li/a)[1]"));
          Actions actions = new Actions(driver);

          actions.moveToElement(desktops).click().build().perform();

          //clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));
          selectMenu("Show AllDesktops");
//Select Sort By position "Name: Z to A"
          WebElement dropDown = driver.findElement(By.id("input-sort"));
          Select select = new Select(dropDown);
          select.selectByVisibleText("Name (Z - A)");
          sleep(500);
          List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));
          List<String> list = new ArrayList();
          List<String> sortedlist = new ArrayList();

          System.out.println("Total Products are " + elementList.size());

          // Verify the Product will arrange in Descending order
          for (WebElement web : elementList) {
              list.add(web.getText().toLowerCase());
              sortedlist.add(web.getText().toLowerCase());
              System.out.println(web.getText());
          }
          Collections.sort(sortedlist, Collections.reverseOrder());
          Assert.assertTrue(list.equals(sortedlist));

      }


    @Test

    public void verifyProductAddedToShoppingCartSuccessFully(){

        //Mouse hover on Desktops Tab.and click
        WebElement desktops = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']/li/a)[1]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(desktops).click().build().perform();

        //clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));
        selectMenu("Show AllDesktops");
//Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");
        sleep(500);
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));
        List<String> list = new ArrayList();
        List<String> sortedlist = new ArrayList();

        System.out.println("Total Products are " + elementList.size());

        // Verify the Product will arrange in Descending order
        for (WebElement web : elementList) {
            list.add(web.getText().toLowerCase());
            sortedlist.add(web.getText().toLowerCase());
            System.out.println(web.getText());
        }
        Collections.sort(sortedlist);
        Assert.assertTrue(list.equals(sortedlist));


        clickOnElement(By.xpath("(//a[text()='HP LP3065'])[1]"));
        sleep(500);
        // Verify the Text "HP LP3065"
        verifyText(By.xpath("//h1[text()='HP LP3065']"), "HP LP3065");
        //Select Delivery Date "2022-11-30"
        sendTextToElement(By.id("input-option225"),"2022-11-30");
        //Enter Qty "1” using Select class.

        sleep(200);
        sendTextToElement(By.id("input-quantity"),"1");
        //Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
        //Verify the Message “Success: You have added HP LP3065 to your shopping cart!"
        verifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×");
        //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
        sleep(300);

        //Verify the text "Shopping Cart"


        //Verify the Model "Product21"
        verifyText(By.xpath("//td[@class='text-left' and text()='Product 21']"), "Product 21");
      // verifyText(By.xpath("//h1[text()='HP LP3065']"), "HP LP3065");
      //  verifyText(By.xpath("(//h2[text()='$122.00'])[1]"), "$122.00");






    }


}


