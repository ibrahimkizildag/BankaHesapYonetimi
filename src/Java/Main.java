package Java;


public class Main {
    public static void main(String[] args) {
        Banka banka = new Banka();
        Hesap hesap = new Hesap("ibrahim kızıldağ", "12345", 2000, "12345678");
        banka.calis(hesap);
        System.out.println("Hizmetlerimizi kullandığınız için teşekkür ederiz. İyi günler!");
    }
}
