package in.edu.tict.cse.courseM.view;

import java.awt.Color;
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
import javax.swing.ImageIcon;

public class Textbook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JToggleButton tglbtnNewToggleButton;
	JToggleButton tglbtnNewToggleButton_1;
	JToggleButton tglbtnNewToggleButton_2;
	JToggleButton tglbtnNewToggleButton_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private String entry_title;
	private String entry_author;
	private String entry_publisher;
	private int count = 0;
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
					Textbook frame = new Textbook();
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
			r = st.executeQuery("SELECT * FROM course_management.textbook_info");
			table.setModel(DbUtils.resultSetToTableModel(r));
			table.getColumnModel().getColumn(0).setWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(1).setHeaderValue("Title");
			table.getColumnModel().getColumn(2).setHeaderValue("Author Name");
			table.getColumnModel().getColumn(3).setHeaderValue("Publisher");
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

	public Textbook() {
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

		tglbtnNewToggleButton_3.setSelected(true);
		tglbtnNewToggleButton_3.setBackground(SystemColor.activeCaption);
		tglbtnNewToggleButton_3.setBounds(0, 237, 143, 37);
		panel.add(tglbtnNewToggleButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Textbook.class.getResource("/in/edu/tict/cse/courseM/icons/icons8-book-shelf-100.png")));
		lblNewLabel.setBounds(21, 10, 100, 100);
		panel.add(lblNewLabel);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(137, 0, 554, 576);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Textbook.class.getResource("/in/edu/tict/cse/courseM/icons/icons8-repeat-16.png")));
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
					entry_title = table.getModel().getValueAt(row, 1).toString();
					entry_author = table.getModel().getValueAt(row, 2).toString();
					entry_publisher = table.getModel().getValueAt(row, 3).toString();
					count++;
				}

			}
		});
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setBounds(375, 73, 131, 20);
		desktopPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(375, 130, 131, 20);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(375, 184, 131, 20);
		desktopPane.add(textField_2);
		textField_2.setColumns(10);
		JButton btnNewButton_1 = new JButton("Add Textbook");
		btnNewButton_1.setBounds(375, 229, 131, 25);
		desktopPane.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(375, 264, 131, 25);
		desktopPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setBounds(375, 299, 131, 25);
		desktopPane.add(btnNewButton_4);
		JLabel lblNewLabel_1 = new JLabel("Title :");
		lblNewLabel_1.setBounds(376, 49, 89, 14);
		desktopPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_2 = new JLabel("Author Name :");
		lblNewLabel_2.setBounds(375, 103, 89, 14);
		desktopPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_3 = new JLabel("Publisher :");
		lblNewLabel_3.setBounds(376, 160, 89, 14);
		desktopPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Textbooks :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(21, 8, 92, 25);
		desktopPane.add(lblNewLabel_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String id = table.getModel().getValueAt(row, 0).toString();
					String title = table.getModel().getValueAt(row, 1).toString();
					String author = table.getModel().getValueAt(row, 2).toString();
					String publisher = table.getModel().getValueAt(row, 3).toString();
					try {
						CourseManagementDao.textbook_delete(Integer.parseInt(id));
						JOptionPane.showMessageDialog(null, "The following entry has been deleted:\nTitle- " + title
								+ "\nAuthor- " + author + "\nPublisher- " + publisher);
						updateTable();
					} catch (Exception edel) {
						JOptionPane.showMessageDialog(null, "Deletion not successful!");
					}
					boolean deleted = CourseManagementDao.DeleteOtherCourses("textbook_info", "textbook_id");
					if (deleted == true) {
						JOptionPane.showMessageDialog(null,
								"Courses taught using " + title + " has also been deleted!");
					}
					count = 0;
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No row has been selected!No row has been selected!\n");
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
					String title_updated = table.getModel().getValueAt(row, 1).toString();
					String author_updated = table.getModel().getValueAt(row, 2).toString();
					String publisher_updated = table.getModel().getValueAt(row, 3).toString();
					CourseManagementDao.textbook_update(title_updated, author_updated, publisher_updated,
							Integer.parseInt(id));
					String change_st = "The following entry has been edited:\n";
					if (!title_updated.equals(entry_title))
						change_st += "Title: " + entry_title + " -> " + title_updated + "\n";
					if (!author_updated.equals(entry_author))
						change_st += "Author: " + entry_author + " -> " + author_updated;
					if (!publisher_updated.equals(entry_publisher))
						change_st += "Publisher: " + entry_publisher + " -> " + publisher_updated;
					if (title_updated.equals(entry_title) && author_updated.equals(entry_author)
							&& publisher_updated.equals(entry_publisher))
						change_st = "No changes have been made.";
					JOptionPane.showMessageDialog(null, change_st);
					if (CourseManagementDao.isTitleAvailable(title_updated)) {
						CourseManagementDao.updateDuplicateTextbook(title_updated);
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
					String textTitle = textField.getText();
					String textAuthor = textField_1.getText();
					String textPublisher = textField_2.getText();
					try {
						CourseManagementDao.textbook_add(textTitle, textAuthor, textPublisher);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						updateTable();
						if (CourseManagementDao.isTitleAvailable(textTitle)) {
							CourseManagementDao.updateDuplicateTextbook(textTitle);
							JOptionPane.showMessageDialog(null,
									"Entries have been updated, because duplicate entries were found.");
						}
						updateTable();
					} catch (Exception eadd) {
						JOptionPane.showMessageDialog(null, "Sorry, could not add the entry.");
					}
				}
			}
		});
		// table.setDefaultEditor(Object.class, null);
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				First window = new First();
				window.getFirstFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(571, 351, 89, 23);
		contentPane.add(btnNewButton);

		updateTable();
	}
}
