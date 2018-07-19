package com.ksergie;

import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SeleniumExtension.class)
@DisplayName("Register page tests")

public class RegisterPageTests {
    @TestTemplate
    void testRegisterWithCorrectData(WebDriver driver){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register();
    }

}
