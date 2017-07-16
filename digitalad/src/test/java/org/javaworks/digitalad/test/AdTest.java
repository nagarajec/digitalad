package org.javaworks.digitalad.test;

import static com.jayway.restassured.RestAssured.given;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.output.WriterOutputStream;
 
import org.javaworks.digitalad.AdResource;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

 

public class AdTest {
	
	Map<String,String> partnerMap = new HashMap<String,String>();
	Map<String,String> adResourceDetail = new HashMap<String,String>();
	
	@Test
	public void addPartnerTest() {
		//System.out.println(RestAssured.);
		partnerMap.put("partnerName", "Nagaraj");
		partnerMap.put("partnerAddress", "12345, Victoria Dr, Mclean VA 22102");
		given().contentType("application/json").body(partnerMap).when().post("http://localhost:8090/digitalad/webapi/adresource/addPartner").then().statusCode(200);
    }
	
	@Test
    public void addAd() {
		adResourceDetail.put("partnerId", "1");
		adResourceDetail.put("adDuration", "3600");
		adResourceDetail.put("adContent", "Mothers Day Celebration Party Coupons!!!");
		given().contentType("application/json").body(partnerMap).when().post("http://localhost:8090/digitalad/webapi/adresource/addAd").then().statusCode(204).extract().asString();
    }
	
	
	@Test
    public void getAdListTest() {
        given().when().get("http://localhost:8090/digitalad/webapi/adresource/listAd").then().statusCode(200);
    }
	
}
