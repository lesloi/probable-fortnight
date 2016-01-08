package jdbc;

import java.sql.*;
import java.util.ArrayList;

import forms.Convention;

public class JDBC_Convention extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Convention";
	static final String SQL_INSERT = "INSERT INTO Convention(idSt, idEtu, approbationCommission, approbationDirecteur, approbationEntreprise, approbationEtudiant) VALUES (?, ?, ?, ?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE Convention SET idSt = ?, idEtu = ?, approbationCommission = ?, approbationDirecteur = ?, approbationEntreprise = ?, approbationEtudiant = ?";
	static final String SQL_DELETE = "DELETE FROM Convention";

	public ArrayList<Convention> selectAll() {
		ArrayList<Convention> arrayList = new ArrayList<Convention>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Convention convention = new Convention(rs.getInt("idSt"), rs.getInt("idEtu"), rs.getBoolean("approbationCommission"), rs.getBoolean("approbationDirecteur"), rs.getBoolean("approbationEntreprise"), rs.getBoolean("approbationEtudiant"));
				convention.setAttr_int_idConv(rs.getInt("idConv"));
				
				arrayList.add(convention);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}
	
	public Convention select(int idConv) {
		Convention convention = null;
		try {
			String sql = SQL_SELECT + " WHERE idConv = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idConv);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				convention = new Convention(rs.getInt("idSt"), rs.getInt("idEtu"), rs.getBoolean("approbationCommission"), rs.getBoolean("approbationDirecteur"), rs.getBoolean("approbationEntreprise"), rs.getBoolean("approbationEtudiant"));
				convention.setAttr_int_idConv(rs.getInt("idConv"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return convention;
	}
	
	public ArrayList<Convention> selectByIdEtu(int idEtu) {
		ArrayList<Convention> arrayList = new ArrayList<Convention>();
		try {
			String sql = SQL_SELECT + " WHERE idEtu = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			
			pstmt.setInt(1, idEtu);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Convention convention = new Convention(rs.getInt("idSt"), rs.getInt("idEtu"), rs.getBoolean("approbationCommission"), rs.getBoolean("approbationDirecteur"), rs.getBoolean("approbationEntreprise"), rs.getBoolean("approbationEtudiant"));
				convention.setAttr_int_idConv(rs.getInt("idConv"));
				
				arrayList.add(convention);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}
	
	public ArrayList<Convention> selectByIdSt(int idSt) {
		ArrayList<Convention> arrayList = new ArrayList<Convention>();
		try {
			String sql = SQL_SELECT + " WHERE idSt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			
			pstmt.setInt(1, idSt);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Convention convention = new Convention(rs.getInt("idSt"), rs.getInt("idEtu"), rs.getBoolean("approbationCommission"), rs.getBoolean("approbationDirecteur"), rs.getBoolean("approbationEntreprise"), rs.getBoolean("approbationEtudiant"));
				convention.setAttr_int_idConv(rs.getInt("idConv"));
				
				arrayList.add(convention);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}

	public int insert(Convention convention) {
		int new_id = -1;

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, convention.getAttr_int_idSt());
			pstmt.setInt(2, convention.getAttr_int_idEtu());
			pstmt.setBoolean(3, convention.getAttr_boolean_approbationCommission());
			pstmt.setBoolean(4, convention.getAttr_boolean_approbationDirecteur());
			pstmt.setBoolean(5, convention.getAttr_boolean_approbationEntreprise());
			pstmt.setBoolean(6, convention.getAttr_boolean_approbationEtudiant());

			if (pstmt.executeUpdate() != 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();

				if (generatedKeys.next()) {
					new_id = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating Convention failed, no ID obtained.");
				}
			} else {
				throw new SQLException("Creating Convention failed, no rows affected.");
			}

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return new_id;
	}

	public void update(Convention convention) {
		try {
			String sql = SQL_UPDATE + " WHERE idConv = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, convention.getAttr_int_idSt());
			pstmt.setInt(2, convention.getAttr_int_idEtu());
			pstmt.setBoolean(3, convention.getAttr_boolean_approbationDirecteur());
			pstmt.setBoolean(4, convention.getAttr_boolean_approbationEntreprise());
			pstmt.setBoolean(5, convention.getAttr_boolean_approbationEtudiant());
			pstmt.setInt(6, convention.getAttr_int_idConv());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Convention convention) {
		delete(convention.getAttr_int_idSt());
	}
	
	public void delete(int idConv) {
		try {
			String sql = SQL_DELETE + " WHERE idConv = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idConv);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void deleteAll() {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_DELETE);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

}
