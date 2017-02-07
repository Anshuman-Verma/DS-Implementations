/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;
/**
 *
 * @author Natsu  Dragneel
 */
public class test {

    public static void main(String args[]){

        int arr[] = {1,2,3,4,5};
        printArray(arr);
        AlterArray(arr);
        printArray(arr);


    }

    public static void AlterArray(int A[]){
        A[1] = 10;
    }

    public static void printArray(int A[]){
        for(int i =  0;  i<A.length; i++){
            System.out.print(A[i]);
        }
        System.out.println();
    }
}
