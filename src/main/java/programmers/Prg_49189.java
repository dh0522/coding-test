package programmers;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prg_49189 {
    public static void main(String[] args) {
        Prg_49189 sol = new Prg_49189();

        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(sol.solution(6, vertex));

    }
    private int solution( int n , int[][] edge ) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for( int i = 0; i<= n; i++ )
            graph.add( new ArrayList<>() );

        for( int i  =0 ;i < edge.length; i++ ){

            int x = edge[i][0];
            int y = edge[i][1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int answer = bfs( graph, n );
        return answer;
    }
    private int bfs( ArrayList<ArrayList<Integer>> graph, int n){

        boolean[] visited = new boolean[n+1];
        int[] depth = new int[n+1];
        int max = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        depth[1] = 1;

        while( !q.isEmpty() ){
            int now = q.poll();

            for( int i = 0; i< graph.get(now).size(); i++ ){

                int next = graph.get(now).get(i);

                if( visited[next] )
                    continue;

                q.add(next);
                depth[next] = depth[now] + 1;
                visited[next] = true;
                max = Math.max( max , depth[next] );
            }
        }

        int count = 0;

        for( int tmp : depth ){
            if (tmp == max)
                count++;
        }

        return count;
    }
}














