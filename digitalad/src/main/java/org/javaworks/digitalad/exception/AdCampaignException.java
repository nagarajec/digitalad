package org.javaworks.digitalad.exception;


/**
 * Class to map application related exceptions
 * 
 * @author amacoder
 *
 */
public class AdCampaignException extends Exception {

	private static final long serialVersionUID = -8999932578270387947L;
	
	/** 
	 * contains redundantly the HTTP status of the response sent back to the client in case of error, so that
	 * the developer does not have to look into the response headers. If null a default 
	 */
	Integer status;
	
	/** application specific error code */
	int code; 
		
	
	/** detailed error description for developers*/
	String developerMessage;	
	
	/**
	 * 
	 * @param status
	 * @param code
	 * @param message
	 * @param developerMessage
	 * @param link
	 */
	public AdCampaignException(int status, String message,
			String developerMessage) {
		super(message);
		this.status = status;
	}

	public AdCampaignException() { }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

					
}