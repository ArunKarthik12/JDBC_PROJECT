package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import model.ProductModel;
import utility.ConnectionManager;

public class ProductDao extends GetConnection{

	Connection dbConn = null;
	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}

	public void storeprodRecordInDb(ArrayList<ProductModel> prodList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "insert into prodTable(id,name,code,price,quantity) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			for(ProductModel pm: prodList) {
				ps.setInt(1, pm.getid());
				ps.setString(2, pm.getname());
				ps.setString(3, pm.getcode());
				ps.setInt(4, pm.getprice());
				ps.setInt(5, (int) pm.getquantity());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println(" NEW PRODUCT HAS BEEN ADDED SUCCESSFULLY .!! ");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewProductTableRecord() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "Select * from prodTable";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			java.sql.ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (resultSet.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print(",  ");
			        String columnValue = resultSet.getString(i);
			        System.out.print(columnValue + " " + rsmd.getColumnName(i));
			    }
			    System.out.println("");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void DeleteProductTableRecord(int id) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "delete from prodTable where id = "+id;
		try {
			Statement stmt = dbConn.createStatement();
		    stmt.execute(sql);
			viewProductTableRecord();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateProductRecord(int option, int id, String newEmpDetail) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = null;
		if(option == 1) {
			sql = "update ProdTable set name = ? where id = ?";	
		}
		else if(option == 2) {
			sql = "update ProdTable set price = ? where id = ?";	
		}
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setString(1, newEmpDetail);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateProductRecord(int id, int newEmpExp) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "update ProdTable set quantity = ? where id = ?";	
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setInt(1, newEmpExp);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateProductRecord(int empId, double newEmpSalary) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "update Product set salary = ? where id = ?";	
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setDouble(1, newEmpSalary);
			ps.setInt(2, empId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
