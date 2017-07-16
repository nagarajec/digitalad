package org.javaworks.digitalad;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.javaworks.digitalad.model.AdResourceDetail;
import org.javaworks.digitalad.model.PartnerProfile;
import org.javaworks.digitalad.service.AdProfileService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("adresource")
public class AdResource {

	AdProfileService service = new AdProfileService();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
    @GET
    @Path("/listAd")
    @Produces(MediaType.APPLICATION_JSON)
	public List<AdResourceDetail> getAds() {
		return service.getAds();
	}

    
    @POST
    @Path("/addPartner")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PartnerProfile addPartner(PartnerProfile partner)
    {
    	return service.addPartner(partner);
    }
    
    
    @POST
    @Path("/addAd")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AdResourceDetail addAd(AdResourceDetail ad)
    {
    	AdResourceDetail adResourceDetail1 = service.addAd(ad);
    	//System.out.println(adResourceDetail1.toString());
    	//return service.addAd(ad);
    	return adResourceDetail1;
    }
	
    
    @GET
    @Path("/{partnerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AdResourceDetail getPartnerAd(@PathParam("partnerId") Long partnerId)
    {
    	return service.getAd(partnerId);
    } 
	
	
}
