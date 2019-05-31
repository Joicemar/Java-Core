package com.br.arrays;

public class Arrays3 {
	public static void main(String[] args){
		// Três formas de criar um array em Java:
		int[] numeros = new int[5];
		int[] numeros2 = {1,2,3,4,5};
		int[] numeros3 = new int[]{1,2,3,4,5};
		
//		for (int i = 0; i<numeros2.length; i++){
//			System.out.println(i+1);
//		}	
		for(int aux: numeros2){
			System.out.println(aux);
		}
	}

}
