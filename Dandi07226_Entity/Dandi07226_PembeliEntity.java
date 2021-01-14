package Dandi07226_Entity;
import java.util.Date;
public class Dandi07226_PembeliEntity  extends Dandi07226_TransaksiEntity{ 
    protected Date tgl_beli; 
    
    public Dandi07226_PembeliEntity(String id,String nama,
    String alamat, String noIdentitas,String notelp,Date tgl_beli){
        super(id,nama,alamat,noIdentitas,notelp); 
        this.tgl_beli=tgl_beli;
    }
    public Dandi07226_PembeliEntity(){
    }    

   @Override 
     public String getId() {
        return id;
    }
 
    public void setid(String id) {
        this.id = id;
    }

    public Date getTgl_beli() {
        return tgl_beli;
    }
    
    public void setTgl_beli(Date tgl_beli) {
        this.tgl_beli = tgl_beli;
    }

}
