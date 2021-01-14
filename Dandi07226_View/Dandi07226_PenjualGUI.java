package Dandi07226_View;
import Dandi07226_Controller.Dandi07226_AllObjectModel;
import Dandi07226_Controller.Dandi07226_PembeliController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Dandi07226_PenjualGUI {
    private static Dandi07226_PembeliController pembeli = new Dandi07226_PembeliController();
    JFrame penjual = new JFrame();
    JTable tabelpembeli = new JTable();
    JScrollPane scrollpenjual = new JScrollPane(tabelpembeli);
    JButton back,bayar,hapus;
    JLabel penjual1,idlabel,namalabel;
    JTextField idtext,namatext;
     public Dandi07226_PenjualGUI(){
        penjual.setSize(650,500);
        penjual.setLayout(null);
        penjual.getContentPane().setBackground(Color.RED);
        
        penjual1 = new JLabel("Penjual");
        penjual1.setBounds(250, 30, 200, 30);
        penjual1.setFont(new Font("Timer New Roman",Font.BOLD,30));
        penjual.add(penjual1);
        
        scrollpenjual.setBounds(30, 100, 570, 200);
        tabelpembeli.setModel(pembeli.daftarpel());
        penjual.add(scrollpenjual);
        
        idlabel = new JLabel("Id");
        idlabel.setBounds(50, 320, 100, 30);
        penjual.add(idlabel);
        idtext = new JTextField();
        idtext.setBounds(50, 350, 100, 30);
        penjual.add(idtext);
        
        namalabel = new JLabel("Nama");
        namalabel.setBounds(200, 320, 100, 30);
        penjual.add(namalabel);
        namatext = new JTextField();
        namatext.setBounds(200, 350, 100, 30);
        penjual.add(namatext);
        
        bayar = new JButton("bayar");
        bayar.setBounds(350, 350, 100, 30);
        bayar.setBackground(Color.GRAY);
        penjual.add(bayar);
        
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.GRAY);
        penjual.add(back);
        
        hapus = new JButton("Hapus");
        hapus.setBounds(350, 410, 100, 30);
        hapus.setBackground(Color.GRAY);
        penjual.add(hapus);
        
        penjual.setLocationRelativeTo(null);
        penjual.setVisible(true);
        penjual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                penjual.dispose();
                Dandi07226_GUI men = new Dandi07226_GUI();//nama objek men
            }
        });
        
        bayar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi id, dan nama
                String id = idtext.getText();
                String nama = namatext.getText();
                int index = Dandi07226_AllObjectModel.daftarpembelimodel.cekData(id, nama); //dicek
                Dandi07226_Allobjctrl.Penjual.updateIsVerified(index, Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(index)
                        .getIndexIkan(),Dandi07226_Allobjctrl.Pembeli.showDaftarPembeli(index).getPembeli());
                tabelpembeli.setModel(pembeli.daftarpel());
            }
        });
        
        hapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi id, dan nama
                
                Dandi07226_Allobjctrl.Pembeli.deleteDataPembeli(0);
                tabelpembeli.setModel(pembeli.daftarpel());
            }
        });
        
        tabelpembeli.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){  //method
                int i = tabelpembeli.getSelectedRow();
                idtext.setText(Dandi07226_Allobjctrl.Pembeli.daftarpel().getValueAt(i, 0).toString());
                namatext.setText(Dandi07226_Allobjctrl.Pembeli.daftarpel().getValueAt(i, 1).toString());
            }
        });
     }
}
