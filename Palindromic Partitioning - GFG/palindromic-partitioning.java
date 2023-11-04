//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static public boolean ispalin(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
    static public int f(String s,int i,int dp[]){
        if(i==s.length())return 0;
        if(dp[i]!=-1)return dp[i];
        int c=Integer.MAX_VALUE;;
        for(int j=i;j<s.length();j++){
            if(ispalin(s,i,j)){
                int cut=1+f(s,j+1,dp);
                c=Math.min(c,cut);
                
            }
        }
        return dp[i]=c;
    }
    static int palindromicPartition(String str)
    {
        int dp[]=new int[str.length()];
        Arrays.fill(dp,-1);
        return f(str,0,dp)-1;
    }
}