package in.edu.tict.cse.courseM.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import in.edu.tict.cse.courseM.dao.CourseManagementDao;
import in.edu.tict.cse.courseM.dbcon.ConnectionDb;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Course extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	JButton btnNewButton;
	JToggleButton tglbtnNewToggleButton;
	JToggleButton tglbtnNewToggleButton_1;
	JToggleButton tglbtnNewToggleButton_2;
	JToggleButton tglbtnNewToggleButton_3;
	private JTextField textField;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_3;

	Connection con = null;
	Statement st = null;
	ResultSet r = null;
	int count = 0;
	boolean clicked = false;
	String Cname = "", Iname = "", Tname = "";
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course frame = new Course();
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

	private void setBoxEmpty(JComboBox box) {
		box.setSelectedItem(null);
	}

	private void addcontentInstructor() {
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			r = st.executeQuery(
					"SELECT course_management.instructor_info.instructor_name,course_management.instructor_info.instructor_id FROM course_management.instructor_info;");
			while (r.next()) {
				try {
					comboBox.addItem(r.getString(1));
					comboBox_2.addItem(r.getString(2));
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data Loading failed!");
				}
			}
			setBoxEmpty(comboBox);
			setBoxEmpty(comboBox_2);
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

	private void addcontentTextbook() {
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			r = st.executeQuery("SELECT textbook_title,textbook_id FROM course_management.textbook_info");
			while (r.next()) {
				try {
					comboBox_1.addItem(r.getString(1));
					comboBox_3.addItem(r.getString(2));
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data Loading failed!");
				}
			}
			setBoxEmpty(comboBox_1);
			setBoxEmpty(comboBox_3);
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

	private void updateTable() {

		try {
			con = ConnectionDb.getConnection();
			CallableStatement cstmt = (CallableStatement) con.prepareCall("{call course_management.getCourseInfo()}");
			ResultSet r = cstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
			table.getColumnModel().getColumn(0).setWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(1).setHeaderValue("Course Name");
			table.getColumnModel().getColumn(2).setHeaderValue("Instructor");
			table.getColumnModel().getColumn(3).setHeaderValue("Textbook");
			table.getColumnModel().getColumn(4).setWidth(0);
			table.getColumnModel().getColumn(4).setMinWidth(0);
			table.getColumnModel().getColumn(4).setMaxWidth(0);
			table.getColumnModel().getColumn(5).setWidth(0);
			table.getColumnModel().getColumn(5).setMinWidth(0);
			table.getColumnModel().getColumn(5).setMaxWidth(0);
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

	/**
	 * Create the frame.
	 */
	public Course() {
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
		tglbtnNewToggleButton_1.setSelected(true);
		tglbtnNewToggleButton_1.setBackground(new Color(176, 196, 222));
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

		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(
				new ImageIcon(Course.class.getResource("/in/edu/tict/cse/courseM/icons/icons8-course-assign-100.png")));
		lblNewLabel_4.setBounds(21, 10, 100, 100);
		panel.add(lblNewLabel_4);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(141, 0, 554, 576);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				First window = new First();
				window.getFirstFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(571, 351, 89, 23);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 44, 328, 310);
		desktopPane.add(scrollPane);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Course.class.getResource("/in/edu/tict/cse/courseM/icons/icons8-repeat-16.png")));
		btnNewButton_2.setBounds(323, 9, 25, 25);
		desktopPane.add(btnNewButton_2);

		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			int row1, row2;
			String id, inst_id, text_id;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (clicked == false) {
					row1 = table.getSelectedRow();
					id = table.getModel().getValueAt(row1, 0).toString();
					Cname = table.getModel().getValueAt(row1, 1).toString();
					Iname = table.getModel().getValueAt(row1, 2).toString();
					Tname = table.getModel().getValueAt(row1, 3).toString();
					inst_id = table.getModel().getValueAt(row1, 4).toString();
					text_id = table.getModel().getValueAt(row1, 5).toString();
					// System.out.println("1::"+id+"-"+Cname+"-"+Iname+"-"+Tname);
					// System.out.println("upd1-
					// "+(Integer.parseInt(table.getModel().getValueAt(row2, 4).toString())-1));
					// System.out.println("upd2-
					// "+(Integer.parseInt(table.getModel().getValueAt(row2, 5).toString())-1));
					textField.setText(Cname);
					comboBox.setSelectedItem(Iname);
					comboBox_1.setSelectedItem(Tname);
					comboBox_2.setSelectedItem(inst_id);
					comboBox_3.setSelectedItem(text_id);
					/*
					 * comboBox.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(row1,
					 * 4).toString())-1);
					 * comboBox_1.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(
					 * row1, 5).toString())-1);
					 * comboBox_2.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(
					 * row1, 4).toString())-1);
					 * comboBox_3.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(
					 * row1, 5).toString())-1);
					 */
					btnNewButton.setEnabled(false);
					clicked = true;
				} else if (clicked == true) {
					row2 = table.getSelectedRow();
					if (row1 == row2) {
						table.clearSelection();
						textField.setText("");
						setBoxEmpty(comboBox);
						setBoxEmpty(comboBox_1);
						setBoxEmpty(comboBox_2);
						setBoxEmpty(comboBox_3);
						btnNewButton.setEnabled(true);
					} else {
						id = table.getModel().getValueAt(row2, 0).toString();
						Cname = table.getModel().getValueAt(row2, 1).toString();
						Iname = table.getModel().getValueAt(row2, 2).toString();
						Tname = table.getModel().getValueAt(row2, 3).toString();
						inst_id = table.getModel().getValueAt(row2, 4).toString();
						text_id = table.getModel().getValueAt(row2, 5).toString();
						textField.setText(Cname);
						comboBox.setSelectedItem(Iname);
						comboBox_1.setSelectedItem(Tname);
						comboBox_2.setSelectedItem(inst_id);
						comboBox_3.setSelectedItem(text_id);
						// System.out.println("upd1-
						// "+(Integer.parseInt(table.getModel().getValueAt(row2, 4).toString())-1));
						// System.out.println("upd2-
						// "+(Integer.parseInt(table.getModel().getValueAt(row2, 5).toString())-1));
						/*
						 * comboBox.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(row2,
						 * 4).toString())-1);
						 * comboBox_1.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(
						 * row2, 5).toString())-1);
						 * comboBox_2.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(
						 * row2, 4).toString())-1);
						 * comboBox_3.setSelectedIndex(Integer.parseInt(table.getModel().getValueAt(
						 * row2, 5).toString())-1);
						 */
						// System.out.println("2::"+id+"-"+Cname+"-"+Iname+"-"+Tname);
						btnNewButton.setEnabled(false);
					}
					clicked = false;
				}

			}
		});
		scrollPane.setViewportView(table);
		JLabel lblNewLabel = new JLabel("Courses :");
		lblNewLabel.setBounds(20, 9, 92, 25);
		desktopPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNewLabel_1 = new JLabel("Course Name :");
		lblNewLabel_1.setBounds(366, 57, 89, 14);
		desktopPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setBounds(366, 81, 131, 20);
		desktopPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Instructor :");
		lblNewLabel_2.setBounds(366, 111, 89, 14);
		desktopPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox = new JComboBox();
		comboBox.setBounds(366, 135, 131, 23);
		desktopPane.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Textbook :");
		lblNewLabel_3.setBounds(366, 168, 89, 14);
		desktopPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(366, 192, 131, 23);
		desktopPane.add(comboBox_1);

		btnNewButton = new JButton("Add Course");
		btnNewButton.setBounds(366, 246, 131, 23);
		desktopPane.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(366, 279, 131, 23);
		desktopPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setBounds(366, 312, 131, 23);
		desktopPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String id = table.getModel().getValueAt(row, 0).toString();
					String name = table.getModel().getValueAt(row, 1).toString();
					String instructor = table.getModel().getValueAt(row, 2).toString();
					String textbook = table.getModel().getValueAt(row, 3).toString();
					try {
						CourseManagementDao.course_delete(Integer.parseInt(id));
						JOptionPane.showMessageDialog(null, "The following entry has been deleted:\nName- " + name
								+ "\nInstructor- " + instructor + "\nTextbook- " + textbook);
						updateTable();
					} catch (Exception edel) {
						JOptionPane.showMessageDialog(null, "Deletion not successful!");
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
					String id = table.getModel().getValueAt(row, 0).toString();
					String name = textField.getText();
					String instructor = comboBox.getSelectedItem().toString();
					String textbook = comboBox_1.getSelectedItem().toString();
					int inst_id = Integer.parseInt(comboBox_2.getSelectedItem().toString());
					int text_id = Integer.parseInt(comboBox_3.getSelectedItem().toString());
					String change_st = "The following entry has been edited:\n";
					if (!name.equals(Cname))
						change_st += "Course: " + Cname + " -> " + name + "\n";
					if (!instructor.equals(Iname))
						change_st += "Instructor: " + Iname + " -> " + instructor + "\n";
					if (!textbook.equals(Tname))
						change_st += "Textbook: " + Tname + " -> " + textbook + "\n";
					if (name.equals(Cname) && instructor.equals(Iname) && textbook.equals(Tname))
						change_st = "No changes have been made.";
					JOptionPane.showMessageDialog(null, change_st);
					try {
						CourseManagementDao.course_update(Integer.parseInt(id), name, inst_id, text_id);
						updateTable();
					} catch (Exception edel) {
						JOptionPane.showMessageDialog(null, "Deletion not successful!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No row has been selected!");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Course name should not be empty!");
				} else {
					String course_name = textField.getText();
					int inst_id = Integer.parseInt(comboBox_2.getSelectedItem().toString());
					int text_id = Integer.parseInt(comboBox_3.getSelectedItem().toString());
					CourseManagementDao.course_add(course_name, inst_id, text_id);
					updateTable();
				}
			}
		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int b2 = comboBox_1.getSelectedIndex();
					if (comboBox_3.getSelectedItem() != null) {
						if (comboBox_1.getSelectedItem() != null) {
							comboBox_3.setSelectedIndex(b2);
						}
					} else if (comboBox_1.getSelectedItem() != null) {
						comboBox_3.setSelectedIndex(b2);
					}
				} catch (IllegalArgumentException ebox) {
				} catch (Exception ebox) {
					System.out.println(ebox);
				}

			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int b1 = comboBox.getSelectedIndex();
					if (comboBox_2.getSelectedItem() != null) {
						if (comboBox.getSelectedItem() != null) {
							comboBox_2.setSelectedIndex(b1);
						}
					} else if (comboBox.getSelectedItem() != null) {
						comboBox_2.setSelectedIndex(b1);
					}
				} catch (IllegalArgumentException ebox) {
				} catch (Exception ebox) {
					System.out.println(ebox);
				}
			}
		});

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(559, 94, 44, 23);
		contentPane.add(comboBox_2);
		comboBox_2.setVisible(false);
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(559, 151, 44, 23);
		contentPane.add(comboBox_3);
		comboBox_3.setVisible(false);
		addcontentInstructor();
		addcontentTextbook();
		updateTable();
	}
}
