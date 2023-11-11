package N11.pages;

import N11.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11 {
    public N11(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy(xpath = "(//a)[1]")
    public WebElement anaSayfa;

    @FindBy(xpath = "(//*[@class='dn-slide-deny-btn'])[1]")
    public WebElement uyari;

    @FindBy(xpath = "//*[@id='searchData']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[text()='Dizüstü Bilgisayar']")
    public WebElement urun;

    @FindBy(xpath = "//h1")
    public WebElement sonucYazisi;

    @FindBy(xpath = "(//*[@class='lazy cardImage'])[5]")
    public WebElement laptop;

    @FindBy(xpath = "(//*[@type='submit'])[1]")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//*[@class='prodPrice']")
    public WebElement urunTutari;

    @FindBy(xpath = "//*[@class='iconsBasketWhite']")
    public WebElement sepetBox;

    @FindBy(xpath = "(//tbody//tr//td)[1]")
    public WebElement eklenenUrun;

    @FindBy(xpath = "//*[@class='btn btnBlack']")
    public WebElement uyariMetni;

    @FindBy(xpath = "//*[@class='spinnerUp spinnerArrow']")
    public WebElement urunAdeti;

    @FindBy(xpath = "//*[@title='Sil']")
    public WebElement sil;

    @FindBy(xpath = "//*[@id='deleteBtnDFLB']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div//h2")
    public WebElement messageVerify;
}
