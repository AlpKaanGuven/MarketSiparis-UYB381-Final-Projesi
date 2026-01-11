# MarketSiparis

MarketSiparis, kullanıcıların temel market ürünlerini seçip sepetlerine ekleyebileceği bir Android uygulamasıdır.  

## Özellikler
- Ürün ekleme (Süt, Ekmek, Yumurta gibi)
- Sepet görüntüleme ve toplam fiyat hesaplama
- Sepette ürün adedini artırıp/azaltabilme
- Sepeti onaylayıp temizleme

## Kullanılan Teknolojiler
- Platform: Android
- Programlama Dili: Java
- Minimum SDK: 21
- Kütüphaneler: AndroidX, RecyclerView

## Proje Dosya Yapısı
- `MainActivity.java` → Ana ekran, ürünleri ekleme ve sepet butonu
- `CartActivity.java` → Sepet ekranı, toplam fiyat ve onaylama
- `Product.java` → Ürün modeli
- `CartAdapter.java` → Sepet RecyclerView adaptörü
- `ProductAdapter.java` → Ürün listesi RecyclerView adaptörü
- `CartManager.java` → Sepet işlemleri yönetimi
- `res/layout/` → Ekran tasarımları (activity ve item XML’leri)

## Kurulum ve Çalıştırma
1. Android Studio’yu açın.
2. `MarketSiparis` projesini açın

## Uygulamadan Resimler

<img width="410" height="859" alt="Uygulama Ana Ekran" src="https://github.com/user-attachments/assets/5edd337d-3ead-4bb8-a8a1-a8ded505327c" />
<img width="407" height="859" alt="Uygulama Sepet Ekranı" src="https://github.com/user-attachments/assets/4a13e2d1-7e79-4e1c-a690-175a70069b09" />
