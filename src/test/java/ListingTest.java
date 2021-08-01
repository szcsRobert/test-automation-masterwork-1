import Pages.AccessoriesPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ListingTest extends BaseTest {
  @Test
  public void listingSuccessful() {
    AccessoriesPage accessoriesPage = PageFactory.initElements(driver, AccessoriesPage.class);
    boardingPage.getAccessoriesMenu().click();
    assertThat(accessoriesPage.isLoaded()).isTrue();
    assertThat(accessoriesPage.getHeader().getText()).isEqualTo("ACCESSORIES");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,500)", accessoriesPage.getSortByDropdown());
    assertThat(accessoriesPage.getSortByDropdown().getText()).isEqualTo("Relevance\n" + "\uE5C5");
    assertThat(accessoriesPage.isPricesInAscendingOrder()).isFalse();
    accessoriesPage.getSortByDropdown().click();
    accessoriesPage.getSortByPriceLowToHigh().click();
    wait.until(ExpectedConditions.textToBePresentInElement(accessoriesPage.getSortByDropdown(), "Price, low to high"));
    js.executeScript("window.scrollBy(0,900)", accessoriesPage.getSortByDropdown());
    assertThat(driver.getCurrentUrl()).isEqualTo("http://test-automation-shop1.greenfox.academy/6-accessories?order=product.price.asc");
    assertThat(accessoriesPage.getSortByDropdown().getText()).isEqualTo("Price, low to high\n" + "\uE5C5");
    assertThat(accessoriesPage.isPricesInAscendingOrder()).isTrue();
  }
}
