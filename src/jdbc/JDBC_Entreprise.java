package jdbc;

import java.sql.*;
import java.util.ArrayList;

import acteurs.Entreprise;
import acteurs.Utilisateur;

public class JDBC_Entreprise extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Entreprise";
	static final String SQL_INSERT = "INSERT INTO Entreprise(idEnt, numSiret, adresse) VALUES (?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE Entreprise SET numSiret = ?, adresse = ?";
	static final String SQL_DELETE = "DELETE FROM Entreprise";

	private static JDBC_Utilisateur jdbc_utilisateur = new JDBC_Utilisateur();
	
	public ArrayList<Entreprise> selectAll() {
		ArrayList<Entreprise> arrayList = new ArrayList<Entreprise>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Utilisateur ut = jdbc_utilisateur.select(rs.getInt("idEnt"));
				Entreprise ent = new Entreprise(ut, rs.getInt("numSiret"), rs.getString("adresse"));

				arrayList.add(ent);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}

	public Entreprise select(int idEnt) {
		Entreprise ent = null;
		try {
			String sql = SQL_SELECT + " WHERE idEnt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			
			pstmt.setInt(1, idEnt);
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Utilisateur ut = jdbc_utilisateur.select(rs.getInt("idEnt"));
				ent = new Entreprise(ut, rs.getInt("numSiret"), rs.getString("adresse"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return ent;
	}

	public void insert(Entreprise ent) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT);

			pstmt.setInt(1, ent.getAttr_int_idUt());
			pstmt.setInt(2, ent.getAttr_int_numSiret());
			pstmt.setString(3, ent.getAttr_str_adresse());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void update(Entreprise ent) {
		try {
			String sql = SQL_UPDATE + " WHERE idEnt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, ent.getAttr_int_numSiret());
			pstmt.setString(2, ent.getAttr_str_adresse());
			pstmt.setInt(3, ent.getAttr_int_idUt());
			
			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Entreprise entr) {
		delete(entr.getAttr_int_idUt());
	}
	
	public void delete(int idEnt) {
		try {
			String sql = SQL_DELETE + " WHERE idEnt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEnt);

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
