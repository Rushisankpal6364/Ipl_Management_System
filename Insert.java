package beans1;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int jerseyno = Integer.parseInt(request.getParameter("jerseyno"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String team = request.getParameter("team");
		String highestscore = request.getParameter("highestscore");
		String type = request.getParameter("type");
		
		
		Player p = new Player();
		
		p.setJerseyno(jerseyno);
		p.setName(name);
		p.setAge(age);
		p.setTeam(team);
		p.setHighestscore(highestscore);
		p.setType(type);
		
		int status = IplDao.insertData(p);
		
		if(status == 1) {
			System.out.println("<<---------Data Inserted------------->>");
		}else {
			System.out.println("<<---------Unable to insert Data------------>>");
		}
	}

}
