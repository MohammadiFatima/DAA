import java.util.*;
public class Nqueens {
    static int[]x= new int[100];
    static int count=0;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.printf("Please Enterthe number of queens to be placed: ");
        int n=sc.nextInt();
        nqueens(1,n);
        System.out.printf("\nTotal Number of Solutions for %d queens is %d",n,count);
      }
      public static void nqueens(int row, int n){
        for(int col=1;col<=n;col++){
            if(isSafe(row,col)){
                x[row]=col; //placing queen
                if(row==n){
                    printboard(n);

                }
                else{
                    nqueens(row+1,n);
                }
            }
        }
      }
      public static boolean isSafe(int row, int col){
        for(int j=1;j<=row-1;j++){//j=prev row
            if((x[j])==col||  (Math.abs(x[j]-col)== Math.abs(j-row))){
                return false;
            }
        }
        return true;
      }
      public static void printboard(int n){
        count++;
        System.out.println("solution"+count+":");
        System.out.print("  ");
        for(int col=1;col<=n; col++){
            System.out.print(col+" ");
        }
        System.out.println();
        for(int row=1;row<=n;row++){
            System.out.print(row+ " ");
            for(int col=1;col<=n;col++){
                if(x[row]==col){
                    System.out.print("Q ");
                }
                else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    }
