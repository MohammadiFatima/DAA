import java.util.*;
public class MergeSort {
    static int n;
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("PLease Enter the size of array");
    n= sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Please Enter numbers to be sorted");
    for(int i=0;i<n;i++){
        arr[i]= sc.nextInt();
    }
    mergeSort(arr,0,n-1);
    System.out.println("Your Sorted Array is:");
    for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
    }
}

public static void mergeSort(int arr[], int low, int high){
    if(low<high){
        int mid=(low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }
}
  public static void merge(int arr[],int low, int mid, int high) {
    int[] b= new int[n];
    int k=low; int i=low; int j=mid+1;
    while(i<=mid && j<=high){
        if(arr[i]<arr[j]){
            b[k]=arr[i];
            i++;
        }
        else{
            b[k]=arr[j];
            j++;
        }
        k++;
    }
    while(i<=mid){
        b[k]=arr[i];
        k++;
        i++;
    }
    while(j<=high){
        b[k]=arr[j];
        k++;
        j++;
    }
    for(int m=low;m<=high;m++){
        arr[m]=b[m];
    }
    
  }  
}
