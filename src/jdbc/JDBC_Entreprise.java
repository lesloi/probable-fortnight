package jdbc;

import java.sql.*;
import java.util.ArrayList;

import acteurs.Entreprise;

public class JDBC_Entreprise extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Entreprise";
	static final String SQL_INSERT = "INSERT INTO Entreprise(login, nom, mail, adresse, signature, nbrStagesPropose) VALUES (?, ?, ?, ?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE Entreprise SET login = ?, nom = ?, mail = ?, adresse = ?, signature = ?, nbrStagesPropose = ?";
	static final String SQL_DELETE = "DELETE FROM Entreprise";

	public ArrayList<Entreprise> selectAll() {
		ArrayList<Entreprise> arrayList = new ArrayList<Entreprise>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Entreprise ent = new Entreprise(rs.getInt("idEntr"), rs.getString("nom"), rs.getDate("start_mandat"),
						rs.getDate("end_mandat"), rs.getString("signature"));
				ent.setAttr_str_login(rs.getString("login"));
				ent.setAttr_int_idDir(rs.getInt("idDir"));

				arrayList.add(ent);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}

	public Entreprise select(int idDir) {
		Entreprise dir = null;
		try {
			String sql = SQL_SELECT + " WHERE idDir = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			
			pstmt.setInt(1, idDir);
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				dir = new Entreprise(rs.getString("prenom"), rs.getString("nom"), rs.getDate("start_mandat"),
						rs.getDate("end_mandat"), rs.getString("signature"));
				dir.setAttr_str_login(rs.getString("login"));
				dir.setAttr_int_idDir(rs.getInt("idDir"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return dir;
	}

	public int insert(Entreprise ent) {
		int new_id = -1;
		
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, ent.getAttr_str_login());
			pstmt.setString(2, ent.getAttr_str_prenom());
			pstmt.setString(3, ent.getAttr_str_nom());
			pstmt.setString(4, ent.getAttr_str_signature());
			pstmt.setDate(5, (Date) ent.getAttr_date_start_mandat());
			pstmt.setDate(6, (Date) ent.getAttr_date_end_mandat());

			if (pstmt.executeUpdate() != 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();

				if (generatedKeys.next()) {
					new_id = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating Entreprise failed, no ID obtained.");
				}
			} else {
				throw new SQLException("Creating Entreprise failed, no rows affected.");
			}

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
		
		return new_id;
	}

	public void update(Entreprise ent) {
		try {
			String sql = SQL_UPDATE + " WHERE idDir = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setString(1, dir.getAttr_str_login());
			pstmt.setString(2, dir.getAttr_str_prenom());
			pstmt.setString(3, dir.getAttr_str_nom());
			pstmt.setString(4, dir.getAttr_str_signature());
			pstmt.setDate(5, (Date) dir.getAttr_date_start_mandat());
			pstmt.setDate(6, (Date) dir.getAttr_date_end_mandat());
			pstmt.setInt(7, dir.getAttr_int_idDir());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Entreprise entr) {
		delete(entr.getAttr_int_idEntr());
	}
	
	public void delete(int idEntr) {
		try {
			String sql = SQL_DELETE + " WHERE idEntr = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEntr);

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
