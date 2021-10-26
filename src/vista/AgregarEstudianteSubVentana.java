package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import negocio.Estudiante;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEstudianteSubVentana extends JInternalFrame {
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textApellido;
	private Estudiante estudiante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEstudianteSubVentana frame = new AgregarEstudianteSubVentana();
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
	public AgregarEstudianteSubVentana() {
		setTitle("Agregar Estudiante");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(10, 0, 800, 400);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 750, 350);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(219, 68, 88, 50);
		panel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(219, 112, 88, 50);
		panel.add(lblNombre);

		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(219, 171, 88, 50);
		panel.add(lblNewLabel_1_1);

		textCedula = new JTextField();
		textCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCedula.setBounds(350, 87, 86, 20);
		panel.add(textCedula);
		textCedula.setColumns(10);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNombre.setColumns(10);
		textNombre.setBounds(350, 131, 86, 20);
		panel.add(textNombre);

		textApellido = new JTextField();
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textApellido.setColumns(10);
		textApellido.setBounds(350, 190, 86, 20);
		panel.add(textApellido);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEstudiante();
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAgregar.setBounds(218, 253, 100, 40);
		panel.add(btnAgregar);

	}

	public void agregarEstudiante() {
		// TODO Auto-generated method stub
		try {
			String nombre = textNombre.getText();
			String apellido = textApellido.getText();
			String cedStr = textCedula.getText();
			int cedInt = Integer.parseInt(cedStr);
			estudiante = new Estudiante(nombre, apellido, cedInt);
			int cedula = estudiante.agregar();
		} catch (Exception e) {
			// TODO: handle exception

		}

	}
}
