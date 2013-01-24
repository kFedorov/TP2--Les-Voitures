import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class FeuCirculation extends JPanel {

  private Image feuCirc;
	private Color feu=Color.red;
	private Color rOff=Color.red.darker(), vOff=Color.green.darker(), jOff=Color.yellow.darker();
	private double factX;
	private int alY=(int)(factX*85);
	private boolean drawFeu = false;


	/**
	 * Create the panel.
	 */
	public FeuCirculation() {
		setOpaque(false);
		setPreferredSize(new Dimension(300, 300));
		URL fichierFeu= getClass().getClassLoader().getResource("feuCirculation.gif");
		try {
			feuCirc=ImageIO.read(fichierFeu);
		}
		catch(IOException e){
			System.out.println("Erreur");
		}


	}

	@Override
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(feuCirc, 0, 0, getWidth(), getHeight(), null);

		g2d.setColor(rOff);
		g2d.fillOval((int) (factX*128),(int) (factX* 85),(int) (factX* 38), (int) (factX*38));

		g2d.setColor(jOff);
		g2d.fillOval((int) (factX*128), (int) (factX* 133),(int) (factX* 38),(int) (factX* 38));

		g2d.setColor(vOff);
		g2d.fillOval((int) (factX*128), (int) (factX*182), (int) (factX*38), (int) (factX*38));

		if(drawFeu){
			feu=feu.brighter();
			feu=feu.brighter();
			g2d.setColor(feu);
			g2d.fillOval((int)(factX*128), alY, 38, 38);
		}



	}

	@Override
	public void setBounds(int x, int y, int width, int height){
		if (width>height){
		super.setBounds(x,y,width,width);
		}else{
			super.setBounds(x,y,height,height);
		}
		factX=(double)(width)/300;
	}


	public Color getFeu() {
		return feu;
	}

	public void setFeu(Feu couleur) {
		switch(couleur){
		case Vert: alY= (int)(factX*182); feu=Color.green; drawFeu=true;
		break;
		case Jaune: alY=(int)(factX*133); feu=Color.yellow; drawFeu=true;
		break;
		case Rouge: alY=(int)(factX*85); feu=Color.red; drawFeu=true;
		break;
		case Aucune: drawFeu=false;
		break;
		}
		repaint();

	}




}
