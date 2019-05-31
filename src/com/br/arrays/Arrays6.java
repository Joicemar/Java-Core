package com.br.arrays;


public class Arrays6 {
	public static void main(String[] args){
		int[] arrint = {1,2,3};
		int[] arrint2 = new int[3];
		int[] arrint3 = new int[] {1,2,3};
		
		int[][] dias = {{0,0},{1,2,3},{0,0,0,0}};
		
		// qual é o valor da posição [1][2] = 3;
		for(int[] arr : dias){
			for(int num: arr){
				System.out.println(num);
			}
		}
	}

}
