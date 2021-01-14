package Dandi07226_View;
import Dandi07226_Entity.Dandi07226_IkanEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class Dandi07226_PembeliGUI {
    JFrame pembeli = new JFrame();
    JButton back,daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarikan;
    JComboBox pilikan = new JComboBox(Dandi07226_IkanEntity.Ikan);
    int cek = Dandi07226_Allobjctrl.Pembeli.cekDaftarPembeli
        (Dandi07226_Allobjctrl.Pembeli.getData().getId());
    
    public Dandi07226_PembeliGUI(){
        pembeli.setSize(720, 600);
        pembeli.setLayout(null);
        pembeli.getContentPane().setBackground(Color.RED);
        
        datadiri = new JLabel("Data Pembeli");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,27));
        datadiri.setBounds(90, 30, 200, 30);
        pembeli.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        pembeli.add(area);
        
        daftarikan = new JLabel("Daftar Ikan");
        daftarikan.setBounds(450, 30, 250, 30);
        daftarikan.setFont(new Font("Times New Roman",Font.BOLD,30));
        pembeli.add(daftarikan);
        pilikan.setBounds(450, 90, 230, 30);
        pembeli.add(pilikan);
        
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        pembeli.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GRAY);
        pembeli.add(back);
        
        pembeli.setVisible(true);
        pembeli.setLocationRelativeTo(null);
        pembeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(cek==-1){ //cek data, apabila kita belum daftar praktkum
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Ikan", "Information", JOptionPane.INFORMATION_MESSAGE);        
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Daftar Ikan", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapelanggan());
        }
        daftarbtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            int indexcamera = pilikan.getSelectedIndex();
            Dandi07226_Allobjctrl.Pembeli.Dandi07226_DaftarIkan
            (indexcamera,Dandi07226_Allobjctrl.Pembeli.getData(), false);
            area.setText(datapelanggan());
        }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                pembeli.dispose();
                Dandi07226_GUI men = new Dandi07226_GUI(); //nama objek menu
            }
        });
    }
    
    String datapelanggan(){
        int cek = Dandi07226_Allobjctrl.Pembeli.cekDaftarPembeli
        (Dandi07226_Allobjctrl.Pembeli.getData().getId());
        String cekverif; //untuk verivikasi data berdasarkan id
        if(Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(cek).isIsVerified()==false){
            cekverif = "Belum DiBayar";
        }else{
            cekverif = "Sudah DiBayar";
        }
         String text = "Id = "+Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(cek).getPembeli().getId()+"\n"
                +"Nama = "+Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(cek).getPembeli().getnama()+"\n"
                +"Alamat = "+Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(cek).getPembeli().getalamat()+"\n"
                +"No Identitas = "+Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(cek).getPembeli().getnoIdentitas()+"\n"
                +"No Telp = "+Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(cek).getPembeli().getnotelp()+"\n"
                +"Tanggal Beli = "+new SimpleDateFormat("dd-MM-yyyy").format(Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(cek).getPembeli().getTgl_beli())+"\n"
                +"Bayar = "+cekverif+"\n"
                +"Ikan = "+Dandi07226_IkanEntity.Ikan[Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(cek).getIndexIkan()];
        return text;
    }
    }
    
