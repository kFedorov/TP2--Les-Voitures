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


public class Application extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnStop;
	private JToggleButton tglPlayPause;
	private JButton btnCorrection;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private Simulation simulation;

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
		btnCorrection.setBounds(230, 84, 107, 23);
		panel.add(btnCorrection);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 82, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(200, 11, 82, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 50, 82, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(200, 50, 97, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 88, 82, 14);
		panel.add(lblNewLabel_4);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(611, 342, 400, 129);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(420, 342, 182, 129);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnStop = new JButton("Stop");
		btnStop.setBounds(20, 82, 140, 23);
		panel_2.add(btnStop);
		
		tglPlayPause = new JToggleButton("Play");
		tglPlayPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tglPlayPause.isSelected()){
					tglPlayPause.setText("Pause");
				}else{
					tglPlayPause.setText("Play");
				}
			}
		});
		tglPlayPause.setBounds(10, 11, 162, 60);
		panel_2.add(tglPlayPause);
		
		simulation = new Simulation();
		simulation.setBorder(null);
		simulation.setBounds(11, 11, 1000, 350);
		contentPane.add(simulation);
	}
}
