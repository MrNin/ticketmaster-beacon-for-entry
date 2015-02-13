package com.ticketmaster.dao;

import java.util.List;

import com.ticketmaster.bean.EventBean;
import com.ticketmaster.bean.RosterEntryBean;
import com.ticketmaster.bean.UserBean;

public interface RosterEntryDao {
	public List<RosterEntryBean> getAllRosterEntries();
	public EventBean getRosterForEvent(int eventId);
	
	// CRUD
	public EventBean createRoster(String name);
	public EventBean readRoster(int id);
	public EventBean updateRoster(int id, UserBean userBean, EventBean eventBean);
	public void deleteRoster(int id);
}
