package ru.qualitylab.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.qualitylab.mailrumanager.MailRuPageManager;

public class BaseTest {
    protected final MailRuPageManager page = new MailRuPageManager();

    @BeforeMethod
    public void setUp() {
        page.init();
    }

    @AfterMethod
    public void tearDown() {
        page.stop();
    }
}
