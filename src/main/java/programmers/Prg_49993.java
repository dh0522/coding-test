package programmers;

public class Prg_49993 {
    public static void main(String[] args) {

        Prg_49993 sol = new Prg_49993();

        System.out.println(sol.solution( "CBD" , new String[] {  "BACDE", "CBADF", "AECB", "BDA"  } ));
    }
    private int solution( String skill , String[] skill_trees ){

        int answer = 0;

        for( String skilltree : skill_trees ){

            int skillidx = 0;
            boolean isAble = true;

            for( char curskill : skilltree.toCharArray() ){

                int nowindex = skill.indexOf( curskill );

                if( nowindex == -1 )
                    continue;
                else if( nowindex == skillidx )
                    skillidx++;
                else{

                    isAble = false;
                    break;
                }

            }
            if( isAble )
                answer++;

        }

        return answer;
    }
}
