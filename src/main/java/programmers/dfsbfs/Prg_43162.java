package programmers.dfsbfs;
import java.util.LinkedList;
import java.util.Queue;
public class Prg_43162 {
    public static void main(String[] args) {

        Prg_43162 sol = new Prg_43162();

        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1} };
        System.out.println(sol.solution(n,computers));

    }
    private int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for( int i = 0; i < n ; i++ ){
            if( !visited[i] ){

                dfs( computers, visited , i );
                answer++;

            }
        }

        return answer;
    }
    private void dfs( int[][] computers , boolean[] visited , int num ){

        visited[num] = true;

        for( int i =0; i < computers.length; i++ ){

            if( computers[num][i] == 1 && !visited[i] ){
                dfs(computers,visited, i);
            }

        }

    }
}