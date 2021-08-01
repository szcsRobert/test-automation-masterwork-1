import Pages.AddressPage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterAddressTest extends BaseTest {
  @Test
  public void registrationAddressSuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    AddressPage addressPage = PageFactory.initElements(driver, AddressPage.class);
    boardingPage.getSignInLink().click();
    loginPage.signIn("successful@gmail.com", "test1234");
    myAccountPage.getAddressLink().click();
    assertThat(addressPage.isLoaded()).isTrue();
    addressPage.createAddress("Success Road 1.", "Miami", "Florida", "33101");
    assertThat(addressPage.getMessage().getText()).isEqualTo("Address successfully added!");
    assertThat(addressPage.NumberOfAddressesUploaded()).isEqualTo(1);
    assertThat(addressPage.printUploadedAddress(0)).isEqualTo("""
        Successful Sarah
        Success Road 1.
        Miami, Florida 33101
        United States""");
    addressPage.getDeleteLink().click();
    boardingPage.getSignOutLink().click();
  }
}
