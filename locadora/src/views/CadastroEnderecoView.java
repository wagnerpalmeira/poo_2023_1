package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Endereco;
import services.CorreioService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CadastroEnderecoView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCep;
	private JTextField textFieldBairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEnderecoView frame = new CadastroEnderecoView();
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
	public CadastroEnderecoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		textFieldCep = new JTextField();
		contentPane.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		textFieldBairro = new JTextField();
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cep = textFieldCep.getText();
				try {
					Endereco endereco = CorreioService.consultarEnderecoPorCEP(cep);
					textFieldBairro.setText(endereco.getBairro());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnBuscar);
		textFieldBairro.setEditable(false);
	}

}
