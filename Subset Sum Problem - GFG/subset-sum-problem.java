//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    public static boolean f(int i,int target,int dp[][],int arr[]){
        if(target==0)return true;
        if(i==0)return arr[0]==target;
        if(dp[i][target]!=-1)return dp[i][target]==1?true:false;
        boolean np=f(i-1,target,dp,arr);boolean p=false;
        if(arr[i]<=target){
            p=f(i-1,target-arr[i],dp,arr);
        }
        boolean ans=p||np;
        dp[i][target]=(ans)==true?1:0;
        return ans;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int dp[][]=new int[N][sum+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        boolean ans=f(N-1,sum,dp,arr);
        //Boolean b=new Boolean(ans);
        return ans;
        
    }
}