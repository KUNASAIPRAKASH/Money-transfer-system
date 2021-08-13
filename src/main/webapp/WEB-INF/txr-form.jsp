<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Transaction</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
</head>
<body style="background-color:#C7CC1F">
    
    <div class="container">
        <hr/>
        <div>
          <h2> <center> Money Transfer System</center></h2>
        </div>
        <hr/>
   


        
        <h5>Welcome : ${sessionScope.currentUser}</h5>
        
        

        <hr/>
        <nav class="nav">

            <a class="btn btn-lg btn-primary" href="transfer-transacn.html">Transfer</a>&nbsp;
            <a class="btn btn-lg btn-primary" href="history">History</a>&nbsp;
            <a class="btn btn-lg btn-primary" href="logout">logout</a>&nbsp;

        </nav>
        <hr/>

        <br> 
        
    <%/**   <div class="row>
        <div class="col-4></div>
        <div class="col-4">
            <form action="recent-transaction" method="POST">
            <div class="card">
                <div class="card-header">Start Transaction</div><br>
                    <div class="card-body">
                        <div class="form-group">
                            <label>From Account:</label>
                            <input name="from_ac" placeholder="ac_num" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>To Account:</label>
                            <input name="to_ac" placeholder="ac_num" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Amount:</label>
                            <input name="amount" placeholder="Amount" class="form-control" />
                        </div>
                    <div class="card-footer">
                        <button class="btn btn-dark">Transfer</button>
                    </div>
                </form>
            </div>
        </div>


    </div> **/ %> 
</body>
</html>