package programmers;

public class Prg_12971 {
    public static void main(String[] args) {
        Prg_12971 sol = new Prg_12971();

        int[] sticker = {1,3,2,5,4};

        System.out.println(sol.solution( sticker ));
    }
    public int solution( int[] sticker ) {
        int answer = 0;

        if(sticker.length == 1){
            return sticker[0];
        }else if(sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        }



        // 첫번째 원소 포함
        int[] dp = new int[sticker.length -1 ];

        dp[0] = sticker[0];
        dp[1] = sticker[0];

        for( int i = 2; i < sticker.length -1; i++ ){
            dp[i] = Math.max( dp[i-1] , dp[i-2] + sticker[i] );
        }

        // 마지막 원소 포함
        int[] lastdp = new int[sticker.length];

        lastdp[0] = 0;
        lastdp[1] = sticker[1];

        for( int i =2 ;i < sticker.length; i++ ){
            lastdp[i] = Math.max( lastdp[i-1], lastdp[i-2] + sticker[i] );
        }

        answer = Math.max( dp[dp.length-1], lastdp[lastdp.length -1] );

        return answer;
    }
}