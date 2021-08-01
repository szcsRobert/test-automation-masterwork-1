package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
  WebDriver driver;

  @FindBy(name = "email")
  WebElement emailFiled;

  @FindBy(name = "password")
  WebElement passwordField;

  @FindBy(id = "submit-login")
  WebElement submitButton;

  @FindBy(linkText = "No account? Create one here")
  WebElement registrationLink;

  @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
  WebElement authenticationAlert;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getForm() {
    return driver.findElement(By.id("login-form"));
  }

  public boolean isLoaded() {
    return this.getForm().isDisplayed();
  }

  public void signIn(String email, String password){
    getEmailFiled().sendKeys(email);
    getPasswordField().sendKeys(password);
    getSubmitButton().click();
  }

  public WebElement getEmailFiled() {
    return emailFiled;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getSubmitButton() {
    return submitButton;
  }

  public WebElement getRegistrationLink() {
    return registrationLink;
  }

  public WebElement getAuthenticationAlert() {
    return authenticationAlert;
  }
}
