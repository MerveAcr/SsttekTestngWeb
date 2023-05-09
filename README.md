## Local Test Env Setup
- /com.interview/src/test/resources un altindaki testing.xml sayfasindan point edilmis testleri calistirabiliriz
- yeni suite, package, class, ve method lari point ederek istedigimiz testleri calistirabiliriz
- yeni suite ler olusturarak smoke, regression, end to end gibi testlerimizi calistirabiliriz

## Parallel Testing
- suite tag inin icerisinde paralel ve thread-count keyword lerini kullanarak paralel execution yapabiliriz
- thread-count un degeri kac tane webdriver initialize edilicegini gosterir.
- parameter annatotion i kullanilarak testlerin ayni anda farkli browserlarda calismasi saglanabilir.

## Cross Browser Testing
- src/test/resources/test-data/configuration.properties dosyasinda calistirilmak istenen tarayiciyi belirleyebiliriz
- tarayici tipini belirlerken "chrome", "safari", "firefox", "edge" keywordlerini kullaniniz

## Gerekli Programlar
 - otomasyon testlerini calistirmak icin gerekli olan programlari yuklediginize emin olun 
    - maven
    - java
    - testNG
    - eclips
    
## Test Execution
- /com.interview/src/test/resources klasorune git
- testing.xml dosyasini ac
- Sag tikla
- Run As e tikla
- TestNGSuite e tikla 
- testing.xml de point edilen test lerin hepsi calisacaktir

##  POM Design Pattern
- page object class larini com.interview.pages in altinda olusturabiliriz
- her bir sayfa/modul icin ayri bir page object olusturmak gerekir
- page object class larini page factory design pattern ile develop edersek @FindBy annotation i kullanarak kolayca WebElement lerimizi locate ederbiliriz
- test lerimizi com.interview.test package inin altina yazabiliriz
- page object veya test file larimizda kullanicagimiz yardimci methodlari com.interview.utilities package inin altinda olusturabilriz
- istenilen yeni library/ dependency leri pom.xml sayfasina eklemeyi unutmayiniz 

## Test Data
- test datalarimizi com.interview.test.data package inin altinda olusturunuz
- key and value cinsinden datalarinizi src/test/resources/test-data klasorunun altina .properties dosya turunden olusturabilirsiniz

## Yardimci Methodlar
- com.interview.utilities package nin altinda HelperMethods classinda yardimci methodlari olusturabiliriz
- ihtiyac duyuldugu takdirde WebDriver objesini olusturmadan Driver.java classindan cagirabilirsiniz

## Test Report 
##### Html Report
	- project in uzerine sag tikliyarak refresh ediniz
	- proje yi yeniledikten sonra main directory de test-output klasorunun geldigini goruceksiniz. 
	- index.html dosyasini tarayicida acarak test sonuclarini goruntuluyebilirsiniz.
	- /src directory de fail olan test lerin screenshot larini test ismi ile gorebilirsiniz 

## .gitignore
- localinizde kalmasini istediginiz, jar,test result gibi dosyalari .gitignore file ina ekleyerek remote repo nuzu gereksiz dosyalardan koruyabilirisiniz

## NOT: PROJEYI INDIRDIKTEN SONRA UPDATE ETMEYI UNUTMAYINIZ



