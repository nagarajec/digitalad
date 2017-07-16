package org.javaworks.digitalad.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javaworks.digitalad.database.DatabaseClass;
import org.javaworks.digitalad.model.AdResourceDetail;
import org.javaworks.digitalad.model.PartnerProfile;

public class AdProfileService {
	
	private Map<Long, PartnerProfile> partnerProfiles = DatabaseClass.getPartners();
	private Map<Long, AdResourceDetail> ads = DatabaseClass.getAds();
	
	public List<AdResourceDetail> getAds()
	{
		return new ArrayList<AdResourceDetail>(ads.values());
	}
	
	public AdResourceDetail getAd(Long partnerId) 
	{
		if(partnerProfiles.containsKey(partnerId))
		{
			if(ads.containsKey(partnerId))
			{
				AdResourceDetail ad = ads.get(partnerId);
				LocalDateTime currentDateTime = LocalDateTime.now();
				LocalDateTime adActiveDateTime = ad.getCreated().plusSeconds(ad.getAdDuration());
				if(adActiveDateTime.isAfter(currentDateTime))
				{
					return ad;
				}
				else
				{
					return null;
				}
			}
		}
			return null;
	}
	
	public PartnerProfile addPartner(PartnerProfile partner)
	{
		partner.setPartnerId((long) (partnerProfiles.size()+1));
		partnerProfiles.put(partner.getPartnerId(), partner);
		return partner;
	}

	public AdResourceDetail addAd(AdResourceDetail adDetail)
	{
		Long partnerId = adDetail.getAdPartnerId();
		if(partnerProfiles.containsKey(partnerId))
		{
			if(ads.containsKey(partnerId))
			{
				ads.remove(partnerId);
			}
			adDetail.setCreated(LocalDateTime.now());
			ads.put(partnerId, adDetail);
			return adDetail;
		}
		else
			return null;
	}
}
