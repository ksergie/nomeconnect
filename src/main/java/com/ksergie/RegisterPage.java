package com.ksergie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // The testing site's URL

    private String url = "http://afdatest.nome.co.za/";

    // XPathes for Pre_register page
    private By buttonRegister = By.xpath("//button/span[text()='Register']");
    private By anchorPre_register = By.xpath("//div[@class='col-centered col-sm-4 col-xs-12']/h2");
    private By checkboxIagree = By.xpath("//label[@for='agreement_checkbox']");
    private By buttonNextPreRegister = By.id("next_button");
    // XPathes for Register/2 page
    private By fieldFirstName = By.id("first_name");
    private By fieldlastName = By.id("last_name");
    private By fieldCellPhone = By.name("cellphone");
    private By fieldEmail = By.name("email");
    private By fieldConfirmEmail = By.name("email_confirmation");
    private By fieldPassword = By.name("password");
    private By fieldConfirmPassword = By.name("password_confirmation");
    private By buttonRegisterRegister2 = By.id("register_btn");
    // XPathes for Apphome page
    private By anchorApphome = By.xpath("//div[@class='jumbotron']/a");
    // XPathes for select_institution page
    private By dropboxSelectInstitute = By.id("institution_select");
    private By optionAFDA = By.xpath("//select[@id='institution_select']/option[@value='1']");
    private By buttonNextSelectInstitution = By.xpath("//input[@type='submit']");
    // XPathe for assessment_process_intro/1 page
    private By buttonNextAssessment = By.xpath("//div[@class='col-xs-12 text-center']/a");
    // XPathe for consent_app_page/119 page
    private By buttonConcentApp = By.xpath("//div[@class='col-md-12  text-center']/a");
    // XPath for Payment page
    private By linkOnlyForTest = By.xpath("(//div[@class='row']/a)[1]");
    // XPathes for BIOGRAPHICAL DATA page
    private By dropboxTitle = By.id("id_title");
    private By optionTitle = By.xpath("//select[@id='id_title']/option[@value='MR']");
    private By dropboxGender = By.id("id_applicant_gender");
    private By optionGender = By.xpath("//select[@id='id_applicant_gender']/option[@value='1']");
    private By dropboxID = By.id("id_id_type");
    private By optionID = By.xpath("//select[@id='id_id_type']/option[@value='ID']");
    private By fieldID = By.id("id_id_number");
    private By inputIDdoc = By.id("id_id_doc");
    private By fieldBirthdate = By.id("id_birth_date");
    private By dropboxEquityCode = By.id("id_equity_code");
    private By optionEquityCode = By.xpath("//select[@id='id_equity_code']/option[@value='W']");
    private By dropboxNationality = By.id("id_nationality");
    private By optionNationality = By.xpath("//select[@id='id_nationality']/option[@value='UA']");
    private By dropboxHomeLanguage = By.id("id_home_language");
    private By optionHomeLanguage = By.xpath("//select[@id='id_home_language']/option[@value='4']");
    private By dropboxRSACitizen = By.id("id_rsa_citizen_resident_status");
    private By optionRSACitizen = By.xpath("//select[@id='id_rsa_citizen_resident_status']/option[@value='Y']");
    private By dropboxSocioStatus = By.id("id_socio_economic_status");
    private By optionSocioStatus = By.xpath("//select[@id='id_socio_economic_status']/option[@value='H']");
    private By dropboxHasDisabilityStatus = By.id("id_has_disability_status");
    private By optionHasDisabilityStatus = By.xpath("//select[@id='id_has_disability_status']/option[@value='Y']");
    private By dropboxDisabilityStatus = By.id("id_disability_status");
    private By optionDisabilityStatus = By.xpath("//select[@id='id_disability_status']/option[@value='C']");
    private By fieldHomeAddress = By.id("id_home_address");
    private By fieldPostAddress = By.id("id_postal_address");
    private By buttonNextBioData = By.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");



    public void registration(){
        driver.manage().window().maximize();
        driver.get(url);

        // Click the Register button

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(buttonRegister)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(buttonRegister));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
                "Do I qualify?",
                "We are not on the pre_register page");

        // Click the checkbox and the Next button on the pre_register page

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(checkboxIagree)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(buttonNextPreRegister)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(buttonNextPreRegister));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
                "Register on NOME Portal",
                "We are not on the register/2 page");

        // fill the Register on NOME Portal page

        String user_name = getUserName();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldFirstName)).sendKeys(user_name);
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldlastName)).sendKeys(user_name);
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldCellPhone)).sendKeys("+380999220963");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldEmail))
                .sendKeys(user_name + "@gmail.com");

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldConfirmEmail))
                .sendKeys(user_name + "@gmail.com");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldPassword)).sendKeys("20nometest18");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldConfirmPassword)).sendKeys("20nometest18");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(buttonRegisterRegister2)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(buttonRegisterRegister2));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorApphome)).getText(),
                "Start my RPL for Access process",
                "We are not on the apphome page");

        // Click the Start my RPL for Access process

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorApphome)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(anchorApphome));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
                "RPL for Access for information",
                "We are not on the select_institution page");

        // Fill the Select institution page

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxSelectInstitute)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxSelectInstitute)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(buttonNextSelectInstitution)).click();
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(buttonNextSelectInstitution));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
                "OVERVIEW OF THE RPL FOR ACCESS PROCESS",
                "We are not on the assessment_process_intro/1 page");

        // Click the Next button on the assessment_process_intro/1 page

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(buttonNextAssessment)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(buttonNextAssessment));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
                "GENERAL TERMS, CONDITIONS AND CONSENT FORM",
                "We are not on the consent_app_page/114 page");

        // Click the Next button on the consent_app_page/119/

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(buttonConcentApp)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(buttonConcentApp));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
                "Payment",
                "We are not on the paymentSage/119 page");

        // Click the link on the Payment page

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(linkOnlyForTest)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(linkOnlyForTest));
        Assertions.assertEquals((new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
                "BIOGRAPHICAL DATA",
                "We are not on the BIOGRAPHICAL DATA page");

        // Fill the BIOGRAPHICAL DATA page

        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxTitle)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionTitle)).click();
//        (new WebDriverWait(driver, 3)).until(ExpectedConditions.invisibilityOfElementLocated(optionTitle));
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxGender)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionGender)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxID)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionID)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldID)).sendKeys("7311065120082");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(inputIDdoc)).sendKeys("D:\\id.png");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldBirthdate)).sendKeys("06111973");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxEquityCode)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionEquityCode)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxNationality)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionNationality)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxHomeLanguage)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionHomeLanguage)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxRSACitizen)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionRSACitizen)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxSocioStatus)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionSocioStatus)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxHasDisabilityStatus)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionHasDisabilityStatus)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(dropboxDisabilityStatus)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(optionDisabilityStatus)).click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldHomeAddress))
                .sendKeys("228 Johannes Ramokhoase(Proes) Street Pretoria South Africa");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(fieldPostAddress))
                .sendKeys("Private Bag X990 Pretoria South Africa");
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(buttonNextBioData)).click();

    }

    private String getUserName(){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date today = Calendar.getInstance().getTime();
        String dat = df.format(today);
        return "nometest" + dat;
    }
}
