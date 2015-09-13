Deployment instructions for Order-processing-service
1. Deploy the war file order-processing-service in \target folder in tomcat webapps folder and start the tomcat
2. Access the http://localhost:8800/order-processing-services/rest/hello/{your_name} in browser to see Hello {your_name} to validate if the service is running properly



Notes
1. Url to place an order using order-processing-service is http://localhost:8800/order-processing-services/rest/order/placeorder
2. Flow diagram is availabe in the same folder for how this order-processing-service works.
3. order-processing-service-client is a simple java client to place order in this order-processing-service.  