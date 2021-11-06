import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.internal.annotations.IAfterClass;


public class Auth extends Property  {

    private String reportDirectory = "reports";
    private String reportFormat = "JSON";
    private ChromeDriver driver = null;

@BeforeTest
public void prepareForRun() {
    System.setProperty(Property.BROWSERSYSNAME, Property.CHROME_DRIVER_PATH);
    driver = new ChromeDriver();
    driver.get(SITE_ADDRESS);
    driver.manage().window().maximize();
}

    @Test(priority = 1)
    public void Authorized() throws InterruptedException {
        //System.setProperty(Property.BROWSERSYSNAME, Property.CHROME_DRIVER_PATH);
        //WebDriver driver = new ChromeDriver();
        //driver.get(SITE_ADDRESS);
        //driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get(SITE_ADDRESS);
        Thread.sleep(3000);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/header/div/div[4]/a/img")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[4]/a[2]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/header/div/div[4]/a[2]/img")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[4]/a[2]/img")).click();
        WebElement eMail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement passWord = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[3]/button"));
        eMail.click();
        eMail.sendKeys("s.kozhobekov.synapse.company@gmail.com");
        passWord.click();
        passWord.sendKeys("Sanjarbaike96$$$");
        submitButton.click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[4]/div/img")).click();

        Thread.sleep(1000);

        WebElement exitButton = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[4]/div/div/ul/li[2]"));
        //WebElement profileButton = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[4]/div"));

        if (exitButton.isDisplayed()) {
            System.out.println("Авторизация произведена успешно");
        } else {
            System.out.println("Авторизация провалена");
        }
    }

   @Test(priority = 2)
    public void QuitFromSelfcare() throws InterruptedException {
        //driver.navigate().refresh();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[4]/div")).click();
        Thread.sleep(1000);
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/header/div/div[4]/div/div")));

        WebElement exitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[4]/div/div/ul/li[2]"));
        System.out.println("Дебаг проведён");


        //driver.findElement(By.xpath("")).click();
        //driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[4]/div/div/ul/li[2]")).click();
        //driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/button")).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]")));
        WebElement closeWindow = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/h3"));

        String exitText = closeWindow.getText();
        System.out.println(exitText);
}


    @Test(priority = 3)
    public void AuthByDeletedAcc() throws InterruptedException {
        System.setProperty(Property.BROWSERSYSNAME, Property.CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(Property.SITE_ADDRESS);
        driver.manage().window().maximize();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div")));
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/button")).click();
        new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[4]/a[2]/img")));
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[4]/a[2]/img")).click();
        Thread.sleep(2000);
        WebElement loginWindow = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        loginWindow.sendKeys("aktansalmorbekov666@gmail.com");
        Thread.sleep(2000);
        WebElement passwordWindow = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordWindow.click();
        Thread.sleep(1000);
        passwordWindow.sendKeys("Sanjarbaike96$$$");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[3]/button/span"));
        submitButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]")));
        boolean expectedResult = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]")).isDisplayed();

        if (expectedResult = true) {
            System.out.println("Тест-кейс проведен успешно");
        } else {
            System.out.println("Кейс не пройден");
        }
    }

    /*@Test(priority = 2)
    public void Unauthorized() throws InterruptedException {
        System.setProperty(Property.BROWSERSYSNAME, Property.CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
    }
*/


    @AfterTest
    public void tearDown() {
        System.out.println("Тестирование завершено");
        driver.quit();

    }
}
