import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class Principal extends JFrame implements MouseListener, KeyListener  {

	private Lua lua;
	//private Lua lua2;
	private Estrela estrela;
	//private Estrela estrela2;
	private Sol sol;
	//private Sol sol2;
	
	public Principal() {
		lua = new Lua(450,150,"lua.png");
		//lua2 = new Lua(450, 150, "lua.png");
		estrela = new Estrela(550, 100, "estrela.png");
		//estrela2 = new Estrela(550, 100, "estrela.png");
		sol = new Sol(300, 90, "sol.png");
//		sol2 = new Sol(300, 90, "sol.png");
		this.setSize(1000, 700);
		this.createBufferStrategy(1);		
		this.setVisible(true);
		this.createBufferStrategy(2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.addKeyListener(this);
	}
	
	public static void main(String [] args) {
		Principal app = new Principal();
	}

	//EVITAR ALTERAR ESSE METODO
	public void renderizarGraphics() {
		if (!getBufferStrategy().contentsLost()) getBufferStrategy().show();
	    Graphics g = getBufferStrategy().getDrawGraphics();
	     
	    //Criando um contexto grafico
	    Graphics g2 = g.create();
	    //Limpando a tela
	    g2.setColor(Color.WHITE);        
	    g2.fillRect(0, 0, getWidth(), getHeight());
	    renderizarImagens(g2);
	     
	    //Liberando os contextos criados.
	    g.dispose(); 
	    g2.dispose();
	}
	
	//ESSE E O METODO QUE DEVE SER ADAPTADO AO PROJETO
	public void renderizarImagens(Graphics g2) {
		//Desenhando as imagens
		lua.desenhar(g2);
		//lua2.desenhar(g2);
		//estrela.run();
		estrela.desenhar(g2);
		//estrela2.desenhar(g2);
		sol.desenhar(g2);
		//sol2.desenhar(g2);
		
		if(lua.getRetangle().intersects(estrela.getRetangle())) {
			lua.setY(900);
		}
		
	}
	
	//EVITAR ALTERAR ESSE M�TODO
	public void paint(Graphics g) {
		this.renderizarGraphics();
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			lua.moverDireita(10);
		}
		else
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			lua.moverEsquerda(10);
		}	
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			lua.moverCima(10);
		}	
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			lua.moverBaixo(10);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D) {
			lua.moverDiagonal(10);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Boa noite")	;
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}