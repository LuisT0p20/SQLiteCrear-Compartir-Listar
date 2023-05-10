package Toribio.EvalPar.org.Entidades;

public class Sistema {
    private String idSistema;
    private String nombreSistema;
    private String propietarioSistema;
    private String precioSistema;
    private String nombreLenguaje;

    public Sistema() {
        this.idSistema = "nnn";
        this.nombreSistema = "nnn";
        this.propietarioSistema = "nnn";
        this.precioSistema = "nnn";
        this.nombreLenguaje = "nnn";
    }

    public Sistema(String idSistema, String nombreSistema, String propietarioSistema, String precioSistema, String nombreLenguaje) {
        this.idSistema = idSistema;
        this.nombreSistema = nombreSistema;
        this.propietarioSistema = propietarioSistema;
        this.precioSistema = precioSistema;
        this.nombreLenguaje = nombreLenguaje;
    }

    public String getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(String idSistema) {
        this.idSistema = idSistema;
    }

    public String getNombreSistema() {
        return nombreSistema;
    }

    public void setNombreSistema(String nombreSistema) {
        this.nombreSistema = nombreSistema;
    }

    public String getPropietarioSistema() {
        return propietarioSistema;
    }

    public void setPropietarioSistema(String propietarioSistema) {
        this.propietarioSistema = propietarioSistema;
    }

    public String getPrecioSistema() {
        return precioSistema;
    }

    public void setPrecioSistema(String precioSistema) {
        this.precioSistema = precioSistema;
    }

    public String getNombreLenguaje() {
        return nombreLenguaje;
    }

    public void setNombreLenguaje(String nombreLenguaje) {
        this.nombreLenguaje = nombreLenguaje;
    }

    @Override
    public String toString() {
        return "Sistema{" +
                "idSistema='" + idSistema + '\'' +
                ", nombreSistema='" + nombreSistema + '\'' +
                ", propietarioSistema='" + propietarioSistema + '\'' +
                ", precioSistema='" + precioSistema + '\'' +
                ", nombreLenguaje='" + nombreLenguaje + '\'' +
                '}';
    }
}
