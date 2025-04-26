package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.Driver;
import Pages.rsmPagesSatınAlma;
import utilities.ReusubleMethods;


public class stepdefinations {

    rsmPagesSatınAlma rsmPagesSatınAlma=new rsmPagesSatınAlma();

    @Given("Kullanıcı rsmoto sayfasına gider")
    public void kullanıcıRsmotoSayfasınaGider() {

        Driver.getDriver().get(ConfigReader.getProperty("rsmotorurl"));

    }

    @And("Tüm kategoriler rks yedek parça kategorisine tıklar")
    public void tümKategorilerRksYedekParçaKategorisineTıklar() throws InterruptedException {

        rsmPagesSatınAlma.menürkstıklama.click();

        Thread.sleep(2000);

    }


    @When("açılan sayfadan litedeki ilk ürünü seçer")
    public void açılanSayfadanLitedekiIlkÜrünüSeçer() {
        ReusubleMethods.elementeKadarScroll(rsmPagesSatınAlma.ilkUrun);
        rsmPagesSatınAlma.ilkUrun.click();

    }

    @And("ürünü sepete ekler")
    public void ürünüSepeteEkler() {
        ReusubleMethods.elementeKadarScroll(rsmPagesSatınAlma.sepeteEkle);
        rsmPagesSatınAlma.sepeteEkle.click();
        ReusubleMethods.enUsteKadarScroll();
        

    }

    @And("sepetim sekmesine tıklar")
    public void sepetimSekmesineTıklar() {
        rsmPagesSatınAlma.upSepeteEkle.click();
    }

    @And("sipariş bilgileri alanını doldurur")
    public void siparişBilgileriAlanınıDoldurur() {
        ReusubleMethods.elementeKadarScroll(rsmPagesSatınAlma.siparişNotBox);

        rsmPagesSatınAlma.nameBox.click();
        ReusubleMethods.fakerDoldur(rsmPagesSatınAlma.nameBox, ReusubleMethods.FakerDataType.FIRST_NAME);

        rsmPagesSatınAlma.lastNameBox.click();
       ReusubleMethods.fakerDoldur(rsmPagesSatınAlma.lastNameBox,ReusubleMethods.FakerDataType.LAST_NAME);

       rsmPagesSatınAlma.tcNoBox.click();
       ReusubleMethods.fakerDoldur(rsmPagesSatınAlma.tcNoBox,ReusubleMethods.FakerDataType.RANDOM_11_DIGIT_NUMBER);

       rsmPagesSatınAlma.paswordBox.click();
       ReusubleMethods.fakerDoldur(rsmPagesSatınAlma.paswordBox,ReusubleMethods.FakerDataType.PASSWORD);

        rsmPagesSatınAlma.cityBox.click();
        ReusubleMethods.randomSelectFromDropdown(rsmPagesSatınAlma.cityBox);

        rsmPagesSatınAlma.ılceBox.click();
        ReusubleMethods.randomSelectFromDropdown(rsmPagesSatınAlma.ılceBox);

        rsmPagesSatınAlma.adressBox.click();
        ReusubleMethods.fakerDoldur(rsmPagesSatınAlma.adressBox,ReusubleMethods.FakerDataType.ADDRESS);

        rsmPagesSatınAlma.contract.click();


    }
}
