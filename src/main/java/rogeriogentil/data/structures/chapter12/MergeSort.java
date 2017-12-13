package rogeriogentil.data.structures.chapter12;

import java.util.Arrays;
import java.util.Comparator;
import rogeriogentil.data.structures.chapter06.LinkedQueue;
import rogeriogentil.data.structures.chapter06.Queue;

/**
 *
 * @author Rogerio J. Gentil
 */
public class MergeSort {
    
    
    // ----- Array-Based Implementation -----
    /**
     * Merge-sort contents of array S.
     * 
     * @param <K>
     * @param S
     * @param comp 
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        
        if (n < 2) {
            return;
        }
        
        // divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);         // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);         // copy of second half
        
        // conquer
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        
        // merge results
        merge(S1, S2, S, comp);         // merge sorted halves back into original
    }
    
        /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     * 
     * @param <K>
     * @param S1
     * @param S2
     * @param S
     * @param comp 
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i+j] = S1[i++];
            } else {
                S[i+j] = S2[j++];
            }
        }
    }
    
    
    // ----- Queue-Based Implementation -----
    /**
     * Merge-sort contents of queue.
     * 
     * @param <K>
     * @param S
     * @param comp 
     */
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        
        if (n < 2) {
            return;
        }
        
        // divide
        int mid = n/2;
        Queue<K> S1 = new LinkedQueue<>();
        Queue<K> S2 = new LinkedQueue<>();
        
        while (S1.size() < mid) {
            S1.enqueue(S.dequeue());    // move the first n/2 elements to S1
        }
        
        while (!S.isEmpty()) {
            S2.enqueue(S.dequeue());    // move remaining elements to S2
        }
        
        // conquer (with recursion)
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        
        // merge results
        merge(S1, S2, S, comp);         // merge sorted halves back into original
    }
    
    /**
     * Merge contents of sorted queues S1 and S2 into empty queue S.
     * 
     * @param <K>
     * @param S1
     * @param S2
     * @param S
     * @param comp 
     */
    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp) {
        while (!S1.isEmpty() && !S2.isEmpty()) {
            if (comp.compare(S1.first(), S2.first()) < 0) {
                S.enqueue(S1.dequeue());
            } else {
                S.enqueue(S2.dequeue());
            }
        }
        
        while (!S1.isEmpty()) {
            S.enqueue(S1.dequeue());    // move any elements that remain in S1
        }
        
        while (!S2.isEmpty()) {
            S.enqueue(S2.dequeue());    // move any elements that remain in S2
        }
    }
    
    // ----- Bottom-Up (Nonrecursive) Implementation -----
    /**
     * Merge-sort contents of data array.
     * 
     * @param <K>
     * @param orig
     * @param comp 
     */
    public static <K> void mergeSortBottomUp(K[] orig, Comparator<K> comp) {
        int n = orig.length;
        
        K[] src = orig;                     // alias for the original
        K[] dest = (K[]) new Object[n];     // make a new temporary array
        K[] temp;                           // reference used only for swapping
        
        for (int i = 1; i < n; i *= 2) {    // each iteration sorts all runs of length i
            for (int j = 0; j < n; j += 2 * i) {    // each pass merges two runs of length i
                merge(src, dest, comp, j, i);
            }
            
            // reverse roles of the arrays
            temp = src;
            src = dest;
            dest = temp;
        }
        
        if (orig != src) {
            System.arraycopy(src, 0, orig, 0, n);   // additional copy to get result to original
        }
    }
    
    /**
     * Merges in[start..start+inc−1] and in[start+inc..start+2∗inc−1] into out.
     * 
     * @param <K>
     * @param in
     * @param out
     * @param comp
     * @param start
     * @param inc 
     */
    public static <K> void merge(K[] in, K[] out, Comparator<K> comp, int start, int inc) {
        int end1 = Math.min(start + inc, in.length);        // boundary for run 1
        int end2 = Math.min(start + 2 * inc, in.length);    // boundary for run 2
        
        int x = start;                                      // index into run 1
        int y = start + inc;                                // index into run 2
        int z = start;                                      // index into output
        
        while (x < end1 && y < end2) {
            if (comp.compare(in[x], in[y]) < 0) {
                out[z++] = in[x++];                         // take next from run 1
            } else {
                out[z++] = in[y++];                         // take next from run 2
            }
        }
        
        if (x < end1) {
            System.arraycopy(in, x, out, z, end1 - x);      // copy rest of run 1
        } else if (y < end2) {
            System.arraycopy(in, y, out, z, end2 - x);      // copy rest of run 2
        }
    }
}
