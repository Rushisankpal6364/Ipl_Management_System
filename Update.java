package beans1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int jerseyno = Integer.parseInt(request.getParameter("jerseyno"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String team = request.getParameter("team");
		String highestscore = request.getParameter("highestscore");
		String type = request.getParameter("type");
		
		int status = IplDao.UpdatePlayer(jerseyno, name, age, team, highestscore, type, id);
		
		if(status == 1) {
			response.sendRedirect("display.jsp");
		}else {
			response.sendRedirect("index.html");
		}
	}

}
