import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practica1_PARCIAL2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[][] calificaciones = new double[5][5];

        String[] grupos = {"1A", "1B", "4A", "4B", "4C"};

        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("CALIFICACIONES DEL LOS ALUMNOS DE TICS");
            System.out.println("*************************************************************");
            System.out.println("Ingrese las calificaciones del grupo " + grupos[i] + ":");
            for (int j = 0; j < calificaciones[i].length; j++) {
                System.out.print("Calificacion " + (j + 1) + ": ");
                calificaciones[i][j] = Double.parseDouble(reader.readLine());
            }
        }

        double[] promediosGrupos = calcularPromedios(calificaciones);
        double promedioGeneral = calcularPromedioGeneral(promediosGrupos);

        for (int i = 0; i < promediosGrupos.length; i++) {
            System.out.println("******************************************************************");
            System.out.println("El promedio del grupo " + grupos[i] + " es: " + promediosGrupos[i]);
        }

        System.out.println("************************************************************************");
        System.out.println("El promedio general de todos los grupos de TICS es: " + promedioGeneral);
    }

    public static double[] calcularPromedios(double[][] calificaciones) {
        double[] promedios = new double[calificaciones.length];

        for (int i = 0; i < calificaciones.length; i++) {
            for (int j = 0; j < calificaciones[i].length; j++) {
                promedios[i] += calificaciones[i][j];
            }
            promedios[i] /= calificaciones[i].length;
        }

        return promedios;
    }

    public static double calcularPromedioGeneral(double[] promedios) {
        double suma = 0;
        for (double promedio : promedios) {
            suma += promedio;
        }
        return suma / promedios.length;
    }
}