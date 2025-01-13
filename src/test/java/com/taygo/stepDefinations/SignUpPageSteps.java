package com.taygo.stepDefinations;

import com.taygo.base.DriverFactory;
import com.taygo.pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class SignUpPageSteps extends DriverFactory {
    private final SignUpPage signUpPage;
    private final JavascriptExecutor js;

    public SignUpPageSteps() {
        this.driver = DriverFactory.getDriver();
        this.signUpPage = new SignUpPage(driver);
        this.js = (JavascriptExecutor) driver;
    }

    @Given("user on the Signup page")
    public void userOnTheSignupPage() {
        signUpPage.clickOnSignUpButton();
        signUpPage.signUpButton.click();
    }

    @When("user enter firstName {string}, lastName {string}, Email {string}, password {string}")
    public void userEnterFirstNameLastNameEmailPassword(
            String fn, String ln, String email, String password) throws InterruptedException {
        signUpPage.fillForm(fn, ln, email, password);
        if (signUpPage.checkBox.isEnabled()) {
            signUpPage.checkBox.click();
        }
        Thread.sleep(100);
        signUpPage.submitButton.click();
        Thread.sleep(2000);
    }


    @When("user enter firstName {string}, lastName {string}, email {string}, mobile {string}")
    public void userEnterFirstNameLastNameEmailMobile(String fn, String ln, String email, String mobNumber) throws InterruptedException {
        signUpPage.fillForm(fn, ln, email, mobNumber);
        signUpPage.submitButton.click();
        Thread.sleep(2000);
    }

    @Then("user verify error messages for firstName {string}, lastName {string}, email {string},and  mobileNum {string}")
    public void userVerifyErrorMessagesForFirstNameLastNameEmailAndMobileNum(String fn, String ln, String email, String mobilnum) {

        // Assert that the actual validation messages match the expected messages
        if (!fn.isBlank()) {
            Assert.assertEquals(
                    fn,
                    signUpPage.errorText.getText());
        }
        if (!ln.isBlank()) {
            System.out.println("name of error ln" + signUpPage.errorText.getText());
            Assert.assertEquals(
                    ln,
                    signUpPage.errorText.getText());
        }
        if (!email.isBlank()) {
            Assert.assertEquals(
                    email,
                    signUpPage.errorText.getText());
        }
        if (!mobilnum.isBlank()) {
            Assert.assertEquals(
                    mobilnum,
                    signUpPage.errorText.getText());
        }
    }

    @When("user enter fill the form as firstName {string}, lastName {string}, mobile {string}")
    public void userEnterFillTheFormAsFirstNameLastNameMobile(String fn, String ln, String mobile) throws InterruptedException {
        signUpPage.fillValidForm(fn, ln, mobile);
    }

    @When("user enter firstName {string}, lastName {string}, mobile {string}")
    public void userEnterFirstNameLastNameMobile(String fn, String ln, String mobile) throws InterruptedException {
        signUpPage.fillValidForm(fn, ln, mobile);
    }

    @And("user set the password {string}")
    public void userSetThePassword(String password) {
        signUpPage.fillPassword(password);
    }

    @And("user fill the individual information JobTitle {string} NMLS_ID {string} Address1 {string} Address2 {string} City {string} ZipCode {string} State {string}")
    public void userFillTheIndividualInformation(String JobTitle, String NMlID, String Address1, String Address2, String City, String ZipCode, String State) {
        signUpPage.fillIndividualInformation(JobTitle, NMlID, Address1, Address2, City, ZipCode, State);
    }

    @And("user fill the company information CompanyName {string} CompanyNMLSID {string} CompanyType {string} Address1 {string} Address2nd {string} City {string} ZipCode {string} State {string} LoanOfficers {string} WebSiteURL {string}")
    public void companyInformation(String companyName, String companyNMLSID, String companyType, String Address1, String Address2nd, String city, String zipCode, String state, String loanOfficers, String webSiteURL) {
        signUpPage.fillCompanyInfo(companyName, companyNMLSID, companyType, Address1, Address2nd, city, zipCode, state, loanOfficers, webSiteURL);
    }

    @And("user verify the cell phone number {string}")
    public void cellPhoneVerification(String mobileNumber) throws InterruptedException {
        signUpPage.sendVerificationCode();
        signUpPage.getVerificationCode(mobileNumber);
        signUpPage.cellPhoneVerification();
    }

    @And("user upload a profile picture")
    public void uploadProfilePhoto() {
        signUpPage.uploadProfilePicture();
    }

    @And("user select a package")
    public void packageSelection() {
        signUpPage.selectPackage();
    }

    @And("user select a company package")
    public void userSelectACompanyPackage() {
        signUpPage.selectCompanyPackage();
    }

    @And("user experiences consistent brand aesthetics")
    public void brandAesthetics() {
        signUpPage.brandAesthetic();
    }

    @And("user enter Name on Card {string}, Card number {string}, date {string} and CVV {string}")
    public void mySubscriptionSummary(String cardName, String cardNumber, String date, String cvv) throws InterruptedException {
        signUpPage.myPaymentMethod(cardName, cardNumber, date, cvv);
    }

    @Then("verify the user dashboard")
    public void verifyDashboard() {
        signUpPage.dashboardMenu();
    }

    @Then("user verify the child account")
    public void verifyChildAccount() throws InterruptedException {
        signUpPage.verifyTheChildAccount();
    }

    @And("user verify the my apps")
    public void verifyMyApps() throws InterruptedException {
        signUpPage.mortgageCalculator();
        signUpPage.reviewApp();
        signUpPage.chatEngagement();
        signUpPage.calendarScheduler();
        signUpPage.formBuilder();
        signUpPage.todaysRate();

    }


}

