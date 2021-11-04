package Dominio;


public class Skin {
    private String nombreSkin;
    private String calidad;

    public Skin(String nombreSkin, String calidad) {
        this.nombreSkin = nombreSkin;
        this.calidad = calidad;
    }

    public String getNombreSkin() {
        return nombreSkin;
    }

    public void setNombreSkin(String nombreSkin) {
        this.nombreSkin = nombreSkin;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
    
    
}
