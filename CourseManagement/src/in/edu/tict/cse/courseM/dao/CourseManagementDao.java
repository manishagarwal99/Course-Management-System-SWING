package in.edu.tict.cse.courseM.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import in.edu.tict.cse.courseM.dbcon.ConnectionDb;

public class CourseManagementDao {
	//Instructor
	/**
	 * Inserts Instructor info into the table instructor_info.
	 * 
	 * @param Name for storing Instructor's Name.
	 *
	 * @param Phone for storing Phone no. of Instructor.
	 *
	 * @return {@code "success"} if insertion is successful or else {@code "failure"} if it is not.
	 * 
	 */
	public static String instructor_add(String Name, String Phone) {
		Connection con = null;
		Statement st = null;
		String result = "";

		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			st.executeUpdate("INSERT INTO `course_management`.`instructor_info` (`instructor_name`, `instructor_phone`) VALUES ('" + Name
					+ "', '" + Phone + "');");
			result = "success";
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e.printStackTrace();
			result = "failure";
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
		return result;
	}
	public static String instructor_del(int ID) {
		Connection con = null;
		Statement st = null;
		String result = "";

		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			st.executeUpdate("DELETE FROM course_management.instructor_info WHERE instructor_id = " + ID);
			result = "success";
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");

			e.printStackTrace();
			result = "failure";
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
		return result;
	}
	public static String instructor_update(String Name, String phone,int ID) {
		Connection con = null;
		Statement st = null;
		String result = "";

		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			st.executeUpdate(
					"UPDATE course_management.instructor_info SET instructor_name = '" + Name + "', instructor_phone = '" + phone
					+"' WHERE instructor_id = " + ID);
			result = "success";
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");

			e.printStackTrace();
			result = "failure";
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
		return result;
	}
	public static boolean isPhoneAvailable(String phNo) {
		Connection con= null;
		Statement st = null;
		
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			ResultSet r = st.executeQuery("SELECT * FROM course_management.instructor_info where instructor_phone='"+phNo+"'");
			int c = 0;
			while(r.next())
				c++;
			if (c==0) 
				return false ;
			else
				return true;
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
		return false;

	}
	public static boolean isInstructorNameAvailable(String name) {
		Connection con= null;
		Statement st = null;
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			ResultSet r = st.executeQuery("SELECT * FROM course_management.instructor_info where instructor_name='"+name+"'");
			int c = 0;
			while(r.next())
				c++;
			if (c==1||c==0) 
				return false;
			else
				return true;
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
		return false;
	}
	public static void updateDuplicateInstructor(String name) {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			st.executeUpdate("update course_management.instructor_info set instructor_name=concat(concat(course_management.instructor_info.instructor_name,'('),concat('id:',concat(course_management.instructor_info.instructor_id,')'))) where instructor_name='"+name+"'");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");

			e.printStackTrace();
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
	
	//textbook
	public static void textbook_add(String Title, String Author, String Publisher) {
		Connection con = null;
		Statement st = null;
		try {
			con=ConnectionDb.getConnection();
			st = con.createStatement();
			int r = st.executeUpdate("INSERT INTO course_management.textbook_info (textbook_title, textbook_author, textbook_publisher) VALUES ('"+Title+"', '"+Author+"', '"+Publisher+"');");
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e.printStackTrace();
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
	public static void textbook_delete(int id) {
		Connection con = null;
		Statement st = null;
		try {
			con=ConnectionDb.getConnection();
			st = con.createStatement();
			int r = st.executeUpdate("DELETE FROM course_management.textbook_info WHERE textbook_id ="+id);
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e.printStackTrace();
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
	public static String textbook_update(String Title,String Author, String Publisher,int ID) {
		Connection con = null;
		Statement st = null;
		String result = "";
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			st.executeUpdate("UPDATE course_management.textbook_info SET textbook_title = '"+Title+"',textbook_author = '"+Author+"', textbook_publisher ='"+Publisher+"' WHERE textbook_id = "+ID);
			result = "success";
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");

			e.printStackTrace();
			result = "failure";
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
		return result;
	}
	public static boolean isTitleAvailable(String Title){
		Connection con= null;
		Statement st = null;
		
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			ResultSet r = st.executeQuery("SELECT * FROM course_management.textbook_info where textbook_title='"+Title+"'");
			int c = 0;
			while(r.next())
				c++;
			if (c==0||c==1) 
				return false ;
			else
				return true;
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
		return false;

	}
	public static void updateDuplicateTextbook(String Textbook) {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			st.executeUpdate("update course_management.textbook_info set textbook_title=concat(concat(course_management.textbook_info.textbook_title,'('),concat('id:',concat(course_management.textbook_info.textbook_id,')'))) where textbook_title='"+Textbook+"'");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");

			e.printStackTrace();
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
	
	//Course
	public static void course_delete(int id) {
		Connection con = null;
		Statement st = null;
		try {
			con=ConnectionDb.getConnection();
			st = con.createStatement();
			int r = st.executeUpdate("DELETE FROM course_management.course_info WHERE course_id ="+id);
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e.printStackTrace();
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
	public static void course_add(String course_name,int inst_id,int text_id) {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectionDb.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"INSERT INTO course_management.course_info (`course_name`, `instructor_id`, `textbook_id`) VALUES (?,?,?)");
			pst.setString(1,course_name);
			pst.setInt(2,inst_id);
			pst.setInt(3,text_id);
			pst.executeUpdate();
		} catch (SQLException e12) {
			JOptionPane.showMessageDialog(null, "Data entry failed!");
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
	public static String course_update(int course_id,String Cname,int inst_id,int text_id) {
		Connection con = null;
		Statement st = null;
		String result = "";
		try {
			con = ConnectionDb.getConnection();
			st = con.createStatement();
			st.executeUpdate("UPDATE course_management.course_info SET course_name = '"+Cname+"',instructor_id = "+inst_id+", textbook_id ="+text_id+" WHERE course_id= "+course_id);
			result = "success";
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");

			e.printStackTrace();
			result = "failure";
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
		return result;
	}
	public static boolean DeleteOtherCourses(String table_name,String column_name)
	{
		Connection con=null;
		Statement st=null;
		Statement st1=null;
		ArrayList <Integer> Id=new ArrayList<Integer>();
		ArrayList <Integer> table_id=new ArrayList<Integer>();
		ArrayList <Integer> current_table_id=new ArrayList<Integer>();
		try {
			con=ConnectionDb.getConnection();
			st = con.createStatement();
			ResultSet r = st.executeQuery("Select course_id,"+column_name+" from course_management.course_info");
			while(r.next()) {
				Id.add(r.getInt(1));
				table_id.add(r.getInt(2));
			}
			st1=con.createStatement();
			ResultSet r1=st1.executeQuery("Select "+column_name+" from "+table_name);
			while(r1.next())
			{
				current_table_id.add(r1.getInt(1));
			}
			System.out.println(Id+"\n"+table_id+"\n"+current_table_id);
			int count=0;
			for(int i=0;i<table_id.size();i++)
			{
				if(!current_table_id.contains(table_id.get(i)))
				{
					System.out.println(Id.get(i));
					count++;
					int r2=st1.executeUpdate("DELETE FROM course_management.course_info WHERE course_id ="+Id.get(i));
				}
			}
			if(count!=0)
				return true;
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e.printStackTrace();
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
		return false;
	}
}
