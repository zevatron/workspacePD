package thread;


// 2-Escreva um programa que realize o cálculo das somas dos valores das linhas de uma matriz, de ordem 4, 
// de números inteiros e imprima o resultado na tela. 
// Faça com que o cálculo do somatório de cada linha seja realizado, em paralelo, por threads.
public class E2 implements Runnable {
	
	private int m[][] = {{1,2,3,4},{3,4,5,6},{5,6,7,8},{7,8,9,10}};
	private int somaTotal = 0;
	
	
	
	public static void main(String[] args) {
		
		E2 e2 = new E2();
		int somaTotal = 0;
		
		for (int i=0 ; i<4 ; i++){
			Thread t = new Thread(e2);
			t.setName(String.valueOf(i));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("A soma total é: " + somaTotal);
	}

	@Override
	public void run() {
		int soma =0;
		for (int i = 0 ; i<4 ; i++){
			soma += m[Integer.parseInt(Thread.currentThread().getName())][i];
		}
		System.out.println("Soma da linha " + Thread.currentThread().getName() + " é: " +soma);
		somaTotal += soma;
		
	}

}
