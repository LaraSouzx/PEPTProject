public class Estrela extends DesenhoAnimado {
	
	private Thread t = new Thread(this);
	
	public Estrela(int x, int y, String path) {
		super(x, y, path);
		t.start();
	}
	@Override
	public void run() {
		
		while(this.getY() < 100) {
			this.setY(this.getY() - 10);
			this.setY(this.getY() + 10);
		}
		try {
			t.sleep(500);
		}
		catch(InterruptedException e) {
         e.printStackTrace();
		}
	}
}
