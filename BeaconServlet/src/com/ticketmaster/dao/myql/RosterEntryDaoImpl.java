package com.ticketmaster.dao.myql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ticketmaster.bean.EventBean;
import com.ticketmaster.bean.RosterEntryBean;
import com.ticketmaster.bean.UserBean;
import com.ticketmaster.dao.RosterEntryDao;

public class RosterEntryDaoImpl extends MySqlDao implements RosterEntryDao {
	
	public List<RosterEntryBean> getAllRosterEntries() {
		Connection con = null;
		List<RosterEntryBean> result = new ArrayList<RosterEntryBean>();
		con = MySqlDao.getConnection();
		
		try {
			String selectAllQuery = "SELECT * FROM eventRoster, users, events WHERE eventRoster.UserId=users.Id AND eventRoster.EventId=events.EventId;";
			PreparedStatement pStatement = con.prepareStatement(selectAllQuery);
			ResultSet rs = pStatement.executeQuery();
			
			// Iterate ResultSet and Initialize Camera list
			while(rs.next()) {
				EventBean eventToAddToEntry = new EventBean();
				eventToAddToEntry.setId(Integer.parseInt(rs.getString("EventId")));
				eventToAddToEntry.setName(rs.getString("EventName"));
				
				UserBean userToAddToEntry = new UserBean();
				userToAddToEntry.setId(Integer.parseInt(rs.getString("Id")));
				userToAddToEntry.setFirstName(rs.getString("FirstName"));
				userToAddToEntry.setLastName(rs.getString("LastName"));
				userToAddToEntry.setUsername(rs.getString("Username"));
				
				boolean userAttendedEntry = rs.getBoolean("AttendedFlag");
				
				RosterEntryBean entry = new RosterEntryBean(eventToAddToEntry, userToAddToEntry, userAttendedEntry);
				result.add(entry);
			}
			
			pStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		} finally {
			// close the connection even if get was unsuccessful
			MySqlDao.cleanup(con);
		}
		return result;
	}
	public List<RosterEntryBean> getRosterForEvent(int eventId) {
		return null;
	}
	
	// CRUD
	public EventBean createRoster(String name) {
		return null;
	}
	
	public EventBean readRoster(int id) {
		return null;
	}
	
	public EventBean updateRoster(int id, UserBean userBean, EventBean eventBean) {
		return null;
	}
	
	public void deleteRoster(int id) {
		
	}
}
