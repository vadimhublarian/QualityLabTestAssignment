package ru.qualitylab.tests;

import org.testng.annotations.Test;

public class MailRuEmailSendTests extends BaseTest {

    /*
        Тест должен уметь следующее:
        1. залогиниться на mail.ru;
        2. написать письмо любого содержания c заполнением поля Body (текста самого письма);
        3. отправить письмо.
        4. проверить наличие сообщения об отправке письма.
        Проверка доставки письма не нужна, только отправка.
    */
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
