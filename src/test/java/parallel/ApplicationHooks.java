package parallel;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.factory.DriverFactory;
import com.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
        driver.get(prop.getProperty("url"));

    }

//     @After(order = 1)
//     public void tearDown(Scenario scenario) {
// //        if (scenario.isFailed()) {
// //            String screenshotName = scenario.getName().replaceAll(" ", "_");
// //            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
// //            scenario.attach(sourcePath, "image/png", screenshotName);
// //        }
        
//         if (scenario.isFailed()) {
//             // Capture Screenshot for failed tests
//             byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//             scenario.attach(screenshot, "image/png", scenario.getName());
//         }
//         quitBrowser();
//     }

    @After(order = 0)
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("Driver is null, skipping browser quit.");
        }
    }
}
