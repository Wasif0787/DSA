import java.util.*;

public class stack {
    public static int trappedWater(int [] arr){
        int n= arr.length;
        int tw=0;
        int ngl[]=new int[arr.length];
        int ngr[]=new int[n];

        //LeftMost
        Stack<Integer> s = new Stack<>();
        for (int i =0; i<n; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ngl[i] = arr[i];
                s.push(i);
            } else {
                ngl[i] = arr[s.peek()];
            }
            
        }
        for(int i=0;i<n;i++){
            System.out.print(ngl[i]+" ");
        }
        System.out.println();

        //RightMost
        s = new Stack<>();
        for (int i =n-1; i>=0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ngr[i] = arr[i];
            } else {
                ngr[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.print(ngr[i]+" ");
        }
        System.out.println();
        
        for(int i=0;i<n;i++){
            int wl=Math.min(ngl[i],ngr[i]);
            tw+=wl-arr[i];
        }
        return tw;
    }
    public static void main(String[] args) {
        int heights[]={4,2,0,6,3,2,5};
        System.out.println(trappedWater(heights));
    }
}
