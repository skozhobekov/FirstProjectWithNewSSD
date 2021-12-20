import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPage {


 private static String URL_MATCH = "registration";

 private WebDriver driver;

 @FindBy(id = "userLogin")
 private WebElement login;

 @FindBy(id = "regPassword")
 private WebElement password;

 @FindBy(id = "submitRegistration")
 private WebElement bSubmitAuth;

 @FindBy(id = "error-message")
 private WebElement authError;

 @FindBy(id = "authSuccess-message")
 private WebElement authSuccess;

 @FindBy(id="profileIcon")
 private WebElement profileIcon;


 public RegistrationPage(WebDriver driver) {
  this.driver = driver;
  if (!driver.getCurrentUrl().contains(URL_MATCH)) {
   throw new IllegalStateException("This is not the page you are expected");
  }

  PageFactory.initElements(driver, this);
  this.driver = driver;
 }

 private void authUser(User user) {
  System.out.println(driver.getTitle());
  login.sendKeys(user.login);
  password.sendKeys(user.password);
  bSubmitAuth.click();
 }

 public HomePage authUserSuccess(User user) {
  authUser(user);
  return new HomePage(driver);
 }

 public RegistrationPage authUserError(User user) {
  authUser(user);
  return new RegistrationPage(driver);
 }

 public RegistrationPage checkErrorMessage(String errorMessage) {
  Assert.assertTrue(authError.isDisplayed(), "Error message should be present");
  Assert.assertTrue(authError.isDisplayed(), authError.getText().contains(errorMessage) + "Error message should contains");
  return this;

 }
}
