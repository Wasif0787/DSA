import java.util.*;

public class stack {
    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int next[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                next[i] = -1;
            } else { 
                next[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<next.length;i++){
            System.out.print(next[i]+" ");
        }
    }
}
