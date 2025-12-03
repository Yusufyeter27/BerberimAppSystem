package application;

import java.io.*;
public class KullaniciDepolama {
    public Kullanici bas;

    public KullaniciDepolama() {
        bas = null;
    }
    public void ekle(Kullanici yeni) {
        if (bas == null) {
            bas = yeni;
        } else {
            Kullanici gecici = bas;
            while (gecici.sonraki != null) {
                gecici = gecici.sonraki;
            }
            gecici.sonraki = yeni;
        }
    }
    public void dosyayaYaz() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("kullanicilar.txt"))) {
            Kullanici gecici = bas;
            while (gecici != null) {
                writer.write(gecici.ad + "," +
                             gecici.soyad + "," +
                             gecici.kullaniciAdi + "," +
                             gecici.sifre);
                writer.newLine();
                gecici = gecici.sonraki;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void dosyadanOku() {
        try (BufferedReader reader = new BufferedReader(new FileReader("kullanicilar.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    Kullanici yeni = new Kullanici(fields[0], fields[1], fields[2], fields[3]);
                    ekle(yeni);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void dosyayaEkle(Kullanici yeni) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("kullanicilar.txt", true))) {
            writer.write(yeni.ad + "," + yeni.soyad + "," + yeni.kullaniciAdi + "," + yeni.sifre);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean girisYap(String kullaniciAdi, String sifre) {
        Kullanici current = bas;
        while (current != null) {
            if (current.kullaniciAdi.equals(kullaniciAdi) && current.sifre.equals(sifre)) {
                return true;
            }
            current = current.sonraki;
        }
        return false;
    }
    public void listele() {
        Kullanici gecici = bas;
        while (gecici != null) {
            System.out.println("Ad: " + gecici.ad +
                               ", Soyad: " + gecici.soyad +
                               ", Kullanıcı Adı: " + gecici.kullaniciAdi +
                               ", Şifre: " + gecici.sifre);
            gecici = gecici.sonraki;
        }
    }
}