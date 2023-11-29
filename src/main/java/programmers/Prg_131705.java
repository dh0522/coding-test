package programmers;

public class Prg_131705 {
    public static void main(String[] args) {

        Prg_131705 sol = new Prg_131705();

        System.out.println(sol.solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(sol.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(sol.solution(new int[]{-1, 1, -1, 1}));
    }
    private int solution(int[] number){
        int answer = 0;

        for( int i = 0; i< number.length; i++ ){
            for( int j = i+1 ;j < number.length; j++ ) {
                for (int t = j + 1; t < number.length; t++) {

                    if (number[i] + number[j] + number[t] == 0)
                        answer++;

                }
            }
        }

        return answer;
    }
}
