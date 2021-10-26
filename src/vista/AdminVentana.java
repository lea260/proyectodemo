package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminVentana extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminVentana frame = new AdminVentana(new PrincipalVentana());
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
	public AdminVentana(PrincipalVentana vp) {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEstudiantes = new JMenu("Estudiantes");
		menuBar.add(mnEstudiantes);
		
		JMenuItem mnitAgregarEst = new JMenuItem("Agregar Estudiante");
		mnitAgregarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verAgregarEstudianteSubVentana();
			}
		});
		mnEstudiantes.add(mnitAgregarEst);
		
		JMenuItem mnitEliminarEst = new JMenuItem("Eliminar Estudiante");
		mnEstudiantes.add(mnitEliminarEst);
		
		JMenuItem mnitModificarEstidiante = new JMenuItem("Modificar Estudiante");
		mnEstudiantes.add(mnitModificarEstidiante);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	public void verAgregarEstudianteSubVentana() {
		// TODO Auto-generated method stub
		AgregarEstudianteSubVentana est= new AgregarEstudianteSubVentana();
		est.setVisible(true);
		desktopPane.add(est);
	}

}
