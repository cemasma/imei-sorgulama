# imei-sorgulama
https://www.turkiye.gov.tr/imei-sorgulama üzerinden Java ile imei sorgulama.

<br>
## Nasıl Çalışıyor?
HttpClient kullanılarak siteye istek gönderiliyor ve Jsoup ile gelen cevaptan HTML kırpılıp istenilen kısım alınıyor.
Browser'dan siteye girip sorgulama yapıyormuşsun gibi fakat captcha ile uğraşmıyorsun.

```java
Client client = new Client();
String sourceHTML = client.connect();

String token = Util.getTokenInHTML(sourceHTML);

sourceHTML = client.submitQuery("111111111111111", token);
String result = Util.getImeiInformationInHTML(sourceHTML);
```

Burada result değişkeninin içeriği, sorgulanan imei numarasının durumu kayıtlı ise "IMEI NUMARASI KAYITLI" değil ise "KAYIT BULUNAMADI" oluyor.

<br>
## Captcha vardı ona ne oldu?
Site üzerinden sorgulama yaparken girilen captcha bilgisi de sorgulama adresine gönderiliyor fakat burada biz göndermiyoruz. Demek ki captcha doğrulamasını atlatabilmemizin nedeni yüksek ihtimal ile captcha kontrolünün ön yüzde yapılması. 
