Accessing the REST Patient Service
=================================


A RESTful patient services WADL can be accessed at this URL 

http://localhost:8080/praveenoruganti-apachecxf-jaxrs/services/patientservice?_wadl
 

A HTTP GET request to URL http://localhost:8080/praveenoruganti-apachecxf-jaxrs/services/patientservice/patients/123
returns a Patient instance whose id is 123. The XML document returned:

<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
 <Patient>
	<id>123</id>
	<name>John</name>
 </Patient>
 

A HTTP POST request to URL http://localhost:8080/praveenoruganti-apachecxf-jaxrs/services/patientservice/patients
with the data:

<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
 <Patient>
	<name>Praveen</name>
 </Patient>

adds a patient whose name is Praveen 


A HTTP PUT request to URL http://localhost:8080/praveenoruganti-apachecxf-jaxrs/services/patientservice/patients
with the data:

<Patient>
   <id>124</id>
   <name>Praveen O</name>
</Patient>

updates the patient instance whose id is 124


A HTTP DELETE request to URL http://localhost:8080/praveenoruganti-apachecxf-jaxrs/services/patientservice/patients/124
will delete a Patient instance whose id is 124.


Sub Resource Mapping:

A HTTP GET request to URL http://localhost:8080/praveenoruganti-apachecxf-jaxrs/services/patientservice/prescriptions/223/medicines/323
returns a Medicine instance 323 if it is present in the order 223. The XML document returned:

<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
 <Medicine>
	<description>Medicine 323</description>
	<id>323</id>
 </Medicine>
