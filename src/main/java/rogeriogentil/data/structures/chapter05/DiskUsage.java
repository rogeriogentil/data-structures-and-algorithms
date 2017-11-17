package rogeriogentil.data.structures.chapter05;

import java.io.File;

/**
 *
 * @author rogerio
 */
public class DiskUsage {

   public static long analysis(File path) {
//      System.out.println("File or directory: " + path.getName());
      
      long total = path.length();
      
      if (path.isDirectory()) {
         for (File file : path.listFiles()) {
            total += analysis(file);
         }
      }
      
      System.out.println(total + "\t" + path);
      return total;
   }
   
   public static void main(String[] args) {
      String path = "/home/rogerio/tmp";
      File file = new File(path);
      
      System.out.println("Disk usage in " + path + ": " + analysis(file) + " bytes");
   }
}
