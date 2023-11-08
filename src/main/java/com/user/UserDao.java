package com.user;

import java.io.IOException;

import java.io.InputStream;

import java.io.UnsupportedEncodingException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Base64;

import jakarta.servlet.http.Part;

public class UserDao {
	
	private static Connection get_connection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(
				
				"jdbc:mysql://localhost:3306/just_do_it_todo_list_app",
				
				"root",
				
				"M64K66L98A01x"
					
			);
			
		} catch (ClassNotFoundException | SQLException ex) {
			
			System.err.println(ex.getMessage());
			
		}
		
		return connection;
		
	}
	
	public static int sign_up(User user, Part part) {
		
		int status = 0;
		
		Connection connection = get_connection();
		
		try (
				
			PreparedStatement ps = connection.prepareStatement(
					
				"INSERT INTO Users (full_name, prof_pic, username, password) "
				
				+ "VALUES (?, ?, ?, ?);"
						
			);
				
		) {
			
			if (!is_username_already_exists(user.getUsername())) {
				
				ps.setString(1, user.getFull_name());
				
				if (part != null) {
					
					InputStream is = part.getInputStream();
					
					ps.setBlob(2, is);
					
				}
				
				ps.setString(3, user.getUsername());
				
				ps.setString(4, user.getPassword());
				
				status = ps.executeUpdate();
				
			} else {
				
				status = -1;
				
			}
			
		} catch (SQLException | IOException ex) {
			
			System.err.println(ex.getMessage());
			
		}
		
		return status;
		
	}
	
	public static User sign_in(String username, String password) {
		
		User user = null;
		
		Connection connection = get_connection();
		
		try (
				
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(
				
				"SELECT * FROM Users WHERE username = " + "'" + username + "'" +
				
				" AND password = " + "'" + password + "';"
					
			);
				
		) {
			
			if (resultSet.next()) {
				
				byte data [] = resultSet.getBytes("prof_pic");
				
				String imageBt = new String(Base64.getEncoder().encode(data), "UTF-8");
				
				user = new User(
						
					resultSet.getInt("id"),
					
					resultSet.getString("full_name"),
					
					imageBt,
					
					resultSet.getString("username"),
					
					resultSet.getString("password")
						
				);
				
			}
			
		} catch (SQLException | UnsupportedEncodingException ex) {
			
			System.err.println(ex.getMessage());
			
		}
		
		return user;
		
	}
	
	private static boolean is_username_already_exists(String username) {
		
		boolean flag = false;
		
		Connection connection = get_connection();
		
		try (
				
				Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery(
					
					"SELECT username FROM Users WHERE username = " +
					
					"'" + username + "';"
						
				);
				
		) {
			
			if (resultSet.next()) flag = true;
			
		} catch (SQLException ex) {
			
			System.err.println(ex.getMessage());
			
		} finally {
			
			if (connection != null)
				
				try {
					
					connection.close();
					
				} catch (SQLException ex) {

					System.err.println(ex.getMessage());
					
				}
			
		}
		
		return flag;
		
	}

}
