package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.QuestionBean;
import com.mvc.dao.AnswerFeedbackDao;

@WebServlet("/AnswerFeedbackServlet")
public class AnswerFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AnswerFeedbackServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionBean Qb=(QuestionBean) request.getSession().getAttribute("ques");
		String user_name=(String) request.getSession().getAttribute("username");
		String ans=request.getParameter("answer");
		String res="";
		
		if(ans.equalsIgnoreCase(Qb.getAnswer()))
		{
			AnswerFeedbackDao dao=new AnswerFeedbackDao();
			res=dao.submitAnswer(Qb, user_name);
			Qb.setFeedback("Congratulations!");
			request.getSession().setAttribute("ques_feedback", Qb);
			request.getSession().setAttribute("uans", ans);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/solve-question-feedback.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			Qb.setFeedback("Incorrect Answer. Try Again!");
			request.getSession().setAttribute("ques_hint", Qb);
			request.getSession().setAttribute("uans", ans);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/solve-question-hint.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		
		
		
		
	}

}
