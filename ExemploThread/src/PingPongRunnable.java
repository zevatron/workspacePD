
public class PingPongRunnable  implements Runnable{

	private String palavra;
	private int delay;
	
	
	
	public PingPongRunnable(String oQueFalar, int tempoDelay) {
		super();
		this.palavra = oQueFalar;
		this.delay = tempoDelay;
	}
	
	@Override
	public void run() {
		for(;;){
			System.out.println(palavra + " ");
			System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority());
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				System.err.println("Erro");
				return;
			}
		}
	}



	public static void main(String[] args) {

		PingPongRunnable ping = new  PingPongRunnable("ping",500);
		Thread t1 = new Thread(ping);
		t1.setPriority(1);
		t1.setName("ThreadPING");
		t1.start();
		PingPongRunnable pong = new PingPongRunnable("PONG", 1000);
		Thread t2 = new Thread(pong);
		t2.setPriority(9);
		t2.setName("ThreadPONG");
		t2.start();
	}

}
