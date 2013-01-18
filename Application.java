import java.awt.BorderLayout;
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
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.JSplitPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class Application extends JFrame {

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(11, 342, 399, 129);
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
		lblMasse2.setBounds(200, 11, 82, 14);
		panel.add(lblMasse2);
		
		lblCoeff = new JLabel("Coeff");
		lblCoeff.setBounds(10, 50, 46, 14);
		panel.add(lblCoeff);
		
		lblNewLabel_3 = new JLabel("Angle (Maximum 30)");
		lblNewLabel_3.setBounds(200, 50, 117, 14);
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
		spnMasse1.setModel(new SpinnerNumberModel(new Integer(100), new Integer(100), null, new Integer(10)));
		spnMasse1.setBounds(66, 8, 87, 20);
		panel.add(spnMasse1);
		
		spnMasse2 = new JSpinner();
		spnMasse2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setM2((int)(spnMasse2.getValue()));
			}
		});
		spnMasse2.setModel(new SpinnerNumberModel(new Integer(100), new Integer(100), null, new Integer(10)));
		spnMasse2.setBounds(253, 8, 113, 20);
		panel.add(spnMasse2);
		
		spnCoeff = new JSpinner();
		spnCoeff.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setFrottement((double)(spnCoeff.getValue()));
			}
		});
		spnCoeff.setModel(new SpinnerNumberModel(new Double(1), new Double(0), null, new Double(0.2)));
		spnCoeff.setBounds(66, 47, 87, 20);
		panel.add(spnCoeff);
		
		spnVitesse = new JSpinner();
		spnVitesse.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setV1((double) spnVitesse.getValue());
			}
		});
		spnVitesse.setModel(new SpinnerNumberModel(new Double(1.0), new Double(1.0), null, new Double(1.0)));
		spnVitesse.setBounds(66, 85, 87, 20);
		panel.add(spnVitesse);
		
		spnAngle = new JSpinner();
		spnAngle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				simulation.setAngle((double) (spnAngle.getValue()));
			}
		});
		spnAngle.setModel(new SpinnerNumberModel(10.0, 0.0, 30.0, 1.0));
		spnAngle.setBounds(327, 47, 39, 20);
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
		lblO.setBounds(369, 41, 52, 16);
		panel.add(lblO);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(611, 342, 400, 129);
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
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(420, 342, 182, 129);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				simulation.arreter();
				tglPlayPause.setSelected(false);
				tglPlayPause.setText("Play");
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
				}else{
					tglPlayPause.setText("Play");
					simulation.pauser();
				}
			}
		});
		tglPlayPause.setBounds(10, 11, 162, 60);
		panel_2.add(tglPlayPause);
		
		simulation = new Simulation();
		simulation.setBorder(null);
		simulation.setBounds(11, 11, 1000, 350);
		simulation.setAngle(20);
		contentPane.add(simulation);
	}
}
