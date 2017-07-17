package org.javaworks.digitalad.test;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

 

public class AdTest {
	
	Map<String,String> partnerMap = new HashMap<String,String>();
	Map<String,String> adResourceDetail = new HashMap<String,String>();
	
	@Test
	public void addPartnerTest() {
		//System.out.println(RestAssured.);
		partnerMap.put("partnerName", "Nagaraj");
		partnerMap.put("partnerAddress", "12345, Victoria Dr, Mclean VA 22102");
		given().contentType("application/json").body(partnerMap).when().post("http://localhost:8090/digitalad/webapi/campaign/partner/add").then().statusCode(200);
    }
	//@Ignore
	@Test
    public void addAd() {
		//addPartnerTest();
		adResourceDetail.put("adPartnerId", "1");
		adResourceDetail.put("adDuration", "3600");
		adResourceDetail.put("adContent", "Mothers Day Celebration Party Coupons!!!");
		given().contentType("application/json").body(adResourceDetail).when().post("http://localhost:8090/digitalad/webapi/campaign/ad/add").then().statusCode(200);
    }
	
	//@Ignore
	@Test
    public void getAdListTest() {
        given().when().get("http://localhost:8090/digitalad/webapi/campaign/ad/list").then().statusCode(200);
    }
	//@Ignore
	@Test
    public void getPartnerAdTest() {
        given().when().get("http://localhost:8090/digitalad/webapi/campaign/partner/1").then().statusCode(200);
    }
	
}
