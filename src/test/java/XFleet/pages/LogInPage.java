package XFleet.pages;

import XFleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage(){
        PageFactory.initElements( Driver.getDriver(), this);
    }


    @FindBy(id = "prependedInput")
    public WebElement logInBox;
    String validationMessage = "Lütfen bu alanı doldurun.";

    @FindBy(id = "prependedInput2")
    public WebElement passwordBox;
    String validationMessage2 = "Lütfen bu alanı doldurun.";

    @FindBy(id = "_submit")
    public WebElement logInButton;

    @FindBy(xpath = "//h1[.='Quick Launchpad']")
    public WebElement quickLaunchpad;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement dashboard;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidCredentials;

    @FindBy(xpath = "//span[@class='custom-checkbox__text']")
    public WebElement rememberMeButton;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotYourPassword;

    @FindBy (xpath = "//h2[.='Forgot Password']")
    public WebElement forgotPasswordPage;

    @FindBy (xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement profileName;


    public void login(String username, String password){

        logInBox.sendKeys(username);
        passwordBox.sendKeys(password);
        logInButton.click();
    }





}
