#include<bits/stdc++.h>

#define newl "\n"
#define MODULO 1000000007

using namespace std;

int size=0, maxsize=20;
int heap[20];

void insert_maxheap(int x){
	if(size+1>=maxsize)
		cout <<  "heap is full";
	else{
		int i;
		size++;
		for( i = size;  i>1 && x > heap[i/2]; i/=2)
			heap[i] = heap[i/2];
		heap[i] = x;
	}
}

void delete_maxheap(){
	if(size==0)
		cout << "Empty heap";
	else{
		int i, last = heap[size];
		heap[1] = heap[size];
		size--;
		for(i=2; i<=size; i*=2){
			if(heap[i+1] > heap[i])
				i++;
			if(heap[i/2] <= heap[i])
				heap[i/2] =  heap[i];
			else
				heap[i/2] = last;
		}
				
	}
}


void printHeap(){
	for(int i =1; i<=size; i++)
		cout << heap[i] << " ";
	cout << newl;
}

void swap(int *a, int *b){
	*a = *a + *b;
	*b = *a - *b;
	*a = *a - *b;
}

void heapify(int arr[], int n, int i)
{
    int largest = i;  // Initialize largest as root
    int l = 2*i + 1;  // left = 2*i + 1
    int r = 2*i + 2;  // right = 2*i + 2
 
    // If left child is larger than root
    if (l < n && arr[l] > arr[largest])
        largest = l;
 
    // If right child is larger than largest so far
    if (r < n && arr[r] > arr[largest])
        largest = r;
 
    // If largest is not root
    if (largest != i)
    {
        swap(arr[i], arr[largest]);
 
        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest);
    }
}

// main function to do heap sort
void heapSort(int arr[], int n)
{
    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
 
    // One by one extract an element from heap
    for (int i=n-1; i>=0; i--)
    {
        // Move current root to end
        swap(arr[0], arr[i]);
 
        // call max heapify on the reduced heap
        heapify(arr, i, 0);
    }
}






int main(){
	std::ios::sync_with_stdio(false);
	
	insert_maxheap(10);
	insert_maxheap(12);
	insert_maxheap(9);
	insert_maxheap(14);
	insert_maxheap(125);
	insert_maxheap(3);
	insert_maxheap(27);
	insert_maxheap(18);
	
	printHeap();
	
	delete_maxheap();
		
	printHeap();	
		
	delete_maxheap();
	
	printHeap();	
	int R[6] = {0,3,7,99,12,1209102};
	heapSort(R, 6);
	for(int i =0; i < 6;  i++)
		cout <<  R[i] << " ";
	cout <<  newl;
	printHeap();

return 0;
}
