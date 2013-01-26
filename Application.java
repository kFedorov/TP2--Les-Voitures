import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Point;


public class Application extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnStop;
	private JToggleButton tglPlayPause;
	private JButton btnCorrection;
	private JLabel lblMasse1;
	private JLabel lblMasse2;
	private JLabel lblCoeff;
	private JLabel lblNewLabel_3;
	private JLabel lblVitesse;
	private Simulation simulation;
	private JButton btnQuittez;
	private JSpinner spnMasse1;
	private JSpinner spnMasse2;
	private JSpinner spnCoeff;
	private JSpinner spnVitesse;
	private JSpinner spnAngle;
	private JLabel lblKg;
	private JLabel lblKg_1;
	private JLabel lblMs;
	private JLabel lblO;
	private JTextField textVitesse;
	private JTextField textDeplace;
	private FeuCirculation feuCirculation;
	private JSpinner spnFPS;
	private JLabel lblFps;
	private Aide aide;

	private double fps = 0.03;
	private double toFloor;
	private JMenuBar menuBar;
	private JMenuItem mbtnAide;
	private JMenu mnAide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setTitle("Simulateur de Collisions - Fedorov, Miriello");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 772);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(13, 604, 399, 129);
		contentPane.add(panel);
		panel.setLayout(null);

		btnCorrection = new JButton("Correction");
		btnCorrection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				simulation.setM1(3200);
				simulation.setM2(2000);
				simulation.setV1((double)35);
				simulation.setAngle(20.00);
				simulation.setFrottement(0.8);
				//DELTA T?
				spnMasse1.setValue(3200);
				spnMasse2.setValue(2000);
				spnVitesse.setValue((double)35);
				spnAngle.setValue(20.00);
				spnCoeff.setValue(0.8);
			}
		});
		btnCorrection.setBounds(230, 84, 107, 23);
		panel.add(btnCorrection);

		lblMasse1 = new JLabel("Masse 1");
		lblMasse1.setBounds(10, 11, 82, 14);
		panel.add(lblMasse1);

		lblMasse2 = new JLabel("Masse 2");
		lblMasse2.setBounds(200, 11, 78, 14);
		panel.add(lblMasse2);

		lblCoeff = new JLabel("Coeff");
		lblCoeff.setBounds(10, 50, 46, 14);
		panel.add(lblCoeff);

		lblNewLabel_3 = new JLabel("Angle");
		lblNewLabel_3.setBounds(200, 50, 39, 14);
		panel.add(lblNewLabel_3);

		lblVitesse = new JLabel("Vitesse");
		lblVitesse.setBounds(10, 88, 82, 14);
		panel.add(lblVitesse);

		spnMasse1 = new JSpinner();
		spnMasse1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setM1((int) spnMasse1.getValue());
			}
		});
		spnMasse1.setModel(new SpinnerNumberModel(new Integer(3200), new Integer(100), null, new Integer(10)));
		spnMasse1.setBounds(66, 8, 87, 20);
		panel.add(spnMasse1);

		spnMasse2 = new JSpinner();
		spnMasse2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setM2((int)(spnMasse2.getValue()));
			}
		});
		spnMasse2.setModel(new SpinnerNumberModel(new Integer(2000), new Integer(100), null, new Integer(10)));
		spnMasse2.setBounds(290, 8, 76, 20);
		panel.add(spnMasse2);

		spnCoeff = new JSpinner();
		spnCoeff.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setFrottement((double)(spnCoeff.getValue()));
			}
		});
		spnCoeff.setModel(new SpinnerNumberModel(new Double(0.8), new Double(0.1), null, new Double(0.1)));
		spnCoeff.setBounds(66, 47, 87, 20);
		panel.add(spnCoeff);

		spnVitesse = new JSpinner();
		spnVitesse.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setV1((double) spnVitesse.getValue());
			}
		});
		spnVitesse.setModel(new SpinnerNumberModel(new Double(35), new Double(1), null, new Double(5)));
		spnVitesse.setBounds(66, 85, 87, 20);
		panel.add(spnVitesse);

		spnAngle = new JSpinner();
		spnAngle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setAngle((double) (spnAngle.getValue()));
			}
		});
		spnAngle.setModel(new SpinnerNumberModel(20.0, 0.0, 30.0, 0.1));
		spnAngle.setBounds(251, 48, 39, 20);
		panel.add(spnAngle);

		lblKg = new JLabel("kg");
		lblKg.setBounds(158, 10, 52, 16);
		panel.add(lblKg);

		lblKg_1 = new JLabel("kg");
		lblKg_1.setBounds(369, 10, 52, 16);
		panel.add(lblKg_1);

		lblMs = new JLabel("m/s");
		lblMs.setBounds(158, 87, 52, 16);
		panel.add(lblMs);

		lblO = new JLabel("o");
		lblO.setBounds(290, 41, 52, 16);
		panel.add(lblO);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(614, 604, 400, 129);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnQuittez = new JButton("Quittez");
		btnQuittez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuittez.setBounds(301, 95, 89, 23);
		panel_1.add(btnQuittez);

		textVitesse = new JTextField();
		textVitesse.setText("0.0");
		textVitesse.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		textVitesse.setHorizontalAlignment(SwingConstants.CENTER);
		textVitesse.setEditable(false);
		textVitesse.setBounds(12, 11, 181, 78);
		panel_1.add(textVitesse);
		textVitesse.setColumns(10);

		textDeplace = new JTextField();
		textDeplace.setHorizontalAlignment(SwingConstants.CENTER);
		textDeplace.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		textDeplace.setEditable(false);
		textDeplace.setText("0.0");
		textDeplace.setBounds(205, 11, 183, 78);
		panel_1.add(textDeplace);
		textDeplace.setColumns(10);

		spnFPS = new JSpinner();
		spnFPS.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				fps=1/(double)spnFPS.getValue();
				simulation.setDt(fps);
			}
		});
		spnFPS.setModel(new SpinnerNumberModel(new Double(33), new Double(1), null, new Double(1)));
		spnFPS.setBounds(22, 97, 51, 20);
		panel_1.add(spnFPS);

		lblFps = new JLabel("Images par Seconde");
		lblFps.setBounds(85, 99, 108, 14);
		panel_1.add(lblFps);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(422, 604, 182, 129);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnStop.getText()=="Reset"){
					btnStop.setText("Stop");
				}
				feuCirculation.setFeu(Feu.Aucune);
				simulation.arreter();
				tglPlayPause.setSelected(false);
				tglPlayPause.setText("Play");
				spnVitesse.setEnabled(true);
				spnAngle.setEnabled(true);
				spnCoeff.setEnabled(true);
				spnMasse1.setEnabled(true);
				spnMasse2.setEnabled(true);
				btnCorrection.setEnabled(true);
				tglPlayPause.setEnabled(true);
				spnFPS.setEnabled(true);
				textVitesse.setText("0.0m");
				textDeplace.setText("0.0m");
			}
		});
		btnStop.setBounds(20, 82, 140, 23);
		panel_2.add(btnStop);

		tglPlayPause = new JToggleButton("Play");
		tglPlayPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tglPlayPause.isSelected()){
					tglPlayPause.setText("Pause");
					simulation.animer();

					//BLOCK DISABLE
					spnVitesse.setEnabled(false);
					spnAngle.setEnabled(false);
					spnCoeff.setEnabled(false);
					spnMasse1.setEnabled(false);
					spnMasse2.setEnabled(false);
					btnCorrection.setEnabled(false);
					spnFPS.setEnabled(false);

					feuCirculation.setFeu(Feu.Vert);

				}else{
					tglPlayPause.setText("Play");
					simulation.pauser();
					feuCirculation.setFeu(Feu.Jaune);
				}
			}
		});
		tglPlayPause.setBounds(10, 11, 162, 60);
		panel_2.add(tglPlayPause);

		simulation = new Simulation();
		simulation.addSimListener(new SimListener() {
			@Override
			public void angleChange() {
				spnAngle.setValue(simulation.getAngle());
			}
			@Override
			public void animationTermine() {
				feuCirculation.setFeu(Feu.Rouge);

				//BLOCK REENABLE

				tglPlayPause.setText("Play");
				tglPlayPause.setEnabled(false);
				btnStop.setText("Reset");

				toFloor = Math.floor(100*((double) simulation.getV2()))/100;
				textVitesse.setText(Double.toString(toFloor)+"m");
				toFloor = Math.floor(100*((double) simulation.getDeplace()))/100;
				textDeplace.setText(Double.toString(toFloor)+"m");
			}
			@Override
			public void estAnime() {
				toFloor = Math.floor(100*((double) simulation.getV2()))/100;
				textVitesse.setText(Double.toString(toFloor)+"m");
				toFloor = Math.floor(100*((double) simulation.getDeplace()))/100;
				textDeplace.setText(Double.toString(toFloor)+"m");

			}
		});
		simulation.setBorder(new LineBorder(new Color(0, 0, 0)));
		simulation.setBounds(13, 32, 1000, 350);
		simulation.setAngle(20);
		contentPane.add(simulation);
		simulation.setLayout(null);

		feuCirculation = new FeuCirculation();
		feuCirculation.setFeu(Feu.Aucune);
		feuCirculation.setBounds(0, 0, 300, 300);
		simulation.add(feuCirculation);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1023, 21);
		contentPane.add(menuBar);

		aide = new Aide();
		aide.setVisible(false);

		mnAide = new JMenu("Options");
		menuBar.add(mnAide);

		mbtnAide = new JMenuItem("Aide");
		mnAide.add(mbtnAide);
		mbtnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aide.setVisible(true);
			}
		});
	}
}
