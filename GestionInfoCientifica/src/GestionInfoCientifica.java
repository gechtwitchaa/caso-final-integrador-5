import java.io.*;
import java.util.*;

public class GestionInfoCientifica {


    public static void ordenarLineasArchivo(String nombreArchivo) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            br.close();

            Collections.sort(lineas);

            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
            for (String l : lineas) {
                bw.write(l + "\n");
            }
            bw.close();
            System.out.println("El archivo ha sido ordenado alfabéticamente.");
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    public static boolean buscarPalabraLineal(String palabra, String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(palabra)) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
        return false;
    }

    public static boolean buscarPalabraBinaria(String palabra, String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            br.close();

            Collections.sort(lineas);

            int inicio = 0, fin = lineas.size() - 1;
            while (inicio <= fin) {
                int medio = (inicio + fin) / 2;
                String lineaMedio = lineas.get(medio);
                if (lineaMedio.equals(palabra)) {
                    return true;
                } else if (lineaMedio.compareTo(palabra) < 0) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
        return false;
    }

    public static void listarFechasOrdenadas(List<String> fechas) {
        Collections.sort(fechas);
        System.out.println("Fechas ordenadas:");
        for (String fecha : fechas) {
            System.out.println(fecha);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String archivo = "documento.txt";
        ordenarLineasArchivo(archivo);

        String palabraBuscada = "investigación";
        if (buscarPalabraLineal(palabraBuscada, archivo)) {
            System.out.println("La palabra '" + palabraBuscada + "' ha sido encontrada (búsqueda lineal).");
        } else {
            System.out.println("La palabra '" + palabraBuscada + "' no ha sido encontrada (búsqueda lineal).");
        }

        if (buscarPalabraBinaria(palabraBuscada, archivo)) {
            System.out.println("La palabra '" + palabraBuscada + "' ha sido encontrada (búsqueda binaria).");
        } else {
            System.out.println("La palabra '" + palabraBuscada + "' no ha sido encontrada (búsqueda binaria).");
        }

        List<String> fechas = Arrays.asList("2023-01-15", "2022-12-25", "2024-05-10"); // Ejemplo de lista de fechas
        listarFechasOrdenadas(fechas);
    }
}
