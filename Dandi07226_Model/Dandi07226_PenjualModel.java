package Dandi07226_Model;
import Dandi07226_Entity.Dandi07226_PenjualEntity;
import java.util.ArrayList;
public class Dandi07226_PenjualModel implements Dandi07226_ModeIinterfaces{ 
    private  ArrayList <Dandi07226_PenjualEntity> PenjualEntityArrayList;   
    public Dandi07226_PenjualModel(){
    PenjualEntityArrayList = new ArrayList<Dandi07226_PenjualEntity>();
    }
    public void insertPenjual(Dandi07226_PenjualEntity penjual){
        PenjualEntityArrayList.add(penjual);
    }
     @Override   
    public int cekData(String id, String nama){
        int loop = 0;
        for(Dandi07226_PenjualEntity penjualEntity : PenjualEntityArrayList){
            if(penjualEntity.getId().equals(id) && penjualEntity.getnama().equals(nama)){
            break;
            }else{
                loop++;
            }
        }
        return loop;
   }
    public Dandi07226_PenjualEntity showDataPenjual(int index){
        return PenjualEntityArrayList.get(index);
    }
}
