package WebTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {
    public static LoadProp loadProp = new LoadProp();
    //getting user name for SauceLab from load prop
    public static final String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    //getting AccessKey os Sauce lab from load property
    public static final String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
    //url of saucelab
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:/wd/hub";
    //Two run time parameter one is select browser and other is for running program in sauce lab or local machine
    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    public static final String browser = System.getProperty("browser");

//setting up browser
    public static void setUpBrowser()
    {   LoadProp loadProp = new LoadProp();
        //if sauceLab is true .........................................
        if (SAUCE_LAB) {
            System.out.println("true");
            System.out.println(browser);
            System.out.println("Running in SauceLab ......with browser " + browser);
            if (browser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "windows 8");
                caps.setCapability("version", "78.0");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                // loadProp.getProperty("url");
                //System.out.println(URL);

            } else if (browser.equalsIgnoreCase("ie")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "windows 10");
                caps.setCapability("version", "11");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("firefox")) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "windows 7");
                caps.setCapability("version", "56");
                caps.setCapability("name", "Testing on Firefox 56");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("Safari")) {
                DesiredCapabilities caps = DesiredCapabilities.safari();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "8");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("edge")) {
                DesiredCapabilities caps = DesiredCapabilities.edge();
                caps.setCapability("platform", "windows 10");
                caps.setCapability("version", "16.16299");
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Browser name is Wrong or empty please check");
            }
            // If sauce lab is false.............................................

        } else {

            System.out.println("Selected browser is " + browser);

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else {
                System.out.println("Browser name is wrong or empty please check");
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://demo.nopcommerce.com/");
        }
    }

}
