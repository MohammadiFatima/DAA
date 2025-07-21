import java.util.*;

public class QuickSort{

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("PLease Enter the size of array");
    int n= sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Please Enter numbers to be sorted");
    for(int i=0;i<n;i++){
        arr[i]= sc.nextInt();
    }
    quickSort(arr,0,n-1);
    System.out.println("Your Sorted Array is:");
    for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
    }
}


public static void quickSort(int arr[], int low, int high){
    if(low<high){
        int pindex= partition(arr,low, high);
        quickSort(arr, low,pindex-1);
        quickSort(arr, pindex+1, high);
    }
}
public static int partition(int []arr,int low, int high){
    int pivot=arr[high];
    int i=low-1;
    for(int j=low; j<high; j++){
        if(arr[j]<pivot){
            i++;
            //swap, as in putting elements smaller than j before pvot
            int temp= arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    i++;
    int temp=arr[i];
    arr[i]= pivot;
    arr[high]= temp;
    return i;
}
}

