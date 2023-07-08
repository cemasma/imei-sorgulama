# imei-sorgulama
https://www.turkiye.gov.tr/imei-sorgulama üzerinden Java ile imei sorgulama.

## Nasıl Çalışıyor?
HttpClient kullanılarak programatik olarak siteye istek gönderiliyor ve Jsoup ile gelen cevaptan HTML kırpılıp istenilen kısım alınıyor.

### Build
```
mvn clean install && mvn package
```

### Run
```
mvn exec:java -Dexec.mainClass=com.github.cemasma.Main -Dexec.args="111111111111111"
```

### Demo
```java
String imei = "111111111111111";
if (args.length > 0 && args[0].length() == 15) {
    imei = args[0];
}

Client client = new Client();
System.out.println(client.query(imei));
```

Burada result değişkeninin içeriği, sorgulanan imei numarasının durumu kayıtlı ise "IMEI NUMARASI KAYITLI" değil ise "KAYIT BULUNAMADI" oluyor.