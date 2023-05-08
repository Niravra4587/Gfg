//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int i=0,j=0,ans=-1;
        while(j<s.length()){
            if(hm.containsKey(s.charAt(j))){
                hm.put(s.charAt(j),hm.get(s.charAt(j))+1);
            }
            else{
                hm.put(s.charAt(j),1);
            }
            if(hm.size()<k){
                j++;
            }
            else if(hm.size()==k){
                ans=Math.max(ans,(j-i+1));
                j++;
            }
            else{
                while(hm.size()>k){
                    hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                    if(hm.get(s.charAt(i))==0){
                        hm.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
            
        }
        return ans;
    }
}