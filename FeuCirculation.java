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
	private double factX;
	private int alY;
	private boolean drawFeu = false;


	/**
	 * Create the panel.
	 */
	public FeuCirculation() {
		setOpaque(false);
		setPreferredSize(new Dimension(400, 400));
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
		factX=((double)getHeight()/400);

		g2d.setColor(Color.red.darker());
		g2d.fillOval((int) (factX*170),(int) (factX*113),(int) (factX*55), (int) (factX*55));

		g2d.setColor(Color.yellow.darker());
		g2d.fillOval((int) (factX*170), (int) (factX*178),(int) (factX*55),(int) (factX*55));

		g2d.setColor(Color.green.darker());
		g2d.fillOval((int)(factX*170), (int)(factX*242), (int)(factX*55), (int)(factX*55));

		if(drawFeu){
			feu=feu.brighter();
			feu=feu.brighter();
			g2d.setColor(feu);
			g2d.fillOval((int)(factX*(double)170), alY, (int)(factX*55),(int)(factX*55));
		}



	}

	@Override
	public void setBounds(int x, int y, int width, int height){
		if (width>height){
			super.setBounds(x,y,width,width);
		}else{
			super.setBounds(x,y,height,height);
		}
		repaint();
	}


	public Color getFeu() {
		return feu;
	}

	public void setFeu(Feu couleur) {
		switch(couleur){
		case Vert: alY= (int)(factX*242); feu=Color.green; drawFeu=true;
		break;
		case Jaune: alY=(int)(factX*178); feu=Color.yellow; drawFeu=true;
		break;
		case Rouge: alY=(int)(factX*113); feu=Color.red; drawFeu=true;
		break;
		case Aucune: drawFeu=false;
		break;
		}
		repaint();

	}




}
