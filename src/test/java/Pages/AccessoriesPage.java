package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessoriesPage {
  WebDriver driver;

  @FindBy(tagName = "h1")
  WebElement header;

  @FindBy(id = "category-description")
  WebElement description;

  @FindBy(xpath = "//body/main[1]/section[1]/div[1]/div[2]/section[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
  WebElement sortByDropdown;

  @FindBy(xpath = "//a[contains(text(),'Price, low to high')]")
  WebElement sortByPriceLowToHigh;

  public AccessoriesPage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isLoaded() {
    return this.description.isDisplayed();
  }

  public boolean isPricesInAscendingOrder() {
    ArrayList<String> pricesList = new ArrayList<>();
    List<WebElement> prices = driver.findElements(By.className("price"));
    for (WebElement price : prices) {
      pricesList.add(price.getText());
    }
    ArrayList<String> pricesListOrdered = new ArrayList<>(pricesList);
    Collections.sort(pricesListOrdered);
    return pricesListOrdered.equals(pricesList);
  }

  public WebElement getHeader() {
    return header;
  }

  public WebElement getSortByDropdown() {
    return sortByDropdown;
  }

  public WebElement getSortByPriceLowToHigh() {
    return sortByPriceLowToHigh;
  }
}
