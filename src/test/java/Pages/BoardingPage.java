package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardingPage {
  WebDriver driver;

  @FindBy(id = "_desktop_user_info")
  WebElement signInLink;

  @FindBy(partialLinkText = "Sign out")
  WebElement signOutLink;

  @FindBy(xpath = "//span[contains(text(),'Sikeres Teszt')]")
  WebElement account;

  @FindBy(id = "category-6")
  WebElement accessoriesMenu;

  @FindBy(partialLinkText = "All products")
  WebElement allProductsLink;

  @FindBy(xpath = "//a[contains(text(),'Hummingbird printed t-shirt')]")
  WebElement firstProductLink;

  public BoardingPage(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get("http://test-automation-shop1.greenfox.academy/");
    driver.manage().window().maximize();
  }

  public WebElement getFooter() {
    return driver.findElement(By.id("footer"));
  }

  public boolean isLoaded() {
    return this.getFooter().isDisplayed();
  }

  public WebElement getSignInLink() {
    return signInLink;
  }

  public WebElement getSignOutLink() {
    return signOutLink;
  }

  public WebElement getAccount() {
    return account;
  }

  public WebElement getAccessoriesMenu() {
    return accessoriesMenu;
  }

  public WebElement getAllProductsLink() {
    return allProductsLink;
  }

  public WebElement getFirstProductLink() {
    return firstProductLink;
  }
}
