package Dandi07226_Model;
import Dandi07226_Entity.Dandi07226_IkanEntity;
import Dandi07226_Entity.Dandi07226_PembeliEntity;
import Dandi07226_Model.Dandi07226_DaftarPembeliModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Dandi07226_PembeliModel implements Dandi07226_ModeIinterfaces { 
    private ArrayList<Dandi07226_PembeliEntity> pembeliEntityArrayList;
     
     public Dandi07226_PembeliModel(){
        pembeliEntityArrayList = new ArrayList<Dandi07226_PembeliEntity>();
    }
public void insert(Dandi07226_PembeliEntity pembeliEntity){ //menambah data pembeli
    pembeliEntityArrayList.add(pembeliEntity);  
}
public void hapuspembeliModel(int index) { //hapus data pembeli
        pembeliEntityArrayList.remove(pembeliEntityArrayList.get(index));
    }
 public int size() {
        return pembeliEntityArrayList.size();
    }
 @Override
    public int cekData(String id, String nama){
        int loop = 0;
        while (!pembeliEntityArrayList.get(loop).getId().equals(id) && 
                !pembeliEntityArrayList.get(loop).getnama().equals(nama)){
            loop++;
        }
        return loop;
    }
    public Dandi07226_PembeliEntity getpembeliEntityArrayList(int index){ //
        return pembeliEntityArrayList.get(index);
    }
}
