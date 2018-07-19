package com.ksergie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private String url = "http://afdatest.nome.co.za/";
    private By buttonRegister = By.xpath("//button/span[text()='Register']");

    public void registration(){
        driver.manage().window().maximize();
        driver.get(url);

    }
}
