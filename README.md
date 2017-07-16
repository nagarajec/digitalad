# digitalad
Ad-campaign application developed on REST API

As per the functional requirements, I have developed this project. Its a maven project and uses jersy(jax-rs) libraries to implement rest apis.


Prerequists to run the project:
1. Eclipse IDE (Any IDE which can run java applications should be fine).
2. Java 8
3. Postman rest client to run rest apis.
4. Tomcat 8 (any tomcat server should be good)

Instructions to run the peoject:

1. Import the git project to eclipse.
2. Build the project 
3. Add  tomcat server and start it
4. Add application to tomcat server and choose run on server.
5. Open postman client to run the APIs.
6. Populate below API resource URI to the address bar in postman and choose respective transfer type(Get/Post)
7. Populate JSON values in the body and  submit the request.
8. Response will be displaying in postman once the request is successfully submitted.


Application APIs:
1. Create Partner API : http://localhost:8090/digitalad/webapi/adresource/addPartner
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
 
 2. Add campaign API : http://localhost:8090/digitalad/webapi/adresource/addAd
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
                      
3. Fetch campaign API for partner:





