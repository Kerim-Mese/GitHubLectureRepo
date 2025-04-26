@US001
  Feature: US001 RSM Oto sipariş test
    Scenario: TC01 Sepete Ürünler Eklenir
      Given Kullanıcı rsmoto sayfasına gider
      And Tüm kategoriler rks yedek parça kategorisine tıklar
      When açılan sayfadan litedeki ilk ürünü seçer
      And ürünü sepete ekler
      And sepetim sekmesine tıklar
      And sipariş bilgileri alanını doldurur
      Then Sipariş tamamla butonuna tıklar

