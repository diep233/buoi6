package net.javaguides.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.login.bean.ThongTinHocSinh;

public class HocSinhDao {
    public List<ThongTinHocSinh> layDanhSachHocSinh(String username) throws ClassNotFoundException {
	boolean status = false;
	List<ThongTinHocSinh> lst = new ArrayList<ThongTinHocSinh>();

	Class.forName("com.mysql.jdbc.Driver");

	try (Connection connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3307/mysql_database?useSSL=false", "root", "diep");

		// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection
			.prepareStatement("select * from thongtinhocsinh where username = ?")) {
	    preparedStatement.setString(1, username);

	    System.out.println(preparedStatement);
	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {

		String hovaten = rs.getString("hovaten");
		String lop = rs.getString("lop");

		ThongTinHocSinh thongTinHocSinh = new ThongTinHocSinh(hovaten, lop);

		lst.add(thongTinHocSinh);
	    }

	} catch (SQLException e) {
	    // process sql exception
	    printSQLException(e);
	}
	return lst;
    }

    public Boolean themHocSinh(ThongTinHocSinh thongTinHocSinh) throws ClassNotFoundException {
	boolean status = false;

	Class.forName("com.mysql.jdbc.Driver");

	try (Connection connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3307/mysql_database?useSSL=false", "root", "diep");

		// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection
			.prepareStatement("insert into thongtinhocsinh values(?, ?, ?)")) {
	    preparedStatement.setString(3, thongTinHocSinh.getLop());

	    System.out.println(preparedStatement);
	    ResultSet rs = preparedStatement.executeQuery();

	    status = rs.next();

	} catch (SQLException e) {
	    // process sql exception
	    printSQLException(e);
	}
	return status;
    }

    private void printSQLException(SQLException ex) {
	for (Throwable e : ex) {
	    if (e instanceof SQLException) {
		e.printStackTrace(System.err);
		System.err.println("SQLState: " + ((SQLException) e).getSQLState());
		System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
		System.err.println("Message: " + e.getMessage());
		Throwable t = ex.getCause();
		while (t != null) {
		    System.out.println("Cause: " + t);
		    t = t.getCause();
		}
	    }
	}
    }
}
