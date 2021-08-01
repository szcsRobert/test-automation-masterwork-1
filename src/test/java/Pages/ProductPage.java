package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
  WebDriver driver;

  @FindBy(id = "empty-product-comment")
  WebElement addCommentButton;

  public ProductPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getCommentsDiv() {
    return driver.findElement(By.className("row"));
  }

  public boolean isLoaded() {
    return this.getCommentsDiv().isDisplayed();
  }

  public WebElement getAddCommentButton() {
    return addCommentButton;
  }
}
