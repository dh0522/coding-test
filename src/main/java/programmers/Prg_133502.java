package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Prg_133502 {
    public static void main(String[] args) {

        Prg_133502 sol = new Prg_133502();
        System.out.println(sol.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(sol.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
        System.out.println(sol.solution(new int[]{ 1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1 }));
    }
    private int solution( int[] ingredient ){
        // 1=빵 . 2 = 야채 , 3 = 고기 ..   ===>  1 2 3 1 순서로 저장
        int ans = 0;
        Stack<Integer> burger = new Stack<>();
        for( int i = 0; i< ingredient.length;  i++ ){


            if( burger.size() >= 3 && ingredient[i] == 1){


                int three = burger.pop();
                int two = burger.pop();
                int one = burger.pop();

                if( three == 3 && two == 2 && one == 1){
                    ans++;
                    continue;
                }
                else{
                    burger.add(one);
                    burger.add(two);
                    burger.add(three);
                    burger.add(ingredient[i]);
                }
            }else{
                burger.add(ingredient[i]);

            }
        }
        return ans;
    }
}