package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;

public class UserDao {

public static void saveUser(User user) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","Fani@2002");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into user(name,age,email,password,mobile) values(?,?,?,?,?)");
		preparedStatement.setString(1, user.getName());
		preparedStatement.setInt(2, user.getAge());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setLong(5, user.getMobile());
		preparedStatement.executeUpdate();
		connection.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static User fetchUserByEmailAndPassword(String email, String password) {
	    
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","Fani@2002");
		PreparedStatement preparedStatement=connection.prepareStatement("select * from user where email=? and password=?");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setAge(resultSet.getInt("age"));
			user.setEmail(email);
			user.setPassword(password);
			user.setMobile(resultSet.getLong("mobile"));
			return user;
			}
		connection.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return null;
}

public static User fetchUserById(int id) {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","Fani@2002");
	PreparedStatement preparedStatement=connection.prepareStatement("select * from user where id=?");
	preparedStatement.setInt(1, id);
	ResultSet resultSet = preparedStatement.executeQuery();
	if (resultSet.next()) {
	    User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setName(resultSet.getString("name"));
		user.setAge(resultSet.getInt("age"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		user.setMobile(resultSet.getLong("mobile"));
		return user;
		}
	connection.close();
	}
	catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} 
	return null;
}

public static  List<User> fetchAllUsers() {
   List<User> list= new ArrayList();       
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","Fani@2002");
	PreparedStatement preparedStatement=connection.prepareStatement("select * from user");
	ResultSet resultSet = preparedStatement.executeQuery();
	while (resultSet.next()) {
		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setName(resultSet.getString("name"));
		user.setAge(resultSet.getInt("age"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		user.setMobile(resultSet.getLong("mobile"));
		list.add(user);
	}
	connection.close();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	return list;
}

public static void UpdateUser(User user) {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","Fani@2002");
			PreparedStatement pst = con.prepareStatement("update user set name=?,age=?,email=?,mobile=? where id=?");
			pst.setString(1, user.getName());
			pst.setInt(2, user.getAge());
			pst.setString(3, user.getEmail());
			pst.setLong(4,user.getMobile());
			pst.setInt(5,user.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

public static void DeleteUser(int id) {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","Fani@2002");
			PreparedStatement pst = con.prepareStatement("DELETE FROM user WHERE id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

public static void updatePassword(int id,String password) {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","Fani@2002");
			PreparedStatement pst = con.prepareStatement("update user set password=? where id=?");
			pst.setString(1, password);
			pst.setInt(2, id);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
