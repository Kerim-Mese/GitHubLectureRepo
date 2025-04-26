package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ReusubleMethods {

    static Faker faker = new Faker(new Locale("tr"));

    // Sayfada belirli bir elemente kadar scroll yapar
    public static void elementeKadarScroll(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    // Sayfanın en üstüne kadar scroll yapar
    public static void enUsteKadarScroll() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.HOME).perform();
    }

    // Faker veri türleri enum
    public enum FakerDataType {
        FIRST_NAME,
        LAST_NAME,
        RANDOM_11_DIGIT_NUMBER,
        TURKISH_PHONE_NUMBER,
        EMAIL,
        PASSWORD,
        ADDRESS
    }

    // Faker kullanarak form alanlarını otomatik doldurur
    public static void fakerDoldur(WebElement element, FakerDataType dataType) {
        String data = "";
        switch (dataType) {
            case FIRST_NAME:
                data = temizleTurkceKarakter(faker.name().firstName());
                break;
            case LAST_NAME:
                data = temizleTurkceKarakter(faker.name().lastName());
                break;
            case RANDOM_11_DIGIT_NUMBER:
                data = getRandom11DigitNumber();
                break;
            case TURKISH_PHONE_NUMBER:
                data = getTurkishPhoneNumber();
                break;
            case EMAIL:
                data = temizleTurkceKarakter(getEmail());
                break;
            case PASSWORD:
                data = getPassword();
                break;
            case ADDRESS:
                data = temizleTurkceKarakter(faker.address().fullAddress());
                break;
            default:
                data = temizleTurkceKarakter(faker.lorem().sentence());
        }
        element.sendKeys(data);
    }

    // Türkçe karakterleri İngilizce karakterlere dönüştürür
    public static String temizleTurkceKarakter(String input) {
        if (input == null) {
            return null;
        }
        return input
                .replace("Ğ", "G")
                .replace("Ü", "U")
                .replace("Ş", "S")
                .replace("İ", "I")
                .replace("Ç", "C")
                .replace("Ö", "O")
                .replace("ğ", "g")
                .replace("ü", "u")
                .replace("ş", "s")
                .replace("ı", "i")
                .replace("ç", "c")
                .replace("ö", "o");
    }

    // 11 Haneli rastgele numara üretir
    public static String getRandom11DigitNumber() {
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
    }

    // Türkiye alan kodlu telefon numarası üretir
    public static String getTurkishPhoneNumber() {
        String phoneNumber = faker.phoneNumber().cellPhone();
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        if (!phoneNumber.startsWith("90")) {
            phoneNumber = "90" + phoneNumber;
        }
        return "+" + phoneNumber;
    }

    // Türkçe isimli email adresi üretir
    public static String getEmail() {
        String emailPrefix = faker.name().firstName().toLowerCase() + faker.number().numberBetween(100, 999);
        return emailPrefix + "@gmail.com";
    }

    // Harf + rakam karışık şifre üretir
    public static String getPassword() {
        String harfler = faker.letterify("??????");
        String rakamlar = faker.numerify("###");
        return harfler + rakamlar;
    }

    // Dropdown içinden rastgele bir seçim yapar
    public static void randomSelectFromDropdown(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomIndex = random.nextInt(options.size() - 1) + 1; // 1'den başlat, 0 seçilmesin (genellikle "Lütfen seçiniz" olur)
        select.selectByIndex(randomIndex);
    }

    // Stok ekleme işlemi: mevcut stok ile maksimum eklenebilecek stok kıyaslaması
    public static int addStock(int availableStock, int maxAdd) {
        return Math.min(maxAdd, availableStock);
    }

    // JavaScript ile bir elemente belirtilen sayıda hızlı click yapar
    public static void clickMultipleTimesJS(WebElement element, int times) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < times; i++) {
            jsExecutor.executeScript("arguments[0].click();", element);
        }
    }
}
