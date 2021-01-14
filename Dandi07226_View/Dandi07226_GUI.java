package Dandi07226_View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
public class Dandi07226_GUI {
    JFrame TampilanAwal = new JFrame();//tampilan awal
    JLabel login,daftar,top; 
    JRadioButton radioPetugas,radiopelanggan; //tombol pilihan
    JTextField textidlogin,textnamalogin,textalamat,textnoantrian,textnotelp,texttglbeli,textiddaftar,textnamadaftar;
    JLabel labelidlogin,labelnamalogin,labelalamat,labelnoidentitas,labelnotelp,labeltglbeli,labeliddaftar,labelnamadaftar;
    JButton check,reg; //tombol
    
    private boolean ceklogin = false;
    public Dandi07226_GUI(){ //komponen
        TampilanAwal.setSize(700, 630); //ukuran 
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.WHITE); //warna background
        
        top = new JLabel("PEMBUDIDAYAAN IKAN LELE");
        top.setBounds(50, 10, 600, 50); 
        top.setFont(new Font("Times New Roman",Font.BOLD,40));
        TampilanAwal.add(top);
        
        login = new JLabel("login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman",Font.BOLD,30));
        TampilanAwal.add(login);
        
        radioPetugas = new JRadioButton("Penjual");
        radioPetugas.setBounds(30, 150, 100, 30);
        radioPetugas.setBackground(Color.GRAY);
        TampilanAwal.add(radioPetugas);
        
        radiopelanggan = new JRadioButton("Pembeli");
        radiopelanggan.setBounds(140, 150, 100, 30);
        radiopelanggan.setBackground(Color.GRAY);
        TampilanAwal.add(radiopelanggan);
        
        labelidlogin = new JLabel("Id");
        labelidlogin.setBounds(30, 180, 30, 30);
        TampilanAwal.add(labelidlogin);
        textidlogin = new JTextField();
        textidlogin.setBounds(30, 210, 200, 30);
        TampilanAwal.add(textidlogin);
        
        labelnamalogin = new JLabel("Nama");
        labelnamalogin.setBounds(30, 240, 100, 30);
        TampilanAwal.add(labelnamalogin);
        textnamalogin = new JTextField();
        textnamalogin.setBounds(30, 270, 200, 30);
        TampilanAwal.add(textnamalogin);
        
        check = new JButton("check");
        check.setBounds(90, 320, 100, 40);
        check.setBackground(Color.GRAY);
        TampilanAwal.add(check);
        
        daftar = new JLabel("Daftar");
        daftar.setFont(new Font("Times New Roman",Font.BOLD,30));
        daftar.setBounds(440, 50, 150, 100);
        TampilanAwal.add(daftar);
        
        labeliddaftar = new JLabel("ID");
        labeliddaftar.setBounds(400, 150, 30, 30);
        TampilanAwal.add(labeliddaftar);
        textiddaftar = new JTextField();
        textiddaftar.setBounds(400, 180, 200, 30);
        TampilanAwal.add(textiddaftar);
        
        labelnamadaftar = new JLabel("Nama");
        labelnamadaftar.setBounds(400, 210, 100, 30);
        TampilanAwal.add(labelnamadaftar);
        textnamadaftar = new JTextField();
        textnamadaftar.setBounds(400, 240, 200, 30);
        TampilanAwal.add(textnamadaftar);
        
        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(400, 270, 100, 30);
        TampilanAwal.add(labelalamat);
        textalamat = new JTextField();
        textalamat.setBounds(400, 300, 200, 30);
        TampilanAwal.add(textalamat);
        
        labelnoidentitas = new JLabel("No Antrian");
        labelnoidentitas.setBounds(400, 330, 100, 30);
        TampilanAwal.add(labelnoidentitas);
        textnoantrian = new JTextField();
        textnoantrian.setBounds(400, 360, 200, 30);
        TampilanAwal.add(textnoantrian);
        
        labelnotelp = new JLabel("No Telepon");
        labelnotelp.setBounds(400, 390, 200, 30);
        TampilanAwal.add(labelnotelp);
        textnotelp = new JTextField();
        textnotelp.setBounds(400, 420, 200, 30);
        TampilanAwal.add(textnotelp);
        
        labeltglbeli = new JLabel("Tanggal Beli (dd/mm/yyyy)");
        labeltglbeli.setBounds(400, 450, 200, 30);
        TampilanAwal.add(labeltglbeli);
        texttglbeli = new JTextField();
        texttglbeli.setBounds(400, 480, 200, 30);
        TampilanAwal.add(texttglbeli);
        
        reg = new JButton("Daftar");
        reg.setBounds(460, 530, 100, 40);
        reg.setBackground(Color.GRAY);
        TampilanAwal.add(reg);
        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal.setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);
        radioPetugas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //method aslab
                if(radioPetugas.isSelected()){
                    radiopelanggan.setSelected(false);
                    ceklogin=true;
                }
            }
        });
        
        radiopelanggan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk praktikan
                if(radiopelanggan.isSelected()){
                    radioPetugas.setSelected(false);//untuk aslab false
                    ceklogin=false;
                }
            }
        });
        
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //method
                if(ceklogin==true){
                    try{ 
                        Dandi07226_Allobjctrl.Penjual.datapenjual(); // login untuk petugas
                        Dandi07226_Allobjctrl.Penjual.login(textidlogin.getText(), textnamalogin.getText());
                        String nama = Dandi07226_Allobjctrl.Penjual.Dandi07226_PenjualEntity().getnama(); //memasukkan id,nama, jika benar 
                        JOptionPane.showMessageDialog(null, "Selamat datang "+nama,"information", JOptionPane.INFORMATION_MESSAGE);
                        Dandi07226_PenjualGUI petugas = new Dandi07226_PenjualGUI();
                        TampilanAwal.dispose();
                    }catch(Exception exception){ //jika id/nama salah makan akan muncul pesan
                        JOptionPane.showMessageDialog(null, "id atau nama salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    }
                        kosong();//method kosong, jika datanya kosong
                }else{
                    try{ //login untuk pelanggan
                       Dandi07226_Allobjctrl.Pembeli.login(textidlogin.getText(),textnamalogin.getText());
                       String nama = Dandi07226_Allobjctrl.Pembeli.getData().getnama(); //memasukkan id,nama, jika benar 
                       JOptionPane.showMessageDialog(null, "Selamat datang "+nama,"information", JOptionPane.INFORMATION_MESSAGE);
                       Dandi07226_PembeliGUI  pel = new Dandi07226_PembeliGUI();
                       TampilanAwal.dispose();
                    }catch(Exception eception){ //jika id/nama salah makan akan muncul pesan
                        JOptionPane.showMessageDialog(null, "id atau nama salah", "information", JOptionPane.INFORMATION_MESSAGE);
                       kosong(); //method kosong, jika datanya kosong
                    }
                }
            }
        });
        
        reg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    String id = textiddaftar.getText(); //regristasi
                    String nama = textnamadaftar.getText();
                    String alamat = textalamat.getText();
                    String noidentitas = textnoantrian.getText();
                    String notelp = textnotelp.getText();
                    Date tglbeli = new Date(texttglbeli.getText());
                    Dandi07226_Allobjctrl.Pembeli.insert(id, nama, alamat, noidentitas, notelp, tglbeli); //jika sukses
                    JOptionPane.showMessageDialog(null, "Registrasi sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
       void kosong(){
        textiddaftar.setText(null);//settext null semua
        textnamadaftar.setText(null);
        textalamat.setText(null);
        textnoantrian.setText(null);
        textnotelp.setText(null);
        texttglbeli.setText(null);
        textidlogin.setText(null);
        textnamalogin.setText(null);
    }
}
