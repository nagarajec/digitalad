# digitalad
Ad-campaign application developed on REST API

As per the functional requirements, I have developed this project. Its a maven project and uses jersy(jax-rs) libraries to implement rest apis.


Prerequists to run the project:
1. Eclipse IDE (Any IDE which can run java applications should be fine).
2. Java 8
3. Postman rest client to run rest apis.
4. Tomcat 8 (any tomcat server should be good)

Instructions to run the peoject:

1. Import the project to local directory using git bash
2. Import the local directory project into eclipse using import->existing maven project
2. Build the project 
3. Add  tomcat server and start it
4. Add application to tomcat server and choose run on server.
5. Open postman client to run the APIs.
6. Populate below API resource URI to the address bar in postman and choose respective transfer type(Get/Post)
7. Populate JSON values in the body and  submit the request.
8. Response will be displaying in postman once the request is successfully submitted.


Application APIs:
--------------------------------------------------------------------------------------------------------------------
1. Create Partner API :  http://localhost:8090/digitalad/webapi/campaign/partner/add
    Method Type : POST
    Input JSON body example:
                         {
	                          "partnerAddress" : "1927 Kennedy Dr, Mclean VA 22102",
	                          "partnerName":"Nagaraj"
                         }
    Sample JSON output: 
                        {
	                          "partnerAddress" : "1927 Kennedy Dr, Mclean VA 22102",
	                          "partnerName":"Nagaraj"
                            "partnerId":"1"
                            
                         }
 Note: Since to add a campaign we need partner id and save the same from above out put JSON.
 ---------------------------------------------------------------------------------------------------------------------
 2. Add campaign API : http://localhost:8090/digitalad/webapi/campaign/ad/add
    Method Type: POST
    Input JSON body example:
                              {
	                              "adPartnerId" : "1",
	                              "adDuration":"120",
	                              "adContent":"Comcast BlackFriday Deals!!!"
                              }
    Output JSON :
                      {
                              "adContent": "Christmas Independance Day Coupons",
                              "adDuration": 120,
                              "adPartnerId": 1,
                               "created": "2017-07-16T16:35:18.298"
                      }
 ----------------------------------------------------------------------------------------------------------------------                     
3. Fetch campaign API for partner: http://localhost:8090/digitalad/webapi/campaign/partner/{Id}
	Method Type : GET
	Input value : Give partner id generated from step number 1. Ex: 1
			http://localhost:8090/digitalad/webapi/campaign/partner/1
-----------------------------------------------------------------------------------------------------------------------			
4. Update Ad campaign API : http://localhost:8090/digitalad/webapi/campaign/ad/update
	Note: Ad campaign will update/replace existing ad only if the ad is active.
	Method Type: POST
    Input JSON body example:
                              {
	                              "adPartnerId" : "1",
	                              "adDuration":"180",
	                              "adContent":"Comcast BlackFriday Deals!!!"
                              }
    Output JSON :
                      {
                              "adContent": "Christmas Independance Day Coupons",
                              "adDuration": 180,
                              "adPartnerId": 1,
                               "created": "2017-07-16T16:35:18.298"
                      }
-----------------------------------------------------------------------------------------------------------------------		      
5. List all ad campaigns API : http://localhost:8090/digitalad/webapi/campaign/ad/list
	Note: This api will list all ads irrespective of partner and also includes non active ads aswell.
-----------------------------------------------------------------------------------------------------------------------	
	
To test the application, I have used rest assured tool which is simple and behavior driven. The same can be found in test directory and you can run as JUNIT test.

I hope, I have covered most of the functionalities listed in the requirement document. Please let me know if you have any questions.





