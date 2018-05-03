package thread;

//1-Crie um programa que cria 10 threads cada uma escreve uma mensagem na tela contendo seu nome.

public class E1 extends Thread{

	@Override
	public void run() {
		System.out.println("Zévatron..." + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		for (int i=0 ; i<100; i++){
			E1 e = new E1();
			e.start();
		}
	}
	
}
