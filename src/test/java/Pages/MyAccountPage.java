package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
  WebDriver driver;

  @FindBy(tagName = "h1")
  WebElement header;

  @FindBy(id = "_desktop_logo")
  WebElement myStoreLogo;

  @FindBy(id = "identity-link")
  WebElement informationLink;

  @FindBy(id = "address-link")
  WebElement addressLink;

  public MyAccountPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getContent() {
    return driver.findElement(By.id("content"));
  }

  public boolean isLoaded() {
    return this.getContent().isDisplayed();
  }

  public WebElement getHeader() {
    return header;
  }

  public WebElement getMyStoreLogo() {
    return myStoreLogo;
  }

  public WebElement getInformationLink() {
    return informationLink;
  }

  public WebElement getAddressLink() {
    return addressLink;
  }
}
