// you can also use imports, for example:
// import java.util.*;
import java.util.Set;
import java.util.HashSet;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {

        if(A.length == 2){
            return absolute(A[0]-A[1]);
        }

        Set<Integer> absoluteDifference = new HashSet<Integer>();
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i<A.length-1; ++i){

            if(i == 0){

                for(int j = 0; j <= i; ++j){
                    sum1 += A[j];
                }


                for(int k = i+1; k<A.length; ++k){
                    sum2 += A[k];
                }
            } else {
                sum1 += A[i];
                sum2 -= A[i];
            }

            int condition = absolute(sum1-sum2);

            if(!absoluteDifference.contains(condition)){
                absoluteDifference.add(condition);
            } else {
                continue;
            }
        }

        return smallestNumber(absoluteDifference);
    }

    public static int absolute(int a){

        if(a >= 0){
            return a;
        } else {
            return (-1)*a;
        }

    }

    public static int smallestNumber(Set<Integer> A){
        int smallest = 1001;
        for(int a:A){
            if(a<smallest)
                smallest = a;

        }

        return smallest;

    }
}
