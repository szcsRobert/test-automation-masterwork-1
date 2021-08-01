import Pages.BoardingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  WebDriver driver;
  WebDriverWait wait;
  BoardingPage boardingPage;
  JavascriptExecutor js;

  @BeforeAll
  public void setup() throws IOException {
    String browser;

    Properties properties = new Properties();
    InputStream propertiesStream = this.getClass().getResourceAsStream("/test.properties");
    properties.load(propertiesStream);
    browser = properties.getProperty("browser");

    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      this.driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      this.driver = new FirefoxDriver();
    } else {
      WebDriverManager.edgedriver().setup();
      this.driver = new EdgeDriver();
    }
    wait = new WebDriverWait(driver, 5);
    js = (JavascriptExecutor) driver;
  }

  @BeforeEach
  public void enterBoardingPage(){
    boardingPage = PageFactory.initElements(driver, BoardingPage.class);
    boardingPage.open();
    assertThat(boardingPage.isLoaded()).isTrue();
  }

//  @AfterAll
//  public void quitFromDriver() {
//    driver.quit();
//  }
}
