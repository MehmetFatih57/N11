package N11.stepdefinition;

import N11.pages.N11;
import N11.utils.ConfigReader;
import N11.utils.Driver;
import N11.utils.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class N11StepDefinition {

    N11 n11 = new N11();
    Actions actions;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Given("kullanici {string} sayfasina properties ile gider")
    public void kullanici_sayfasina_properties_ile_gider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
        ReusableMethods.bekle(3);
    }
    @Then("Ana sayfanın açıldığı kontrol edilir")
    public void ana_sayfanın_açıldığı_kontrol_edilir() {
        Assert.assertTrue(n11.anaSayfa.isDisplayed());
        ReusableMethods.bekle(3);
    }
    @And("Cikan uyariyi kapat")
    public void cikanUyariyiKapat() {
        js.executeScript("arguments[0].click();" , n11.uyari);
        ReusableMethods.bekle(3);
    }
    @And("Arama kutucuğuna {string} kelimesini properties ile aratir.")
    public void aramaKutucuğunaKelimesiniPropertiesIleAratir(String str) {
        n11.aramaKutusu.sendKeys(ConfigReader.getProperty(str) , Keys.ENTER);
        ReusableMethods.bekle(3);
    }
    @And("Kategoriler bolumunden rastgele bir bolume tiklanir")
    public void kategorilerBolumundenRastgeleBirBolumeTiklanir() {
        js.executeScript("arguments[0].click();" , n11.urun);
        ReusableMethods.bekle(3);
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
    }
    @And("Tikladigin kategori bolumunde oldugunu dogrula")
    public void tikladiginKategoriBolumundeOldugunuDogrula() {
        assert n11.sonucYazisi.isDisplayed();
        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi("Kategori");
    }
    @Then("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.")
    public void sonuca_göre_sergilenen_ürünlerden_rastgele_bir_ürün_seçilir() {
        js.executeScript("arguments[0].click();" , n11.laptop);
        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi("laptop");
        ReusableMethods.bekle(3);
    }
    @Then("Seçilen ürün sepete eklenir.")
    public void seçilen_ürün_sepete_eklenir() {
        js.executeScript("arguments[0].click();" , n11.sepeteEkle);
        ReusableMethods.bekle(3);
    }
    @And("Sepete git")
    public void sepeteGit() {
        js.executeScript("arguments[0].click();" , n11.sepetBox);
        ReusableMethods.bekle(3);
    }
    @And("Urunun sepette oldugunu dogrula")
    public void urununSepetteOldugunuDogrula() {
        assert n11.eklenenUrun.isDisplayed();
        ReusableMethods.bekle(3);
        js.executeScript("arguments[0].click();" , n11.uyariMetni);
        ReusableMethods.bekle(3);
        assert n11.eklenenUrun.isDisplayed();
        //js.executeScript("arguments[0].scrollIntoView();" , n11.eklenenUrun);
        ReusableMethods.bekle(3);
    }
    @Then("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.")
    public void ürün_sayfasındaki_fiyat_ile_sepette_yer_alan_ürün_fiyatının_doğruluğu_karşılaştırılır() {
//        assert n11.urunTutari.isDisplayed();
//        ReusableMethods.bekle(3);
        String urunFiyati = "20.999,00 TL";
        Assert.assertEquals(n11.urunTutari.getText() , urunFiyati);
        ReusableMethods.bekle(3);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.bekle(3);
    }
    @And("Adet arttırılarak ürün adedini bir arttir.")
    public void adetArttırılarakÜrünAdediniBirArttir() {
        js.executeScript("arguments[0].click();" , n11.urunAdeti);
        ReusableMethods.bekle(3);
    }
    @Then("Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.")
    public void ürün_sepetten_silinerek_sepetin_boş_olduğu_kontrol_edilir() {
        js.executeScript("arguments[0].click();" , n11.sil);
        ReusableMethods.bekle(3);
        js.executeScript("arguments[0].click();" , n11.deleteButton);
        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi("Delete");
        assert n11.messageVerify.getText().contains("Sepetin Boş Görünüyor");
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}
