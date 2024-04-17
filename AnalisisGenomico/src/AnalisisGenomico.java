public class AnalisisGenomico {


    public static int contarGenes(String cadenaADN) {
        int contador = 0;
        int indice = cadenaADN.indexOf("ATG");
        while (indice != -1) {
            contador++;
            indice = cadenaADN.indexOf("ATG", indice + 3);
        }
        return contador;
    }


    public static int calcularCombinacionesGeneticas(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return calcularCombinacionesGeneticas(n - 1) + calcularCombinacionesGeneticas(n - 2);
    }

    public static void main(String[] args) {

        String cadenaADN = "ATGCTATGATGCGATGTAG";
        System.out.println("Número de genes en la cadena de ADN: " + contarGenes(cadenaADN));

        int n = 5; 
        System.out.println("Número de combinaciones genéticas para n=" + n + ": " + calcularCombinacionesGeneticas(n));
    }
}
