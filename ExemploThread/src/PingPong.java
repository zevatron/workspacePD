
public class PingPong extends Thread{

	private String palavra;
	private int delay;
	
	
	
	public PingPong(String oQueFalar, int tempoDelay) {
		super();
		this.palavra = oQueFalar;
		this.delay = tempoDelay;
	}
	
	@Override
	public void run() {
		for(;;){
			System.out.println(palavra + " ");
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				System.err.println("Erro");
				return;
			}
		}
	}



	public static void main(String[] args) {

		PingPong ping = new  PingPong("ping",500);
		ping.start();
		PingPong pong = new PingPong("PONG", 1000);
		pong.start();
		
	}

}
