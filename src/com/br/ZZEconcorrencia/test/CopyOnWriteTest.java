package com.br.ZZEconcorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteTest implements Runnable {
//	private List<Integer> list = Collections.synchronizedList(new ArrayList<>());
	/*O CopyOnWriteArrayList é recomendado usado se for para leitura, para muitas alterações ele não
	 * da uma boa performane pois a cada alteração ele cria uma nova lista*/
	private List<Integer> list = new CopyOnWriteArrayList<>();
	public CopyOnWriteTest() {
		for(int i = 0; i < 900; i++) {
			list.add(i);
		}
	}
	@Override
	public void run() {
		/*Por o Iterator ser imutável a Thread ainda terá a lista na memória mesmo que outra Thread
		 * tenha a removido antes, o Iterator manterá a referência. Não é recomentado adicionar ou remover com o Iterator*/
		Iterator<Integer> iterator = list.iterator();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		while(iterator.hasNext()) {
			System.out.println(Thread.currentThread().getName()+" "+iterator.next());
		}
	}

	public List<Integer> getList(){
		return list;
	}
	
	public static void main(String[] args) {
		CopyOnWriteTest ct = new CopyOnWriteTest();
		Thread t1 = new Thread(ct);
		Thread t2 = new Thread(ct);
		Thread t3 = new Thread(new RemoverMembros(ct.getList()));
		t1.start();
		t2.start();
		t3.start();
		
		
	}
	
	private static class RemoverMembros implements Runnable{
		private List<Integer> list;
		
		public RemoverMembros(List<Integer> list) {
			this.list = list;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 500; i++) {
				System.out.println(Thread.currentThread().getName()+" removeu "+list.remove(i));
			}
			
		}
		
	}
	
}






