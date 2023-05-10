package Toribio.EvalPar.org.utils;

public class Utilidades {
    //Sistema
    public static final String TABLA_SISTEMA = "sistema";
    public static final String CAMPO_ID = "idSistema";
    public static final String CAMPO_NOMBRE = "nombreSistema";
    public static final String CAMPO_PROPIETARIO = "propietarioSistema";
    public static final String CAMPO_PRECIO = "precioSistema";
    public static final String CAMPO_NOMBRE_LENGUAJE = "nombreLenguaje";
    //Lenguaje
    public static final String TABLA_LENGUAJE = "lenguaje";
    public static final String CAMPO_ID_LENGUAJE = "idLenguaje";
    public static final String CAMPO_NOMBRELENGUAJE = "nombreLenguaje";
    //datos tabla
    public static final Integer VERSION = 1;
    public static final String NOMBREBD = "bd_ltp_sistema";
    //creacion
    public static final String CREAR_TABLA_SISTEMA = "CREATE TABLE " + TABLA_SISTEMA +
            " (" + CAMPO_ID + " TEXT, "
            + CAMPO_NOMBRE + " TEXT, " +
            CAMPO_PROPIETARIO + " TEXT, " +
            CAMPO_PRECIO + " TEXT, " +
            CAMPO_NOMBRE_LENGUAJE+ " TEXT)";
    public static final String CREAR_TABLA_LENGUAJE = "CREATE TABLE " + TABLA_LENGUAJE + " (" + CAMPO_ID_LENGUAJE + " TEXT, " +  CAMPO_NOMBRELENGUAJE + " TEXT)";

    public static final String insert_LENGUAJE ="INSERT INTO " + TABLA_LENGUAJE + " (" + CAMPO_ID_LENGUAJE + ", " + CAMPO_NOMBRELENGUAJE + ") " +
            "values('1', 'Java'), ('2', 'Go'), " +
            "('3', 'JavaScript'), ('4', 'Python'), ('5', 'Dart');";
}
