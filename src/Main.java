
/**
 *
 * @author Martín CJ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int TAM = 50;
        double dIni, dFin, dTotal;
        int[] iArray = new int[TAM];

        for (int i = 0; i < iArray.length; i++) {
            iArray[i] = (int) (Math.random() * 100);

        }

        dIni = System.nanoTime();
        selectionsort(iArray);
        dFin = System.nanoTime();
        dTotal = dFin - dIni;
        dTotal /= 1000000;
        System.out.println("El tiempo es:  " + dTotal);

    }

    public static void insertionsort(int[] aiDatos) {
        int temp;
        for (int i = 1; i < aiDatos.length; i++) {
            for (int j = i; j > 0; j--) {
                if (aiDatos[j] < aiDatos[j - 1]) {
                    temp = aiDatos[j];
                    aiDatos[j] = aiDatos[j - 1];
                    aiDatos[j - 1] = temp;
                }
            }

        }
    }

    public static void quicksort(int iArray[], int izq, int der) {
        int pivote = iArray[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {
            while (iArray[i] <= pivote && i < j) {
                i++;
            }
            while (iArray[j] > pivote) {
                j--;
            }
            if (i < j) {
                aux = iArray[i];
                iArray[i] = iArray[j];
                iArray[j] = aux;
            }
        }
        iArray[izq] = iArray[j];
        iArray[j] = pivote;
        if (izq < j - 1) {
            quicksort(iArray, izq, j - 1);
        }

        if (j + 1 < der) {
            quicksort(iArray, j + 1, der);
        }
    }

    public static void bubblesort(int[] aiDatos) {
        //int temp;
        for (int i = 0; i < aiDatos.length; i++) {
            for (int j = 0; j < aiDatos.length; j++) {
                if (aiDatos[i] < aiDatos[j]) {
                    aiDatos[i] = aiDatos[i] + aiDatos[j];
                    aiDatos[j] = aiDatos[i] - aiDatos[j];
                    aiDatos[i] = aiDatos[i] - aiDatos[j];
                }
            }

        }

    }

    public static void selectionsort(int[] iArray) {
        int min;
        //primer for de la segunda posicion hasta el final
        for (int i = 0; i < iArray.length - 1; i++) {
            min = i;
            //segundo for desde la posicion 1 hasta el penultimo lugar
            for (int j = i + 1; j < iArray.length; j++) {

                if (iArray[min] > iArray[j]) {
                    min = j;
                }
            }
            int iTemp = iArray[i];
            iArray[i] = iArray[min];
            iArray[min] = iTemp;
        }
    }
}
