package Utilidades;

public class DoubleUtil {
    public static double truncarDouble(double valor, int casasDecimais){
        String formato = "%." + casasDecimais+"f";
        return Double.parseDouble(String.format(formato, valor));
    }
}
