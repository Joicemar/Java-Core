package com.br.ZZDthreads.classes;

public class ContaTest implements Runnable {

	private Conta conta = new Conta();

	public static void main(String[] args) {

		ContaTest contaTest = new ContaTest();
		Thread willian = new Thread(contaTest, "Willian");
		Thread anna = new Thread(contaTest, "Anna");
		willian.start();
		anna.start();
	}

	public static void imprime() {
		synchronized(ContaTest.class) {
			System.out.println("Classe literal. Métodos estaticos pertencem a classe; toda vez que sincrinizar um"
					+ "desses métodos estará sincronizando a classe junta");
		}
	}
	
	private void saque(double valor) {
		synchronized (conta) { //Bloco sincronizado
			if (conta.getSaldo() >= valor) {
				System.out.println(Thread.currentThread().getName() + " está indo sacar");
				conta.saque(10);
				System.out.println(Thread.currentThread().getName() + " completou o saque, saldo: " + conta.getSaldo());
			} else {
				System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque, saldo: "
						+ conta.getSaldo());
			}
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			saque(10);
		}
	}

}
