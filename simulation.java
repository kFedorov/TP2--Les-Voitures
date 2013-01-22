import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;


public class Simulation extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private int m1=3200,m2=2000, carreHeight;
	private double frottement=0.8,angle=45;
	private Color cFond=Color.WHITE, cRoute=Color.BLACK, cCarre=Color.GREEN;
	private Rectangle2D.Double carreAngle;
	private boolean carreDeplace=false, carreFonctionnel=true;
	private Image auto1,auto2;
	private int posAuto1=0,posAuto2=0;
	private boolean estAnimee=false;
	private double v1=35,v2=0;
	private double dt=0.03;
	private double pixelParM;
	private Thread proc;
	private double tailleAuto=0.04;
	private double v2Carre;
	private double vraiePosAuto2=0;
	private final EventListenerList ecouteurs=new EventListenerList();
	private int tailleCarre=10;
	
	public Simulation() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(carreDeplace){
					if(e.getY()<=0){
						carreHeight=0;
						angle=45;
					}else{
						if(e.getY()>=getHeight()*9/10){
							carreHeight=getHeight()*9/10;
							angle=0;
						}else{
							carreHeight=e.getY();
							angle=Math.toDegrees((Math.atan(((double)(getHeight()*9)/10-carreHeight)*2/getWidth())));
						}
					}
					
					fireAngleChange();
					repaint();
				}
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(carreAngle.contains(getMousePosition())&&carreFonctionnel){
					carreDeplace=true;
					cCarre=Color.RED;
					repaint();
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				carreDeplace=false;
				if(carreFonctionnel){
					cCarre=Color.GREEN;
				}
				repaint();
			}
		});
		
		
		
		setPreferredSize(new Dimension(1000,320));
		setBackground(cFond);
		
		URL fichierAuto1= getClass().getClassLoader().getResource("autoVerte.png");
		try {
			auto1=ImageIO.read(fichierAuto1);
		}
		catch(IOException e){
			System.out.println("Erreur");
		}
		
		URL fichierAuto2= getClass().getClassLoader().getResource("autoRouge.png");
		try {
			auto2=ImageIO.read(fichierAuto2);
		}
		catch(IOException e){
			System.out.println("Erreur");
		}
		
		
		
		
	}
	
	@Override
	public void run() {
		while (estAnimee){
			if(posAuto1+v1*dt*pixelParM<getWidth()/2-getWidth()*tailleAuto){
				posAuto1=(int) (posAuto1+v1*dt*pixelParM);
				
			}else{
				posAuto1=(int) (getWidth()/2-getWidth()*tailleAuto);
				v2Carre=(m1*v1*v1*0.5-frottement*m2*9.8*Math.cos(Math.toRadians(angle))*vraiePosAuto2/pixelParM-m2*9.8*vraiePosAuto2/pixelParM*Math.sin(Math.toRadians(angle)))*2/m2;
				if(v2Carre>0){
					v2= Math.sqrt(v2Carre);
					vraiePosAuto2= (vraiePosAuto2+v2*dt*pixelParM);
					posAuto2=(int)(vraiePosAuto2);
				}else{
					v2=0;
					fireAnimationTermine();
					
					estAnimee=false;
				}
				
				
			}
			fireEstAnime();
			repaint();
			try {
				Thread.sleep((long)(dt*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.translate(0, getHeight()*9/10);
		
		g2d.drawImage(auto1, posAuto1, (int)(-getWidth()/2*tailleAuto), (int)(getWidth()*tailleAuto), (int)(getWidth()/2*tailleAuto), null);
		g2d.scale(1, -1);
				
		g2d.setColor(cRoute);
		g2d.drawLine(0, 0, getWidth()/2, 0);
		for(int i=getWidth()/2;i<=getWidth();i=i+10){
			g2d.drawLine(i, 0, i+5, 0);
		}
		
		

		g2d.drawArc(getWidth()/3, -getWidth()/6, getWidth()/3, getWidth()/3, 0, -(int) angle);
		g2d.scale(1, -1);
		if(angle>=5){
			g2d.drawString("Angle : "+Math.floor(angle*100)/100+"°", (int) (getWidth()/6*Math.cos(Math.toRadians(angle/2)))+getWidth()/2+4, -(int) (getWidth()/6*Math.sin(Math.toRadians(angle/2))));
		}
		g2d.scale(1, -1);

		
		g2d.rotate(angle*Math.PI/180,getWidth()/2,0);
		g2d.drawLine(getWidth()/2, 0, (int) (getWidth()+getHeight()*Math.sin(Math.toRadians(angle))),0);
		
		g2d.translate(getWidth()/2, 0);
		g2d.scale(1, -1);
				
		g2d.drawImage(auto2, posAuto2, (int)(-getWidth()/2*tailleAuto+2), (int)(getWidth()*tailleAuto), (int)(getWidth()/2*tailleAuto-2), null);
		if(posAuto2>getWidth()/2/Math.cos(Math.toRadians(angle))-100){
			g2d.drawString("Vitesse: "+Math.floor(v2*100)/100+" m/s", (int) (getWidth()/2/Math.cos(Math.toRadians(angle))-100), (int) (-tailleAuto*getWidth()/2-2));
		}else{
			g2d.drawString("Vitesse: "+Math.floor(v2*100)/100+" m/s", posAuto2-5, (int) (-tailleAuto*getWidth()/2-2));
		}
		
		g2d.drawLine(0, 5, posAuto2, 5);
		if (angle>5){
			g2d.setColor(Color.white);
			g2d.fillRect(0,6,140,20);
			g2d.setColor(Color.black);
		}
		g2d.drawString("Déplacement: "+Math.floor(vraiePosAuto2/pixelParM*100)/100+" m.", 0, 20);
		g2d.translate(-getWidth()/2, 0);
		g2d.rotate(angle*Math.PI/180,getWidth()/2,0);
		
		g2d.translate(0, -getHeight()*9/10);
		g2d.setColor(cCarre);
		carreAngle=new Rectangle2D.Double(getWidth()-tailleCarre, carreHeight-tailleCarre/2, tailleCarre, tailleCarre);
		g2d.fill(carreAngle);
		
	
	}
	@Override
	public void setBounds(int x, int y, int width, int height){
		super.setBounds(x,y,width,(int)(Math.tan((double)(45)/180*Math.PI)*width/2*10/9));
		pixelParM=(double)(width)/200;
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

	public double getV1() {
		return v1;
	}

	public void setV1(double v1) {
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
		if(angle>90){
			this.angle=90;
		}else{
			if(angle<0){
				this.angle=0;
			}else{
				this.angle = angle;
			}
		}
		carreHeight=(int)(getHeight()*9/10-Math.tan(Math.toRadians(angle))*getWidth()/2);
		repaint();
		
	}
	
	public void animer(){
		carreFonctionnel=false;
		cCarre=Color.BLACK;
		estAnimee=true;
		proc=new Thread(this);
		proc.start();
		
		
	}
	
	public void pauser(){
		estAnimee=false;
	}
	
	public void arreter(){
		cCarre=Color.GREEN;
		carreFonctionnel=true;
		estAnimee=false;
		posAuto1=0;
		vraiePosAuto2=0;
		posAuto2=0;
		v2=0;
		repaint();
	}
	
	public double getV2(){
		return v2;
	}

	public double getDeplace(){
		return vraiePosAuto2/pixelParM;
	}
	
	public double getDt() {
		return dt;
	}

	public void setDt(double dt) {
		this.dt = dt;
	}

	public void addSimListener(SimListener ecout){
		ecouteurs.add(SimListener.class, ecout);
	}
	private void fireAnimationTermine(){
		for (SimListener ecout:ecouteurs.getListeners(SimListener.class)){
			ecout.animationTermine();
		}
	}
	private void fireAngleChange(){
		for(SimListener ecout:ecouteurs.getListeners(SimListener.class)){
			ecout.angleChange();
		}
	}
	private void fireEstAnime(){
		for (SimListener ecout:ecouteurs.getListeners(SimListener.class)){
			ecout.estAnime();
		}
	}

	

}
