package Dandi07226_Controller;
import Dandi07226_Entity.Dandi07226_DaftarPembeliEntity;
import Dandi07226_Entity.Dandi07226_PembeliEntity;
import Dandi07226_Model.Dandi07226_PembeliModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class Dandi07226_PembeliController implements Dandi07226_ControllerInterface{
    int indexLogin = 0;
    
    public Dandi07226_PembeliController() {
    }
    
    public Dandi07226_PembeliEntity getData() {
        return Dandi07226_AllObjectModel.pembeliModel.getpembeliEntityArrayList(indexLogin);
    }
    
    public void Dandi07226_DaftarIkan(int indexIkan,  Dandi07226_PembeliEntity pembeli,
            boolean isVerified) {
        Dandi07226_AllObjectModel.daftarpembelimodel.insertDataPelanggan(new 
        Dandi07226_DaftarPembeliEntity (indexIkan,pembeli, isVerified));
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin = Dandi07226_AllObjectModel.pembeliModel.cekData(id, nama);
    }
    
    public void insert(String id,String nama,String alamat, String noIdentitas,String notelp,Date tgl_beli) {
        Dandi07226_PembeliEntity pembeliModel = new Dandi07226_PembeliEntity();
        pembeliModel.setid(id);
        pembeliModel.setnama(nama);
        pembeliModel.setalamat(alamat);
        pembeliModel.setnoIdentitas(noIdentitas);
        pembeliModel.setnotelp(notelp);
        pembeliModel.setTgl_beli(tgl_beli);
        Dandi07226_AllObjectModel.pembeliModel.insert(pembeliModel);
    }

    public int cekDaftarPembeli(String id) {
        int cek = Dandi07226_AllObjectModel.daftarpembelimodel.cekData(id, null);
        return cek;
    }
    
    public Dandi07226_DaftarPembeliEntity showDaftarPembeli(int index) {
        return Dandi07226_AllObjectModel.daftarpembelimodel.showDaftarPembeli(index);
    }
    public void deleteDataPembeli(int index) {
        Dandi07226_AllObjectModel.daftarpembelimodel.hapusPembeliModel(index);
    }
    public ArrayList<Dandi07226_DaftarPembeliEntity> cekDaftarPembeliModel() {
        return Dandi07226_AllObjectModel.daftarpembelimodel.getdaftarpembeliArrayList();
    }
    public DefaultTableModel daftarpel(){
        DefaultTableModel dtmdaftarpel = new DefaultTableModel();
        Object[] kolom ={"Id","Nama","Alamat","No Identitas","No Telp","Tgl Beli","Ikan","Bayar"};
        dtmdaftarpel.setColumnIdentifiers(kolom);
        int size = Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().size();
        String verif = null;
        for(int i=0;i<size;i++){
            if(Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().get(i).isIsVerified()==false){
                verif = "no";
            }else{
                verif = "yes";
            }
            Object [] data = new Object[9];
            data[0] = Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().get(i).getPembeli().getId();
            data[1] = Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().get(i).getPembeli().getnama();
            data[2] = Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().get(i).getPembeli().getalamat();
            data[3] = Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().get(i).getPembeli().getnoIdentitas();
            data[4] = Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().get(i).getPembeli().getnotelp();
            data[5] = Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().get(i).getPembeli().getTgl_beli();
            data[6] = Dandi07226_AllObjectModel.daftarpembelimodel.alldatapembeli().get(i).getIndexIkan();
            data[7] = verif;
            dtmdaftarpel.addRow(data);
    }
        return dtmdaftarpel;
    }
}
