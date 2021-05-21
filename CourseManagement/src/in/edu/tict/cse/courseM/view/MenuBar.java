package in.edu.tict.cse.courseM.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class MenuBar extends JFrame {
	JToggleButton tglbtnNewToggleButton;
	JToggleButton tglbtnNewToggleButton_1;
	JToggleButton tglbtnNewToggleButton_2;
	JToggleButton tglbtnNewToggleButton_3;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBar frame = new MenuBar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setInactiveExcept(int n) {
		if (n != 1) {
			tglbtnNewToggleButton.setSelected(false);
		}
		if (n != 2) {
			tglbtnNewToggleButton_1.setSelected(false);
		}
		if (n != 3) {
			tglbtnNewToggleButton_2.setSelected(false);
		}
		if (n != 4) {
			tglbtnNewToggleButton_3.setSelected(false);
		}
	}

	/**
	 * Create the frame.
	 */
	public MenuBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 143, 382);
		contentPane.add(panel);
		panel.setLayout(null);

		tglbtnNewToggleButton = new JToggleButton("Home");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInactiveExcept(1);
			}
		});
		tglbtnNewToggleButton.setBackground(SystemColor.activeCaption);
		tglbtnNewToggleButton.setBounds(0, 139, 143, 37);
		panel.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setSelected(true);
		tglbtnNewToggleButton_1 = new JToggleButton("Courses");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course frame = new Course();
				frame.setVisible(true);
				dispose();
				setInactiveExcept(2);
			}
		});
		tglbtnNewToggleButton_1.setBackground(SystemColor.activeCaption);
		tglbtnNewToggleButton_1.setBounds(0, 170, 143, 37);
		panel.add(tglbtnNewToggleButton_1);

		tglbtnNewToggleButton_2 = new JToggleButton("Instructors");
		tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInactiveExcept(3);
				Instructor frame = new Instructor();
				frame.setVisible(true);
				dispose();
			}
		});
		tglbtnNewToggleButton_2.setBackground(SystemColor.activeCaption);
		tglbtnNewToggleButton_2.setBounds(0, 204, 143, 37);
		panel.add(tglbtnNewToggleButton_2);

		tglbtnNewToggleButton_3 = new JToggleButton("Textbooks");
		tglbtnNewToggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Textbook frame = new Textbook();
				frame.setVisible(true);
				dispose();
				setInactiveExcept(4);
			}
		});
		tglbtnNewToggleButton_3.setBackground(SystemColor.activeCaption);
		tglbtnNewToggleButton_3.setBounds(0, 237, 143, 37);
		panel.add(tglbtnNewToggleButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(MenuBar.class.getResource("/in/edu/tict/cse/courseM/icons/icons8-home-office-100 (1).png")));
		lblNewLabel_5.setBounds(21, 10, 100, 100);
		panel.add(lblNewLabel_5);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(141, 0, 537, 392);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(110, 256, 260, 51);
		desktopPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Course Management");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(109, 303, 342, 51);
		desktopPane.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(127, 212, 0, -79);
		desktopPane.add(separator);

		JLabel lblNewLabel_3 = new JLabel("|");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblNewLabel_3.setForeground(SystemColor.activeCaption);
		lblNewLabel_3.setBounds(70, 174, 46, 247);
		desktopPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(MenuBar.class.getResource("/in/edu/tict/cse/courseM/icons/ezgif.com-gif-maker (1).gif")));
		lblNewLabel_4.setBounds(51, 10, 400, 237);
		desktopPane.add(lblNewLabel_4);
	}
}
