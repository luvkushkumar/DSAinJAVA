public class MergeSort {
    public static void mergeSort(int arr[])
    {
        if(arr.length <= 1)return;
        int temp[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }
    public static void mergeSort(int arr[],int low,int high,int temp[])
    {
        if(low >= high)return;
        
        int mid = low+(high-low)/2;
        mergeSort(arr, low, mid, temp);
        mergeSort(arr, mid+1, high, temp); 

        merge(arr,low,mid,high,temp);
    }
    public static void merge(int arr[],int low,int mid,int high,int []temp)
    {
       int left = low;
       int right = mid+1;
        int i=low;
       while(left <= mid && right <=high)
       {
            if(arr[left] <= arr[right])
            {
                temp[i++] = arr[left++];
            }
            else 
            {
                temp[i++] = arr[right++];
            }
       }

       while(left <= mid)temp[i++] = arr[left++];
       while(right <= high)temp[i++] = arr[right++];

       for(int j=low;j<=high;j++)
       { 
             arr[j] = temp[j];
       }

    }
  public static void main(String[] args) {
    int arr[] = {3,7,4,5,2,0};
    int n = arr.length;
    mergeSort(arr);

    for(int i=0;i<n;i++)System.out.print(arr[i]+" ");
  }  
}
