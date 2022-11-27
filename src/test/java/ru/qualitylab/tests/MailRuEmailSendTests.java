package ru.qualitylab.tests;

import org.testng.annotations.Test;

public class EmailSendTests extends BaseTest {

    @Test
    public void emailComposeAndSendTest() throws InterruptedException {
        page.login("aatest00", "dftbNtzHKzuJ6r5U");

        page.openComposeNewEmailForm();

        page.fillInToField("test@test.com");
        page.fillInEmailBody("Lorem ipsum dolor sit amet");

        page.clickSendButton();

        page.checkEmailSent();

    }
}
