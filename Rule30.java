/**
*
*@ author cj LAPUZ
*
*/
import java.util.Scanner;
import java.lang.*;
public class Rule30 {
    
    public static void printGeneration(int[] arr){
        for (int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("");
    }   
    
    public static int[] setNextGen(int[] arr){
        int length = arr.length;
        int newArr[] = new int[length];
        
        // Setting the first value
        if (  arr[0] == 0 && arr[1] == 0)
        {
            newArr[0] = 0;    
        
        } else if (  arr[0] == 1 && arr[1] == 1 
                  || arr[0] == 1 && arr[1] == 0
                  || arr[0] == 0 && arr[1] == 1)
        {
            newArr[0] = 1;    
        }
        
        
        //Setting the last value
        if (  arr[length - 2] == 0 && arr[length - 1] == 0)
        {
            newArr[length - 1] = 0;    
        
        } else if (  arr[length - 2] == 0 && arr[length - 1] == 1 
                  || arr[length - 2] == 1 && arr[length - 1] == 0)
        {
            newArr[length - 1] = 1;    
        }
        
        
        //Setting the middle values
        for (int i = 1; i < length - 1; i++){
            if (   (arr[i - 1] == 0 && arr[i] == 0 && arr[i + 1] == 0)
                || (arr[i - 1] == 1 && arr[i] == 1 && arr[i + 1] == 1)
                || (arr[i - 1] == 1 && arr[i] == 1 && arr[i + 1] == 0)
                || (arr[i - 1] == 1 && arr[i] == 0 && arr[i + 1] == 1))
            {
                newArr[i] = 0;
                
            } else if ((arr[i - 1] == 1 && arr[i] == 0 && arr[i + 1] == 0)
                    || (arr[i - 1] == 0 && arr[i] == 1 && arr[i + 1] == 1)
                    || (arr[i - 1] == 0 && arr[i] == 1 && arr[i + 1] == 0)
                    || (arr[i - 1] == 0 && arr[i] == 0 && arr[i + 1] == 1))
            {
                newArr[i] = 1;
            } 
        }
        
        return newArr;
    }
    
    
    public static void main(String[] args) {
       
        Scanner generation = new Scanner(System.in);

        int num = generation.nextInt();
        
        if ( 1 <= num && num <= 30){
            Double mid = Math.ceil(num / 2.0);
            int seed = mid.intValue();
            int[] gen = new int[num];
        
            for (int i = 0; i < num - 1; i++){
                gen[i] = 0;
            }
            gen[seed - 1] = 1;
            printGeneration(gen);
        
        
            while (num  > 1){
            gen = setNextGen(gen);
            printGeneration(gen);
            num--;
            }
        }
    }
}
