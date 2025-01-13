package com.taygo.pages;

import com.taygo.base.DriverFactory;
import com.taygo.utility.*;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.restassured.RestAssured;
import io.restassured.response.Response;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.taygo.utility.EmailFormat.email;
import static com.taygo.utility.VerificationCode.VerifyCode;

public class SignUpPage extends DriverFactory {
    public EmailFormat emailFormat = new EmailFormat ();
    public VerificationCode verificationCode = new VerificationCode ();
    public String projectPath = System.getProperty ("user.dir");
    public String actualMortgageCalculatorAppName;
    public String expectedMortgageCalculatorAppName = "Default Loan Calculator App";
    public String actualMortgageStatus;
    public String expectedMortgageStatus = "PUBLISHED";
    public String actualReviewAppName;
    public String expectedReviewAppName = "Default Review App";
    public String actualReviewAppStatus;
    public String expectedReviewAppStatus = "PUBLISHED";
    public String actualChatEngagementAppName;
    public String expectedChatEngagementName = "Default Chat App";
    public String actualChatEngagementStatus;
    public String expectedChatEngagementStatus = "PUBLISHED";

    public String actualGoogleReviewAppName;
    public String expectedGoogleReviewAppName = "Default Google Review App";
    public String actualGoogleReviewStatus;
    public String expectedGoogleReviewStatus = "UNPUBLISHED";
    public String actualCalendarSchedulerTxt;
    public String expectedCalendarScheduler = "Calendar Scheduler";
    public String actualCalendarSchedulerStatus;
    public String expectedCalendarSchedulerStatus = "UNPUBLISHED";
    public String actualFormBuilderStatus;
    public String expectedFormBuilderStatus = "PUBLISHED";
    public String actualTodaysRateHeading;
    public String expectedTodaysRateHeading = "Compare Rates for All Home Loan Types";
    public String actualChildAccountHeading;
    public String expectedChildAccountHeading = "Child Accounts";
    private String receiveSMSURL = "https://receive-sms-free.cc/Free-USA-Phone-Number/1";
    String filePath = projectPath + "/src/main/resources/testdata/taygo_logo.jpeg";

    public SignUpPage (WebDriver driver) {
        PageFactory.initElements (new HighlightElementLocatorFactory (driver) , this);
    }

    @FindBy (css = "a[href*='signup']")
    public WebElement signUpButton;

    @FindBy (css = "li[class*='suggestion-item'] span")
    List <WebElement> addressOptions;

    @FindBy (name = "first_name")
    public WebElement firstNameText;

    @FindBy (name = "last_name")
    public WebElement lastNameText;

    @FindBy (name = "email")
    public WebElement emailText;

    @FindBy (name = "mobileno")
    public WebElement mobileTextBox;

    @FindBy (css = "[type='checkbox']")
    public WebElement checkBox;

    @FindBy (css = "[type='submit']")
    public WebElement submitButton;

    @FindBy (css = "[class*='MuiFormHelperText']")
    public WebElement errorText;

    @FindBy (css = "[class*='MuiButton-contained']")
    public WebElement verifyCodeSubmitButton;

    @FindBy (xpath = "//*[text()='Verifying Invite Link']")
    public WebElement verifyLinkText;

    @FindBy (name = "password")
    public WebElement passwordText;

    @FindBy (id = "signin-confirm-password")
    public WebElement confirmPasswordText;

    @FindBy (css = "[class*='MuiOutlinedInput'] input")
    public WebElement codeText;

    @FindBy (css = "[src*='icon_loader_home']")
    public WebElement loadingHomePageIcon;

    //Individual Information

    @FindBy (name = "title")
    public WebElement jobTitleText;
    @FindBy (name = "nmls_id")
    public WebElement nmlsIdText;
    @FindBy (name = "street_1")
    public WebElement address1;
    @FindBy (name = "street_2")
    public WebElement address2nd;
    @FindBy (name = "city")
    public WebElement cityName;
    @FindBy (xpath = "//input[@name='state']/..")
    public WebElement stateName;
    @FindBy (xpath = "//div[contains(@id,'react-select-3-option')]/descendant::p")
    List <WebElement> stateOptions;
    @FindBy (name = "postal_code")
    public WebElement zipCode;
    @FindBy (css = "button[type='button'][class*='MuiButton-containedPrimary']")
    public WebElement nextButton;
    @FindBy (name = "account_name")
    public WebElement companyNameTxtField;
    @FindBy (name = "companyNmls")
    public WebElement companyNMLSIDTxtField;
    @FindBy (xpath = "//input[@name='companyType']/..")
    public WebElement companyTypeTxtField;
    @FindBy (xpath = "//div[@data-id='Menu_List']/descendant::p")
    List <WebElement> companyTypeOptions;
    @FindBy (name = "companyCity")
    public WebElement companyCityTxtField;
    @FindBy (name = "companyAddress")
    public WebElement companyAddress1TxtField;
    @FindBy (css = "[placeholder='Address 2']")
    public WebElement companyAddress2ndTxtField;
    @FindBy (name = "companyZip")
    public WebElement companyZipCodeTxtField;
    @FindBy (xpath = "//input[@name='companyState']/..")
    public WebElement companyStateTxtField;
    @FindBy (xpath = "//div[@data-id='Menu_List']/descendant::p")
    List <WebElement> companyStateOptions;
    @FindBy (name = "numberLOs")
    public WebElement numberOfLoanOfficersTxtField;
    @FindBy (name = "companyWebsite")
    public WebElement companyWebsiteTxtField;
    @FindBy (xpath = "//button[text()='Send Code']")
    public WebElement sendCodeButton;
    @FindBy (xpath = "//button[text()='Resend Code']")
    public WebElement resendCodeButton;
    @FindBy (css = "input[aria-label*='Character'][type='text']")
    public List <WebElement> verificationCodeTextFields;
    @FindBy (xpath = "//button[text()='Verify Code']")
    public WebElement verifyCodeButton;
    @FindBy (xpath = "//h1[contains(@class,'MuiTypography-h1')]")
    public WebElement profilePictureHeading;
    @FindBy (css = "input[type='file']")
    public WebElement uploadPhoto;
    @FindBy (xpath = "//button[text()='Remove Photo']")
    public WebElement removePhoto;
    @FindBy (xpath = "(//div[contains(@class,'package-right-corner-icon')]/..)[1]")
    public WebElement selectPackage;
    @FindBy (xpath = "(//div[contains(@class,'package-right-corner-icon')]/..)[2]")
    public WebElement selectCompanyPackage;
    @FindBy (xpath = "(//div[@id='onboarding_alert_wrapper']//following::h1)[1]")
    public WebElement brandAestheticsHeading;
    @FindBy (xpath = "(//input[@type='file'])[1]")
    public WebElement uploadBrandAestheticsPhoto;
    @FindBy (xpath = "(//input[@type='file']//following::p)[1]")
    public WebElement uploadedFileTxt;
    @FindBy (xpath = "(//div[@id='onboarding_alert_wrapper']//following::h1)[1]")
    public WebElement myPaymentMethodHeading;
    @FindBy (css = "input[name='domain_name']")
    public WebElement domainName;
    @FindBy (css = "input[name='name_on_card']")
    public WebElement cardNameTxtField;
    @FindBy (css = "span[class='InputContainer'] input[name='cardnumber']")
    public WebElement cardNumberTxtField;
    @FindBy (css = "input[name='exp-date']")
    public WebElement dateTxtField;
    @FindBy (css = "input[name='cvc']")
    public WebElement cvvTxtField;
    @FindBy (css = "div[id='onboarding_next_button_wrapper'] button")
    public WebElement activateAccountButton;
    @FindBy (css = "[name*='privateStripeFrame']")
    public List <WebElement> iFrameElement;
    @FindBy (xpath = "(//div[contains(@class,'MuiDrawer-root')]//following::p)[1]")
    public WebElement dashboardMenu;
    @FindBy (xpath = "//p[text()='My Apps']/..")
    public WebElement myAppsMenu;
    @FindBy (xpath = "//div[text()='Mortgage Calculator']/..")
    public WebElement mortgageCalculatorApp;
    @FindBy (css = "div[data-field='name'] span[class*='MuiTypography-h5']")
    public WebElement loanCalculatorAppNameTxt;
    @FindBy (css = "div[data-field='status'] span[class*='MuiChip-label']")
    public WebElement mortgageCalculatorStatus;
    @FindBy (css = "li[aria-label='Review App']")
    public WebElement reviewAppMenu;
    @FindBy (css = "div[data-field='name'] span[class*='MuiTypography-h5']")
    public WebElement reviewAppNameTxt;
    @FindBy (css = "div[data-field='status'] span[class*='MuiChip-label']")
    public WebElement reviewAppStatus;
    @FindBy (css = "li[aria-label='Chat Engagement']")
    public WebElement chatEngagementMenu;
    @FindBy (css = "div[data-field='name'] span[class*='MuiTypography-h5']")
    public WebElement chatEngagementAppNameTxt;
    @FindBy (css = "div[data-field='status'] span[class*='MuiChip-label']")
    public WebElement chatEngagementStatus;
    @FindBy (css = "li[aria-label='Google Reviews']")
    public WebElement googleReviewsMenu;
    @FindBy (css = "div[data-field='name'] span[class*='MuiTypography-h5']")
    public WebElement googleReviewsAppNameTxt;
    @FindBy (css = "div[data-field='status'] span[class*='MuiChip-label']")
    public WebElement googleReviewsStatus;
    @FindBy (css = "li[aria-label='Calendar Scheduler']")
    public WebElement calendarScheduleMenu;
    @FindBy (xpath = "(//div[@id='apps_alert_wrapper']//following::p)[1]")
    public WebElement calendarSchedulerHeading;
    @FindBy (xpath = "(//div[@id='apps_alert_wrapper']//following::span)[1]")
    public WebElement calendarSchedulerStatus;
    @FindBy (css = "li[aria-label='Form Builder']")
    public WebElement formBuilderMenu;
    @FindBy (css = "div[data-field='status'] span")
    public List <WebElement> formBuilderStatus;
    @FindBy (css = "li[aria-label*='Rate']")
    public WebElement todaysRateMenu;
    @FindBy (css = "h1[class*='MuiTypography-alignCenter']")
    public WebElement compareRatesHeading;
    @FindBy (css = "button[id='account-setting-button']")
    public WebElement accountSettingMenu;
    @FindBy (css = "a[href='/child_account/']")
    public WebElement childAccountMenu;
    @FindBy (css = "div[id='main_topbar_title'] h3")
    public WebElement childAccountHeading;

    public void fillForm (String fn , String ln , String email , String mobile) throws InterruptedException {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (firstNameText);
        firstNameText.sendKeys (fn);
        Thread.sleep (2000);
        lastNameText.sendKeys (ln);
        Thread.sleep (2000);
        emailText.sendKeys (email);
        Thread.sleep (2000);
        mobileTextBox.sendKeys (mobile);
        Thread.sleep (2000);
    }

//    public static String email;


    public void fillValidForm (String fn , String ln , String mobile) throws InterruptedException {
        emailFormat.email ();
        verificationCode.uid ();
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (firstNameText);
        firstNameText.sendKeys (fn);
        lastNameText.sendKeys (ln);
        emailText.sendKeys (email);
        mobileTextBox.sendKeys (mobile);
        submitButton.click ();
        Thread.sleep (18000);
        verificationCode.uid ();
        verificationCode.getMessage ();
    }


    public void fillPassword (String password) {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (codeText);
        codeText.sendKeys (VerifyCode);
        verifyCodeSubmitButton.click ();
        testUtil1.invisibleOfElementWait (verifyLinkText);
        testUtil1.presenceOfElementWait (passwordText);
        passwordText.sendKeys (password);
        confirmPasswordText.sendKeys (password);
        submitButton.click ();
        testUtil1.invisibleOfElementWait (loadingHomePageIcon);
        System.out.println ("wait meor the ");
    }


    public void fillIndividualInformation (String jobTitle , String nms , String address , String address2 , String city , String zipcode , String state) {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (jobTitleText);
        jobTitleText.sendKeys (jobTitle);
        try {
            Thread.sleep (2000);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }
        nmlsIdText.sendKeys (nms);
        address1.sendKeys (address);
        for (WebElement addressList : addressOptions) {
            String addressTab = addressList.getText ();
            if (addressTab.equalsIgnoreCase (address)) {
                addressList.click ();
            }
        }
        address2nd.sendKeys (address2);
        cityName.sendKeys (city);
        stateName.click ();

        try {
            for (WebElement stateList : stateOptions) {
                String stateOption = stateList.getText ();
                if (stateOption.equalsIgnoreCase (state)) {
                    stateList.click ();
                }
            }
        } catch (StaleElementReferenceException e) {
            System.out.println ("Element e" + e);
        }
        zipCode.sendKeys (zipcode);
        nextButton.click ();
    }

    public void fillCompanyInfo (String companyName , String companyNMLSID , String companyType , String Address1 , String Address2nd , String city , String zipCode , String state , String loanOfficers , String webSiteURL) {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (companyNameTxtField);
        companyNameTxtField.sendKeys (companyName+emailFormat.currentDate());
        companyNMLSIDTxtField.sendKeys (companyNMLSID);
        companyTypeTxtField.click ();
        try {
            for (WebElement companyTypeList : companyTypeOptions) {
                String companyTypeTab = companyTypeList.getText ();
                System.out.println ("Company Type name:" + companyTypeTab);
                if (companyTypeTab.equalsIgnoreCase (companyType)) {
                    companyTypeList.click ();
                }
            }
        } catch (StaleElementReferenceException e) {
            System.out.println ("Element e" + e);
        }
        companyAddress1TxtField.sendKeys (Address1);
        companyAddress2ndTxtField.sendKeys (Address2nd);
        companyCityTxtField.sendKeys (city);
        companyZipCodeTxtField.sendKeys (zipCode);
        companyStateTxtField.click ();
        try {
            for (WebElement companyStateList : companyStateOptions) {
                String stateOptionTab = companyStateList.getText ();
                System.out.println ("Company State name:" + stateOptionTab);
                if (stateOptionTab.equalsIgnoreCase (state)) {
                    companyStateList.click ();
                }
            }
        } catch (StaleElementReferenceException e) {
            System.out.println ("Element e" + e);
        }
        numberOfLoanOfficersTxtField.sendKeys (loanOfficers);
        companyWebsiteTxtField.sendKeys (webSiteURL);
        nextButton.click ();
    }

    public void sendVerificationCode () throws InterruptedException {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (sendCodeButton);
        sendCodeButton.click ();
        Thread.sleep (8000);
    }

    public void cellPhoneVerification () throws InterruptedException {
        enterOTP ();
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (verifyCodeButton);
        verifyCodeButton.click ();
//        testUtil1.presenceOfElementWait(nextButton);
        Thread.sleep (10000);
        nextButton.click ();
    }

    public void enterOTP () throws InterruptedException {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (resendCodeButton);
        verificationCodeTextFields.get (0).click ();
        Thread.sleep (3000);
        System.out.println ("Code>>>>>>>>>>" + mobileVerificationCode);

/*        verificationCodeTextFields.get(0).sendKeys(String.valueOf(mobileVerificationCode.charAt(0)));
        verificationCodeTextFields.get(1).sendKeys(String.valueOf(mobileVerificationCode.charAt(1)));
        verificationCodeTextFields.get(2).sendKeys(String.valueOf(mobileVerificationCode.charAt(2)));
        verificationCodeTextFields.get(3).sendKeys(String.valueOf(mobileVerificationCode.charAt(3)));
        verificationCodeTextFields.get(4).sendKeys(String.valueOf(mobileVerificationCode.charAt(4)));
        verificationCodeTextFields.get(5).sendKeys(String.valueOf(mobileVerificationCode.charAt(5)));*/

        for (int i = 0 ; i < verificationCodeTextFields.size () ; i++) {
            verificationCodeTextFields.get (i).sendKeys (String.valueOf (mobileVerificationCode.charAt (i)));
        }

    }

    public static String mobileVerificationCode;

    public void getVerificationCode (String mobileNumber) {
        // Endpoint URL
        String endpointUrl1 = receiveSMSURL + mobileNumber + "/";

        // Send the GET request with necessary headers and cookies
        Response response = RestAssured.given ()

                .header ("User-Agent" , "PostmanRuntime/7.42.0").get (endpointUrl1).then ().extract ().response ();
        // Check if the response status code is 200 (OK)
        if (response.getStatusCode () == 200) {
            // Print the response body
            String responseBody = response.getBody ().asString ();
            System.out.println ("Response Body:");
            System.out.println (responseBody);

            // Regular expression to extract the verification code from the HTML
            String regex = "<span class=\"btn1\" data-clipboard-text=\"\\d+\"><b>(\\d+)<\\/b><\\/span>";
            Pattern pattern = Pattern.compile (regex);
            Matcher matcher = pattern.matcher (responseBody);

            // Check if the verification code was found
            if (matcher.find ()) {
                String verificationCode = matcher.group (1);
                System.out.println ("Verification Code: " + verificationCode);
                mobileVerificationCode = verificationCode;
            } else {
                System.out.println ("Verification code not found in the response.");
            }
        } else {
            // Handle non-200 status codes
            System.out.println ("Failed to get a valid response. Status Code: " + response.getStatusCode ());
        }
    }

    public void uploadProfilePicture () {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (profilePictureHeading);
        uploadPhoto.sendKeys (filePath);
        testUtil1.presenceOfElementWait (removePhoto);
        nextButton.click ();
    }

    public void selectPackage () {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (selectPackage);
        selectPackage.click ();
        nextButton.click ();
    }

    public void selectCompanyPackage () {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (selectCompanyPackage);
        selectCompanyPackage.click ();
        nextButton.click ();
    }

    public void brandAesthetic () {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (brandAestheticsHeading);
        try {
            Thread.sleep (8000);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }
        uploadBrandAestheticsPhoto.sendKeys (filePath);
        try {
            Thread.sleep (20000);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }
        testUtil1.presenceOfElementWait (uploadedFileTxt);
        nextButton.click ();
    }

    public void myPaymentMethod (String cardName , String cardNumber , String date , String cvv) throws InterruptedException {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (cardNameTxtField);
        cardNameTxtField.sendKeys (cardName);
        Thread.sleep (2000);
        testUtil1.switchToIframe (iFrameElement.get (0));
        cardNumberTxtField.sendKeys (cardNumber);
        driver.switchTo ().defaultContent ();
        testUtil1.switchToIframe (iFrameElement.get (1));
        dateTxtField.sendKeys (date);
        driver.switchTo ().defaultContent ();
        testUtil1.switchToIframe (iFrameElement.get (2));
        cvvTxtField.sendKeys (cvv);
        driver.switchTo ().defaultContent ();
        activateAccountButton.click ();
    }

    public void dashboardMenu () {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (dashboardMenu);
    }

    public void verifyTheChildAccount () throws InterruptedException {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (accountSettingMenu);
        Thread.sleep (3000);
        accountSettingMenu.click ();
        testUtil1.presenceOfElementWait (childAccountMenu);
        Thread.sleep (3000);
        childAccountMenu.click ();
        testUtil1.presenceOfElementWait (childAccountHeading);
        Thread.sleep (3000);
        actualChildAccountHeading = childAccountHeading.getText ();
        Assert.assertTrue ("Verify Child Account" , actualChildAccountHeading.contains (expectedChildAccountHeading));
    }

    public void mortgageCalculator () {
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (myAppsMenu);
        myAppsMenu.click ();
        testUtil1.presenceOfElementWait (mortgageCalculatorApp);
        mortgageCalculatorApp.click ();
        testUtil1.presenceOfElementWait (loanCalculatorAppNameTxt);
        actualMortgageCalculatorAppName = loanCalculatorAppNameTxt.getText ();
        Assert.assertTrue ("Verify App Name" , actualMortgageCalculatorAppName.contains (expectedMortgageCalculatorAppName));
        actualMortgageStatus = mortgageCalculatorStatus.getText ();
        Assert.assertTrue ("Verify Status" , actualMortgageStatus.contains (expectedMortgageStatus));
    }

    public void reviewApp () {
        reviewAppMenu.click ();
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (reviewAppNameTxt);
        actualReviewAppName = reviewAppNameTxt.getText ();
        Assert.assertTrue ("Verify App Name" , actualReviewAppName.contains (expectedReviewAppName));
        actualReviewAppStatus = reviewAppStatus.getText ();
        Assert.assertTrue ("Verify Status" , actualReviewAppStatus.contains (expectedReviewAppStatus));
    }

    public void chatEngagement () {
        chatEngagementMenu.click ();
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (chatEngagementAppNameTxt);
        actualChatEngagementAppName = chatEngagementAppNameTxt.getText ();
        Assert.assertTrue ("Verify App Name" , actualChatEngagementAppName.contains (expectedChatEngagementName));
        actualChatEngagementStatus = chatEngagementStatus.getText ();
        Assert.assertTrue ("Verify Status" , actualChatEngagementStatus.contains (expectedChatEngagementStatus));
    }

    public void googleReview () {
        googleReviewsMenu.click ();
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (googleReviewsAppNameTxt);
        actualGoogleReviewAppName = googleReviewsAppNameTxt.getText ();
        Assert.assertTrue ("Verify App Name" , actualGoogleReviewAppName.contains (expectedGoogleReviewAppName));
        actualGoogleReviewStatus = googleReviewsStatus.getText ();
        Assert.assertTrue ("Verify Status" , actualGoogleReviewStatus.contains (expectedGoogleReviewStatus));
    }

    public void calendarScheduler () throws InterruptedException {
        calendarScheduleMenu.click ();
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (calendarSchedulerHeading);
        actualCalendarSchedulerTxt = calendarSchedulerHeading.getText ();
        Assert.assertTrue ("Verify the calendar scheduler page" , actualCalendarSchedulerTxt.contains (expectedCalendarScheduler));
        Thread.sleep (3000);
        testUtil1.presenceOfElementWait (calendarSchedulerStatus);
        actualCalendarSchedulerStatus = calendarSchedulerStatus.getText ();
        Assert.assertTrue ("Verify Status" , actualCalendarSchedulerStatus.contains (expectedCalendarSchedulerStatus));
    }

    public void formBuilder () throws InterruptedException {
        formBuilderMenu.click ();
        Thread.sleep (10000);
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (myAppsMenu);
        myAppsMenu.click ();
        testUtil1.presenceOfElementWait (mortgageCalculatorApp);
        mortgageCalculatorApp.click ();
        testUtil1.presenceOfElementWait (loanCalculatorAppNameTxt);
        formBuilderMenu.click ();
        testUtil1.presenceOfElementWait (formBuilderStatus.get (0));
        Thread.sleep (8000);
        actualFormBuilderStatus = formBuilderStatus.get (0).getText ();
        System.out.println ("Form Builder Status:-" + actualFormBuilderStatus);
        Assert.assertTrue ("Verify the Form Builder status" , actualFormBuilderStatus.contains (expectedFormBuilderStatus));
    }

    public void todaysRate () {
        todaysRateMenu.click ();
        TestUtil testUtil1 = new TestUtil ();
        testUtil1.presenceOfElementWait (compareRatesHeading);
        actualTodaysRateHeading = compareRatesHeading.getText ();
        Assert.assertTrue ("Verify the todays rate heading" , actualTodaysRateHeading.contains (expectedTodaysRateHeading));
    }

    public void clickOnSignUpButton(){
        TestUtil testUtil=new TestUtil ();
        testUtil.presenceOfElementWait (signUpButton);

    }
}

