package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage {
  WebDriver driver;

  @FindBy(name = "firstname")
  WebElement firstNameField;

  @FindBy(name = "lastname")
  WebElement lastNameField;

  @FindBy(name = "email")
  WebElement emailField;

  @FindBy(name = "password")
  WebElement password;

  @FindBy(name = "customer_privacy")
  WebElement customerPrivacyCheckbox;

  @FindBy(name = "psgdpr")
  WebElement termsAndConditionsCheckbox;

  @FindBy(linkText = "terms and conditions and the privacy policy")
  WebElement termsAndConditionsLink;

  @FindBy(xpath = "//button[contains(text(),'Save')]")
  WebElement saveButton;

  public CreateAccountPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getForm() {
    return driver.findElement(By.id("customer-form"));
  }

  public boolean isLoaded() {
    return this.getForm().isDisplayed();
  }

  public void createAnAccount(String firstName, String email, String password){
    getFirstNameField().sendKeys(firstName);
    getEmailField().sendKeys(email);
    getPassword().sendKeys(password);
    getCustomerPrivacyCheckbox().click();
    getTermsAndConditionsCheckbox().click();
    getSaveButton().click();
  }

  public void createAnAccount(String firstName, String lastName, String email, String password){
    getFirstNameField().sendKeys(firstName);
    getLastNameField().sendKeys(lastName);
    getEmailField().sendKeys(email);
    getPassword().sendKeys(password);
    getCustomerPrivacyCheckbox().click();
    getTermsAndConditionsCheckbox().click();
    getSaveButton().click();
  }

  public WebElement getFirstNameField() {
    return firstNameField;
  }

  public WebElement getLastNameField() {
    return lastNameField;
  }

  public WebElement getEmailField() {
    return emailField;
  }

  public WebElement getPassword() {
    return password;
  }

  public WebElement getCustomerPrivacyCheckbox() {
    return customerPrivacyCheckbox;
  }

  public WebElement getTermsAndConditionsCheckbox() {
    return termsAndConditionsCheckbox;
  }

  public WebElement getTermsAndConditionsLink() {
    return termsAndConditionsLink;
  }

  public WebElement getSaveButton() {
    return saveButton;
  }
}
