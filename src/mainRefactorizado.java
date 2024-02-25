import java.util.Scanner;

public class mainRefactorizado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = scanner.nextInt();
        scanner.close(); // Cerrar el scanner después de su uso

        System.out.println("\nVector inicial hasta: " + dato);
        imprimirVectorInicial(dato);

        int[] primos = generarPrimos(dato);
        System.out.println("\nVector de primos hasta: " + dato);
        imprimirVector(primos);
    }

    /** Imprimir vector inicial hasta el número dado
     * @param max Tamaño máximo del array
    */
    public static void imprimirVectorInicial(int max) {
        for (int i = 1; i <= max; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + "\t");
        }
    }

    /** Imprimir vector de primos
     * @param vector Almacena todos los datos hasta el máximo para después imprimirlo
     */
    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    // Generar números primos de 1 a max usando la criba de Eratóstenes
    public static int[] generarPrimos(int max) {
        if (max < 2) return new int[0]; // Caso base: max < 2

        boolean[] esPrimo = new boolean[max + 1];
        esPrimo = rellenarArray(esPrimo, max);
        esPrimo = cribaErastotenes(esPrimo, max);
        return rellenarPrimos(cuentaPrimos(esPrimo), max, esPrimo);
    }

    /** Rellena el array
     * @param esPrimo Dice si es primo o no
     */
    public static boolean[] rellenarArray(boolean[] esPrimo, int max) {
        for (int i = 2; i <= max; i++) {
            esPrimo[i] = true;
        }
        return esPrimo;
    }

    // Cuenta la cantidad de primos existen
    public static int cuentaPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) cuenta++;
        }
        return cuenta;
    }

    /** Rellenar el vector de números primos
     * @param cuenta Cantidad de primos que hay
     */
    public static int[] rellenarPrimos(int cuenta, int max, boolean[] esPrimo) {
        int[] primos = new int[cuenta];
        int idx = 0;
        for (int i = 2; i <= max; i++) {
            if (esPrimo[i]) {
                primos[idx++] = i;
            }
        }
        return primos;
    }

    // Elimina los números que no son primos
    public static boolean[] cribaErastotenes(boolean[] esPrimo, int max) {
        for (int i = 2; i * i <= max; i++) {
        if (esPrimo[i]) {
            for (int j = i * i; j <= max; j += i) {
                esPrimo[j] = false;
                }
            }
        }
        return esPrimo;
    }
}

