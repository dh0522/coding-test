package programmers;

public class Prg_161990 {
    public static void main(String[] args) {


        Prg_161990 sol = new Prg_161990();
        int[] ans = sol.solution(new String[]{".#...", "..#..", "...#."});
        for( int i : ans )
            System.out.print(i+" ");
        System.out.println();

        int[] ans2 = sol.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."});
        for( int i: ans2 )
            System.out.print(i+" ");
        System.out.println();

        int[] ans3 = sol.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
        for( int i: ans3 )
            System.out.print(i+" ");
        System.out.println();
    }
    private int[] solution( String[] wallpaper ){

        int sx =Integer.MAX_VALUE, sy = Integer.MAX_VALUE;
        int ex = Integer.MIN_VALUE, ey = Integer.MIN_VALUE;
        for( int i = 0; i< wallpaper.length; i++ ){
            String tmp = wallpaper[i];
            for( int j= 0; j< wallpaper[0].length();j++){
                if( tmp.charAt(j) == '#'){

                    if(sx > i ) sx = i;
                    if(sy > j ) sy = j;
                    if( ex < i ) ex = i;
                    if( ey < j) ey = j;
                }
            }
        }
        return new int[]{sx,sy,ex+1,ey+1};
    }
}
