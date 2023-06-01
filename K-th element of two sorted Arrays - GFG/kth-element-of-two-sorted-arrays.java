//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        int l=Math.max(0,k-m),h=Math.min(n,k);
        while(l<=h){
            int c1=(l+h)/2;
            int c2=(k-c1);
            int l1=c1==0?Integer.MIN_VALUE:arr1[c1-1];
            int l2=c2==0?Integer.MIN_VALUE:arr2[c2-1];
            int r1=c1==n?Integer.MAX_VALUE:arr1[c1];
            int r2=c2==m?Integer.MAX_VALUE:arr2[c2];
            if(l1<=r2&&l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                h=c1-1;
            }
            else{
                l=c1+1;
            }
            
    }
    return -1;
    }
}