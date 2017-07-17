package org.javaworks.digitalad.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javaworks.digitalad.database.DatabaseClass;
import org.javaworks.digitalad.exception.AdCampaignException;
import org.javaworks.digitalad.model.AdResourceDetail;
import org.javaworks.digitalad.model.PartnerProfile;

public class AdProfileService {

	private Map<Long, PartnerProfile> partnerProfiles = DatabaseClass.getPartners();
	private Map<Long, AdResourceDetail> ads = DatabaseClass.getAds();

	public List<AdResourceDetail> getAds() throws AdCampaignException {
		List<AdResourceDetail> adDetails;	
		try {
			adDetails =  new ArrayList<AdResourceDetail>(ads.values());
			System.out.println("Inside 2");
		}catch(Exception ex) {
			throw new AdCampaignException(500, "Server Error: Please try again later sometime",ex.getMessage());
		}
		if(null == adDetails || adDetails.size() <=0)			
		{
			throw new AdCampaignException(404, "No ads found","There are no ads in database to fetch");
		}
		return adDetails;
	}

	public AdResourceDetail getAd(Long partnerId) throws AdCampaignException {
		if (partnerProfiles.containsKey(partnerId)) {
			if (ads.containsKey(partnerId)) {
				AdResourceDetail ad = ads.get(partnerId);
				LocalDateTime currentDateTime = LocalDateTime.now();
				LocalDateTime adActiveDateTime = ad.getCreated().plusSeconds(ad.getAdDuration());
				if (adActiveDateTime.isAfter(currentDateTime)) {
					return ad;
				}
				else {
					throw new AdCampaignException(404, "Ad campaign is expired for partner id :" + partnerId,
							"No entry in database");

				}
			} else {
				throw new AdCampaignException(404, "No capmapign found for partner id :" + partnerId,
						"No entry in database");

			}
		} else {
			throw new AdCampaignException(404, "Partner not found for partner Id:" + partnerId, "No entry in database");

		}
	}

	public PartnerProfile addPartner(PartnerProfile partner) throws AdCampaignException {
		try {
		partner.setPartnerId((long) (partnerProfiles.size() + 1));
		partnerProfiles.put(partner.getPartnerId(), partner);
		return partner;
		}
		catch(Exception ex)
		{
			throw new AdCampaignException(500,
					"Server Error : Unable to add Partner at this time. Please try sometime later", ex.getMessage());
		}
	}

	public AdResourceDetail addAd(AdResourceDetail adDetail) throws AdCampaignException {
		Long partnerId = adDetail.getAdPartnerId();
		if (partnerProfiles.containsKey(partnerId)) {
			if (ads.containsKey(partnerId)) {
				LocalDateTime currentDateTime = LocalDateTime.now();
				AdResourceDetail ad = ads.get(partnerId);
				LocalDateTime adActiveDateTime = ad.getCreated().plusSeconds(ad.getAdDuration());
				if (adActiveDateTime.isAfter(currentDateTime)) {
					throw new AdCampaignException(409, "Ad campaign exist and active!!",
							"Unable to add campaign due to resource exist");
				} else {
					adDetail.setCreated(LocalDateTime.now());
					ads.put(partnerId, adDetail);
					return adDetail;
				}
			}
			else
			{
				adDetail.setCreated(LocalDateTime.now());
				ads.put(partnerId, adDetail);
				return adDetail;
			}

		} else {
			throw new AdCampaignException(404,
					"Unable to add Ad. Partner not found for the provided partner Id : " + adDetail.getAdPartnerId(),
					"There are no partner for provided partner Id in database");
		}
	}
	
	public AdResourceDetail updateAd(AdResourceDetail adDetail) throws AdCampaignException {
		try
		{
			Long partnerId = adDetail.getAdPartnerId();
			if (partnerProfiles.containsKey(partnerId)) {
				if (ads.containsKey(partnerId)) {
					ads.remove(partnerId);
				}
				else
				{
					adDetail.setCreated(LocalDateTime.now());
					ads.put(partnerId, adDetail);
					return adDetail;
				}
				
			}
		}catch(Exception ex)
		{
			throw new AdCampaignException(500,
					"Unable to update the ad campaign for the provided partner Id : "+adDetail.getAdPartnerId(), 
					"Unable to update the ad campaign");
		}
		return adDetail;
		
	}
}
