package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DatabaseAccessObject;

import vo.ValueObject;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		List ls=null;
		DatabaseAccessObject dao=new DatabaseAccessObject();
		ValueObject vo=new ValueObject();
		HttpSession session=request.getSession();
		
		if(flag.equals("search")){
			
			ls=dao.search();
			session.setAttribute("lssearch_intro",ls);
			response.sendRedirect(request.getContextPath()+"/userInput/searchIntro.jsp");
		}
		if(flag.equals("edit")){
			
			int id=Integer.parseInt(request.getParameter("id"));
			vo.setPersonId(id);
			ls=dao.edit(vo);
			session.setAttribute("lssearch_edit",ls);
			response.sendRedirect(request.getContextPath()+"/userInput/editIntro.jsp");
		}
		if(flag.equals("delete")){
			int id=Integer.parseInt(request.getParameter("id"));
			vo.setPersonId(id);
			System.out.println("DELETE PERSON ID : "+vo.getPersonId());
			dao.delete(vo);
			response.sendRedirect(request.getContextPath()+"/Controller?flag=search");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("POST method invocked !!!!");
		String flag=request.getParameter("flag");
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		
		ValueObject vo=new ValueObject();
		DatabaseAccessObject dao=new DatabaseAccessObject();
		
		if(flag.equals("insert")){
			vo.setFirstName(fname);
			vo.setLastName(lname);
			dao.insert(vo);
			response.sendRedirect(request.getContextPath()+"/Controller?flag=search");
		}
		if(flag.equals("update")){
			int id=Integer.parseInt(request.getParameter("id"));
			vo.setPersonId(id);
			vo.setFirstName(fname);
			vo.setLastName(lname);
			dao.update(vo);
			response.sendRedirect(request.getContextPath()+"/Controller?flag=search");
		}
	}
}
