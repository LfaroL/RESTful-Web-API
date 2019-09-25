# RESTful-Web-API
Exercise tracking web service using Java and REST <br /><br />
Technologies used: <br />
<ul>
  <li>Maven: build automation</li>
  <li>Tomcat: local web server</li>
  <li>Jersey: RESTful web services framework</li>
  </ul>
  
  <br />
  Follows the Richardson Maturity Model up to Level 2:<br />
  Level 1: Resources - focused on nouns and accessed through URIs<br />
  Level 2: HTTP Verbs - interaction with resources through HTTP verbs<br />
  Level 3: Hypermedia - client interacts with server through hypermedia <br />
  
  <br />
  
  Classes:
  <ul>
  <li>Activity: model for data</li>
  <li>ActivityRepository: store Activity data and methods that interact with Activity data</li>
  <li>ActivityResource: methods for each HTTP verb</li>
  <li>ActivityClient: web client to call ActivityResource methods through HTTP verbs</li>
  <li>ActivityClientTest: validates method and returned object correctness</li>
  </ul>
  
  <br />
  HTTP Verbs:<br />
  GET:
  <img src="images/GET_method.png" height=200 width=auto/>
  <img src="images/GET_postman.png" height=200 width=auto/>
<br />
  POST:
  <img src="images/POST_method.png" height=200 width=auto/>
  <img src="images/POST_postman.png" height=200 width=auto/>
  <br />
  POST JSON:
  <img src="images/POST_JSON_method.png" height=200 width=auto/>
  <img src="images/POST_JSON_postman.png" height=200 width=auto/>
  <br />
  PUT:
  <img src="images/PUT_method.png" height=200 width=auto/>
  <img src="images/PUT_postman.png" height=200 width=auto/>
  <br />
  DELETE:
  <img src="images/DELETE_method.png" height=200 width=auto/>
  <img src="images/DELETE_postman.png" height=200 width=auto/>
  
  <br /><br />
  JUnit Results:<br />
    <img src="images/junit_tests.png" height=250 width=auto/>
