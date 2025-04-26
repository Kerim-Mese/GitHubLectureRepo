package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class rsmPagesSatınAlma {
    public rsmPagesSatınAlma(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//ul[@class='menu vertical-menu category-menu']/li/a)[1]\n")
    public WebElement menürkstıklama;

    @FindBy(xpath = "//div[@class='product-wrap'][1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-cart']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//div[@class='dropdown cart-dropdown cart-offcanvas mr-0 mr-lg-2']")
    public WebElement upSepeteEkle;

    @FindBy(xpath = "//textarea[@name='siparis_not']")
    public  WebElement siparişNotBox;

    @FindBy(xpath ="//input[@name='ad']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@name='soyad']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@placeholder='T.C Kimlik No']")
    public WebElement tcNoBox;

    @FindBy(xpath = "//input[@name='telefon']")
    public WebElement phoneBox;

    @FindBy(xpath = "//input[@name='email'][1]")
    public WebElement email;

    @FindBy(xpath = "//input[@name='sifre']")
    public WebElement paswordBox;

    @FindBy(xpath = "//select[@name='il']")
    public WebElement cityBox;

    @FindBy(xpath = "//select[@name='ilce']")
    public WebElement ılceBox;

    @FindBy(xpath = "//textarea[@placeholder='Sipariş Adresiniz']")
    public WebElement adressBox;

    @FindBy(xpath = "//textarea[@placeholder='Sipariş Notunuz']")
    public WebElement note;

    @FindBy(id = "approve")
    public WebElement contract;

    @FindBy(xpath = "//button[@class='btn btn-block btn-dark btn-icon-right btn-rounded btn-checkout mt-3 FormBtn']")
    public WebElement orderComplated;

    @FindBy(xpath = "//button[contains(@class, 'quantity-plus')]")
    public WebElement artıButonu;










}
