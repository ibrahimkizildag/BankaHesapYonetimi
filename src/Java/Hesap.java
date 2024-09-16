package Java;

public class Hesap {

    private String kullanici_adi;
    private String parola;
    private int bakiye;
    private String hesapNo;

    public Hesap(String kullanici_adi, String parola, int bakiye, String hesapNo) {
        this.kullanici_adi = kullanici_adi;
        this.parola = parola;
        this.bakiye = bakiye;
        this.hesapNo = hesapNo;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public String getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(String hesapNo) {
        this.hesapNo = hesapNo;
    }

    public void paraYatir(int tutar) {
        bakiye += tutar;
        System.out.println("Yeni Bakiyeniz: " + bakiye);
    }

    public void paraCek(int tutar) {
        if ((bakiye - tutar) <  0) {
            System.out.println("Yeterli Bakiyeniz Yok...");
            System.out.println("Mevcut Bakiyeniz : " + bakiye);
        } else {
            bakiye -= tutar;
            System.out.println("Yeni Bakiyeniz : " + bakiye);
        }
    }
}
	
