
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
/**
 * 
 * Fenêtre d'aide pour le fonctionnement de l'application.
 * @author Konstantin Fedorov et Philippe Miriello
 *
 */
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
	 * Génération de la fenêtre
	 */
	public Aide() {
		setResizable(false);
		
		
		setTitle("Aide - Miriello, Fedorov");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(5, 266, 623, 23);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnQuitter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 33, 623, 233);
		contentPane.add(scrollPane);
		
		txtpnCetteApplicationPermet = new JTextPane();
		txtpnCetteApplicationPermet.setText("Cette application permet de calculer et d'afficher la vitesse et la position d'un objet suite \u00E0 une collision, en tenant compte des param\u00E8tres suivants : la masse des deux objets, la vitesse initiale du premier objet, l'angle de la pente sur laquelle est situ\u00E9 le deuxi\u00E8me objet et le coefficient de friction entre le deuxi\u00E8me objet et la pente.\r\n\r\nINSTRUCTIONS:\r\n -Entrez les param\u00E8tres d\u00E9sir\u00E9s dans les endroits pr\u00E9vus \u00E0 cet effet.\r\n\t\t-Plus l'angle est \u00E9lev\u00E9, moins le deuxi\u00E8me objet ira loin.\r\n\t\t-Plus le coefficient de friction est \u00E9lev\u00E9, moins le deuxi\u00E8me objet ira loin.\r\n\t\t-Plus la vitesse du premier objet est \u00E9lev\u00E9e, plus le  deuxi\u00E8me objet ira loin.\r\n\t\t-plus la masse du premier objet est \u00E9lev\u00E9e, plus le deuxi\u00E8me objet ira loin.\r\n\t\t-Plus la masse du premier objet est \u00E9lev\u00E9e, moins le deuxi\u00E8me objet ira loin.\r\n -Appuyez sur le boutton play pour commencer l'animation.\r\n\t\t-Pour pauser l'animation, appuyez sur pause.\r\n -Vous pouvez en tout temps arr\u00EAter l'animation en appuyant sur arr\u00EAter.\r\n -Apr\u00E8s avoir appuyer sur le bouton \"Arr\u00EAter\", vous pouvez entrer de nouvelles valeurs et recommencer \u00E0 la premi\u00E8re \u00E9tape.\r\n\r\nVARIABLES:\r\n\tVariables d'entr\u00E9:\r\n\t\t-Masse 1 : Masse de la premi\u00E8re voiture.\r\n\t\t-Masse 2 : Masse de la deuxi\u00E8me voiture.\r\n\t\t-Coeff      : Coefficient de frottement cin\u00E9tique pour la voiture 2.\r\n\t\t-Angle     : Angle de la pente.\r\n\t\t-Vitesse   : Vitesse de la premi\u00E8re voiture avant la collision.\r\n\r\n\tDonn\u00E9es de Sortie:\r\n\t\t-Vitesse\t   : Vitesse de la deuxi\u00E8me voiture.\r\n\t\t-Distance : D\u00E9placement (en X) de la voiture 2.");
		txtpnCetteApplicationPermet.setBackground(Color.WHITE);
		scrollPane.setViewportView(txtpnCetteApplicationPermet);
		
		txtAideInstructions = new JTextField();
		txtAideInstructions.setBounds(5, 5, 623, 28);
		txtAideInstructions.setEditable(false);
		txtAideInstructions.setText("Aide - Instructions");
		txtAideInstructions.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtAideInstructions.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(txtAideInstructions);
		txtAideInstructions.setColumns(10);
	}
}
