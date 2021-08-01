import Pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaginationTest extends BaseTest {
  @Test
  public void paginationSuccessful() {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    js.executeScript("window.scrollBy(0,800)", boardingPage.getAllProductsLink());
    boardingPage.getAllProductsLink().click();
    assertThat(homePage.isLoaded()).isTrue();
    assertThat(homePage.getHeader().getText()).isEqualTo("HOME");
    js.executeScript("window.scrollBy(0,1300)", homePage.getNextLink());
    homePage.getNextLink().click();
    wait.until(ExpectedConditions.textToBePresentInElement(homePage.getShowingActualPagesText(), "Showing 13-19 of 19 item(s)"));
    js.executeScript("window.scrollBy(0,700)", homePage.getShowingActualPagesText());
    assertThat(driver.getCurrentUrl()).isEqualTo("http://test-automation-shop1.greenfox.academy/2-home?page=2");
    assertThat(homePage.getShowingActualPagesText().getText()).isEqualTo("Showing 13-19 of 19 item(s)");
  }
}
