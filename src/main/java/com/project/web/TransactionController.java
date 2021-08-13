package com.project.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.repository.AccountRepository;
import com.project.repository.AccountRepositoryImpl;
import com.project.repository.TransactionRepository;
import com.project.repository.TransactionRepositoryImpl;
//import com.project.repository.AccountRepositoryImpl;
import com.project.service.TransferService;
import com.project.service.TransferServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/recent-transaction" })
public class TransactionController extends HttpServlet {
	TransferService transferService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		AccountRepository accountRepository = new AccountRepositoryImpl();
		TransactionRepository transactionRepository = new TransactionRepositoryImpl();
		transferService = new TransferServiceImpl(accountRepository, transactionRepository);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = req.getSession(false);
		if (httpSession != null) {
			req.getRequestDispatcher("/WEB-INF/txr-form.jsp").forward(req, res);
		} else {
			res.sendRedirect("login.html");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession httpSession = req.getSession(false);
		if (httpSession != null) {

			String from_ac = req.getParameter("from_ac");
			String to_ac = req.getParameter("to_ac");
			double amount = Double.parseDouble(req.getParameter("amount"));

			transferService.transfer(amount, from_ac, to_ac);
			req.setAttribute("message", "transaction done");
			req.getRequestDispatcher("/WEB-INF/txr-status.jsp").forward(req, res);
			
		} else {
			res.sendRedirect("login.html");
		}

	}

}
