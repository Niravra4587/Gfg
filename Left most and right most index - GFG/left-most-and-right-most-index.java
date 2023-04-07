//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        
        int s=0,e=v.length-1;
        int lind=-1,rind=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if((mid==0||v[mid]!=v[mid-1])&&x==v[mid]){
                    lind=mid;
                    break;
                }
                
            else if(v[mid]<x){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
    }
    s=0;e=v.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if((mid==v.length-1||v[mid]!=v[mid+1])&&v[mid]==x){
                    rind=(mid);
                    break;
                }
                
            else if(v[mid]>x){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
    }
    pair p=new pair(lind,rind);
    return p;
    
    }
}