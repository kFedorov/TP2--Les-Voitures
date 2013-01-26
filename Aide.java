
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aide extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnQuitter;
	private JScrollPane scrollPane;
	private JTextPane txtpnCetteApplicationPermet;
	private JTextField txtAideInstructions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aide frame = new Aide();
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
	public Aide() {
		
		
		setTitle("Aide - Miriello, Fedorov");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnQuitter, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtpnCetteApplicationPermet = new JTextPane();
		txtpnCetteApplicationPermet.setEditable(false);
		txtpnCetteApplicationPermet.setText("Cette application permet de calculer et d'afficher la vitesse et la position d'un objet suite \u00E0 une collision, en tenant compte des param\u00E8tres suivants : la masse des deux objets, la vitesse initiale du premier objet, l'angle de la pente sur laquelle est situ\u00E9 le deuxi\u00E8me objet et le coefficient de friction entre le deuxi\u00E8me objet et la pente.\r\n\r\nINSTRUCTIONS:\r\n -Entrez les param\u00E8tres d\u00E9sir\u00E9s dans les endroits pr\u00E9vus \u00E0 cet effet.\r\n\t\t-Plus l'angle est \u00E9lev\u00E9, moins le deuxi\u00E8me objet ira loin.\r\n\t\t-Plus le coefficient de friction est \u00E9lev\u00E9, moins le deuxi\u00E8me objet ira loin.\r\n\t\t-Plus la vitesse du premier objet est \u00E9lev\u00E9e, plus le  deuxi\u00E8me objet ira loin.\r\n\t\t-plus la masse du premier objet est \u00E9lev\u00E9e, plus le deuxi\u00E8me objet ira loin.\r\n\t\t-Plus la masse du premier objet est \u00E9lev\u00E9e, moins le deuxi\u00E8me objet ira loin.\r\n -Appuyez sur le boutton play pour commencer l'animation.\r\n\t\t-Pour pauser l'animation, appuyez sur pause.\r\n -Vous pouvez en tout temps arr\u00EAter l'animation en appuyant sur arr\u00EAter.\r\n -Apr\u00E8s avoir appuyer sur le bouton \"Arr\u00EAter\", vous pouvez entrer de nouvelles valeurs et recommencer \u00E0 la premi\u00E8re \u00E9tape.");
		txtpnCetteApplicationPermet.setBackground(Color.WHITE);
		scrollPane.setViewportView(txtpnCetteApplicationPermet);
		
		txtAideInstructions = new JTextField();
		txtAideInstructions.setEditable(false);
		txtAideInstructions.setText("Aide - Instructions");
		txtAideInstructions.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtAideInstructions.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(txtAideInstructions, BorderLayout.NORTH);
		txtAideInstructions.setColumns(10);
	}
}
