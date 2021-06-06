package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.GPU_DaoImpl;
import model_parts.GPU;

/**
 * Root resource (exposed at "gpu_resource" path)
 */
@Path("gpu_resource")
public class GPU_Resource {
	
	private GPU_DaoImpl dao;

	/**
	 * 
	 * Path Produces information on GET POST from API
	 * 
	 * @return	String	String of information
	 * 
	 * */
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Dedoru GPU Resource "
	    +"\n Paths:"
	    +"\n GET allgpu"
	    +"\n GET allgpu/tier/{tier}"
	    +"\n GET allgpu/{id}"
	    +"\n GET allgpu/date/{date}"
	    +"\n GET allgpu/date/{date}&{tier}"
	    +"\n GET allgpu/fromtoday/{today}&{toDate}"
	    +"\n GET allgpu/fromtoday/{today}&{toDate}&{tier}"
	    +"\n" + "\n"
	    +"\n POST ingpu"
	    +"\n POST ingpu/{id}";
    }
	
	
	/**
	 * 
	 * Path returns all GPUs
	 * 
	 * @return	List<GPU>	List of all the GPU's
	 * 
	 * */
	@GET
    @Path("allgpu")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<GPU> findAllGPU() {
    	
    	dao = new GPU_DaoImpl();
    	
    	return dao.findAll();
    }
	
	/**
	 * 
	 * Path returns all GPU's by specific tier
	 * 
	 * @param	tier		tier of GPU that user wants to retrieve (3070, 3080...)
	 * 
	 * @return	List<GPU>	List of all GPU's within the tier specification
	 * 
	 * */
	@GET
    @Path("allgpu/tier/{tier}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<GPU> findAllGPUByTier(@PathParam("tier") String tier) {
    	
    	dao = new GPU_DaoImpl();
    	
    	return dao.findAllGPUByTier(tier);
    }
	
	/**
	 * 
	 * Path returns a GPU by the given Id
	 * 
	 * @param	id	id INT of GPU that user wants to retrieve
	 * 
	 * @return	GPU	GPU object that was retrieved using id
	 * 
	 * */
	@GET
    @Path("allgpu/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public GPU findGPUById(@PathParam("id") int id) {
    	
    	dao = new GPU_DaoImpl();
    	
    	return dao.findGPUByID(id);
    }
	
	/**
	 * 
	 * Path returns all GPU's by given date
	 * 
	 * @param	date		Date String used to find GPU's
	 * 
	 * @return	List<GPU>	List of all GPU's that share given Date
	 * 
	 * */
	@GET
    @Path("allgpu/date/{date}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<GPU> findAllGPUByDate(@PathParam("date") String date) {
    	
    	dao = new GPU_DaoImpl();
    	
    	return dao.findAllGPUByDate(date);
    }
	
	/**
	 * 
	 * Path returns all GPU's by given date and tier
	 * 
	 * @param	date, tier	date String and tier String used to find GPU's
	 * 
	 * @return	List<GPU>	List of all GPU's that share given date and tier
	 * 
	 * */
	@GET
    @Path("allgpu/date/{date}&{tier}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<GPU> findAllGPUByDateAndTier(@PathParam("date") String date
    		, @PathParam("tier") String tier) {
    	
    	dao = new GPU_DaoImpl();
    	List<GPU> myGPUs = dao.findAllGPUByDateAndTier(date, tier);
    	
    	return myGPUs;
    }
	
	/**
	 * 
	 * Path returns all GPU's between today and toDate, today is todays 
	 * date and toDate is the date maximum
	 * 
	 * @param	today, toDate	today String and toDate String used to find a GPU 
	 * 							between two given dates (today, toDate)
	 * 
	 * @return	List<GPU>		List of all GPU's within today and toDate
	 * 
	 * */
	@GET
    @Path("allgpu/fromtoday/{today}&{toDate}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<GPU> findAllGPUFromDateRange(@PathParam("today") String today
    		, @PathParam("toDate") String toDate) {
    	
    	dao = new GPU_DaoImpl();
    	
    	return dao.findAllGPUFromDateRange(today, toDate);
    }
	
	/**
	 * 
	 * Path returns all GPU's between today and toDate while also following
	 * given tier specification
	 * 
	 * @param	today, toDate, tier		today String, toDate String and tier String
	 * 									used to find a GPU between two given dates
	 * 									and that in within the tier specifications
	 * 
	 * @return	List<GPU>				List of all GPU's within today and toDate but
	 * 									also has given tier
	 * 
	 * */
	@GET
    @Path("allgpu/fromtoday/{today}&{toDate}&{tier}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<GPU> findAllGPUFromDateRangeAndTier(@PathParam("today") String today
    		, @PathParam("toDate") String toDate
    		, @PathParam("tier") String tier) {
    	
    	dao = new GPU_DaoImpl();
    	
    	return dao.findAllGPUFromDateRangeAndTier(today, toDate, tier);
    }
	
	/**
	 * 
	 * Path returns Response with Status and embedded object if the
	 * newID does not return null, else the returned Response Status is BAD_REQUEST
	 * 
	 * @param	newGPU		newGPU GPU to be inserted into the database
	 * 
	 * @return	Response	Response returned with Status and embedded GPU object
	 * 
	 * */
	@POST
    @Path("ingpu")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createNewGPU(GPU newGPU) {
    	
    	dao = new GPU_DaoImpl();
    	
    	Long newID = dao.createNewGPU(newGPU);
    	
    	newGPU.setId(newID);
    	
    	if(newID != null) {
    		
    		return Response
        			.status(Response.Status.OK)
        			.entity(newGPU)
        			.build();
    	}else {
    		
    		return Response
    				.status(Response.Status.BAD_REQUEST)
    				.build();
    	}
    }
	
	/**
	 * 
	 * Path returns Response with Status, if the DAO returns true then the
	 * response status is OK else status is BAD REQUEST
	 * 
	 * @param	gpuID, updateGPU	gpuID String used to find GPU in the database and
	 * 								update it with updateGPU GPU
	 * 
	 * @return	Response			Response returned with Status
	 * 
	 * */
	@POST
    @Path("ingpu/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateGPUByID(@PathParam("id") String gpuID, GPU updateGPU) {
		
    	dao = new GPU_DaoImpl();
    	
    	boolean isOkay = dao.updateGPUByID(gpuID, updateGPU);
    	
    	if(isOkay) {
    		
    		return Response
        			.status(Response.Status.OK)
        			.build();
    		
    	}else {
    		
    		return Response
    				.status(Response.Status.BAD_REQUEST)
    				.build();
    	}
    }
}






