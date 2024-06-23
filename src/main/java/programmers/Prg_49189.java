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
    static boolean[] visited;
    static int[] depth;
    private int solution(int n, int[][] edge) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        visited = new boolean[n+1];
        depth = new int[n+1];
        for( int i =0 ; i<=n ; i++ )
            graph.add(new ArrayList<>());

        for( int i =0; i< edge.length; i++ ){
            int x = edge[i][0];
            int y = edge[i][1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int answer = bfs(1 , graph );

        return answer;
    }
    private static int bfs( int start , ArrayList<ArrayList<Integer>> graph ){

        Queue<Integer> q = new LinkedList<>();

        q.add( start );
        visited[ start ] = true;
        depth[1] = 1;

        int max = 0;
        int answer =0;

        while( !q.isEmpty() ){

            int now = q.poll();

            for( int i =0 ;i < graph.get(now).size(); i++ ){

                int next = graph.get(now).get(i);

                if( visited[next] )
                    continue;

                visited[next] = true;


                depth[next] = depth[now] +1;
                max = Math.max( depth[next] , max );
                q.add( next );

            }
        }

        for( int count : depth ){

            if(count == max )
                answer++;
        }

        return answer;
    }
}












