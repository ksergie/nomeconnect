package com.ksergie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url = "http://afdatest.nome.co.za/";
    private By buttonRegister = By.xpath("//button/span[text()='Register']");
    private By anchorPre_register = By.xpath("//div[@class='col-centered col-sm-4 col-xs-12']/h2");

    public void registration(){
        driver.manage().window().maximize();
        driver.get(url);
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(buttonRegister)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(buttonRegister));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
                "Do I qualify?",
                "We are not on the pre_register page");
    }
}
