package com.br.ZZEconcorrencia.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcorrenciaColocoesTest {
	public static void main(String[] args) {
		
		/*Essas classes quando alguma Thread alterar um valor em lista, elas aceitar�o,
		 * e elas n�o criam multiplas c�pias internas de uma cole��o*/
		//ConcurrentHasmap
		//ConcurrentLinkedDeque
		//ConcurrentLinkedQueue
		//ConcurrentSkipListMap
		//ConcurrentSkipListSet
		
		ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
		map.put("1", "3");
		map.putIfAbsent("1", "2");
		System.out.println(map.get("1"));
		
	}

}
