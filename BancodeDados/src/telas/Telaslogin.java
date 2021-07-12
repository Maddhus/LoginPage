package telas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Conexao;
import dao.Pessoa;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Telaslogin extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JLabel cpfLabel;
	private JPasswordField telefone;
	private JPasswordField cpf;
	private JPasswordField passwordField_2;
	private JPasswordField email;
	private Pessoa pessoa; 
	protected Object statement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telaslogin frame = new Telaslogin();
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
	public Telaslogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(158, 91, 183, 20);
		contentPane.add(nome);
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nome.setColumns(35);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		emailLabel.setBounds(75, 121, 75, 20);
		contentPane.add(emailLabel);
		
		cpfLabel = new JLabel("CPF:");
		cpfLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		cpfLabel.setBounds(75, 167, 75, 17);
		contentPane.add(cpfLabel);
		
		telefone = new JPasswordField();
		telefone.setBounds(158, 209, 183, 20);
		contentPane.add(telefone);
		
		JLabel telefoneLabel = new JLabel("Telefone:");
		telefoneLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		telefoneLabel.setBounds(75, 210, 75, 14);
		contentPane.add(telefoneLabel);
		
		JButton cadastar = new JButton("Cadastrar");
		cadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				       pessoa = new Pessoa(nome.getText(), 
					   String.valueOf(email.getPassword()), 
					   String.valueOf(cpf.getPassword()),
					   String.valueOf(telefone.getPassword())); 
				
				
				try {
					 Conexao con = new Conexao();
					 
					 Connection conn = con.connect();
					
					String sql = "insert into nome(nome, email, cpf, telefone) values ('" + pessoa.getNome() 
					+  "', '"+ pessoa.getEmail() + "', '" + pessoa.getCpf() +  "', '"+ pessoa.getTelefone() + "');";                                                
					java.sql.PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute();
					
                  
					
				   conn.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				
				
				if(pessoa.getNome().length()!=0 &&
				pessoa.getEmail().length()!=0 &&
				pessoa.getCpf().length()!=0 &&
				pessoa.getTelefone().length()!= 0)
				{
					
					
					
			       JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso." + "\nBem Vindo " + 
			       		 pessoa.getNome() + "\nEmail: " + pessoa.getEmail() + "\nCPF: " + pessoa.getCpf() + "\nTelefone" + pessoa.getTelefone());
				}	   
			}
		});
		cadastar.setBounds(193, 257, 116, 23);
		contentPane.add(cadastar);
		
		cpf = new JPasswordField();
		cpf.setBounds(158, 167, 183, 20);
		contentPane.add(cpf);
		
		
		
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(562, 188, -167, 8);
		contentPane.add(passwordField_2);
		
		
		
		email = new JPasswordField();
		email.setBounds(158, 122, 183, 20);
		contentPane.add(email);
		
		
		
		JLabel NomeLabel = new JLabel("Nome:");
		NomeLabel.setBounds(75, 89, 47, 21);
		contentPane.add(NomeLabel);
		NomeLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		
	}
}
