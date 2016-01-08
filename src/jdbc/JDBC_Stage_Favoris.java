package jdbc;

import java.sql.*;
import java.util.ArrayList;

import forms.Stage_Favoris;

public class JDBC_Stage_Favoris extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Stage_Favoris";
	static final String SQL_INSERT = "INSERT INTO Stage_Favoris(idEtu, idSt) VALUES (?, ?)";
	static final String SQL_DELETE = "DELETE FROM Stage_Favoris";

	public ArrayList<Stage_Favoris> selectAll() {
		ArrayList<Stage_Favoris> arrayList = new ArrayList<Stage_Favoris>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Stage_Favoris st_fav = new Stage_Favoris(rs.getInt("idEtu"), rs.getInt("idSt"));

				arrayList.add(st_fav);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}

	public Stage_Favoris select(int idEtu, int idSt) {
		Stage_Favoris st_fav = null;
		try {
			String sql = SQL_SELECT + " WHERE idEtu = ? AND idSt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEtu);
			pstmt.setInt(2, idSt);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				st_fav = new Stage_Favoris(rs.getInt("idEtu"), rs.getInt("idSt"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return st_fav;
	}

	public ArrayList<Stage_Favoris> selectByIdEtu(int idEtu) {
		ArrayList<Stage_Favoris> arrayList = new ArrayList<Stage_Favoris>();
		try {
			String sql = SQL_SELECT + " WHERE idEtu = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEtu);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Stage_Favoris st_fav = new Stage_Favoris(rs.getInt("idEtu"), rs.getInt("idSt"));

				arrayList.add(st_fav);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}

	public ArrayList<Stage_Favoris> selectByIdSt(int idSt) {
		ArrayList<Stage_Favoris> arrayList = new ArrayList<Stage_Favoris>();
		try {
			String sql = SQL_SELECT + " WHERE idSt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idSt);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Stage_Favoris st_fav = new Stage_Favoris(rs.getInt("idEtu"), rs.getInt("idSt"));

				arrayList.add(st_fav);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}

	public void insert(Stage_Favoris st_fav) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT);

			pstmt.setInt(1, st_fav.getAttr_int_idEtu());
			pstmt.setInt(2, st_fav.getAttr_int_idSt());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Stage_Favoris st_fav) {
		delete(st_fav.getAttr_int_idEtu(), st_fav.getAttr_int_idSt());
	}

	public void delete(int idEtu, int idSt) {
		try {
			String sql = SQL_DELETE + " WHERE idEtu = ? AND idSt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEtu);
			pstmt.setInt(2, idSt);

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
