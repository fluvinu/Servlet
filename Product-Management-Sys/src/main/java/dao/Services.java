package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import dto.Product;

public class Services {
	public List<Product> displayAllProduct() {
		List<Product> p= new ArrayList();
		Connection con= GetConn.conn;
		String q= "select * from product_info";
		try {
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name= rs.getString(2);
				double price = rs.getDouble(3);
				String type = rs.getString(4);
				Product pro= new Product(id,name,price,type);
				p.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
	}
	
	public int deleteProduct(int id ) {
		Connection conn= GetConn.conn;
		int n=0;
		String deleQ="delete from product_info where product_id="+id+";";
			Statement stmt;
			try {
				stmt = conn.createStatement();
				n =stmt.executeUpdate(deleQ);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return n;
		
	}

	public int insert(Product p) {
		Connection conn= GetConn.conn;
		int re=0;
		String qury="insert into product_info values(?,?,?,?);";
		
		try {
			PreparedStatement pstmt= conn.prepareStatement(qury);
			pstmt.setInt(1, p.getpId());
			pstmt.setString(2,p.getpName() );
			pstmt.setDouble(3, p.getPrice());
			pstmt.setString(4, p.getType());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return re;
	}
	
	public int updateProduct(Product p) {
		Connection conn=GetConn.conn;
		int n = 0 ;
		String quar="update product_info set product_name= ?,product_price=?,product_type=? where product_id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(quar);
			pstmt.setString(1, p.getpName());
			pstmt.setDouble(2, p.getPrice());
			pstmt.setString(3, p.getType());
			pstmt.setInt(4, p.getpId());
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
}
