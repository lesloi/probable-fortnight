package jdbc;

import java.sql.*;
import java.util.ArrayList;

import acteurs.Etudiant;
import acteurs.Utilisateur;

public class JDBC_Etudiant extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Etudiant";
	static final String SQL_INSERT = "INSERT INTO Etudiant(idEtu, numEtudiant, formation, idEc) VALUES (?, ?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE Etudiant SET numEtudiant = ?, formation = ?, idEc = ?";
	static final String SQL_DELETE = "DELETE FROM Etudiant";

	private static JDBC_Utilisateur jdbc_utilisateur = new JDBC_Utilisateur();

	public ArrayList<Etudiant> selectAll() {
		ArrayList<Etudiant> arrayList = new ArrayList<Etudiant>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Utilisateur ut = jdbc_utilisateur.select(rs.getInt("idEtu"));
				Etudiant etu = new Etudiant(ut, rs.getInt("numEtudiant"), rs.getString("formation"), rs.getInt("idEc"));
				
				arrayList.add(etu);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}
	
	public Etudiant select(int idEtu) {
		Etudiant etu = null;
		try {
			String sql = SQL_SELECT + " WHERE idEtu = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEtu);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Utilisateur ut = jdbc_utilisateur.select(rs.getInt("idEtu"));
				etu = new Etudiant(ut, rs.getInt("numEtudiant"), rs.getString("formation"), rs.getInt("idEc"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return etu;
	}

	public void insert(Etudiant etu) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT);

			pstmt.setString(1, etu.getAttr_str_login());
			pstmt.setString(2, etu.getAttr_str_mail());
			pstmt.setString(3, etu.getAttr_str_prenom());
			pstmt.setString(4, etu.getAttr_str_nom());
			pstmt.setInt(5, etu.getAttr_int_type());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void update(Etudiant etu) {
		try {
			String sql = SQL_UPDATE + " WHERE idEtu = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setString(1, etu.getAttr_str_login());
			pstmt.setString(2, etu.getAttr_str_mail());
			pstmt.setString(3, etu.getAttr_str_prenom());
			pstmt.setString(4, etu.getAttr_str_nom());
			pstmt.setInt(5, etu.getAttr_int_type());
			pstmt.setInt(6, etu.getAttr_int_idUt());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Etudiant etu) {
		delete(etu.getAttr_int_idUt());
	}
	
	public void delete(int idEtu) {
		try {
			String sql = SQL_DELETE + " WHERE idEtu = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEtu);

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
