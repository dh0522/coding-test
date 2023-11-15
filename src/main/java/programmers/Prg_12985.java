package programmers;

public class Prg_12985 {
    public static void main(String[] args) {

        Prg_12985 sol = new Prg_12985();
        System.out.println(sol.solution(8,4,7));

    }
    private int solution(int n, int a , int b){
        int ans = 1;
        int min = Math.min(a,b);
        int max = Math.max(a,b);


        while(true){

            if( min+1 == max && min%2 != 0){
                break;
            }

            min = min%2 == 0 ? min/2 : min/2 + 1;
            max = max%2 == 0 ? max/2 : max/2 + 1;

            ans++;
        }
        return ans;

    }
}
