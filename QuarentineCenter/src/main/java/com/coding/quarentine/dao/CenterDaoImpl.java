package com.coding.quarentine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coding.quarentine.exceptions.DuplicateNameException;
import com.coding.quarentine.models.Center;
import com.coding.quarentine.utility.DbConnection;

public class CenterDaoImpl implements CenterDao {

	public Center addCenter(String place, int strength) throws DuplicateNameException {
		if (duplicateCenter(place)) {
			throw new DuplicateNameException("The Center Name already exits, try other");
		}
		Connection con = DbConnection.getConnection();
		Center center = null;
		String query = "INSERT INTO centers(center_place, center_strength) VALUES(?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, place);
			pstmt.setInt(2, strength);
			pstmt.executeUpdate();

			center = new Center(place, strength);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return center;
	}

	public boolean duplicateCenter(String place) {
		try(Connection con = DbConnection.getConnection();Statement stmt = con.createStatement();){
			String query = "SELECT * FROM centers WHERE center_place='" + place + "'";
			try (ResultSet rs= stmt.executeQuery(query)){
				if (rs.next()) {
					return true;
				} else {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		return false;

	}

	@Override
	public Center updateCenter(int updateId, String updatedPlace, int updatedStrength) throws DuplicateNameException {
		if (duplicateCenter(updatedPlace)) {
			throw new DuplicateNameException("The Center Name already exits, try other");
		}
		Connection con = DbConnection.getConnection();
		Center center = null;
		String query = "UPDATE centers SET center_place=?, center_strength=? WHERE center_id=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, updatedPlace);
			pstmt.setInt(2, updatedStrength);
			pstmt.setInt(3, updateId);
			pstmt.executeUpdate();

			center = new Center(updatedPlace, updatedStrength);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return center;
	}

	@Override
	public void deleteCenter(int deleteId) {
		Connection con = DbConnection.getConnection();
		String query = "DELETE FROM centers WHERE center_id=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,deleteId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 
	public List<Center> getCenters() {
		Connection con = DbConnection.getConnection();
		String query = "SELECT * FROM centers ";
		Statement stmt = null;
		ResultSet rs = null;
		List<Center> centers = new ArrayList<Center>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("center_id");
				String name = rs.getString("center_place");
				int strength = rs.getInt("center_strength");
				Center center= new Center(id, name, strength);
				centers.add(center);
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return centers;

	}


}
