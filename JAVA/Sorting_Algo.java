import java.io.*;
import java.util.*;

public class Sorting_Algo{

        public static void main(String args[]) throws IOException{


                PrintWriter pw = new PrintWriter("Sort.txt","UTF-8");
                FileReader fr = new FileReader("Sort.txt");
                BufferedReader br = new BufferedReader(fr);
                Scanner sc = new Scanner(System.in);
                Random r = new Random();
                String line;
                int n = sc.nextInt();
                int RArray[] = new int [n];
                int FBArray[] = new int [n];
                int FIArray[] = new int [n];
                int j = 0;
                int i,sort,temp;

                try{

                        for(i=0;i<n;i++){
                                RArray[i] = 1000+r.nextInt(100);
                                pw.println(RArray[i]);
                        }
                }
                catch(Exception e){
                        System.out.println("Error");
                }
                pw.close();

                try{
                        while((line=br.readLine())!=null){
                                FBArray[j] = Integer.parseInt(line);
                                FIArray[j] = Integer.parseInt(line);
                                j++;
                        }
                }
                catch(Exception e){
                        System.out.println("File not found");
                }

                //Bubble Sort
                //System.out.println("Bubble Sort\n");
                long BubbleStart = System.nanoTime();
                while(true){
                        sort = 0;
                        for(i=0;i<n-1;i++){
                                if(FBArray[i]>FBArray[i+1]){
                                        temp = FBArray[i];
                                        FBArray[i] = FBArray[i+1];
                                        FBArray[i+1] = temp;
                                        sort = 1;
                                }
                        }
                        if(sort==0)
                                break;
                }
                long BubbleEnd = System.nanoTime();

                //for(int y:FBArray)
                        //System.out.println(y);
                System.out.println("Time for Bubble Sort = "+(BubbleEnd-BubbleStart)+" ns");
                System.out.println();

                //Insertion Sort
                //System.out.println("Insertion Sort\n");
                long InsertionStart = System.nanoTime();
                for(i=1;i<n;i++){
                        j = i-1;
                        temp = FIArray[i];
                        while(j>=0 && FIArray[j]>temp){
                                FIArray[j+1] = FIArray[j];
                                j--;
                        }
                        FIArray[j+1] = temp;
                }
                long InsertionEnd = System.nanoTime();

                //for(int x:FIArray)
                        //System.out.println(x);
                System.out.println("Time for Insertion Sort ="
+(InsertionEnd-InsertionStart)+ " ns");

                br.close();
                sc.close();

        }
}