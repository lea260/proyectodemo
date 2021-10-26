package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import vista.*;

//ctrl+shift+o
//borrra los los imports no utilizados
//ctrl +shift +f
//le da formato al codigo
public class PrincipalVentana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVentana frame = new PrincipalVentana();
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
	public PrincipalVentana() {
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 43, 700, 307);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAdministrativo = new JButton("Administrativo");
		btnAdministrativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verAdminVentana();
			}
		});
		btnAdministrativo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdministrativo.setBounds(249, 68, 200, 50);
		panel.add(btnAdministrativo);

		JButton btnAdscripto = new JButton("Adscripto");
		btnAdscripto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdscripto.setBounds(249, 161, 200, 50);
		panel.add(btnAdscripto);
	}

	public void verAdminVentana() {
		// TODO Auto-generated method stub
		AdminVentana adminVentana = new AdminVentana(this);
		adminVentana.setVisible(true);
		this.setVisible(false);

	}
}
