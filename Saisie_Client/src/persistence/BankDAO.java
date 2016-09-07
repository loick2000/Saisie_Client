package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.*;

import metier.*;
import persistence.*;
public class BankDAO {

	public BankDAO() {
		// TODO Auto-generated constructor stub
	}
	public int compterClient(){
		int result = 10;
		String query = "SELECT count(id) from client";
		try {
			PreparedStatement st = BankConnection.getInstance().prepareStatement(query);
			ResultSet rs = st.executeQuery(query);
			result =  rs.getInt("id");
			st.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
	}
	public void ajouterClient(ClientBean client) {
		String query = "INSERT INTO client VALUES(?,?,?,?,?)";
		try {
			PreparedStatement st = BankConnection.getInstance().prepareStatement(query);
			st.setString(1, client.getNom());
			st.setString(2, client.getPrenom());
			st.setString(3, client.getTel());
			st.setString(4, client.getEmail());
			st.setString(5, client.getMdp());

			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("on ajoute un client");
	}
/*
	public void modifyClient(ClientBean client) {
		String query = "UPDATE client SET nom=?, tel=? WHERE id=?";
		try {
			PreparedStatement st = BankConnection.getInstance().prepareStatement(query);
			st.setString(1, customer.getName());
			st.setString(2, customer.getPhone());
			st.setString(3, customer.getId());
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
		}
	}
*/
	public List<ClientBean> lireTousLesClients() {
		List<ClientBean> clients = new ArrayList<>();
		ClientBean bean;
		int id;
		String query = "SELECT * FROM client;";

		try {
			Statement st = BankConnection.getInstance().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
				clients.add(rs.getInt(1) , new ClientBean(
						 rs.getString("nom"), 
						 rs.getString("prenom"),
						 rs.getString("tel"),
						 rs.getString("email"),
						 rs.getString("mdp")
						)
						);
			rs.close();
			st.close();
		} catch (SQLException e) {
		}
		return clients;
	}
/*
	public ClientBean lectureClient(int id) {
		String query = "SELECT * FROM client WHERE id=?";
		Customer customer = null;
		try {
			System.out.println(id);
			PreparedStatement st = BankConnection.getInstance().prepareStatement(query);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getString("id"), rs.getString("nom"), rs.getString("tel"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
		}

		return customer;
	}
*/
	public void deleteCustomer(String id) {
		String query = "DELETE FROM client WHERE id=?";

		try {
			PreparedStatement st = BankConnection.getInstance().prepareStatement(query);
			st.setString(1, id);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
		}
	}
}
