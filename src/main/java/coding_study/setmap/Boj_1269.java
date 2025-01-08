package coding_study.setmap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_1269 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int aSize = Integer.parseInt(st.nextToken());
		int bSize = Integer.parseInt(st.nextToken());

		int answer = aSize+bSize;
		Set<Integer> set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for( int i =0; i < aSize; i++ ){
			set.add( Integer.parseInt(st.nextToken()) );
		}

		st = new StringTokenizer(br.readLine());
		for( int i =0; i< bSize; i++ ){
			set.add( Integer.parseInt(st.nextToken()) );
		}

		int intersect = aSize + bSize - set.size();
		System.out.println( answer - intersect*2 );

		// Asize + Bsize - (A교B)



	}
}
