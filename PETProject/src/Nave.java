public class Nave extends DesenhoAnimado{
	
	private Thread t = new Thread(this);
	
	public Nave() {
		
	}
	
	public Nave(int x, int y, String path) {
		super(x, y, path);
		t.start();
	}

	@Override
	public void run() {
		while(this.getX() < 5000) {
			this.setX(getX() + 3);
			try {
				t.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
