package Dandi07226_Main;
import Dandi07226_Entity.Dandi07226_IkanEntity;
import Dandi07226_Entity.Dandi07226_DaftarPembeliEntity;
import Dandi07226_Model.Dandi07226_DaftarPembeliModel;
import Dandi07226_Controller.Dandi07226_PenjualController;
import Dandi07226_Controller.Dandi07226_AllObjectModel;
import Dandi07226_Controller.Dandi07226_PembeliController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner; 
import Dandi07226_View.Dandi07226_GUI;

public class Dandi07226_main {
    private static Dandi07226_PenjualController penjualModel = new Dandi07226_PenjualController(); 
    private static Dandi07226_PembeliController pembeliModel = new Dandi07226_PembeliController();
    private static Scanner input = new Scanner (System.in);

    public static void main(String[] args){ 
        Dandi07226_main data = new Dandi07226_main();
        data.view(); 
    }
    void view(){
    do {
            int pilih;
            System.out.println("Menu\n" +
                    "1. Console\n" +
                    "2. GUI\n" +
                    "Masukkan Pilihan Anda : ");
            pilih = input.nextInt();

            switch (pilih){
                case 1:
                    viewMenu();
                    break;
                case 2:
                    GUI();
                    break;
                default:
                    break;
            }
        }while (true);
    }
    
    void GUI(){
        Dandi07226_GUI gui = new Dandi07226_GUI();
    }
    
    void viewMenu(){
        int loop = 0;
        int pilih = 0;
        int pilLogin = 0;
        penjualModel.datapenjual();
        do{
           System.out.print("Selamat Datang Di Pembudidayaan Ikan Lele !!" +
                            "\n 1. Login" +
                            "\n 2. Daftar Pembeli" +
                            "\n 3. Hapus Pembeli"+
                            "\n 4. Lihat Pembeli"+
                            "\n 5. Close"+
                            "\n Masukkan Pilihan Anda : ");
                        pilih = input.nextInt();
                        if(pilih == 1){
            System.out.print("1. Login petugas" + "\n2. Login pelanggan" + "\n Pilih : ");
                pilLogin = input.nextInt();
                if(pilLogin == 1){
                    loginPetugas();  
                }else{
                    loginPelanggan();
                }
            }else if(pilih == 2){
                register();
            }else if(pilih == 3){
                viewHapusDataPelanggan();
            }else if(pilih == 4){
                if (penjualModel.cekDaftarPembeliModel().size() == 0) {
                System.out.println("Data Masih Kosong !!!");
                } else{
                viewDataPelanggan();
                }
            }else if(pilih == 5){
                view();
            }else{
                break;
            }
        }while (loop != 1);
    }
     
        void register(){
                System.out.print("Input ID = ");
                String id = input.next();
                System.out.print("Input nama = ");
                String nama = input.next();
                System.out.print("Input Alamat = ");
                String alamat = input.next();
                System.out.print("Input no Identitas = ");
                String noIdentitas =  input.next();
                System.out.print("Input no Telepon = ");
                String notelp =  input.next();
                System.out.print("Input Tgl sewa (dd/mm/yyyy) = ");
                Date Tgl_beli = new Date(input.next());
                pembeliModel.insert(id,nama,alamat,noIdentitas,notelp,Tgl_beli);
                System.out.println("Daftar Sukses !!");
        }
        
        static void registerPembeli() {
        System.out.println("Pilih Camera : ");
        for (int i = 0; i < Dandi07226_IkanEntity.Ikan.length; i++) {
            System.out.println((i) + " " + Dandi07226_IkanEntity.Ikan[i]);
        }
        int pilPrak = input.nextInt();
        pembeliModel.Dandi07226_DaftarIkan(pilPrak, pembeliModel.getData(), false);
        
    }
        
        void viewDataPelanggan() {
        int i=0;
        for (Dandi07226_DaftarPembeliEntity pembeli : pembeliModel.cekDaftarPembeliModel()) {
                System.out.println("Data Ke - : "+i);
                System.out.println("Id : " + pembeliModel.showDaftarPembeli(i).getPembeli().getId());
                System.out.println("Nama = "+pembeliModel.showDaftarPembeli(i).getPembeli().getnama());
                System.out.println("No identitas = "+pembeliModel.showDaftarPembeli(i).getPembeli().getnoIdentitas());
                System.out.println("No telp = "+pembeliModel.showDaftarPembeli(i).getPembeli().getnotelp());
                System.out.println("Ikan = "+Dandi07226_IkanEntity.Ikan[pembeliModel.showDaftarPembeli(i).getIndexIkan()]);
                System.out.println("Tgl Beli           : "+new SimpleDateFormat(" dd - MM - yyyy").format(pembeliModel.showDaftarPembeli(i).getPembeli().getTgl_beli()));                System.out.println("isVerified = ");
                if (pembeliModel.showDaftarPembeli(i).isIsVerified() == false) {
                    System.out.print("Belum Di Verifikasi petugas\n");
                    System.out.print("===========================\n");
                } else {
                    System.out.print("Telah Di Verifikasi petugas\n");
                    System.out.print("===========================\n");
                }         
            i++;
        }
    }
        
        void loginPelanggan(){
        System.out.print("ID : ");
        String id = input.next();
        System.out.print("Nama : ");
        String nama = input.next();
        try {
        pembeliModel.login(id, nama);
        System.out.println("Selamat datang "+pembeliModel.getData().getnama());
        int cekpembeli = pembeliModel.cekDaftarPembeli(pembeliModel.getData().getId());
        if (cekpembeli == -1){
            System.out.println("Anda belum memilih kamera");
                registerPembeli();
        }else if(cekpembeli == -2){
            System.out.println("Anda belum memilih kamera");
                registerPembeli();
        }else{
        System.out.println("Nama = "+pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getnama());
        System.out.println("id = "+pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getId());
        System.out.println("No identitas = "+pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getnoIdentitas());
        System.out.println("No telp = "+pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getnotelp());
        System.out.println("camera = "+Dandi07226_IkanEntity.Ikan[pembeliModel.showDaftarPembeli(cekpembeli).getIndexIkan()]);
        System.out.println("Tgl beli           : "+new SimpleDateFormat(" dd - MM - yyyy").format(pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getTgl_beli()));
        System.out.println("isVerified = ");
         if (pembeliModel.showDaftarPembeli(cekpembeli).isIsVerified() == false) {
                System.out.print("Belum Di Verifikasi petugas\n");
            } else {
                System.out.print("Telah Di Verifikasi petugas\n");
            }
        
        }} catch (Exception e) {
            System.out.println("id atau nama Anda Salah !!!");
        }
    }
        
        void loginPetugas(){
        System.out.print("id : ");
        String id = input.next();
        System.out.print("nama: ");
        String nama = input.next();
        try {
            penjualModel.login(id, nama);
            System.out.println("Selamat Datang " + penjualModel.Dandi07226_PenjualEntity().getnama() + " Id "
                    + penjualModel.Dandi07226_PenjualEntity().getId());
            if (penjualModel.cekDaftarPembeliModel().size() == 0) {
                System.out.println("Data Masih Kosong !!!");
            } else{
                viewDataPelanggan();
                updateIsVerified();
            }
        } catch (Exception e) {
            System.out.println("id atau nama Anda Salah !!!");
        }
    }
         
        void updateIsVerified() {
        System.out.println("id Pelanggan : ");
        String id = input.next();
        System.out.println("=======================");
        int index = Dandi07226_AllObjectModel.daftarpembelimodel.cekData(id, null);
        penjualModel.updateIsVerified(index, pembeliModel.showDaftarPembeli(index).getIndexIkan(),pembeliModel.showDaftarPembeli(index).getPembeli());
    }
        
        void viewHapusDataPelanggan() {
        viewDataPelanggan();
        System.out.print("Pilih Data Ke - : ");
        int index = input.nextInt();
        pembeliModel.deleteDataPembeli(index);
        System.out.println("Data Berhasil Dihapus");
    }   
}