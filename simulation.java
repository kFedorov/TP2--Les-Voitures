import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Simulation extends JPanel {
  private static final long serialVersionUID = 1L;
	private int m1,m2,v1;
	private double frottement,angle;
	private Color cFond=Color.WHITE;
	
	public Simulation() {
		setPreferredSize(new Dimension(1000,500));
		setBackground(cFond);
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
	}
	

	public int getM1() {
		return m1;
	}

	public void setM1(int m1) {
		this.m1 = m1;
		repaint();
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
		repaint();
	}

	public int getV1() {
		return v1;
	}

	public void setV1(int v1) {
		this.v1 = v1;
		repaint();
	}

	public double getFrottement() {
		return frottement;
	}

	public void setFrottement(double frottement) {
		this.frottement = frottement;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
		repaint();
	}

}
