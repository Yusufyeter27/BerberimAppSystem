package application;

public class randevumodel {
    private String tarih;
    private String saat;
    private String hizmet;
    private String personel;

    public randevumodel(String tarih, String saat, String hizmet, String personel) {
        this.tarih = tarih;
        this.saat = saat;
        this.hizmet = hizmet;
        this.personel = personel;
    }

    public String getTarih() { return tarih; }
    public String getSaat() { return saat; }
    public String getHizmet() { return hizmet; }
    public String getPersonel() { return personel; }
}