package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Serveces {
	Connection conn= GetConnection.conn;
	public Food getFoodById(String id) {
		
		String quary = "select * from indian_food where id=?";
		
		Food fod=new Food();
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(quary);
			pstmt.setString(1,id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				fod.setFoodId(rs.getInt(1));
				fod.setFoodName(rs.getString(2));
				fod.setFoodIngredients(rs.getString(3));
				fod.setFoodDiet(rs.getString(4));
				fod.setPreptime(rs.getInt(5));
				fod.setCookTime(rs.getInt(6));
				fod.setFlavorProfile(rs.getString(7));
				fod.setFoodCourse(rs.getString(8));
				fod.setState(rs.getString(9));
				fod.setRegion(rs.getString(10));
				
				return fod;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fod;
		
	}
	
	public String deletePro(String id) {
		int n =0;
//		Connection con= GetConnection.conn;
		String Quary = "delete from indian_food where id="+id+";";
		try {
			Statement stmt = conn.createStatement();
			 n =stmt.executeUpdate(Quary);
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "delete ho gya "+n+" updaete hui ";
	}

	public List<Food> getFood() {
		List<Food> foodList=new ArrayList();

		String qury= "select id,name,diet from indian_food";
		
		
		
		try {
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(qury);
			
			while(rs.next()) {
				int id =rs.getInt(1);
				String name=rs.getString(2);
				String diet= rs.getString(3);
				
				Food food= new Food();
				food.setFoodId(id);
				food.setFoodName(name);
				food.setFoodDiet(diet);
				
				foodList.add(food);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodList;
	}

	public int updateFood(Food newfood) {
		String quary="update indian_food set name= '"
				+newfood.getFoodName()+"', ingredients='"+newfood.getFoodIngredients()+"', diet='"+newfood.getFoodDiet()+"', prep_time="+newfood.getPreptime()+", cook_time="+newfood.getCookTime()+", flavor_profile= '"+newfood.getFlavorProfile()+"', course='"+newfood.getFoodCourse()+"', state='"+newfood.getState()+"' where id="+newfood.getFoodId()  ;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			int n  = stmt.executeUpdate(quary);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}
	
	
	
}
