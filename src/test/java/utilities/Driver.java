package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    //WebDriver tipinde bir ThreadLocal objecti olusturduk
    //Bu sayede paralel test yaparken her threadin kendi webdriver objectine sahip olmasini sagladik
    //ve böylece pralel olarak calisan farkli threadler birbirlerinin webdriverlerini etkileyemezler
    // ThreadLocal ile her thread için ayrı bir WebDriver objesi oluşturuyoruz.

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            // WebDriver i thread bazında oluşturuyoruz.
            // if'i bu metot her calıştığında yeni bir driver oluşturmaması için kullanıyorruz
            // if driver'i kontrol edecek, eğer bir değer ataması yapıldıysa yeni bir driver oluşturmayacak

            switch (ConfigReader.getProperty("browser")) {
                // case'i driver'i istediğimiz browser'da caliştirmak icin kullanıyoruz
                // configuration.properties dosyasında browser olarak ne yazdıysak, tüm testlerimiz o browser'da calışacak
                // browser secimi yapılmadıysa default olarak chrome devreye girecek
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    driverPool.set(new ChromeDriver());
            }

            // Oluşturulan WebDriveri yapılandırıyoruz.
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        // Thread'a özgü WebDriver objecti return ediyoruz.
        return driverPool.get();
    }

    public Driver() {
        // Singleton pattern
    }

    public static void closeDriver() {
        // Açık olan WebDriver örneğini kapatıyoruz.
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove(); // ThreadLocal'daki referansı temizliyoruz.
        }
    }
}


