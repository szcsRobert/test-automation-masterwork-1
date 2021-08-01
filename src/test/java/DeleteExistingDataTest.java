import Pages.AddressPage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeleteExistingDataTest extends BaseTest {

  @Test
  public void deleteAddressSuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    AddressPage addressPage = PageFactory.initElements(driver, AddressPage.class);
    boardingPage.getSignInLink().click();
    loginPage.signIn("sikeresteszt@gmail.com", "test1234");
    myAccountPage.getAddressLink().click();
    addressPage.createAddress("Success Road 1.", "Miami", "Florida", "33101");
    addressPage.getDeleteLink().click();
    assertThat(addressPage.getMessage().getText()).isEqualTo("Address successfully deleted!");
    assertThat(addressPage.NumberOfAddressesUploaded()).isEqualTo(0);
  }
}
