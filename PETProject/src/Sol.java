public class Sol extends DesenhoAnimado{
	
	private Thread t = new Thread(this);
	
	public Sol() {
		
	}
	
	public Sol(int x, int y, String path) {
		super(x, y, path);
		t.start();
	}

	@Override
	public void run() {
		while(this.getY() < 90) {
			this.setY(getY() + 3);
			try {
				t.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
