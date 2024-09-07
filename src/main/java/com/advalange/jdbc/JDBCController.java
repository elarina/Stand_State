package com.advalange.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.advalange.model.Employee;
import com.advalange.model.Stand;

public class JDBCController {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public JDBCController(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Employee> queryTowns() {
		List<Employee> employees = new ArrayList<Employee>();

		String sql = "SELECT name, lastname FROM employee";

		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> record : records) {
			String name = (String) record.get("name");
			String lastname = (String) record.get("lastname");
			employees.add(new Employee(name, lastname));
		}

		return employees;
	}

	public List<Stand> queryStands() {
		List<Stand> stands = new ArrayList<Stand>();

		String sql = "SELECT id, name, ip, username, password, busy FROM stands;";

		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> record : records) {
			int id = (int) record.get("id");
			String name = (String) record.get("name");
			String ip = (String) record.get("ip");
			String username = (String) record.get("username");
			String password = (String) record.get("password");
			boolean busy = (boolean) record.get("busy");
			stands.add(new Stand(id, name, ip, username, password, busy));
		}

		return stands;
	}

	public void removeStands(int[] ids) {
		String idsStr = "";
		for (int i = 0; i < ids.length - 1; i++) {
			idsStr = i + ", ";
		}
		idsStr += ids[ids.length - 1];
		String sql = "DELETE FROM stands where id in(" + idsStr + ");";
		jdbcTemplate.update(sql);
	}

	public void addStand(Stand stand) {
		Connection connection;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO stands (id, name, ip, username, password, busy) values (?, ?, ?, ?, ?, ?);");
			statement.setInt(1, stand.getId());
			statement.setString(2, stand.getName());
			statement.setString(3, stand.getIp());
			statement.setString(4, stand.getUsername());
			statement.setString(5, stand.getPassword());
			statement.setBoolean(6, stand.getBusy());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}