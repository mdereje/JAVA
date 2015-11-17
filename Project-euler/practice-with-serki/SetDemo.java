import java.util.*;
import java.util.Arrays;

public class SetDemo {

  public static void main(String args[]) { 
     int count[] = {34, 22, 10, 60, 30, 22, 10, 13, 38, 42, 2834, 28, 58, 36, 12, 10, 22, 38, 42};
     Set<Integer> set = new HashSet<Integer>();

     try{
        for(int i = 0; i < count.length; i++){
           set.add(count[i]);
        }
        System.out.println("arrays : " + Arrays.toString(count));
        System.out.println("sets : " + set);
  
        TreeSet sortedSet = new TreeSet<Integer>(set);

        System.out.println("The sorted list is:");
        System.out.println(sortedSet);

        System.out.println("The First element of the set is: "+
                          (Integer)sortedSet.first());
        System.out.println("The last element of the set is: "+
                        (Integer)sortedSet.last());
     }
     catch(Exception e){}
  }
} 