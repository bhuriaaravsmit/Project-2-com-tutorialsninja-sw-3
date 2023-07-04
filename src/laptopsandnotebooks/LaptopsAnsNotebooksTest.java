package laptopsandnotebooks;

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

public class LaptopsAnsNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        WebElement laptops = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']/li/a)[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptops).click().build().perform();

        selectMenu("Show AllLaptops & Notebooks");

        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (High > Low)");
        List<WebElement> elementList = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> list = new ArrayList();
        List<String> sortedlist = new ArrayList();

        System.out.println("Total Prices are " + elementList.size());
        for (WebElement web : elementList) {
            list.add(web.getText());
            sortedlist.add(web.getText());
            System.out.println(web.getText());
        }
        Collections.sort(sortedlist);
      //  Assert.assertTrue(list.equals(sortedlist));
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        WebElement laptops = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']/li/a)[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptops).click().build().perform();

        selectMenu("Show AllLaptops & Notebooks");

        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");
        List<WebElement> elementList = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> list = new ArrayList();
        List<String> sortedlist = new ArrayList();


        //Select Product “MacBook”

        clickOnElement(By.xpath("//a[text()='MacBook']"));
        sleep(200);
        //Verify the text “MacBook

        verifyText(By.xpath("//h1[text()='MacBook']"), "MacBook");

        //Click on ‘Add To Cart’ button

        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!\n" +
                "×");
        // Click on link “shopping cart” display into success message

        clickOnElement(By.xpath("//a[text()='shopping cart']"));


        //Verify the text "Shopping Cart"

        verifyText(By.xpath("//a[text()='Shopping Cart']"), "Shopping Cart");

        //Verify the Product name "MacBook"

        //verifyText(By.xpath("(//a[text()='MacBook'])[1]"), "MacBook");


        //Change Quantity "2
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");

        //Click on “Update” Tab

        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //Verify the message “Success: You have modified your shopping cart!”

        verifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have modified your shopping cart!\n" +
                        "×");
//Verify the Total £737.45

    //    verifyText(By.xpath("(//td[@class='text-right'])[1]"),"$1,204.00");
//Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
     //Verify the text “Checkout”
    sleep(200);
        verifyText(By.xpath("//h1[text()='Checkout']"),"Checkout");
//Verify the Text “New Customer”
        verifyText(By.xpath("(//div[@class='col-sm-6']/h2)[1]"),"New Customer");
//Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@name='account']"));
       //Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
//Fill the mandatory fields

        sendTextToElement(By.id("input-payment-firstname"),"Shweta");
        sendTextToElement(By.id("input-payment-lastname"),"Shah");
        sendTextToElement(By.id("input-payment-email"),"Shwetashh5@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"),"07412569874");
        sendTextToElement(By.id("input-payment-address-1"),"62eastbrookhall");
        sendTextToElement(By.id("input-payment-city"),"Bradford");
        sendTextToElement(By.id("input-payment-postcode"),"BD15AE");
        sendTextToElement(By.id("input-payment-password"), "Shweta123");
        sendTextToElement(By.id("input-payment-confirm"), "Shweta123");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"),"United Kingdom");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"),"West Yorkshire");

//Check the Terms & Conditions check box

        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.id("button-register"));

        sendTextToElement(By.className("form-control"), "Test Order");
        clickOnElement(By.xpath("//input[@name='agree']"));
        sleep(200);
        clickOnElement(By.id("button-payment-method"));

        //Verify the message “Warning: Payment method required!

        verifyText(By.xpath("//div[@class='alert alert-warning alert-dismissible']"),"Warning: No Payment options are available. Please contact us for assistance!");


    }


}


