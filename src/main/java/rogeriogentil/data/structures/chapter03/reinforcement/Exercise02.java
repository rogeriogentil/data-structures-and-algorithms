package rogeriogentil.data.structures.chapter03.reinforcement;

import java.util.Date;
import java.util.Random;

/**
 * Write a Java method that repeatedly selects and removes a random entry from
 * an array until the array holds no more entries.
 *
 * @author Rogerio J. Gentil
 */
public class Exercise02 {

    private static int capacidade = 20;    
    private static Double[] doubleArray = new Double[capacidade];

    public static void main(String[] args) {
        PseudoRandom pseudoRandom = new PseudoRandom(new Date().getTime());

        for (int i = 0; i < capacidade; i++) {
            doubleArray[i] = pseudoRandom.next();
            System.out.println(i + ". " + doubleArray[i]);
        }

        while (doubleArray.length > 0) { // Testar todas as entradas == null ou total de elemento == 0?
            remove();
        }
    }

    public static void remove() {
        Random random = new Random();
        int index = random.nextInt(capacidade);
        
        if (doubleArray[index] == null) {
            return;
        }
            
        double valor = doubleArray[index];
        doubleArray[index] = null;
        
        System.out.println("removeu no index " + index + ": " + valor);
    }
}
