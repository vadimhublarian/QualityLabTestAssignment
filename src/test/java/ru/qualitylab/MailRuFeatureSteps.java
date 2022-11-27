package ru.qualitylab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class MailRuFeatureSteps {

    WebDriver driver = new ChromeDriver();

    @Given("browser is opened on login page")
    public void browserIsOpenedOnLoginPage() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://account.mail.ru/login");
    }

    @When("logged in with valid creds")
    public void login() {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("aatest00");
        usernameField.sendKeys(Keys.ENTER);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("dftbNtzHKzuJ6r5U");
        passwordField.sendKeys(Keys.ENTER);
    }

    @When("compose new email form is opened")
    public void openComposeNewEmailForm() {
        driver.findElement(By.className("compose-button__txt")).click();
    }


    @And("filled in Email body with text {string}")
    public void fillInEmailBodyWithText(String arg0) {
        WebElement bodyTextArea = driver.findElement(By.xpath(".//div[@role='textbox']"));
        bodyTextArea.clear();
        bodyTextArea.sendKeys(arg0);
    }

    @And("filled in To field with email {string}")
    public void fillInToFieldWithEmail(String arg0) {
        WebElement emailInput = driver.findElement(By.xpath(".//div[contains(@class,'inputContainer')]//input[@type='text']"));
        emailInput.sendKeys(arg0);
    }

    @And("clicked the Send Button")
    public void clickedTheSendButton() {
        WebElement sendButton = driver.findElement(By.xpath(".//button[@data-test-id='send']"));
        sendButton.click();
    }

    @Then("Email sent successfully")
    public void emailSent() {
        WebElement emailSentMessageContainer = driver.findElement(By.xpath(".//div[contains(@class,'layer-sent-page')]"));
        emailSentMessageContainer.isDisplayed();

        Assert.assertTrue(emailSentMessageContainer.isDisplayed(), "\"Письмо отправлено\" text is not found!");
    }
}
