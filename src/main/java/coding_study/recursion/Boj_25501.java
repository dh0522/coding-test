package coding_study.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_25501 {
	static boolean check;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		while(t-- > 0){
			check = true;
			String original = br.readLine();

			int num = isPalindrome( original, 0, original.length()-1, 1 );
			if (check){
				answer.append(1).append(" ").append(num).append("\n");
			}else{
				answer.append(0).append(" ").append(num).append("\n");
			}
		}

		System.out.println(answer);
	}
	private static int isPalindrome(String ori, int i, int j, int depth){

		if( i >= j )
			return depth;

		else if(ori.charAt(i) != ori.charAt(j) ){
			check = false;
			return depth;
		}
		else{
			return isPalindrome(ori, i+1, j-1, depth+1);
		}

	}

}
