package com.lfarol.view;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lfarol.model.Activity;
import com.lfarol.model.User;
import com.lfarol.repository.ActivityRepository;
import com.lfarol.repository.ActivityRepositoryStub;

@Path("activities") // http:localhost:8080/exercise-services/webapi/activities
public class ActivityResource {
	
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
		
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities() {
		return activityRepository.findAllActivities();
	}
	
//	@GET
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	@Path("{activityId}") // http:localhost:8080/exercise-services/webapi/activities/1234
//	public Activity getActivity(@PathParam ("activityId") String activityId) { // Takes path parameter activityId and places it into function parameter activityId
//		return activityRepository.findActivity(activityId);
//	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}") // http:localhost:8080/exercise-services/webapi/activities/1234
	public Response getActivity(@PathParam ("activityId") String activityId) { // Takes path parameter activityId and places it into function parameter activityId
		// if passed argument is null
		if(activityId == null || activityId.length() > 4) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Activity activity;
		if (!activityId.equals("123")) {
			activity = activityRepository.findActivity(activityId);
		} else {
			activity = null; 
		}
		
		// if activity not found in repository, return NOT_FOUND
		if (activity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		// return Status OK, and return the activity that was queried
		return Response.ok().entity(activity).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user") // http:localhost:8080/exercise-services/webapi/activities/1234/user
	public User getActivityUser(@PathParam ("activityId") String activityId) { // Takes path parameter activityId and places it into function parameter activityId
		Activity activity = activityRepository.findActivity(activityId);
		User user = activity.getUser();
		return user;
	}
	
	@POST
	@Path("activity") // http:localhost:8080/exercise-services/webapi/activities/activity
	@Consumes(MediaType.APPLICATION_JSON) // Takes in JSON arguments
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createActivity(Activity activity) {
		// 'description' field name should be 'desc' because of @XmlElement(name="desc")
		if(activity.getDescription() == null || activity.getDescription().isEmpty() || activity.getDuration() <= 0) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		activityRepository.create(activity);
		
		return Response.ok().entity(activity).build();
	}
	
//	@POST
//	@Path("activity") // http:localhost:8080/exercise-services/webapi/activities/activity
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Takes in urlencoded arguments
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	public Activity createActivityParams(@FormParam("description") String description, @FormParam("duration") String duration) { // @FormParam to take input based on field value
//		
//		Activity activity = new Activity();
//		activity.setDescription(description);
//		activity.setDuration(Integer.parseInt(duration));
//		
//		activityRepository.create(activity);
//		
//		return activity;
//	}

	@POST
	@Path("activity") // http:localhost:8080/exercise-services/webapi/activities/activity
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Takes in urlencoded arguments
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createActivityParams(@FormParam("description") String description, @FormParam("duration") String duration) { // @FormParam to take input based on field value
		// if form arguments are invalid
		if(description == null || description.isEmpty() || duration == null || duration.isEmpty()) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Activity activity = new Activity();
		activity.setDescription(description);
		activity.setDuration(Integer.parseInt(duration));
		
		activityRepository.create(activity);
		
		return Response.ok().entity(activity).build();
	}
	
	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON) // Takes in JSON arguments
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Activity activity) {
		
		activity = activityRepository.update(activity);
		
		return Response.ok().entity(activity).build();
	}
	
	@DELETE
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Takes in urlencoded arguments
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam ("activityId") String activityId) {
		activityRepository.delete(activityId);
		
		return Response.ok().build();
	}
	
}

