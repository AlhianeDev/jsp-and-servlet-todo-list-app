package com.todo;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

public class TodoDao {
	
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
	
	public static int save_todo(Todo todo) {
		
		int status = 0;
		
		Connection connection = get_connection();
		
		try (
		
			PreparedStatement ps = connection.prepareStatement(
			
				"INSERT INTO Todos (title, is_checked, user_id) VALUES (?, ?, ?);"
					
			);
				
		) {
			
			ps.setString(1, todo.getTitle());
			
			ps.setBoolean(2, todo.getIs_checked());
			
			ps.setInt(3, todo.getUser_id());
			
			status = ps.executeUpdate();
			
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
		
		return status;
		
	}
	
	public static Todo get_todo_by_id(int id, int user_id) {
		
		Todo todo = null;
		
		Connection connection = get_connection();
		
		try (
		
			Statement statement = connection.createStatement();
				
			ResultSet rs = statement.executeQuery(
					
				"SELECT * FROM Todos WHERE id = " + "'" + id +
				
				"' AND user_id = " + "'" + user_id + "';"
					
			);
				
		) {
			
			if (rs.next()) {
				
				todo = new Todo(
						
					rs.getInt("id"),
					
					rs.getString("title"),
					
					rs.getString("createdAt"),
					
					rs.getBoolean("is_checked"),
					
					rs.getInt("user_id")
						
				);
				
			}
			
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
		
		return todo;
		
	}
	
	public static int update_todo(Todo todo) {
		
		int status = 0;
		
		Connection connection = get_connection();
		
		try (
		
			PreparedStatement ps = connection.prepareStatement(
			
				"UPDATE Todos SET title = ? WHERE id = ? AND user_id = ?;"  
					
			);
				
		) {
			
			ps.setString(1, todo.getTitle());
			
			ps.setInt(2, todo.getId());
			
			ps.setInt(3, todo.getUser_id());
			
			status = ps.executeUpdate();
			
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
		
		return status;
		
	}
	
	public static List<Todo> read_todos(int user_id) {
		
		List<Todo> todos = new ArrayList<Todo>();
		
		Connection connection = get_connection();
		
		try (
		
			Statement statement = connection.createStatement();
				
			ResultSet rs = statement.executeQuery(
				
				"SELECT * FROM Todos WHERE user_id = " + "'" + user_id + "'"
					
			);
				
		) {
			
			while (rs.next()) {
				
				Todo todo = new Todo (
				
					rs.getInt("id"),
					
					rs.getString("title"),
					
					rs.getString("createdAt"),
					
					rs.getBoolean("is_checked"),
					
					rs.getInt("user_id")
						
				);
				
				todos.add(todo);
				
			}
			
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
		
		return todos;
		
	}
	
	public static List<Todo> read_limit_todos(int user_id, int pageId, int total) {
		
		List<Todo> todos = new ArrayList<Todo>();
		
		Connection connection = get_connection();
		
		try (
		
			Statement statement = connection.createStatement(
			
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY
					
			);
				
			ResultSet rs = statement.executeQuery(
				
				"SELECT * FROM Todos WHERE user_id = " + "'" + user_id + "'" +
				
				" LIMIT " + (pageId > 1 ? ((pageId - 1) * total + 1) - 1 : pageId - 1) +
				
				", " + total
					
			);
				
		) {
			
			if (rs.next()) {
				
				rs.beforeFirst();
				
				while (rs.next()) {
					
					Todo todo = new Todo (
					
						rs.getInt("id"),
						
						rs.getString("title"),
						
						rs.getString("createdAt"),
						
						rs.getBoolean("is_checked"),
						
						rs.getInt("user_id")
							
					);
					
					todos.add(todo);
					
				}
			
			} else {
				
				return read_limit_todos(user_id, pageId - 1, total);
				
			}
			
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
		
		return todos;
		
	}
	
	public static int delete_todo(int id, int user_id) {
		
		int status = 0;
		
		Connection connection = get_connection();
		
		try (
		
			PreparedStatement ps = connection.prepareStatement(
			
				"DELETE FROM Todos WHERE id = ? AND user_id = ?;"
					
			);
				
		) {
			
			ps.setInt(1, id);
			
			ps.setInt(2, user_id);
			
			status = ps.executeUpdate();
			
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
		
		return status;
		
	}
	
	public static int check_todo(int id, int user_id) {
		
		int status = 0;
		
		Connection connection = get_connection();
		
		try (
		
			PreparedStatement ps = connection.prepareStatement(
			
				"UPDATE Todos SET is_checked = ? WHERE id = ? AND user_id = ?;"
					
			);
				
		) {
			
			ps.setBoolean(1, !is_checked(id, user_id));
			
			ps.setInt(2, id);
			
			ps.setInt(3, user_id);
			
			status = ps.executeUpdate();
			
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
		
		return status;
		
	}
	
	private static boolean is_checked(int id, int user_id) {
		
		boolean flag = false;
		
		Connection connection = get_connection();
		
		try (
		
			Statement statement = connection.createStatement();
				
			ResultSet rs = statement.executeQuery(
				
				"SELECT is_checked FROM Todos WHERE id = " + "'" + id + "'" +
				
				" AND user_id = " + "'" + user_id + "'"
					
			);
				
		) {
			
			if (rs.next()) flag = rs.getBoolean("is_checked");
			
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
