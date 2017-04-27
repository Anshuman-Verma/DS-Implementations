import java.util.*;
import java.io.*;

/*
	Anshuman Verma
	201652003
*/
class SortingAlgo{

	// swap function for various sorting algos
	static void swap(int a, int b){
	a=a+b;
	b=a-b;
	a=a-b;
	}


	// Implementation of insertion sort
	static void insSort(int[] a){
		for(int j = 1; j<a.length; j++){
			int temp=a[j],i = j-1;
			while(i>=0 && temp<a[i]){
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = temp;
		}
	}



	// Implementation of bubble sort
	static void bubSort(int[] a){
		for(int i = 0; i<a.length; i++){
			for(int j = a.length-1; j>0; j--){
				if(a[j]<a[j-1]){
					a[j] = a[j] + a[j-1];
					a[j-1] = a[j] - a[j-1];
					a[j] = a[j] - a[j-1];
				}
			}
		}
	}



	//Simple function to find minimum value in an array starting from a given index
	static int findMin(int[] x, int start){
		int min = 1000000000;
		for(int i = start; i<x.length; i++)
			if(x[i]<min)
				min = x[i];

		return min;
	}



	// Implementation of Selection Sort
	 static void selSort(int[] a){
		for(int i =0; i<a.length; i++){
			int min = i, temp = a[i];	// min stores the index of min value post i+1
			for(int j = i+1; j<a.length; j++)	//find min element starting from i+1'th index
				if(a[min] > a[j])
					min = j;

			a[i] = a[min];
			a[min] = temp;
		}

	}



	//Implementation of Quick Sort
	static void qSort(int[] a, int left, int right){

		int i = left, j = right,pivot, temp;
		pivot = a[(left+right)/2];	//taking pivot as the central element

		// partitioning of given array
		while(i<=j){

			while(a[i]<pivot)
				i++;
			while(a[j]>pivot)
				j--;

			if(i<=j){
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}

		}

		// recursion to sort individual partitions
		if(left<j)
			qSort(a,left, j);
		if(i < right)
			qSort(a, i, right);
	}



	// Implementation of Merge Sort
	static void mergeSort(int[] a, int l, int r){
		if(l<r){
			int mid = l + (r-l)/2;


			// partitioning array
			mergeSort(a, l , mid);
			mergeSort(a, mid+1, r);


			// Merging together all the partitions
			Merge(a,l,mid,r);
		}
	}

	static void Merge(int[] arr, int l, int m, int r){
		int i, j, k;
		int n1 = m-l+1;
		int n2 = r-m;


		// create temp arrays for partitions of main arary
		int[] L = new int[n1];
		int[] R = new int[n2];

		// copying data to temp arrays
		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1+ j];

		/* Merge the temp arrays back into arr[l..r]*/
		i = 0; // Initial index of first subarray
		j = 0; // Initial index of second subarray
		k = l; // Initial index of merged subarray
		while (i < n1 && j < n2){
			if (L[i] <= R[j]){
				arr[k] = L[i];
				i++;
			}
			else{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		//We need to take care of the left out elements in both arrays

		// Copy remaining elements of L temp array
		while(i<n1){
			arr[k] = L[i];
			i++;
			k++;
		}

		//Copy remaining  elements of R temp array
		while(j < n2){
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	// global variable to keep track of array size
    private static int N;
	
	//Implementation of heap sort
    public static void heapSort(int arr[])
    {       
        heapify(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }     
	
	
    // Function for heap ssort to build a max heap 
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
	
	
	////Function for heap sort to swap elements and convert it to heap      
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }
	
	
    /* Function to swap two numbers in an array arr at 2 specified locations*/
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    
	
	

	// Simple function to print an array
	static void printArray(int[] a){
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}


	public static void main(String args[]){

		int n;
		// some variables to record start time
		long inst,bubt,selt,mert,heapt,qtime;
		//some variables to record end time
		long rinst,rbubt,rselt,rmert,rheapt,rqtime;

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("Enter No of input elements");
		n = sc.nextInt();
		
		// Renerating random arrays to be sorted
		int[] ipNonRepeated = new int[n];
		int[] ipRepeated = new int[n];
		for(int i =0; i<n; i++){
			ipRepeated[i] = rand.nextInt(n/4) + 10001;
			ipNonRepeated[i] = rand.nextInt(1000000);
		}
		
		/*for(int i =0; i<n; i++){
			System.out.println(ipNonRepeated[i] +  " " + ipRepeated[i] );
		}*/
		
		// below is the code to calculate Non-Repeated time complexity, similarly Repeated can be done
		int[] temp;
		temp = ipNonRepeated.clone();
		inst = System.nanoTime();
		insSort(temp);
		rinst = System.nanoTime();
		
		temp = ipNonRepeated.clone();
		bubt = System.nanoTime();
		bubSort(temp);
		rbubt = System.nanoTime();
		
		temp = ipNonRepeated.clone();
		selt = System.nanoTime();
		selSort(temp);
		rselt = System.nanoTime();
		
		temp = ipNonRepeated.clone();
		mert = System.nanoTime();
		mergeSort(temp,0,temp.length-1);
		rmert = System.nanoTime();
		
		temp = ipNonRepeated.clone();
		qtime = System.nanoTime();
		qSort(temp,0,temp.length-1);
		rqtime = System.nanoTime();
		
		temp = ipNonRepeated.clone();
		heapt = System.nanoTime();
		heapSort(temp);
		rheapt = System.nanoTime();
		
		System.out.println("ins-"+ (rinst-inst) + "\n bub-" + (rbubt-bubt) + "\n sel-"+(rselt-selt) + "\n merge-"+ (rmert-mert) + "\nquick-" + (rqtime-qtime)+ "\nheap-" + (rheapt-heapt));
	
		
	}


}
