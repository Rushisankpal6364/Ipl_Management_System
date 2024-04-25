package beans1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class IplDao {

	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/IPL","root","Rushikesh@123");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return con;
		
	}
	
	public static int insertData(Player p) {
		int status = 0;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("Insert into IPLmgmt(jerseyno,name,age,team,highestscore,type) values(?,?,?,?,?,?)");
			
			ps.setInt(1, p.getJerseyno());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getAge());
			ps.setString(4, p.getTeam());
			ps.setString(5, p.getHighestscore());
			ps.setString(6, p.getType());
		
			status = ps.executeUpdate();
			
		}catch (SQLException w1) {
			// TODO Auto-generated catch block
			w1.printStackTrace();
		}
		return status;
		
	}
	
	public static List<Player> getAllPlayers() {
		Connection con = getConnection();
		List<Player>list = new ArrayList<Player>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from IPLmgmt");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Player p = new Player();
				p.setId(rs.getInt("id"));
				p.setJerseyno(rs.getInt("jerseyno"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setTeam(rs.getString("team"));
				p.setHighestscore(rs.getString("highestscore"));
				p.setType(rs.getString("type"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public static int DeleteData(int id) {
		
		int status = 0;
		PreparedStatement ps;
		
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("Delete from IPLmgmt where id=?");
			ps.setInt(1, id);
		    status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
	public static Player getPlayer(int id) {
		Connection con = getConnection();
		Player p = new Player();
		PreparedStatement ps;
		
		try {
			 ps = con.prepareStatement("Select * from IPLmgmt where id=?");
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 p.setId(rs.getInt("id"));
				 p.setJerseyno(rs.getInt("jerseyno"));
				 p.setName(rs.getString("name"));
				 p.setAge(rs.getInt("age"));
				 p.setTeam(rs.getString("team"));
				 p.setHighestscore(rs.getString("highestscore"));
				 p.setType(rs.getString("type"));
				 
			 }
		}catch (SQLException p1) {
			// TODO Auto-generated catch block
			p1.printStackTrace();
	}return p;
}
	
	
	public static int UpdatePlayer(int jerseyno, String name, int age, String team, String highestscore, String type, int id) {
		int status = 0;
		PreparedStatement ps;
		
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("Update IPLmgmt set jerseyno=?,name=?,age=?,team=?,highestscore=?,type=? where id=?");
			ps.setInt(1, jerseyno);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, team);
			ps.setString(5, highestscore);
			ps.setString(6, type);
			ps.setInt(7, id);
		    status = ps.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
}
