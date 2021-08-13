<%@ page import="java.util.List" %>
<%@ page import="com.project.entity.Transaction" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>History</title>
    <link href="./css/bootstrap.css" type="text/css" rel="stylesheet">
</head>
<body style="background-color:#EAC697" class ="container">
    
    

        <hr/>
        <div>
          <h2> <center> Money Transfer System</center></h2>
        </div>
        <hr/>
        
        
        <hr/>
       <h5> Welcome : ${sessionScope.currentUser}</h5>
        <hr/>
        
        
        <nav class="nav">

            <a class="btn btn-lg btn-primary" href="transfer-transacn.html">Transfer</a>&nbsp;
            <a class="btn btn-lg btn-primary" href="history">History</a>&nbsp;
            <a class="btn btn-lg btn-primary" href="logout">logout</a>&nbsp;


        </nav>
        

        
        <hr/>
           <a class="btn btn-lg btn-primary" href="history?filter=all">All</a>&nbsp;
           <a class="btn btn-lg btn-primary" href="history?filter=top10">Top 10</a>&nbsp;
           <a class="btn btn-lg btn-primary" href="history?filter=debit">DEBIT</a>&nbsp;
           <a class="btn btn-lg btn-primary" href="history?filter=credit">CREDIT</a>&nbsp;
        <hr/>

        <%

          List <Transaction> transactions= (List<Transaction>) request.getAttribute("transactions");
        %>
        
        <table class="table table-stripped">
            <thead>
                <tr>
                    <th>Trans_id</th>
                    <th>Date-time</th>
                    <th>Account</th>
                    <th>Amount</th>
                    <th>Txn_Type</th>
                </tr>
            </thead>
            <tbody>
               <%
               for(Transaction transaction:transactions){
               %>

               <tr>
                   <td><%=transaction.getTrans_id()%></td>
                   <td><%=transaction.getDate_time()%></td>
                   <td><%=transaction.getAccount()%></td>
                   <td><%=transaction.getAmount()%></td>
                   <td><%=transaction.getDebit_or_credit()%></td>
               </tr>
               <%
                  }
               %>

            </tbody>
        </table>
  
</body>
</html>