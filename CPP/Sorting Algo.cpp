#include<iostream>
#include<string>
using namespace std;
void merge(int arr[],int l,int m,int r);

void swap(int *a, int *b){			// swap function for other functions
	
    *a = *a + *b;
    *b = *a - *b;
    *a = *a - *b;
    
}


int selsort(int *A,int N){

    for(int i = 0; i < N; i++){
        
        int min = 100000,index;
        
    	for(int x = i;x<N;x++){
	        if(A[x]<min){
	            min = A[x];
	            index =  x;
			}
    	}
    //	cout << "min " << min << A[index] << index << A[i] << i << endl;
    	if(index !=  i)
    	swap(&A[i],&A[index]);
	}
    return *A;
}

int inssort(int *A,int N){

	for(int itr = 1 ; itr<N ; itr++){
	
		int temp = A[itr],x=itr-1;
		
		while(A[x] > temp && x>=0){
			A[x+1] = A[x];
			x--;
			}
		A[x+1] = temp;
		
	}

return *A;

}


int quickSort(int arr[], int left, int right) {
      int i = left, j = right;
      int tmp;
      int pivot = arr[(left + right) / 2];
 
      /* partition */
      while (i <= j) {
            while (arr[i] < pivot)
                  i++;
            while (arr[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
      };
      /* recursion */
      if (left < j)
            quickSort(arr, left, j);
      if (i < right)
            quickSort(arr, i, right);

return *arr;
}


void mergeSort(int a[], int l, int r)
{	
	if(l<r)
	{
		int m  =  l + (r-l)/2;
		
		mergeSort(a, l , m);
		mergeSort(a,m+1,r);
		
		merge(a,l,m,r);	
	}
	
}

void merge(int arr[], int l, int m, int r)
{
    int i, j, k;
    int n1 = m - l + 1;
    int n2 =  r - m;
 
    /* create temp arrays */
    int L[n1], R[n2];
 
    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1+ j];
 
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray
    j = 0; // Initial index of second subarray
    k = l; // Initial index of merged subarray
    while (i < n1 && j < n2)
    {
        if (L[i] <= R[j])
        {
            arr[k] = L[i];
            i++;
        }
        else
        {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
 
    /* Copy the remaining elements of L[], if there
       are any */
    while (i < n1)
    {
        arr[k] = L[i];
        i++;
        k++;
    }
 
    /* Copy the remaining elements of R[], if there
       are any */
    while (j < n2)
    {
        arr[k] = R[j];
        j++;
        k++;
    }
}




int bsort(int *A,int N){

    for(int i= N-1 ;i>=0; i--){

        int pos = N-2;

        while(pos >= N-i-1){
            if(A[pos]>A[pos+1])
                swap(&A[pos],&A[pos+1]);

                pos--;
        }
    }
    return *A;
}


int main(){

    int n;
    cout << "Enter Array Length \n";
    cin >> n;
    int a[n];

    for(int i = 0;i<n;i++){
        cin >> a[i];
    }
    
   mergeSort(a,0,n-1);

    for(int i = 0;i<n;i++){
       cout <<  a[i] << "  ";
    }
    
   

return 0;
}
