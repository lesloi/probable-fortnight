package jdbc;

import java.sql.*;
import java.util.ArrayList;

import acteurs.Ecole;

public class JDBC_Ecole extends Abstract_JDBC {

	static final String SQL_SELECT = "SELECT * FROM Ecole";
	static final String SQL_INSERT = "INSERT INTO Ecole(nom, adresse, mail, idDir) VALUES (?, ?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE Ecole SET nom = ?, adresse = ?, mail = ?, idDir = ?";
	static final String SQL_DELETE = "DELETE FROM Ecole";

	public ArrayList<Ecole> selectAll() {
		ArrayList<Ecole> arrayList = new ArrayList<Ecole>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_SELECT);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Ecole ecole = new Ecole(rs.getString("nom"), rs.getString("adresse"), rs.getString("mail"), rs.getInt("idDir"));
				ecole.setAttr_int_idEc(rs.getInt("idEc"));
				
				arrayList.add(ecole);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return arrayList;
	}
	
	public Ecole select(int idEc) {
		Ecole ecole = null;
		try {
			String sql = SQL_SELECT + " WHERE idEc = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEc);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ecole = new Ecole(rs.getString("nom"), rs.getString("adresse"), rs.getString("mail"), rs.getInt("idDir"));
				ecole.setAttr_int_idEc(rs.getInt("idEc"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return ecole;
	}

	public int insert(Ecole ecole) {
		int new_id = -1;

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, ecole.getAttr_str_nom());
			pstmt.setString(2, ecole.getAttr_str_adresse());
			pstmt.setString(3, ecole.getAttr_str_mail());
			pstmt.setInt(4, ecole.getAttr_int_idDir());

			if (pstmt.executeUpdate() != 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();

				if (generatedKeys.next()) {
					new_id = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating Ecole failed, no ID obtained.");
				}
			} else {
				throw new SQLException("Creating Ecole failed, no rows affected.");
			}

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}

		return new_id;
	}

	public void update(Ecole ecole) {
		try {
			String sql = SQL_UPDATE + " WHERE idEc = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setString(1, ecole.getAttr_str_nom());
			pstmt.setString(2, ecole.getAttr_str_adresse());
			pstmt.setString(3, ecole.getAttr_str_mail());
			pstmt.setInt(4, ecole.getAttr_int_idDir());
			pstmt.setInt(5, ecole.getAttr_int_idEc());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
		}
	}

	public void delete(Ecole ecole) {
		delete(ecole.getAttr_int_idEc());
	}
	
	public void delete(int idEc) {
		try {
			String sql = SQL_DELETE + " WHERE idEc = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(sql);

			pstmt.setInt(1, idEc);

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
