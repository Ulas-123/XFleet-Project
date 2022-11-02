package XFleet.step_definition;

import XFleet.pages.LogInPage;
import XFleet.utilities.ConfigurationReader;
import XFleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinition {


    LogInPage loginPage = new LogInPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {

        String url = ConfigurationReader.getProperty("XFleet-Url");
        Driver.getDriver().get(url);

    }


    @Given("Login as a {string}")
    public void login_as_a(String userType) {
        System.out.println(userType);


    }

    @When("The user enter {string} and {string}")
    public void the_user_enter_and(String username, String password) {

        loginPage.logInBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.logInButton.click();


    }

    @Then("The user is on the {string} page")
    public void the_user_is_on_the_page(String pageSubTitle) {

        String actual;
        if (pageSubTitle.equals("Quick Launchpad")) {
            actual = loginPage.quickLaunchpad.getText();

        } else {
            actual = loginPage.dashboard.getText();

        }
        Assert.assertEquals("Not Equal", pageSubTitle, actual);

    }

    @When("The user tries to login with {string} and {string}")
    public void the_user_tries_to_login_with_and(String username, String password) {

        loginPage.logInBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.logInButton.click();

    }

    @Then("The user can not login and see Invalid username or password.")
    public void the_user_can_not_login_and_see_invalid_username_or_password() {
        String actual = loginPage.invalidCredentials.getText();
        Assert.assertEquals("Invalid user name or password.", actual);
    }


    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String string) {

            String actual = loginPage.logInBox.getAttribute("validationMessage");
            Assert.assertEquals(string, actual);



    }

    @When("The users try to login with \"user1\" and \"\"")
    public void the_users_try_to_login(){

        loginPage.logInBox.sendKeys("user1" + Keys.ENTER);
        loginPage.passwordBox.sendKeys("");
        loginPage.logInButton.click();

    }

    @Then("{string} message should be displayed if password is empty")
    public void message_should_be_displayed_if_password_is_empty(String string) {
        String actual = loginPage.passwordBox.getAttribute("validationMessage");
        Assert.assertEquals(string, actual);

    }

    @When("The user click the {string} link")
    public void the_user_click_the_link(String string) {

        loginPage.forgotYourPassword.click();

    }

    @Then("The user land on {string} page")
    public void the_user_land_on_page(String string) {
        String actual = loginPage.forgotPasswordPage.getText();
        Assert.assertEquals("Forgot Password", actual);

    }

    @Then("The user can see {string} link")
    public void the_user_can_see_link(String string) {

        Assert.assertTrue(loginPage.rememberMeButton.isDisplayed());

    }

    @Then("The link is clickable")
    public void the_link_is_clickable() {

        loginPage.rememberMeButton.isEnabled();
        Assert.assertTrue(loginPage.rememberMeButton.isEnabled());

    }

    //username
    @When("The user enter the {string}")
    public void the_user_enter_the(String UserUser123) {

        loginPage.passwordBox.sendKeys(UserUser123);

    }

    @Then("The password in bullet sign by default")
    public void the_in_bullet_sign_by_default() {

        String actual = loginPage.passwordBox.getAttribute("type");
        Assert.assertEquals("password", actual);

    }

    @Then("The user enter username and password and press the ENTER key")
    public void the_user_enter_username_and_password_and_press_the_ENTER_key() {
        loginPage.logInBox.sendKeys("user1"+Keys.ENTER);
        loginPage.passwordBox.sendKeys("UserUser123" + Keys.ENTER);

    }

    //**INCORRECT */
    @Then("The Enter key is working")
    public void the_enter_key_is_working() {
        Assert.assertTrue(loginPage.dashboard.isDisplayed());

    }

    @And("The users should see {string} name in the profile menu")
    public void the_users_should_see_their_own_name_in_the_profile_menu() {
        Assert.assertTrue(loginPage.profileName.isDisplayed());

    }

}
