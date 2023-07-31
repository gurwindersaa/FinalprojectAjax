<%-- 
    Document   : Inventory
    Created on : 30-Jul-2023, 1:00:08 AM
    Author     : gurwi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="js/items.js"></script>
    </head>
    <body>
        <h2>Inventory Home</h2>
        <h3>Welcome ${email}</h3>
        <table id="items" class="table table-success table-striped-columns">
            <thead>
                <tr>
                    <th>Item id</th>
                    <th>Catagory</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>

            <tbody>

            </tbody>
        </table>
    </body>
</html>
