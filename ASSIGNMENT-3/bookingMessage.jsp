<!DOCTYPE html>
<html>
    <head>
      <title>Booking Message</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body class="bg-light p-5">
        <%
            String name=request.getParameter("f-name");
            String dest=request.getParameter("dest");
            String dept=request.getParameter("dept");
            String arr=request.getParameter("arr");
            String room=request.getParameter("room");
            String mob=request.getParameter("mob");
        %>
        <div class="container m-5 p-5 bg-info" style="position:absolute; top: 10%; left: 10%;">
          <div class="jumbotron shadow p-3 mb-5 bg-white rounded p-5">
            <h2>Hi .. <i><%=name%></i> <br><br>--------------------------------------------------------------------<br><br> Your confirmation ticket:</h2><br>
            <h4>
                --------------------------------------------------------------------<br>
                Name: <%=name%><br>
                Destination: <%=dest%><br>
                Departure: <%=dept%> <br>
                Arrival: <%=arr%>  <br>
                No of rooms: <%=room%> <br>
                Phone Number: <%=mob%> <br>
                --------------------------------------------------------------------
            </h4>
 
        </div>
               
        </div>
    
    </body>
</html>