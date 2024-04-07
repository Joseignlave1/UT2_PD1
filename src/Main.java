import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {


    public static void bubbleSort(String rutaArchivo) {
        FileReader fr;
        try {
            fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();//Leemos la primera línea.
            String aPartirdeSegundaLinea = br.readLine();//Leemos a partir de la segunda línea
            int[] archivoArray = new int[Integer.parseInt(lineaActual)];
            int index = 0;
            while(aPartirdeSegundaLinea != null) {
                archivoArray[index++] = Integer.parseInt(aPartirdeSegundaLinea);
                aPartirdeSegundaLinea = br.readLine();
            }
            int N = archivoArray.length;
            int counter = 0;
            for(int i = 1; i < N; i++) { // i va hasta n - 1;
                for(int j = N - 1; j >= i;  j--) { //En java los Arrays van de 0 hasta N -1, por ende
                    // j tienen que inicializarse en el último elemento del array, que en el pseudocódigo es N
                    //Como j se inicializa en el último elemento del Array, tiene que ir decrementando,
                    if(archivoArray[j] <  archivoArray[j -1]) {
                        counter++;
                        //Swapping implementando el método intercambiar.
                        int temp = archivoArray[j];
                        archivoArray[j] = archivoArray[j -1];
                        archivoArray[j - 1] = temp;
                    }
                }
            }
            System.out.println("Longitud de N" + " " + N);
            System.out.println("Se invocó a la sentencia si" + " " + counter);
            System.out.println("Primer elemento del Array ordenado" + " " + archivoArray[0]);
            System.out.println("último elemento del Array ordenado" + " " + archivoArray[N - 1]);
            System.out.println(Arrays.toString(archivoArray));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Archivo leído correctamente");

    }
    public static void main(String[] args) {
        bubbleSort("C:/Users/Leo84/IdeaProjects/UT1_PD2-Jose Ignacio Lavecchia/out/production/UT1_PD2-Jose Ignacio Lavecchia/numeros.txt");
    }
}

//i se inicializa en 1, j va decrementando hasta que sea mayor que i + 1, o sea hasta que llegue al segundo elemento del Array
//Ya qué este algoritmo compara desde el último elemento del Array, hasta el segundo, se puede implementar de varias maneras.
//en este caso compara el elemento actual con el anterior, por eso inicializamos i en 1, para que pueda comparar el elemento
//en la posición 1 con el elemento en la posición 0, si i = 0; entonces compararía el elemento en la posición 0
//con el elemento en la posición 0 - 1, y esto no es una posición válida en el Array.