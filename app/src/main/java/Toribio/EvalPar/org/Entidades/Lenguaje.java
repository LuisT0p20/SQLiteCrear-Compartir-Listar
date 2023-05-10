package Toribio.EvalPar.org.Entidades;

public class Lenguaje {
    private String idLenguaje;
    private String nombreLenguaje;

    public Lenguaje() {
        this.idLenguaje = "0";
        this.nombreLenguaje = "nnn";
    }

    public Lenguaje(String idLenguaje, String nombreLenguaje) {
        this.idLenguaje = idLenguaje;
        this.nombreLenguaje = nombreLenguaje;
    }

    public String getIdLenguaje() {
        return idLenguaje;
    }

    public void setIdLenguaje(String idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    public String getNombreLenguaje() {
        return nombreLenguaje;
    }

    public void setNombreLenguaje(String nombreLenguaje) {
        this.nombreLenguaje = nombreLenguaje;
    }

    @Override
    public String toString() {
        return "Lenguaje{" +
                "idLenguaje='" + idLenguaje + '\'' +
                ", nombreLenguaje='" + nombreLenguaje + '\'' +
                '}';
    }
}
