package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressPage {
  WebDriver driver;
  List<WebElement> addresses;

  @FindBy(name = "address1")
  WebElement addressField;

  @FindBy(name = "city")
  WebElement cityField;

  @FindBy(name = "id_state")
  WebElement stateField;

  @FindBy(name = "postcode")
  WebElement zipField;

  @FindBy(xpath = "//button[contains(text(),'Save')]")
  WebElement saveButton;

  @FindBy(id = "notifications")
  WebElement message;

  @FindBy(xpath = "//span[contains(text(),'Delete')]")
  WebElement deleteLink;

  public AddressPage(WebDriver driver) {
    this.driver = driver;
  }

  public void createAddress(String address, String city, String stateOfUSA, String zip){
    getAddressField().sendKeys(address);
    getCityField().sendKeys(city);
    Select state = new Select(getStateField());
    state.selectByVisibleText(stateOfUSA);
    getZipField().sendKeys(zip);
    getSaveButton().click();
  }

  public int NumberOfAddressesUploaded() {
    addresses = driver.findElements(By.tagName("address"));
    return addresses.size();
  }

  public String printUploadedAddress(int index){
    addresses = driver.findElements(By.tagName("address"));
    return addresses.get(index).getText();
  }

  public WebElement getAddressForm() {
    return driver.findElement(By.className("address-form"));
  }

  public boolean isLoaded() {
    return this.getAddressForm().isDisplayed();
  }

  public WebElement getAddressField() {
    return addressField;
  }

  public WebElement getCityField() {
    return cityField;
  }

  public WebElement getStateField() {
    return stateField;
  }

  public WebElement getZipField() {
    return zipField;
  }

  public WebElement getSaveButton() {
    return saveButton;
  }

  public WebElement getMessage() {
    return message;
  }

  public WebElement getDeleteLink() {
    return deleteLink;
  }
}
