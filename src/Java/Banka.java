package Java;
import java.util.ArrayList;
import java.util.Scanner;


public class Banka {
    
    private ArrayList<Hesap> hesaplar = new ArrayList<>();
    private Hesap aktifHesap;

    public void calis(Hesap hesap) {
        hesaplar.add(hesap); 
        aktifHesap = hesap; 
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bankamıza Hoşgeldiniz....");

        System.out.println("****************************");
        System.out.println("Kullanıcı Girişi");
        System.out.println("****************************");
        int giris_hakki = 3;

        while (true) {
            if (login.login(hesap)) {
                System.out.println("Giriş Başarılı...");
                break;
            } else {
                System.out.println("Giriş Başarısız...");
                giris_hakki -= 1;
                System.out.println("Kalan Giriş Hakkı : " + giris_hakki);
            }
            if (giris_hakki == 0) {
                System.out.println("Giriş Hakkınız Bitti...");
                return;
            }
        }

        System.out.println("*********************************");
        String islemler = "1. Bakiye Görüntüle\n"
                         + "2. Para Yatırma\n"
                         + "3. Para Çekme\n"
                         + "4. Yeni Hesap Aç\n"
                         + "5. Hesap Değiştir\n"
                         + "Çıkış için 6'ya basın";
        System.out.println(islemler);
        System.out.println("**********************************");

        while (true) {
            System.out.println("İşlemi Seçiniz : ");
            String islem = scanner.nextLine();

            if (islem.equals("6")) {
                break;
            } 
            else if (islem.equals("1")) {
                System.out.println("Bakiyeniz : " + aktifHesap.getBakiye());
                
            } 
            else if (islem.equals("2")) {
                System.out.print("Yatırmak istediğiniz tutar : ");
                int tutar = scanner.nextInt();
                scanner.nextLine();
                aktifHesap.paraYatir(tutar);   
                
            } 
            else if (islem.equals("3")) {
                System.out.print("Çekmek istediğiniz tutar : ");
                int tutar = scanner.nextInt();
                scanner.nextLine();
                aktifHesap.paraCek(tutar);
                
            } 
            else if (islem.equals("4")) {
            	
                System.out.println("Yeni hesap için kullanıcı adı girin: ");
                String yeniKullaniciAdi = scanner.nextLine();
                System.out.println("Yeni hesap için parola girin: ");
                String yeniParola = scanner.nextLine();
                System.out.println("Yeni hesap için bakiye girin: ");
                int yeniBakiye = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Yeni hesap için hesap numarası girin: ");
                String yeniHesapNo = scanner.nextLine();

                Hesap yeniHesap = new Hesap(yeniKullaniciAdi, yeniParola, yeniBakiye, yeniHesapNo);
                hesaplar.add(yeniHesap);
                System.out.println("Yeni hesap oluşturuldu.");
                
            } 
            else if (islem.equals("5")) {
                System.out.println("Geçiş yapmak istediğiniz hesap numarasını girin: ");
                String hesapNo = scanner.nextLine();
                Hesap bulunanHesap = hesapBul(hesapNo);
                if (bulunanHesap != null) {
                    aktifHesap = bulunanHesap;
                    System.out.println("Hesap başarıyla değiştirildi.");
                } 
                else {
                    System.out.println("Hesap numarası bulunamadı.");
                }
            } 
            else {
                System.out.println("Geçersiz İşlem....");
            }
        }
    }

    private Hesap hesapBul(String hesapNo) {
        for (Hesap h : hesaplar) {
            if (h.getHesapNo().equals(hesapNo)) {
                return h;
            }
        }
        return null;
    }
}

