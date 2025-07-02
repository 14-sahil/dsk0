// C++ program for implementation of
// selection sort
#include <bits/stdc++.h>
using namespace std;

// Function for Selection sort
void selectionSort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n - 1; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[i])
            {
                swap(arr[j], arr[i]);
            }
        }
    }
}

void bubbleSort(int arr[], int n)
{
    
    // for (i = 0; i < n - 1; i++)
    // {
    //     for (j = 0; j < n - i - 1; j++)
    //     {
    //         if (arr[j] > arr[j + 1])
    //         {
    //             swap(arr[j], arr[j + 1]);
    //         }
    //     }
    // }

    for (int j = n-1; j > 0; j--)
    {
       int i = 0;
        while (i < j)
        {
            if (arr[i] > arr[i + 1])
            {
                swap(arr[i], arr[i + 1]);
                i++;
            }
            else
            {
                i++;
            }
        }
    }
}

void insertionSort(int arr[], int n)
{
    int i, j;
    for (i = 1; i < n; i++)
    {
        j = i;
        while (j > 0 && arr[j - 1] > arr[j])
        {
            swap(arr[j - 1], arr[j]);
            j--;
        }
    }
}

void max_heapify(int arr[], int n, int i)
{
    int largest = i;
    int left = 2 * i;
    int right = 2 * i + 1;
    if (left <= n && arr[largest] < arr[left])
    {
        largest = left;
    }
    if (right <= n && arr[largest] < arr[right])
    {
        largest = right;
    }
    if (largest != i)
    {
        swap(arr[largest], arr[i]);
        max_heapify(arr, n, largest);
    }
}

void heapsort(int arr[], int size)
{

    int r = size;

    while (r > 1)
    {
        swap(arr[r], arr[1]);
        r--;
        max_heapify(arr, r, 1);
    }
}

int partion(int arr[], int s, int e)
{

    int pivot = arr[s];
    int cnt = 0;
    for (int i = s + 1; i <= e; i++)
    {
        if (arr[i] <= pivot)
        {
            cnt++;
        }
    }
    int pivotindex = s + cnt;
    swap(arr[pivotindex], arr[s]);

    int i = s;
    int j = e;
    while (i < pivotindex && j > pivotindex)
    {
        while (arr[i] < pivot)
        {
            i++;
        }
        while (arr[j] > pivot)
        {
            j--;
        }
        if (i < pivotindex && j > pivotindex)
        {
            swap(arr[i], arr[j]);
            i++;
            j--;
        }
    }

    return pivotindex;
}
void quicksort(int arr[], int s, int e)
{
    if (s >= e)
        return;

    int p = partion(arr, s, e);

    // left part
    quicksort(arr, s, p - 1);

    // right part
    quicksort(arr, p + 1, e);
}

// Function to print an array
void printArray(int arr[], int size)
{

    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}

// Driver program

int main()
{
    // int arr[] = {-1, 8, 23, 11, 21, 73};
    int arr[] = {12,45,23,51,19,8};
    int n = sizeof(arr) / sizeof(arr[0]);\
    // int n = n1 - 1;

    // Function Call
    // selectionSort(arr, n);
    bubbleSort(arr, n);
    // insertionSort(arr, n);
    // heap
    // for (int i = n / 2; i > 0; i--)
    // {
    //     max_heapify(arr, n, i);
    // }

    // printArray(arr, n);
    // cout << endl;
    // heapsort(arr, n);

    // quick sort
    // quicksort(arr, 0, n - 1);

    printArray(arr, n);

    return 0;
}
