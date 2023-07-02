//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int MOD=(int)(Math.pow(10,9))+7;
    public int f(int i,int target,int nums[],int dp[][]){
        if(target==0)return 1;
        if(i==0){
            if(nums[0]==target)return 1;
            else return 0;
        }
        if(dp[i][target]!=-1)return dp[i][target];
        int np=f(i-1,target,nums,dp)%MOD;
        int p=0;
        if(nums[i]<=target){
            p=f(i-1,target-nums[i],nums,dp)%MOD;
        }
        return dp[i][target]=(np+p)%MOD;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    Arrays.sort(arr);
	    int a[]=new int[n];
	    int c=0;
	    for(int i=n-1;i>=0;i--){
	        a[c++]=arr[i];
	    }
	    int dp[][]=new int[n][sum+1];
	    for(int i[]:dp){
	        Arrays.fill(i,-1);
	    }
	    return f(n-1,sum,a,dp);
	} 
}