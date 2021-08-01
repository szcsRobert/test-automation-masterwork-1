import Pages.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExistingDataUpdateTest extends BaseTest {
  @Test
  public void registrationNameChangeSuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
    boardingPage.getSignInLink().click();
    loginPage.signIn("sikeresteszt@gmail.com", "test1234");
    myAccountPage.getInformationLink().click();
    assertThat(driver.findElement(By.name("email")).getAttribute("value")).isEqualTo("sikeresteszt@gmail.com");
    createAccountPage.createAnAccount("New");
    assertThat(createAccountPage.getSuccessfulUpdateMessage().getText()).isEqualTo("Information successfully updated.");
  }
}
