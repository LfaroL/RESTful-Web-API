package com.lfarol.client;

// static import for JUnit tests
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lfarol.model.Activity;

public class ActivityClientTest {

	ActivityClient client;
	
	@Before
	public void setUp() {
		client = new ActivityClient();
	}
	
	@Test
	public void testGet() {		
		Activity activity = client.get("1");

		assertNotNull(activity);
		assertEquals(activity.getDescription(), "Running");
		assertEquals(activity.getDuration(), 30);
	}
	
	@Test
	public void testGetList() {		
		List<Activity> activities = client.getList();

		assertNotNull(activities);
		
		Activity activity = activities.get(0);
		
		assertEquals(activity.getDescription(), "Running");
		assertEquals(activity.getDuration(), 30);	
	}
	
	// expect a 400 runtime exception
	@Test(expected = RuntimeException.class)
	public void testGetWithBadRequest() {		
		client.get("12345");
	}
	
	// expect a 404 runtime exception
	@Test(expected = RuntimeException.class)
	public void testGetWithNotFound() {		
		client.get("9999");
	}
	
	@Test
	public void testPost() {
		Activity activity = new Activity();
		activity.setDescription("Swimming");
		activity.setDuration(45);
		
		activity = client.create(activity);
		
		assertNotNull(activity);
		assertEquals(activity.getDescription(), "Swimming");
		assertEquals(activity.getDuration(), 45);	
	}

	@Test
	public void testPostForm() {
		Activity activity = new Activity();
		activity.setDescription("Swimming");
		activity.setDuration(45);
		
		activity = client.createForm(activity);
		
		assertNotNull(activity);
		assertEquals(activity.getDescription(), "Swimming");
		assertEquals(activity.getDuration(), 45);	
	}
	
	@Test
	public void testPut() {
		Activity activity = new Activity();
		
		activity.setId("3");
		activity.setDescription("Yoga");
		activity.setDuration(120);
		
		activity = client.update(activity);
		
		assertNotNull(activity);
		assertEquals(activity.getDescription(), "Yoga");
		assertEquals(activity.getDuration(), 120);	
		assertEquals(activity.getId(), "3");
	}
	
	// expect a 404 runtime exception
	@Test(expected = RuntimeException.class)
	public void testDelete() {
		client.delete("123");
		client.get("123");		
	}

}
