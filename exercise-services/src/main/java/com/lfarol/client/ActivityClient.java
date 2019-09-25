package com.lfarol.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.lfarol.model.Activity;

public class ActivityClient {

	private Client client;
	
	public ActivityClient() {
		client = ClientBuilder.newClient();
	}
	
	public Activity get(String id) {
		
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
//		String resp = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
//		System.out.println(resp);
		
//		// append activities + id to target path: http://localhost:8080/exercise-services/webapi/activities/id
//		// build request to target, specify the return type format, in this case it's default type
//		// invoke GET request and bind response to Activity class
//		Activity response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Activity.class);
		
		Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": error on the server");
		}
		return response.readEntity(Activity.class);		
		
	}
	
	public List<Activity> getList() {
		
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
		// append activities to target path: http://localhost:8080/exercise-services/webapi/activities
		// new GenericType<List<Activity>> () {} for getting List return type. List<activity> will return error
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>> () {});
		
		return response;
		
	}

	public Activity create(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
		Response response = target.path("activities/activity")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON)); // post Entity with activity as argument and JSON as format
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": error on the server");
		}
		
		return response.readEntity(Activity.class);
	}
	
	public Activity createForm(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
	    MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
	    formData.add("description", activity.getDescription());
	    formData.add("duration", Integer.toString(activity.getDuration()));
	    
		Response response = target.path("activities/activity")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(formData, MediaType.APPLICATION_FORM_URLENCODED)); // post Entity with activity as argument and JSON as format
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": error on the server");
		}
		
		return response.readEntity(Activity.class);
	}

	public Activity update(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");

		Response response = target.path("activities/" + activity.getId())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": error on the server");
		}
		
		return response.readEntity(Activity.class);
	}

	public void delete(String activityId) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");

		Response response = target.path("activities/" + activityId).request(MediaType.APPLICATION_JSON).delete();
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": error on the server");
		}
	}
	
}
