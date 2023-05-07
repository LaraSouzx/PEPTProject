//ESTA CLASSE DEVE SE OBRIGATORIAMENTE MANTIDA NO PROJETO. QUALQUER ALTERACAO REALIZADA
//DEVE OBEDECER A HIERARQUIA. ELA DEVE SER UTILIZADA NA HERANCA DE DESENHOS QUE POSSAM
//SER MOVIMENTADOS PELO USUARIO 
public class DesenhoMovel extends Desenho {
	
	public DesenhoMovel() {}
	
	public DesenhoMovel(int x, int y, String path) {
		super(x, y, path);
	}
	
	
	public void moverCima(int shift) {
		this.setY(this.getY() - shift);
		this.updateXYRetangle();
	}
	
	public void moverBaixo(int shift) {
		this.setY(this.getY() + shift);
		this.updateXYRetangle();
	}
	
	public void moverDiagonal(int shift) {
		this.setY(this.getY() + shift);
		this.setX(this.getX() + shift);
		this.updateXYRetangle();
	}
	public void moverDireita(int shift) {
		this.setX(this.getX() + shift);
		this.updateXYRetangle();
	}
	
	public void moverEsquerda(int shift) {
		this.setX(this.getX() - shift);
		this.updateXYRetangle();
	}
}