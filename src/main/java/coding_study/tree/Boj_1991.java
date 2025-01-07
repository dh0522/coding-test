package coding_study.tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Boj_1991 {
	public static void main(String[] args) throws Exception {

		String mom, son1, son2;
		StringTokenizer st;
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );


		String[][] tree = new String[n][2];
		for( int i =0; i < n; i++ ) {

			st = new StringTokenizer(br.readLine());

			mom = st.nextToken();
			son1 = st.nextToken();
			son2 = st.nextToken();

			int momIdx=  mom.charAt(0) -'A';
			tree[momIdx][0] = son1;
			tree[momIdx][1] = son2;

		}

		StringBuilder sb = new StringBuilder();
		preOrder( 0 , sb ,  tree );
		sb.append("\n");
		inOrder( 0, sb, tree );
		sb.append("\n");
		postOrder( 0, sb, tree );

		System.out.println( sb );
	}
	private static void preOrder( int idx , StringBuilder sb, String[][] tree ){
		sb.append((char)(idx+'A'));

		if( !tree[idx][0].equals(".") ){
			int nextIdx = tree[idx][0].charAt(0) - 'A';
			preOrder( nextIdx, sb, tree );
		}
		if( !tree[idx][1].equals(".") ){
			int nextIdx = tree[idx][1].charAt(0) - 'A';
			preOrder( nextIdx , sb , tree );
		}
	}


	private static void inOrder( int idx, StringBuilder sb, String[][] tree ){


		// 왼쪽 끝 노드까지 가는 것
		if( !tree[idx][0].equals(".") ){
			int nextIdx = tree[idx][0].charAt(0) - 'A';
			inOrder( nextIdx, sb, tree );
		}
		sb.append((char)(idx+'A'));

		if( !tree[idx][1].equals(".") ){
			int nextIdx = tree[idx][1].charAt(0) - 'A';
			inOrder( nextIdx, sb, tree );
		}
	}

	private static void postOrder( int idx , StringBuilder sb, String[][] tree ){

		if( !tree[idx][0].equals(".") ){
			int nextIdx = tree[idx][0].charAt(0) - 'A';
			postOrder( nextIdx, sb, tree );
		}

		if( !tree[idx][1].equals(".") ){
			int nextIdx = tree[idx][1].charAt(0) - 'A';
			postOrder( nextIdx, sb, tree );
		}
		sb.append( (char)(idx+'A') );
	}
}
