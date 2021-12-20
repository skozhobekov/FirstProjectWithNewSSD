import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Auth {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[2]/div[3]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[2]/div[3]/div[2]/a")
    private WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[2]/div[3]/p/a")
    private WebElement registration;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPassword (String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginBut() {
        loginButton.click();
    }
}

