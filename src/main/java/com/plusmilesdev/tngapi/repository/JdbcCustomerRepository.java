package com.plusmilesdev.tngapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.plusmilesdev.tngapi.model.Customer;

@Repository
public class JdbcCustomerRepository implements CustomerRepository{

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbctemplate;
	
	public JdbcCustomerRepository() {
		super();
	}

	@Override
	public List<Customer> findAll() {
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("Select * from SampleCustomer");
				return ps;
			}
			
		};
		return jdbctemplate.query(psc, (rs,rownum)->new Customer(rs.getString("tagid"),rs.getString("customername"),rs.getTimestamp("createddate")));
	}

	@Override
	public int save(Customer customer) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("Insert into SampleCustomer(tagid,customername,createddate) values(?,?,?)");
				ps.setString(1, customer.getTagid());
				ps.setString(2, customer.getCustomername());
				ps.setTimestamp(3, (Timestamp) customer.getCreateddate());
				return ps;
			}
			
		};
		return jdbctemplate.update(psc);
	}

}
