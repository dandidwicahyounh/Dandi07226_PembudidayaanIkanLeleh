package Dandi07226_Model; 
import Dandi07226_Entity.Dandi07226_DaftarPembeliEntity;
import Dandi07226_Entity.Dandi07226_IkanEntity;
import Dandi07226_Entity.Dandi07226_PenjualEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
public class Dandi07226_DaftarPembeliModel implements Dandi07226_ModeIinterfaces { 
    private ArrayList<Dandi07226_DaftarPembeliEntity> daftarpembeliArrayList;
    public Dandi07226_DaftarPembeliModel(){
    daftarpembeliArrayList = new ArrayList<Dandi07226_DaftarPembeliEntity>();
        }
    public void insertDataPelanggan(Dandi07226_DaftarPembeliEntity daftarpembeli){
        daftarpembeliArrayList.add(daftarpembeli);
    }
    public ArrayList<Dandi07226_DaftarPembeliEntity> getdaftarpembeliArrayList(){
        return daftarpembeliArrayList;
    }
    @Override 
    public int cekData(String id, String nama){
        int loop = 0;
        if(daftarpembeliArrayList.size() ==0){
            loop = -1;//data kosong
        }else{
            for(int i = 0; i <daftarpembeliArrayList.size(); i++){
            if(daftarpembeliArrayList.get(i).getPembeli().getId().equals(id)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
    public Dandi07226_DaftarPembeliEntity showDaftarPembeli(int index){
        return daftarpembeliArrayList.get(index); //menampilkan data pembeli
    }
    public void hapusPembeliModel(int index) {
        daftarpembeliArrayList.remove(daftarpembeliArrayList.get(index)); //mengapus data pembeli
    }
    public void updateIsVerified(int index,Dandi07226_DaftarPembeliEntity daftarpembeli){
    daftarpembeliArrayList.set(index, daftarpembeli); 
    }
    public ArrayList <Dandi07226_DaftarPembeliEntity> alldatapembeli(){
        return  daftarpembeliArrayList;
    }
}
