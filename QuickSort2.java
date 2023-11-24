
package quicksort2;

public class QuickSort2 {
   
    public static int partition(int arr[],int low,int high)
    {
        int pivot= arr[high];
        int i=low -1;
        for(int j=low;j<high;j++)
        {
            if(arr[j]>pivot)
            {
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                        
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
        
        return i;
       
    }
            
    public static void quicksort(int arr[],int low, int high)
    {
        if(low<high){
        int pivdx = partition(arr,low,high);
        quicksort(arr,low,pivdx-1);
        quicksort(arr,pivdx+1,high);
        }
    }
    public static void main(String[] args) {
        int arr[]= {300,4,5,1,7,9,8};
        int n= arr.length;
        
        quicksort(arr,0,n-1);
        
        for(int i=0;i<n;i++)
        {
            System.out.println(" "+arr[i]);
        }
        
        
             
      
    }
    
}
