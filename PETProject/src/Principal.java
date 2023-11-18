import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Principal extends JFrame implements MouseListener, KeyListener  {

	private Lua lua;
	
	private Estrela estrela;
	
	private Sol sol;
	
	private Nave nave;

	public Principal() {
		File file = new File ("D:\\Lara S.Montenegro\\Documents\\teste.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Estrela lido = (Estrela) ois.readObject();
			ois.close();
			fis.close();
		}catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}catch (IOException e) {
			System.out.println("Erro de I/O!");
		}catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
		}
		
		
		lua = new Lua(500,200,"lua.png");
		
		estrela = new Estrela(500, 100, "estrela.png");
		
		sol = new Sol(450, 0, "sol.png");
		
		nave = new Nave(0, 300, "nave.png");
//		
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
	    try{
	    	renderizarImagens(g2);
	    }catch(naveException e){
	    	nave.desenhar(g2);
	    }
	    
	     
	    //Liberando os contextos criados.
	    g.dispose(); 
	    g2.dispose();
	}
	
	//ESSE E O METODO QUE DEVE SER ADAPTADO AO PROJETO
	
		
	public void renderizarImagens(Graphics g2) throws naveException{
		lua.desenhar(g2);
		
		estrela.desenhar(g2);
		
		if(lua.getRetangle().intersects(estrela.getRetangle())) {
			lua.setY(900);
			estrela.setY(900);
			sol.desenhar(g2);
		}
		if(sol.getY() == 90) {
			throw new naveException();
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
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			estrela.salvar();
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