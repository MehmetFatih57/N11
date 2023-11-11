@N11
Feature: US001_Kullanici_alisveris_yapabilmeli
  Scenario: TC01_Kullanici_alisveris_yapabilmeli
    Given kullanici "anaSayfa" sayfasina properties ile gider
    Then Ana sayfanın açıldığı kontrol edilir
    And Cikan uyariyi kapat
    Then Arama kutucuğuna "Urun" kelimesini properties ile aratir.
    And Kategoriler bolumunden rastgele bir bolume tiklanir
    And Tikladigin kategori bolumunde oldugunu dogrula
    And Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
    And Seçilen ürün sepete eklenir.
    And Sepete git
    And Urunun sepette oldugunu dogrula
    And Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
    And Adet arttırılarak ürün adedini bir arttir.
    And Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.











