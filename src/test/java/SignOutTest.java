import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SignOutTest extends BaseTest {
  @Test
  public void signOutSuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    boardingPage.getSignInLink().click();
    loginPage.signIn("sikeresteszt@gmail.com", "test1234");
    boardingPage.getSignOutLink().click();
    assertThat(boardingPage.getSignInLink().getText()).isEqualTo("\uE7FF Sign in");
  }
}
