package Dandi07226_Entity;
public class Dandi07226_DaftarPembeliEntity {
   private Dandi07226_PembeliEntity pembeli; 
    private boolean isVerified;
    private int indexIkan; 
     public Dandi07226_DaftarPembeliEntity(int indexIkan,
             Dandi07226_PembeliEntity pembeli, boolean isVerified) { 
         this.indexIkan = indexIkan;
        this.pembeli = pembeli;
        this.isVerified = isVerified;
    }
    public Dandi07226_PembeliEntity getPembeli() {
        return pembeli;
    }
    public boolean isIsVerified() {
        return isVerified;
    }
    public int getIndexIkan() {
        return indexIkan;
    }
    public void setPelanggan(Dandi07226_PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    public void setIndexCamera(int indexIkan) {
        this.indexIkan = indexIkan;
    }

  
}
