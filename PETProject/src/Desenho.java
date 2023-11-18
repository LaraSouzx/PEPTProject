import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

//ESTA CLASSE DEVE SE OBRIGATORIAMENTE MANTIDA NO PROJETO. QUALQUER ALTERA��O REALIZADA DEVE OBEDECER A HIERARQUIA.
public class Desenho {
	
	private int x;
	private int y;
	private BufferedImage img;
	private Rectangle retangle;
	
	public Desenho() {}
	
	public Desenho(int x, int y, String path) {
		this.setX(x);
		this.setY(y);
		
		File fileImg = new File(path);
		try {
			img = ImageIO.read(fileImg);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		retangle = new Rectangle(x, y, img.getWidth(), img.getHeight());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void updateXYRetangle() {
		this.retangle.x = x;
		this.retangle.y = y;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(String path) {
		File fileImg = new File(path);
		try {
			img = ImageIO.read(fileImg);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Rectangle getRetangle() {
		return retangle;
	}

	public void setRetangle(Rectangle retangle) {
		this.retangle = retangle;
	}
	public void salvar() {
		File file = new File("teste.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(this);
			oos.close();
			fos.close();
		}catch(FileNotFoundException e){
			System.out.println("ARQUIVO NÃO ENCONTRADO !");
		}catch(IOException e) {
			System.out.println("ERRO DE I/O !");
		}
	}
	public void desenhar(Graphics g) {
		//Desenhando a imagem na tela
		g.drawImage(this.getImg(), this.getX(), this.getY(), null);
	}
}
