package Logica;


import Dominio.Skin;


public class ListaSkins {
    private Skin [] listaSkins;
    private int cantSkins;
    private int max;

    public ListaSkins(int max) {
        this.cantSkins = 0;
        this.max = max;
        listaSkins = new Skin[max];
    }
    public boolean ingresarSkin(Skin skin){
        if(cantSkins<max){
            listaSkins[cantSkins] = skin;
            cantSkins++;
            return true;
        }else{
            return false;
        }
    }
    
    public Skin buscarSkin (String nombreSkin)
    {
        int i;
        for (i = 0; i < cantSkins; i++) {
            if(listaSkins[i].getNombreSkin().equals(nombreSkin)){
                break;
            }
        }
        
        if(i==cantSkins){
            return null;
        }else{
            return listaSkins[i];
        }
    }

    public int getCantSkins() {
        return cantSkins;
    }

    public void setCantSkins(int cantSkins) {
        this.cantSkins = cantSkins;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public Skin getSkinI(int i){
        if(i>=0 && i< cantSkins){
            return listaSkins[i];
        }else{
            return null;
        }
    }
    
}
