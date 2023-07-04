package myaccounts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String options){
        clickOnElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']"));
        sleep(200);
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a[text()='"+options+"']"));
    }
@Test
public void verifyUserShouldNavigateToRegisterPageSuccessfully(){


}

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        selectMyAccountOptions("Register");
        verifyText(By.xpath("//div[@id='content']/h1"), "Register Account");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
//Call the method “selectMyAccountOptions” method and pass the parameter
//“Register
        selectMyAccountOptions("Register");
        verifyText(By.xpath("//div[@id='content']/h1"), "Register Account");


        //Enter First Name
        //3.4 Enter Last Name
        //3.5 Enter Email
        //3.6 Enter Telephone
        //3.7 Enter Password
        //3.8 Enter Password Confirm
        //3.9 Select Subscribe Yes radio button
        //3.10 Click on Privacy Policy check box
        //3.11 Click on Continue button
        sendTextToElement(By.id("input-firstname"), "Shweta");
        sendTextToElement(By.id("input-lastname"), "Shah");
        sendTextToElement(By.id("input-email"), "Shweta1265@gmail.com");
        sendTextToElement(By.id("input-telephone"), "07417789456");
        sendTextToElement(By.id("input-password"), "Shweta123");
        sendTextToElement(By.id("input-confirm"), "Shweta123");

        clickOnElement(By.xpath("//input[@name='newsletter']"));
        clickOnElement(By.xpath("//input[@name='agree']"));

        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));
//Verify the message “Your Account Has Been Created!”
        verifyText(By.xpath("//div[@id='content']/h1"), "Your Account Has Been Created!");
// Click on Continue button

        selectMyAccountOptions("Logout");
        //Verify the text “Account Logout”
        verifyText(By.xpath("//div[@id='content']/h1"), "Account Logout");
        //Click on Continue button
        clickOnElement(By.xpath("//div[@class='pull-right']/a"));

    }


    @Test

    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
//Call the method “selectMyAccountOptions” method and pass the parameter
//“Login”
        selectMyAccountOptions("Login");
//Enter Email address
        sendTextToElement(By.id("input-email"), "Shweta125@gmail.com");
        //Enter Last Name
        sendTextToElement(By.id("input-password"), "Shweta123");
        //Click on Login button
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));
        //Verify text “My Account”
        verifyText(By.xpath("//div[@id='content']/h2[1]"), "My Account");
        //Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");
        //Verify the text “Account Logout
        verifyText(By.xpath("//div[@id='content']/h1"), "Account Logout");
        //Click on Continue button
        clickOnElement(By.xpath("//div[@class='pull-right']/a"));


    }
}