# imei-sorgulama
https://www.turkiye.gov.tr/imei-sorgulama üzerinden Java ile imei sorgulama.

## Nasıl Çalışıyor?
HttpClient ve Jsoup kullanılarak siteye istek gönderiliyor ve gelen cevaptan HTML kırpılıp istenilen kısım alınıyor.
Browser'dan siteye girip sorgulama yapıyormuşsun gibi fakat captcha ile uğraşmıyorsun.

Captcha'yi atlatabilmemizin nedeninin büyük ihtimal girilen captcha'nin sadece girildiği aşamada kontrol edilmesinin olduğunu düşünüyorum.
Normalde siteye girip sorgulama yaparken POST ile gönderilen verilere bakılırsa girilen captcha'nin gönderildiği görülür.
Demek ki captcha bilgisi POST edildiği yerde kontrol edilmiyor.
