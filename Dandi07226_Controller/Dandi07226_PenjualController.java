package Dandi07226_Controller;
import Dandi07226_Entity.Dandi07226_PenjualEntity;
import Dandi07226_Entity.Dandi07226_DaftarPembeliEntity;
import Dandi07226_Entity.Dandi07226_PembeliEntity;
import java.util.Date;
import java.util.ArrayList;
public class Dandi07226_PenjualController implements Dandi07226_ControllerInterface{
    int indexLogin = 0;
    public Dandi07226_PenjualController() {    
    }
    
    public void datapenjual(){
        String id[] = {"1","2","3"};
        String nama [] = {"dandi","bri","jimi"};
        String alamat [] = {"sby","sby","menganti"};
        String noIdentitas [] = {"01","02","03"};
        String notelp [] = {"1","2","3"};
              for(int i=0;i<id.length;i++){
                Dandi07226_AllObjectModel.penjualModel.insertPenjual(new 
                Dandi07226_PenjualEntity(id[i],nama[i],alamat[i],
                noIdentitas[i],notelp[i]));
            }
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin =  Dandi07226_AllObjectModel.penjualModel.cekData(id, nama);
    }
    
    public Dandi07226_PenjualEntity Dandi07226_PenjualEntity() {
        return Dandi07226_AllObjectModel.penjualModel.showDataPenjual(indexLogin);
    }
    
    public void updateIsVerified(int index,int indexCamera,Dandi07226_PembeliEntity pelanggan ) {
        Dandi07226_AllObjectModel.daftarpembelimodel.updateIsVerified(index, new 
        Dandi07226_DaftarPembeliEntity(indexCamera, pelanggan,true));
    }
    
    public ArrayList<Dandi07226_DaftarPembeliEntity> cekDaftarPembeliModel() {
        return Dandi07226_AllObjectModel.daftarpembelimodel.getdaftarpembeliArrayList();
    }
}
