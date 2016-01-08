package jdbc;

import java.sql.*;
import java.util.ArrayList;

import acteurs.Utilisateur;

public class JDBC_Utilisateur extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Utilisateur";
	static final String SQL_INSERT = "INSERT INTO Utilisateur(login, mail, prenom, nom, type) VALUES (?, ?, ?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE Utilisateur SET login = ?, mail = ?, prenom = ?, nom = ?, type = ?";
	static final String SQL_DELETE = "DELETE FROM Utilisateur";

	public ArrayList<Utilisateur> selectAll() {
		ArrayList<Utilisateur> arrayList = new ArrayList<Utilisateur>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Utilisateur ut = new Utilisateur(rs.getString("login"), rs.getString("mail"), rs.getString("prenom"), rs.getString("nom"), rs.getInt("type"));
				ut.setAttr_int_idUt(rs.getInt("idUt"));
				
				arrayList.add(ut);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}
	
	public Utilisateur select(int idUt) {
		Utilisateur ut = null;
		try {
			String sql = SQL_SELECT + " WHERE idUt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idUt);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ut = new Utilisateur(rs.getString("login"), rs.getString("mail"), rs.getString("prenom"), rs.getString("nom"), rs.getInt("type"));
				ut.setAttr_int_idUt(rs.getInt("idUt"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return ut;
	}

	public int insert(Utilisateur ut) {
		int new_id = -1;

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, ut.getAttr_str_login());
			pstmt.setString(2, ut.getAttr_str_mail());
			pstmt.setString(3, ut.getAttr_str_prenom());
			pstmt.setString(4, ut.getAttr_str_nom());
			pstmt.setInt(5, ut.getAttr_int_type());

			if (pstmt.executeUpdate() != 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();

				if (generatedKeys.next()) {
					new_id = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating Utilisateur failed, no ID obtained.");
				}
			} else {
				throw new SQLException("Creating Utilisateur failed, no rows affected.");
			}

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return new_id;
	}

	public void update(Utilisateur ut) {
		try {
			String sql = SQL_UPDATE + " WHERE idUt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setString(1, ut.getAttr_str_login());
			pstmt.setString(2, ut.getAttr_str_mail());
			pstmt.setString(3, ut.getAttr_str_prenom());
			pstmt.setString(4, ut.getAttr_str_nom());
			pstmt.setInt(5, ut.getAttr_int_type());
			pstmt.setInt(6, ut.getAttr_int_idUt());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Utilisateur ut) {
		delete(ut.getAttr_int_idUt());
	}
	
	public void delete(int idUt) {
		try {
			String sql = SQL_DELETE + " WHERE idUt = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idUt);

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
