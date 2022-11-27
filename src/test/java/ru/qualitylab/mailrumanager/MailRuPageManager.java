package ru.qualitylab.mailrumanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class MailRuPageManager {
    WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://account.mail.ru/login");

    }

    public void stop() {
        driver.quit();
    }

    public void login(String username, String password) {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);
        usernameField.sendKeys(Keys.ENTER);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
    }

    public void openComposeNewEmailForm() {
        driver.findElement(By.className("compose-button__txt")).click();
    }

    public void fillInEmailBody(String bodyText) {
        WebElement bodyTextArea = driver.findElement(By.xpath(".//div[@role='textbox']"));
        bodyTextArea.clear();
        bodyTextArea.sendKeys(bodyText);
    }

    public void fillInToField(String emailAddress) {
        WebElement emailInput = driver.findElement(By.xpath(".//div[contains(@class,'inputContainer')]//input[@type='text']"));
        emailInput.sendKeys(emailAddress);
    }

    public void clickSendButton() {
        WebElement sendButton = driver.findElement(By.xpath(".//button[@data-test-id='send']"));
        sendButton.click();
    }

    public void checkEmailSent() {
        WebElement emailSentMessageContainer = driver.findElement(By.xpath(".//div[contains(@class,'layer-sent-page')]"));
        emailSentMessageContainer.isDisplayed();

        Assert.assertTrue(emailSentMessageContainer.isDisplayed(), "\"Письмо отправлено\" text is not found!");
    }
}
