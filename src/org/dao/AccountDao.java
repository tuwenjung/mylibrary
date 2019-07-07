package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.conn.DBConn;
import org.module.Account;

public class AccountDao implements Dao<Account> {
	/* (non-Javadoc)
	 * @see org.dao.Dao#get(java.lang.String, java.lang.String)
	 */
	
	public Account get(String name,String password) {
		Connection conn=DBConn.get();
		String sql = "SELECT * FROM account WHERE name=? AND password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name );
			ps.setString(2, password);
			ResultSet  rs=ps.executeQuery();
			if(rs.next()) {
				return new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getByte(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/* (non-Javadoc)
	 * @see org.dao.Dao#add(org.module.Account)
	 */
	@Override
	public int add(Account ac) {
		Connection conn=DBConn.get();
		String sql = "INSERT INTO account(name,password,role) VALUES(?,?,?)";
		int rowCount=0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,ac.getName() );
			ps.setString(2, ac.getPassword());
			ps.setByte(3, ac.getRole());
			rowCount=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	@Override
	public int update(Account ac) {
		Connection conn=DBConn.get();
		String sql = "UPDATE account SET name=?,password=?,role=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,ac.getName() );
			ps.setString(2, ac.getPassword());
			ps.setByte(3, ac.getRole());
			ps.setInt(4, ac.getId());
			int s=ps.executeUpdate();
			return s;
		} catch (SQLException e) {
			
		}
		return 0;
		
	}
	/* (non-Javadoc)
	 * @see org.dao.Dao#del(int)
	 */
	@Override
	public int del(int id) {
		Connection conn=DBConn.get();
		String sql = "DELETE FROM account WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);	
			int s=ps.executeUpdate();
			return s;
		} catch (SQLException e) {
			
		}
		return 0;
		
	}

	public static void main(String[] args) {
		Dao<Account> dao=new AccountDao();
		Account ac;
		//�s
		ac=new Account("candy", "1234",(byte) 1);
		System.out.println(dao.add(ac));
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		sc.nextLine();
		//�d
//		ac=dao.get("candy", "1234");
//		System.out.println(ac.getRole());
//		sc.nextLine();
		//��
//		ac.setName("John");
//		System.out.println(dao.update(ac));
//		System.out.println(dao.get("John","1234").getName());
//		sc.nextLine();
		//�R
//		System.out.println(dao.del(ac.getId()));
	}
	@Override
	public Account get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
