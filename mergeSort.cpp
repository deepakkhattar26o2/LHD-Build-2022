#include<iostream>
using namespace std;
void merge(int arr[], int st, int mid, int en)
{
    int barr[en + 1];
    int i = st, j = mid + 1, k = st;
    while (i <= mid && j <= en)
    {
        if (arr[i] < arr[j])
        {
            barr[k] = arr[i];
            i++;
        }
        else
        {
            barr[k] = arr[j];
            j++;
        }
        k++;
    }
    if (i > mid)
    {
        while (j <= en)
        {
            barr[k] = arr[j];
            j++;
            k++;
        }
    }
    else
    {
        while (i <= mid)
        {
            barr[k] = arr[i];
            k++;
            i++;
        }
    }
    for(int x=st;x<=en;x++)
    {
        arr[x] = barr[x];
    }
}
void mergeSort(int arr[], int st, int en)
{
    if (st < en)
    {
        int mid = (st + en) / 2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, en);
        merge(arr, st, mid, en);
    }
}
int main()
{
    int N,x;
    cout<<"Enter Number of Elements: ";
    cin>>N;
    int arr[N];
    cout<<"Enter Elements: "<<endl;
    for(int i=0;i<N;i++)
    {
        cin>>arr[i];
    }
    mergeSort(arr, 0, N-1);
    cout<<"Elements Sorted Using MergeSort: "<<endl;
    for(int i=0;i<N;i++)
    {
        cout<<arr[i]<<" ";
    }
    cout<<endl;
    return 0;
}
