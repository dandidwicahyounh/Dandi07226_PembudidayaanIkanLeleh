package Dandi07226_Entity;
import java.util.Date;
public class Dandi07226_PenjualEntity extends Dandi07226_TransaksiEntity{ 
    public Dandi07226_PenjualEntity(String id,String nama,
    String alamat, String noIdentitas,String notelp){
        super(id,nama,alamat,noIdentitas,notelp); 
}
    
 @Override 
    public String getId() {
        return id;
    }
}

