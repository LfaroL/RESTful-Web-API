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
  
  
