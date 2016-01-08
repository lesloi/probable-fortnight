package jdbc;

import java.sql.*;
import java.util.ArrayList;

import acteurs.Professeur;
import acteurs.Utilisateur;;

public class JDBC_Professeur extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Professeur";
	static final String SQL_INSERT = "INSERT INTO Professeur(idProf, matiere, idEc, isCom) VALUES (?, ?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE Professeur SET matiere = ?, idEc = ?, isCom = ?";
	static final String SQL_DELETE = "DELETE FROM Professeur";

	private static JDBC_Utilisateur jdbc_utilisateur = new JDBC_Utilisateur();
	
	public ArrayList<Professeur> selectAll() {
		ArrayList<Professeur> arrayList = new ArrayList<Professeur>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Utilisateur ut = jdbc_utilisateur.select(rs.getInt("idEtu"));
				Professeur prof = new Professeur(ut, rs.getString("matiere"), rs.getInt("idEc"), rs.getInt("isCom"));
				prof.setAttr_int_idUt(ut.getAttr_int_idUt());
				
				arrayList.add(prof);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}
	
	public Professeur select(int idProf) {
		Professeur prof = null;
		try {
			String sql = SQL_SELECT + " WHERE idProf = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idProf);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Utilisateur ut = jdbc_utilisateur.select(rs.getInt("idEtu"));
				prof = new Professeur(ut, rs.getString("matiere"), rs.getInt("idEc"), rs.getInt("isCom"));
				prof.setAttr_int_idUt(ut.getAttr_int_idUt());
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return prof;
	}

	public void insert(Professeur prof) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT);

			pstmt.setString(1, prof.getAttr_str_login());
			pstmt.setString(2, prof.getAttr_str_mail());
			pstmt.setString(3, prof.getAttr_str_prenom());
			pstmt.setString(4, prof.getAttr_str_nom());
			pstmt.setInt(5, prof.getAttr_int_type());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void update(Professeur prof) {
		try {
			String sql = SQL_UPDATE + " WHERE idProf = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setString(1, prof.getAttr_str_matiere());
			pstmt.setInt(2, prof.getAttr_int_idEc());
			pstmt.setInt(3, prof.getAttr_int_isCom());
			pstmt.setInt(4, prof.getAttr_int_idUt());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Professeur prof) {
		delete(prof.getAttr_int_idUt());
	}
	
	public void delete(int idProf) {
		try {
			String sql = SQL_DELETE + " WHERE idProf = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idProf);

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
