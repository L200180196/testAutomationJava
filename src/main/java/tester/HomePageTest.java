package tester;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    public static WebDriver driver;

    @BeforeTest
    private void init() {
        System.setProperty("webdriver.edge.driver", "D:/Programs/EdgeDriver.exe");
        driver = new EdgeDriver();

        driver.navigate().to("https://dashboard-staging.rekalaba.com");
        driver.manage().window().maximize();
    }

    @Test
    private void allCase() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // LOGIN
        WebElement email = driver.findElement(By.id("mat-input-0"));
        email.sendKeys("pinnuspryandi@gmail.com");
        driver.findElement(By.id("mat-input-1")).sendKeys("admin123456");
        driver.findElement(By.className("submit-button")).click();

        // Find Customer Menu
        WebElement customer = driver.findElement(By.xpath("//*[contains(text(),'Customer (CRM)')]"));
        customer.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tunggu hingga 10 detik
        WebElement customerList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Customer List')]")));
        customerList.click();

        // Add Customer
        WebElement addCustomer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'+ Add Customer')]")));
        addCustomer.click();
        WebElement customerName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-4")));
        customerName.sendKeys("Lana21");
        WebElement customerEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-5")));
        customerEmail.sendKeys("Lana21@gmail.com");
        WebElement customerPhone = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-6")));
        customerPhone.sendKeys("12312312");
        WebElement customerAddress = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-7")));
        customerAddress.sendKeys("Jalan Angkasa");
        WebElement customerCompany = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-8")));
        customerCompany.sendKeys("Angkasa Raya");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Save')]"))).click();

        // Example Alternatife karena Id nya kadang beda
        // WebElement sayuranInput = driver.findElement(By.cssSelector("input[placeholder='Customer Name']"));

        // Update Customer
        WebElement selectCustomer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Lana21@gmail.com')]")));
        selectCustomer.click();
        WebElement updateName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[formcontrolname='name']")));
        updateName.clear();
        updateName.sendKeys("Lana");
        WebElement updaterEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[formcontrolname='email']")));
        updaterEmail.clear();
        updaterEmail.sendKeys("L@gmail.com");
        WebElement updatePhone = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[formcontrolname='phoneNo']")));
        updatePhone.clear();
        updatePhone.sendKeys("000000000");
        WebElement updateAddress = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[formcontrolname='address']")));
        updateAddress.clear();
        updateAddress.sendKeys("Jalan Bumi");
        WebElement updateCompany = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[formcontrolname='companyName']")));
        updateCompany.clear();
        updateCompany.sendKeys("Bumi Raya");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Save')]"))).click();

    }
}
