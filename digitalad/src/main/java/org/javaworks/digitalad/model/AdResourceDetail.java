package org.javaworks.digitalad.model;

import java.time.LocalDateTime;

public class AdResourceDetail {
	
	private Long adPartnerId;
	private int adDuration;
	private String adContent;
	private LocalDateTime created;
	
	public Long getAdPartnerId() {
		return adPartnerId;
	}
	public void setAdPartnerId(Long adPartnerId) {
		this.adPartnerId = adPartnerId;
	}
	public int getAdDuration() {
		return adDuration;
	}
	public void setAdDuration(int adDuration) {
		this.adDuration = adDuration;
	}
	public String getAdContent() {
		return adContent;
	}
	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}
