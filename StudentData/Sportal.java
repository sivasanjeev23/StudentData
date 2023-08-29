package practice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Sportal {
	Connection con;
	public Sportal() throws SQLException {
		con=Dbconnect.dbCon();}
	public int add(int regno,String name,String date,String gender,String course,int fees) throws SQLException {
		int r=0;
		PreparedStatement pst=con.prepareStatement("insert into students values(?,?,?,?,?,?)");
		pst.setInt(1, regno);
		pst.setString(2,name);
		pst.setString(3,date);
		pst.setString(4, gender);
		pst.setString(5, course);
		pst.setInt(6,fees);
		r=pst.executeUpdate();
		return r;}
	public int edit(int regno,float fees) throws SQLException {
		int r=0;
		PreparedStatement pst1=con.prepareStatement("select fees from students where regno=?");
		pst1.setInt(1, regno);
		ResultSet rs=pst1.executeQuery();int fee=0;
		if(rs.next()) {fee=rs.getInt("fees");}
		if(fee<fees) {
		PreparedStatement pst=con.prepareStatement("update students set fees=? where regno=?");
		pst.setFloat(1,fees);pst.setInt(2,regno);r=pst.executeUpdate();
		}
		return r;
	}
	public void view() throws SQLException {
		PreparedStatement pst=con.prepareStatement("Select * from students");
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			int regno=rs.getInt("regno");
			String name=rs.getString("name");
			Date dob=rs.getDate("dob");
			String gender=rs.getString("gender");
			String course=rs.getString("course");
			int fees=rs.getInt("fees");
			System.out.println(regno+"\t"+name+"\t"+dob+"\t"+gender+"\t"+course+"\t"+fees);
		}
	}
	public int remove(int regno) throws SQLException {
		int r=0;
		PreparedStatement pst=con.prepareStatement("Delete from students where regno=?");
		pst.setInt(1, regno);
		r=pst.executeUpdate();
		return r;
	}
}
