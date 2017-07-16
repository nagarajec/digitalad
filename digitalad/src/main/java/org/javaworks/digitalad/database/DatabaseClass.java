/**
 * 
 */
package org.javaworks.digitalad.database;

import java.util.HashMap;
import java.util.Map;

import org.javaworks.digitalad.model.AdResourceDetail;
import org.javaworks.digitalad.model.PartnerProfile;

/**
 * @author Nagaraj
 *
 */
public class DatabaseClass {
	
	
	private static Map<Long,AdResourceDetail> adResources = new HashMap<>();
	
	private static Map<Long,PartnerProfile> partners = new HashMap<>();
	
	public static Map<Long,AdResourceDetail> getAds()
	{
		return adResources;
	}
	
	public static Map<Long,PartnerProfile> getPartners()
	{
		return partners;
	}

}
