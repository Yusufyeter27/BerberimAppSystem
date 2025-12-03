package application;

public class Kullanici {
    public String ad;
    public String soyad;
    public String kullaniciAdi;
    public String sifre;
    public Kullanici sonraki;

    public Kullanici(String ad, String soyad, String kullaniciAdi, String sifre) {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.sonraki = null;
    }
}