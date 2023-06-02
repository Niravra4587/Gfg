//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 

{
    public static boolean valid(int []A,int k,int M){
        int p=0,b=0;
        for(int i=0;i<A.length;i++){
            
            if(p+A[i]>k){
                b++;
                p=A[i];
                if(p>k)return false;
            }
            else{
                p+=A[i];
            }
            
        }
        if(b<M)return true;
        return false;
    }
    public static int findPages(int[]A,int N,int M)
    {
        if(M>N)return -1;
        int min=A[0],s=0;
        for(int i:A){
            min=Math.min(i,min);
            s+=i;
        }
        int l=min,h=s,ans=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(valid(A,mid,M)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
};