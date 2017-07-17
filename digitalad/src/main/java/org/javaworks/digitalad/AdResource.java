package org.javaworks.digitalad;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.javaworks.digitalad.exception.AdCampaignException;
import org.javaworks.digitalad.model.AdResourceDetail;
import org.javaworks.digitalad.model.PartnerProfile;
import org.javaworks.digitalad.service.AdProfileService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("campaign")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdResource {

	AdProfileService service = new AdProfileService();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws AdCampaignException 
     */
	
    @GET
    @Path("/ad/list")
	public Response getAds() throws AdCampaignException {
		return Response.ok().entity(service.getAds()).build();
	}

    
    @POST
    @Path("/partner/add")
    public Response addPartner(PartnerProfile partner) throws AdCampaignException
    {
    	return Response.ok().entity(service.addPartner(partner)).build();
    }
    
    
    @POST
    @Path("/ad/add")
    public Response addAd(AdResourceDetail ad) throws AdCampaignException
    {
    	return Response.ok().entity(service.addAd(ad)).build();
    }
	
    @PUT
    @Path("/ad/update")
    public Response updateAd(AdResourceDetail ad) throws AdCampaignException
    {
    	return Response.ok().entity(service.updateAd(ad)).build();
    }
    
    @GET
    @Path("/partner/{Id}")
    public Response getPartnerAd(@PathParam("Id") Long partnerId) throws AdCampaignException
    {
    	System.out.println(" In AddResource  Exce Handler condition -------------------");
    	return Response.ok().entity(service.getAd(partnerId)).build();
    	 
    } 
	
	
}
