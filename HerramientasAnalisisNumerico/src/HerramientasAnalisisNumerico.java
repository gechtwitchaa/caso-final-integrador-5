public class HerramientasAnalisisNumerico {

    public static int calcularSumatoria(int n) {
        if (n == 0) {
            return 0;
        }
        return n + calcularSumatoria(n - 1);
    }

    public static void listarNumerosEnRango(int inicio, int fin) {

        if (inicio > fin) {
            return;
        }
        System.out.print(inicio + " ");
        listarNumerosEnRango(inicio + 1, fin);
    }

    public static int calcularPotencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }

        return base * calcularPotencia(base, exponente - 1);
    }


    public static int encontrarMaximo(int[] arreglo, int inicio, int fin) {

        if (inicio == fin) {
            return arreglo[inicio];
        }
        int medio = (inicio + fin) / 2;
        int maximoIzquierda = encontrarMaximo(arreglo, inicio, medio);
        int maximoDerecha = encontrarMaximo(arreglo, medio + 1, fin);
        return Math.max(maximoIzquierda, maximoDerecha);
    }


    public static int encontrarMaximo(int[] arreglo) {

        return encontrarMaximo(arreglo, 0, arreglo.length - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sumatoria de los primeros " + n + " números naturales: " + calcularSumatoria(n));

        int inicio = 1, fin = 10;
        System.out.print("Listado de números en el rango [" + inicio + ", " + fin + "]: ");
        listarNumerosEnRango(inicio, fin);
        System.out.println();

        int base = 2, exponente = 5;
        System.out.println("Potencia de " + base + " elevado a " + exponente + ": " + calcularPotencia(base, exponente));

        int[] arreglo = {3, 7, 2, 9, 5};
        System.out.println("Valor máximo en el arreglo: " + encontrarMaximo(arreglo));
    }
}
