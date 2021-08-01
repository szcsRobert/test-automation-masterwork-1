package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
  WebDriver driver;

  @FindBy(tagName = "h1")
  WebElement header;

  @FindBy(partialLinkText = "Next")
  WebElement nextLink;

  @FindBy(className = "col-md-4")
  WebElement showingActualPagesText;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getProductsDisplayed() {
    return driver.findElement(By.id("products"));
  }

  public boolean isLoaded() {
    return this.getProductsDisplayed().isDisplayed();
  }

  public WebElement getHeader() {
    return header;
  }

  public WebElement getNextLink() {
    return nextLink;
  }

  public WebElement getShowingActualPagesText() {
    return showingActualPagesText;
  }
}
