package programmers;

public class Prg_131128 {
    public static void main(String[] args) {

        Prg_131128 sol = new Prg_131128();

        System.out.println(sol.solution("100","2345"));
        System.out.println(sol.solution("100","203045"));
        System.out.println(sol.solution("100","123450"));
        System.out.println(sol.solution("12321","42531"	));
        System.out.println(sol.solution("5525","1255"));

    }
    private String solution(String X , String Y ){

        int[] xarr = new int[10];
        int[] yarr = new int[10];

        for(int i = 0 ; i < X.length(); i++ ){
            int x = Integer.parseInt(X.substring(i,i+1));
            xarr[x]++;
        }

        for(int i = 0 ; i < Y.length(); i++ ){
            int y = Integer.parseInt(Y.substring(i,i+1));
            yarr[y]++;
        }

        StringBuilder sb = new StringBuilder();

        for( int i = 9 ; i>= 0 ; i-- ){

            int x = xarr[i];
            int y = yarr[i];

            if( x == 0 || y == 0 )
                continue;

            int num = Math.min(x,y);

            for( int j = 0; j< num ;j ++ ){
                sb.append(i);
            }


        }
        String answer = sb.toString();

        if(answer.length() == 0 )
            return "-1";
        if( answer.replace("0","") == "" )
            return "0";


        return answer;
    }
}