package application;

import java.io.*;

public class KullaniciDepolama {
    private Kullanici bas;

    // BURADA EKLEDİM! Varsayılan dosya müşteri dosyası.
    private String dosyaAdi = "kullanicilar.txt";

    public void setDosyaAdi(String dosyaAdi) {
        this.dosyaAdi = dosyaAdi;
    }

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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
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

    public void dosyayaEkle(Kullanici yeni) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
            writer.write(yeni.ad + "," + yeni.soyad + "," +
                    yeni.kullaniciAdi + "," + yeni.sifre);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dosyadanOku() {
        bas = null; // eski listeyi temizle
        File f = new File(dosyaAdi);

        if (!f.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
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

    public Kullanici getKullanici(String kullaniciAdi) {
        Kullanici gecici = bas;
        while (gecici != null) {
            if (gecici.kullaniciAdi.equals(kullaniciAdi)) {
                return gecici;
            }
            gecici = gecici.sonraki;
        }
        return null;
    }

    public boolean girisYap(String kullaniciAdi, String sifre) {
        Kullanici gecici = bas;
        while (gecici != null) {
            if (gecici.kullaniciAdi.equals(kullaniciAdi)
                    && gecici.sifre.equals(sifre)) {
                return true;
            }
            gecici = gecici.sonraki;
        }
        return false;
    }
}
