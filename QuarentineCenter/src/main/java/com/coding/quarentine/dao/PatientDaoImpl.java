package com.coding.quarentine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.coding.quarentine.models.Patient;
import com.coding.quarentine.utility.DbConnection;

public class PatientDaoImpl implements PatientDao {
	public Patient addPatient(String name, int age, int centerId) {
		Connection con = DbConnection.getConnection();
		Patient patient= null;
		String query="INSERT INTO patients(patient_name, patient_age, center_id) VALUES(?,?,?)";
		PreparedStatement pstmt =null;
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, centerId);
			pstmt.executeUpdate();
			
			patient= new Patient(name, age, centerId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return patient;
		
	}
}
