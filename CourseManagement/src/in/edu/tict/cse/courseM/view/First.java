package in.edu.tict.cse.courseM.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class First {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public First() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Instructor");
		btnNewButton.setBounds(185, 43, 110, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Instructor ins = new Instructor();
				ins.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Course");
		btnNewButton_1.setBounds(185, 103, 110, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Course cou = new Course();
				cou.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Textbook");
		btnNewButton_2.setBounds(185, 163, 110, 27);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Textbook text = new Textbook();
				text.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("View/Edit details of :");
		lblNewLabel.setBounds(31, 43, 122, 18);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(btnNewButton_2);
	}
	
	public JFrame getFirstFrame(){
	return frame;
	}
}
