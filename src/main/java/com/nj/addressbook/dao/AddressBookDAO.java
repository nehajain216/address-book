package com.nj.addressbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.nj.addressbook.entities.Contact;


@Component
public class AddressBookDAO 
{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AddressBookDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Contact> getAllContacts()
	{
		String sql = "select * from contacts";
		List<Contact> listOfAllContacts =  jdbcTemplate.query(sql, new AddressBookRowMapper());
		return listOfAllContacts;
	}
	
	public Contact getContactById(int id)
	{
		String sql = "select * from contacts where id=?";
		Contact contact = jdbcTemplate.queryForObject(sql, new Object[] {id}, new AddressBookRowMapper());
		return contact;
	}
	
	public Contact createContact(Contact contact)
	{
		String sql = "insert into contacts(name,phonenumber,email,address) values(?,?,?,?)";

		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,  contact.getName());
				ps.setString(2,  contact.getPhoneNumber());
				ps.setString(3,  contact.getEmail());
				ps.setString(4, contact.getAddress());
				return ps;
			}
		};

		// The newly generated key will be saved in this object
		final KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(psc, holder);

		final int contactId = holder.getKey().intValue();
		contact.setId(contactId);
		return contact;
	}

}

class AddressBookRowMapper implements RowMapper<Contact>
{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Contact contact = new Contact();
		contact.setId(rs.getInt("id"));
		contact.setName(rs.getString("name"));
		contact.setPhoneNumber(rs.getString("phonenumber"));
		contact.setEmail(rs.getString("email"));
		contact.setAddress(rs.getString("address"));
		return contact;
	}
	
}
