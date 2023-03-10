# City Parking Management API 
# cpm-goosfraba
<hr>
This api was created using Spring Boot. It connects to a MySQL Database. 
Db connection details can be found in /resources/application.properties. 

Project description available at this [link](https://docs.google.com/document/d/1tE8wNIzkiZZjVuvSg8tF7HYh0R0TH6c6JCuF_jnGuUc/edit).
<br>
I implemented this API using Service Layer Design Pattern, more details [here](https://java-design-patterns.com/patterns/service-layer/#explanation).
And I tried to follow OOP and SOLID principles.
<br> 

<hr>
This api exposes the following endpoints: <br>
<table>
    <tr>
        <th>Method</th>
        <th>endpoint</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>POST</td>
        <td>/api/cities</td>
        <td>Create a new city</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/api/cities/{cityId}</td>
        <td>Get city by id</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/api/cities/{cityCode}</td>
        <td>Get city by code</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/api/cities</td>
        <td>Get all cities</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/facilities/{cityId}</td>
        <td>Ceate parking facility (for specific city)</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/facilities/{facilityId}</td>
        <td>Get parking facility by id</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/facilities/city/{cityId}</td>
        <td>Get all parking facilities (for a given city)</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/vehicles/{cityId}</td>
        <td>Create vehicle (for a given city)</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/vehicles/{cityCode}</td>
        <td>Get vehicles by city code</td>
    </tr>
    <tr>
        <td>PUT</td>
        <td>/vehicles/{facilityId}</td>
        <td>Park vehicle in a parking facility</td>
    </tr>
    <tr>
        <td>PUT</td>
        <td>/vehicles</td>
        <td>Un-park vehicle</td>
    </tr>

</table>
 

