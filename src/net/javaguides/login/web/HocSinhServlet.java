package net.javaguides.login.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.login.bean.LoginBean;
import net.javaguides.login.bean.ThongTinHocSinh;
import net.javaguides.login.database.HocSinhDao;
import net.javaguides.login.database.LoginDao;

@WebServlet("/themhocsinh")
public class HocSinhServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    private HocSinhDao hocSinhDao;

    @Override
    public void init() {
	loginDao = new LoginDao();
	hocSinhDao = new HocSinhDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	LoginBean loginBean = new LoginBean();
	loginBean.setUsername(username);
	loginBean.setPassword(password);

	try {
	    if (loginDao.validate(loginBean)) {
		// HttpSession session = request.getSession();
		// session.setAttribute("username",username);
		List<ThongTinHocSinh> lst = hocSinhDao.layDanhSachHocSinh(username);
		request.setAttribute("lst", lst);
		request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
	    } else {
		HttpSession session = request.getSession();
		// session.setAttribute("user", username);
		// response.sendRedirect("login.jsp");
	    }
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String ten = request.getParameter("ten");
	String hovatendem = request.getParameter("hovatendem");
	String lop = request.getParameter("lop");

    }
}
