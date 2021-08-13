package com.project.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.entity.Transaction;
import com.project.entity.TxnType;
import com.project.repository.TransactionRepository;
import com.project.repository.TransactionRepositoryImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns= {"/history"})
public class HistoryController extends HttpServlet{
	
	private TransactionRepository transactionRepository;
	
	String account;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		transactionRepository = new TransactionRepositoryImpl();
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{

		HttpSession httpsession= req.getSession(false);
		if(httpsession !=null) {
		String filter=req.getParameter("filter");
		
		List<Transaction> transactions=new ArrayList<>();
		
		if(filter == null || filter.equals("all")) {
			transactions=transactionRepository.getTransaction();
		}
		if(filter!=null) {
		if(filter.equals("top10")) {
			transactions=transactionRepository.getTransactionByLimit(10);
		}

		if(filter.equals("credit") || filter.equals("debit")) {
			transactions=transactionRepository.getTransactionType(TxnType.valueOf(filter.toUpperCase()));
		}
		}
		
		//account=req.getParameter("account");
		//List<Transaction> transactions=transactionRepository.getTransaction(account);
		req.setAttribute("transactions", transactions);
		req.getRequestDispatcher("/WEB-INF/history.jsp").forward(req, res);		
		}
		else {
			res.sendRedirect("login.html");
		}
	}
}
