import java.util.*;

public class OptimizacionProcesos {

    public static void quicksort(int[] arreglo) {
        quicksortAuxiliar(arreglo, 0, arreglo.length - 1);
    }

    private static void quicksortAuxiliar(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(arreglo, inicio, fin);
            quicksortAuxiliar(arreglo, inicio, indicePivote - 1);
            quicksortAuxiliar(arreglo, indicePivote + 1, fin);
        }
    }

    private static int particionar(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] < pivote) {
                i++;
                intercambiar(arreglo, i, j);
            }
        }
        intercambiar(arreglo, i + 1, fin);
        return i + 1;
    }
    private static void intercambiar(int[] arreglo, int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    public static void main(String[] args) {
        int[] arreglo = {12, 4, 7, 9, 2, 16, 5};
        System.out.println("Arreglo original: " + Arrays.toString(arreglo));
        quicksort(arreglo);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
    }
}
