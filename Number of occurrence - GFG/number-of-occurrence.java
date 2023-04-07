//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] v, int n, int x) {
        // code here
        int s=0,e=n-1;
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
    s=0;e=n-1;
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
    if(rind==-1&&lind==-1)return 0;
    return (rind-lind+1);
        
    }
}