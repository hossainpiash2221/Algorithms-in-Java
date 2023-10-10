
package mergesort;

public class MergeSort {

    public void merge(int arr[],int l, int mid, int r){
        int n1=mid-l+1;
        int n2=r-mid;
        
        int a[]=new int [n1];
        int b[]=new int [n2];
        
        for(int i=0;i<n1;i++)
        {
            a[i]=arr[l+i];
           
        }
        for(int i=0;i<n2;i++)
        {
            b[i]=arr[mid+1+i];
        }
        
        int i=0,j=0;
        int k=l;
        while(i<n1 && j<n2)
        {
            if(a[i]<b[j])
            {
                arr[k]=a[i++];
            }
            else{
                arr[k]=b[j++];
            }
            k++;
        }
        while(i<n1)
        {
            arr[k++]=a[i++];
        }
        while(j<n2)
        {
            arr[k++]=b[j++];
        }
    }
    public void sort(int arr[],int l, int r)
    {
        if(l<r){
            int mid =(l+r)/2;
            sort(arr,l,mid);
            sort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
    
    public static void main(String[] args) {
       int arr[]={3,2,1,4};
       MergeSort ob = new MergeSort();
       ob.sort(arr,0,arr.length-1);
       
       for(int i=0;i<arr.length;i++)
       {
           System.out.println(" "+arr[i]);
       }
    }
    
}
