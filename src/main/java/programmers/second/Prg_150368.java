package programmers.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prg_150368 {
	public static void main(String[] args) {
		Prg_150368 sol = new Prg_150368();

		System.out.println(Arrays.toString( sol.solution( new int[][]{{ 40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900 }}, new int[]{ 1300, 1500, 1600, 4900 })));
	}
	private static int[][] user;
	private static int[] emoticon;
	static List<Ticket> list = new ArrayList<>();
	private static int[] solution( int[][] users, int[] emoticons){

		user = new int[users.length][users[0].length];
		for(int i = 0; i< users.length; i++)
			user[i] = users[i].clone();


		emoticon = emoticons.clone();

		for(int i = 0; i < 4; i++){
			int[] each = new int[emoticons.length];
			// 1. dfs = 각 이모티콘마다 할인율 부여
			dfs( 0 , i, each);
		}


		Collections.sort(list);
		return new int[]{list.get(0).plus, list.get(0).price};
	}


	private static void dfs(int depth, int salesIdx, int[] eachSales){
		if(depth == eachSales.length ){
			search(eachSales);
			return;
		}

		for(int i = salesIdx; i < 4; i++){
			eachSales[depth] = i;
			dfs(depth+1, salesIdx, eachSales);
		}
	}

	private static void search(int[] eachSales){

		int[] sales = {10,20,30,40};

		Ticket ticket = new Ticket(0,0);

		for(int i = 0; i < user.length; i++){
			int percent = user[i][0];
			int price = user[i][1];

			int sum = 0;

			for( int j = 0; j < emoticon.length; j++){

				int emoticonSale = sales[ eachSales[j]] ;
				if( percent <= emoticonSale){
					sum += (int) (emoticon[j]*(100-emoticonSale)/100);
				}
				// System.out.println(percent+" "+emoticonSale);
			}

			if(sum >= price)
				ticket.plus++;
			else
				ticket.price += sum;


		}

		list.add(ticket);


	}

}

class Ticket implements Comparable<Ticket> {
	int plus;
	int price;

	public Ticket(int plus, int price){
		this.plus = plus;
		this.price = price;
	}

	@Override
	public int compareTo(Ticket t1){
		if(this.plus == t1.plus)
			return t1.price - this.price;

		return t1.plus - this.plus;
	}
}
