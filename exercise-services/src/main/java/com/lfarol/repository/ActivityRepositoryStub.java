package com.lfarol.repository;

import java.util.ArrayList;
import java.util.List;

import com.lfarol.model.Activity;
import com.lfarol.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity a1 = new Activity();
	
		a1.setId("1");
		a1.setDescription("Running");
		a1.setDuration(30);

		User user = new User();
		user.setId("1001");
		user.setName("Eli");
		
		a1.setUser(user);
		
		activities.add(a1);
		
		Activity a2 = new Activity();
		
		a2.setId("2");
		a2.setDescription("Cycling");
		a2.setDuration(60);
		
		User user2 = new User();
		user2.setId("1002");
		user2.setName("Gary");
		
		a2.setUser(user2);
		
		activities.add(a2);
		
		return activities;
	}
	
	@Override
	public Activity findActivity(String activityId) {
		
		if(activityId.equals("9999")) {
			return null;
		}
		// Usually a database query
		Activity a1 = new Activity();
		
		a1.setId("1");
		a1.setDescription("Running");
		a1.setDuration(30);
		
		User user = new User();
		user.setId("1000");
		user.setName("Eli");
		
		a1.setUser(user);
		
		return a1;
	}
	
	@Override
	public void create(Activity activity) {
		// should insert activity to database
	}
	
	@Override
	public Activity update(Activity activity) {
		// search database if activity ID already exists,
		// select * from Activity where id = activity.getId()
		// if rs size == 0
		// insert into Activity table
		// else update
		
		return activity;
	}
	
	@Override
	public void delete(String activityId) {
		// search database using activity ID
		// delete from activity where id = activityId
	}
	
	@Override
	public List<Activity> findByDescription(List<String> descriptions) {
		// select * from activity where description in (?, ?, ?)
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity a1 = new Activity();
		
		a1.setId("1");
		a1.setDescription("Running");
		a1.setDuration(30);
		
		User user = new User();
		user.setId("1000");
		user.setName("Eli");
		
		a1.setUser(user);
		
		activities.add(a1);
		
		return activities;
	}

}
