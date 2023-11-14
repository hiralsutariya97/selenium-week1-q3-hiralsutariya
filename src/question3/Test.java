package question3;
/**
 * Project-3 - ProjectName : com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Test {
    static String baseUrl = "https://the-internet.herokuapp.com/login";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {

        // Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }

        //Open the URL into browser
        driver.get(baseUrl);
        //Maximise the browser
        driver.manage().window().maximize();
        //We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //Get Current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());

        //Get Page Source
        System.out.println(driver.getPageSource());

        //Find Email field Element ant Type the Email
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("Tomsmith");

        //Find Password field Element ant Type the Email
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Click on login button
        driver.findElement(By.cssSelector("i[class^='fa fa-2x fa-sign-in']")).click();

        // Print the current URL
        System.out.println("The Current Page URL: " + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();

        //close the browser
        driver.quit();
    }
}
