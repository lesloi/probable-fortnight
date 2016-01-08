package jdbc;

import java.sql.*;
import java.util.ArrayList;

import forms.Stage;

public class JDBC_Stage extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Stage";
	static final String SQL_INSERT = "INSERT INTO Stage(intitule, description, idEnt) VALUES (?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE Stage SET intitule = ?, description = ?, idEnt = ?";
	static final String SQL_DELETE = "DELETE FROM Stage";

	public ArrayList<Stage> selectAll() {
		ArrayList<Stage> arrayList = new ArrayList<Stage>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Stage stage = new Stage(rs.getString("intitule"), rs.getString("description"), rs.getInt("idEnt"));
				stage.setAttr_int_idSt(rs.getInt("idSt"));
				
				arrayList.add(stage);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}
	
	public Stage select(int idSt) {
		Stage stage = null;
		try {
			String sql = SQL_SELECT + " WHERE idSt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idSt);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				stage = new Stage(rs.getString("intitule"), rs.getString("description"), rs.getInt("idEnt"));
				stage.setAttr_int_idSt(rs.getInt("idSt"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return stage;
	}
	
	public ArrayList<Stage> selectByIdEnt(int idEnt) {
		ArrayList<Stage> arrayList = new ArrayList<Stage>();
		try {
			String sql = SQL_SELECT + " WHERE idEnt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			
			pstmt.setInt(1, idEnt);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Stage stage = new Stage(rs.getString("intitule"), rs.getString("description"), rs.getInt("idEnt"));
				stage.setAttr_int_idSt(rs.getInt("idSt"));
				
				arrayList.add(stage);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}

	public int insert(Stage stage) {
		int new_id = -1;

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, stage.getAttr_str_intitule());
			pstmt.setString(2, stage.getAttr_str_description());
			pstmt.setInt(3, stage.getAttr_int_idEnt());

			if (pstmt.executeUpdate() != 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();

				if (generatedKeys.next()) {
					new_id = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating Stage failed, no ID obtained.");
				}
			} else {
				throw new SQLException("Creating Stage failed, no rows affected.");
			}

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return new_id;
	}

	public void update(Stage stage) {
		try {
			String sql = SQL_UPDATE + " WHERE idSt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setString(1, stage.getAttr_str_intitule());
			pstmt.setString(2, stage.getAttr_str_description());
			pstmt.setInt(3, stage.getAttr_int_idEnt());
			pstmt.setInt(4, stage.getAttr_int_idSt());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Stage stage) {
		delete(stage.getAttr_int_idSt());
	}
	
	public void delete(int idSt) {
		try {
			String sql = SQL_DELETE + " WHERE idSt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idSt);

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
