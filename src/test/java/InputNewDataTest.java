import Pages.LoginPage;
import Pages.ModalPage;
import Pages.MyAccountPage;
import Pages.ProductPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputNewDataTest extends BaseTest {
  @Test
  public void addNewCommentSuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
    ModalPage modalPage= PageFactory.initElements(driver, ModalPage.class);
    boardingPage.getSignInLink().click();
    loginPage.signIn("sikeresteszt@gmail.com", "test1234");
    myAccountPage.getMyStoreLogo().click();
    assertThat(driver.getCurrentUrl()).isEqualTo("http://test-automation-shop1.greenfox.academy/");
    boardingPage.getFirstProductLink().click();
    assertThat(productPage.isLoaded()).isTrue();
    js.executeScript("window.scrollBy(0,800)", productPage.getAddCommentButton());
    productPage.getAddCommentButton().click();
    wait.until(ExpectedConditions.visibilityOf(modalPage.getCommentModal()));
    driver.switchTo().activeElement();
    modalPage.getCommentTitle().sendKeys("Comment1");
    modalPage.getReview().sendKeys("Fantastic product!");
    modalPage.getSendButton().click();
    wait.until(ExpectedConditions.visibilityOf(modalPage.getCommentPostedModal()));
    driver.switchTo().activeElement();
    assertThat(modalPage.getSuccessfulAddingCommentMessage().getText()).isEqualTo("Your comment has been submitted and will be available once approved by a moderator.");
  }
}
