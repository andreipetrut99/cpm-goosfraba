# City Parking Management API 
# cpm-goosfraba
<hr>
This api was created using Spring Boot. It connects to a MySQL Database. 
Db connection details can be found in /resources/application.properties. 

Project description available at this [link](https://docs.google.com/document/d/1tE8wNIzkiZZjVuvSg8tF7HYh0R0TH6c6JCuF_jnGuUc/edit).

<hr>
This api expose the following endpoints: <br>
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
</table>
 
// todo: add other endpoints. 
