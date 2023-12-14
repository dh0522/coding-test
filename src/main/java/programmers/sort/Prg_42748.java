package programmers.sort;

import java.util.*;

public class Prg_42748 {
    public static void main(String[] args) {

        Prg_42748 sol = new Prg_42748();

        int[] ans1 = sol.solution( new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2,5,3},{4,4,1},{1,7,3} });
        for( int i : ans1)
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] solution(int[] array, int[][] commands ){
        int[] answer = new int[commands.length];

        List<Integer> list = new ArrayList<>();
        for( int i : array )
            list.add(i);

        for( int i = 0 ; i< commands.length; i++ ){

            List<Integer> temp = new ArrayList<>(list.subList(commands[i][0]-1,commands[i][1]));
            Collections.sort(temp);
            answer[i] = temp.get( commands[i][2] - 1 );

        }

        return answer;
    }
}
