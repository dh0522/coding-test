package SamsungSWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_17144 {
	static int[][] room ;
	static List<int[]> list = new ArrayList<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		room = new int[r][c];

		for( int i = 0 ; i < r; i++ ){
			st = new StringTokenizer(br.readLine());
			for( int j = 0; j < c ; j++ ){
				room[i][j] = Integer.parseInt(st.nextToken());
				if( room[i][j] == -1  )
					list.add( new int[]{i,j});
			}
		}

		for( int i = 0; i< t; i++ ){
			spread();
			airclean();
		}
		int answer = 0;
		for( int i = 0; i < r ; i++){
			for( int j = 0 ; j < c ; j++ ){
				if( room[i][j] > 0 )
					answer += room[i][j];
			}
		}
		System.out.println(answer);
	}
	public static void spread(){

		int[][] updateroom = new int[room.length][room[0].length];
		for(int i = 0 ; i < room.length;i ++ ){
			updateroom[i] = room[i].clone();
		}

		for( int i = 0; i< room.length; i++ ){
			for( int j = 0; j <room[0].length; j++ ){

				if( room[i][j] == 0 || room[i][j] == -1 )
					continue;

				int possiblenum = possible( i, j );
				int dust = room[i][j]/5;

				updateroom[i][j] -= possiblenum*dust;
				for( int d = 0; d < 4; d++ ){

					int nx = i + dx[d];
					int ny = j + dy[d];

					if( nx < 0 || ny < 0 || nx >= room.length || ny >= room[0].length )
						continue;

					if( room[nx][ny] == -1 )
						continue;
					updateroom[nx][ny] += dust;
				}
			}
		}
		room = updateroom;

	}
	public static void airclean(){

		int row = room.length -1;
		int column = room[0].length-1;

		// first 반시계 방향으로 원소 이동
		int x = list.get(0)[0];

		int temp = room[x][column];
		int temp2 = room[0][column];
		int temp3 = room[0][0];

		for( int i = column-1; i > 0 ; i-- ){
			room[x][i+1] = room[x][i];
		}
		room[x][1] = 0;

		for( int i = 0 ; i < x; i ++ ){
			room[i][column] = room[i+1][column];
		}
		room[x-1][column] = temp;

		for( int i =0; i< column ; i++ ){
			room[0][i] = room[0][i+1];
		}
		room[0][column-1] = temp2;

		for( int i = x-1; i>0 ; i-- ){
			room[i][0] = room[i-1][0];
		}
		room[1][0] = temp3;
		room[x][0] = -1;


		// second 시계 방향으로 원소 이동
		x = list.get(1)[0];

		temp = room[x][column];
		temp2 = room[row ][column];
		temp3 = room[row][0];

		for( int i = column-1; i > 0 ; i-- ){
			room[x][i+1] = room[x][i];
		}
		room[x][1] = 0;

		for( int i = row; i > x  ; i-- ){
			room[i][column] = room[i-1][column];
		}
		room[x+1][column] = temp;


		for( int i =0; i< column; i++ ){
			room[row][i] = room[row][i+1];
		}
		room[row][column-1] = temp2;

		for( int i = x;i < row; i++ ){
			room[i][0] = room[i+1][0];
		}

		room[row -1][0] = temp3;
		room[x][0] = -1;




	}




	public static int possible( int x , int y ){

		int num = 0;

		for( int i = 0; i< 4; i++ ){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if( nx < 0 || ny < 0 || nx >= room.length || ny >= room[0].length )
				continue;

			if( room[nx][ny] == -1 )
				continue;

			num ++;
		}
		return num;
	}
}
