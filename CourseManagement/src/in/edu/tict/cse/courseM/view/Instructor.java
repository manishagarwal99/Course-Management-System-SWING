package in.edu.tict.cse.courseM.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import in.edu.tict.cse.courseM.dao.CourseManagementDao;
import in.edu.tict.cse.courseM.dbcon.ConnectionDb;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Instructor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private String entry_name;
	private String entry_phone;
	private int count = 0;
	JToggleButton tglbtnNewToggleButton;
	JToggleButton tglbtnNewToggleButton_1;
	JToggleButton tglbtnNewToggleButton_2;
	JToggleButton tglbtnNewToggleButton_3;
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet r = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructor frame = new Instructor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void updateTable() {

		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			r = st.executeQuery("SELECT * FROM course_management.instructor_info");
			table.setModel(DbUtils.resultSetToTableModel(r));
			table.getColumnModel().getColumn(0).setWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(1).setHeaderValue("Instructor Name");
			table.getColumnModel().getColumn(2).setHeaderValue("Phone No.");
		} catch (SQLException e12) {
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e12.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}

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

	public Instructor() {
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
				MenuBar frame = new MenuBar();
				frame.setVisible(true);
				dispose();
			}
		});
		tglbtnNewToggleButton.setBackground(SystemColor.activeCaption);
		tglbtnNewToggleButton.setBounds(0, 139, 143, 37);
		panel.add(tglbtnNewToggleButton);

		tglbtnNewToggleButton_1 = new JToggleButton("Courses");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInactiveExcept(2);
				Course frame = new Course();
				frame.setVisible(true);
				dispose();
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
		tglbtnNewToggleButton_2.setSelected(true);
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
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Instructor.class.getResource("/in/edu/tict/cse/courseM/icons/icons8-classroom-100.png")));
		lblNewLabel_3.setBounds(21, 10, 100, 100);
		panel.add(lblNewLabel_3);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(138, 0, 554, 576);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Instructor.class.getResource("/in/edu/tict/cse/courseM/icons/icons8-repeat-16.png")));
		btnNewButton_2.setBounds(323, 9, 25, 25);
		desktopPane.add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 44, 328, 310);
		desktopPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (count == 0) {
					int row = table.getSelectedRow();
					entry_name = table.getModel().getValueAt(row, 1).toString();
					entry_phone = table.getModel().getValueAt(row, 2).toString();
					// System.out.println(name+" -- "+phone);
					count++;
				}

			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Instructors :");
		lblNewLabel.setBounds(21, 8, 92, 25);
		desktopPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNewLabel_1 = new JLabel("Instructor Name :");
		lblNewLabel_1.setBounds(358, 68, 103, 14);
		desktopPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField = new JTextField();
		textField.setBounds(358, 92, 131, 20);
		desktopPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Phone No.  :");
		lblNewLabel_2.setBounds(358, 122, 103, 14);
		desktopPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField_1 = new JTextField();
		textField_1.setBounds(358, 144, 131, 23);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		JButton btnNewButton_1 = new JButton("Add Instructor");
		btnNewButton_1.setBounds(358, 199, 131, 23);
		desktopPane.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(358, 240, 131, 23);
		desktopPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setBounds(358, 285, 131, 23);
		desktopPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String id = table.getModel().getValueAt(row, 0).toString();
					String name = table.getModel().getValueAt(row, 1).toString();
					String phone = table.getModel().getValueAt(row, 2).toString();
					System.out.println(id + "-" + name + "-" + phone);
					try {
						CourseManagementDao.instructor_del(Integer.parseInt(id));
						JOptionPane.showMessageDialog(null,
								"The following entry has been deleted:\nName- " + name + "\nPhone- " + phone + "\n");
						updateTable();
					} catch (Exception edel) {
						JOptionPane.showMessageDialog(null, "Deletion not successful!");
					}
					boolean deleted = CourseManagementDao.DeleteOtherCourses("instructor_info", "instructor_id");
					if (deleted == true) {
						JOptionPane.showMessageDialog(null, "Courses taught by " + name + " has also been deleted!");
					}
					count = 0;
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No row has been selected!");
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					table.editCellAt(row, column);
					String id = table.getModel().getValueAt(row, 0).toString();
					String name_updated = table.getModel().getValueAt(row, 1).toString();
					String phone_updated = table.getModel().getValueAt(row, 2).toString();
					System.out.println(entry_name + " - " + name_updated);
					System.out.println(entry_phone + " - " + phone_updated);
					CourseManagementDao.instructor_update(name_updated, phone_updated, Integer.parseInt(id));
					String change_st = "The following entry has been edited:\n";
					if (!name_updated.equals(entry_name))
						change_st += "Name: " + entry_name + " -> " + name_updated + "\n";
					if (!phone_updated.equals(entry_phone))
						change_st += "Phone: " + entry_phone + " -> " + phone_updated;
					if (name_updated.equals(entry_name) && phone_updated.equals(entry_phone))
						change_st = "No changes have been made.";
					JOptionPane.showMessageDialog(null, change_st);
					boolean flag = CourseManagementDao.isInstructorNameAvailable(name_updated);
					if (flag) {
						CourseManagementDao.updateDuplicateInstructor(name_updated);
						JOptionPane.showMessageDialog(null,
								"Entries have been updated, because duplicate entries were found.");
					}
					updateTable();
					count = 0;
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No row has been selected!");
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Instructor  name should not be empty!");
				} else if ((textField_1.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Phone no. should not be empty!");
				} else {
					String textName = textField.getText();
					String textPhone = textField_1.getText();
					try {
						if (CourseManagementDao.isPhoneAvailable(textPhone)) {
							JOptionPane.showMessageDialog(null, "Sorry, Phone number already exists.");
						} else {
							CourseManagementDao.instructor_add(textName, textPhone);
							textField.setText("");
							textField_1.setText("");
							boolean flag = CourseManagementDao.isInstructorNameAvailable(textName);
							if (flag) {
								CourseManagementDao.updateDuplicateInstructor(textName);
								JOptionPane.showMessageDialog(null,
										"Entries have been updated, because duplicate entries were found.");
							}
							updateTable();
						}
					} catch (Exception eadd) {
						JOptionPane.showMessageDialog(null, "Sorry, could not add the entry.");
					}
				}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});

		updateTable();
	}
}
