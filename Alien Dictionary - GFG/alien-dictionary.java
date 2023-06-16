//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    Stack<Integer> st=new Stack<>();
    public void dfs(List<List<Integer>> ls,int i,int vis[]){
        vis[i]=1;
        for(int j=0;j<ls.get(i).size();j++){
            if(vis[ls.get(i).get(j)]!=1){
                dfs(ls,ls.get(i).get(j),vis);
            }
        }
        st.push(i);
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=0;i<K;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=1;i<dict.length;i++){
            for(int j=0;j<Math.min(dict[i].length(),dict[i-1].length());j++){
                if(dict[i-1].charAt(j)!=dict[i].charAt(j)){
                    ls.get(dict[i-1].charAt(j)-'a').add(dict[i].charAt(j)-'a');
                    break;
                }
            }
        }
        int vis[]=new int[K];
        Arrays.fill(vis,-1);
        for(int i=0;i<K;i++){
            if(vis[i]!=1){
                dfs(ls,i,vis);
            }
        }
        String s="";
        while(!st.isEmpty()){
            s+=(char)(st.pop()+'a');
        }
        
        return s;
    }
}