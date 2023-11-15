package programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
public class Prg_17680 {
    public static void main(String[] args) {

        Prg_17680 sol = new Prg_17680();

        System.out.println(sol.solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));

        System.out.println(sol.solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo",
                "Seoul", "Jeju", "Pangyo", "Seoul"}));

        System.out.println(sol.solution(2,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork",
                "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));

        System.out.println(sol.solution(5,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork",
                "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));

        System.out.println(sol.solution(2,new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));

    }
    private int solution(int cacheSize, String[] cities ){

        int ans= 0;
        List<String> list = new ArrayList<>();
        for( int i =0; i< cities.length; i++ ){

            if( cacheSize == 0){
                ans = 5 * cities.length;
                break;
            }

            String city = cities[i].toLowerCase();

            if( list.size() < cacheSize ){
                if( list.contains(city) ){
                    list.remove(city);
                    list.add(city);
                    ans += 1;
                    continue;
                }else{
                    list.add( city );
                    ans+=5;
                    continue;
                }
            }else{
                if( list.contains(city) ){

                    list.remove(city);
                    list.add(city);
                    ans += 1;
                    continue;

                }else{
                    list.remove(0);
                    list.add(city);
                    ans+=5;
                    continue;
                }
            }
        }
        return ans;

    }
}

