<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
			   
			
			body  
			{  
			    margin: 0;  
			    padding: 0;  
			    background-color:#f7e6ff;  
			    font-family: 'Arial';  
			}  
			.login{  
			        width: 382px;  
			        overflow: hidden;  
			        margin: auto;  
			        padding-right: 40px;
			        padding-left: 100px; 
			         padding-top: 50px;
			          padding-bottom: 50px;   
			        background: #e6b3ff;  
			        border-radius: 15px ;  
			          
			}  
			h2{  
			    text-align: center;  
			    color:  #8b00cc;  
			    padding: 20px;  
			}  
			label{  
			    color: white;  
			    font-size: 17px;  
			}  
			#username{  
			    width: 300px;  
			    height: 30px;  
			    border: none;  
			    border-radius: 3px;  
			    padding-left: 8px;  
			}  
			#password{  
			    width: 300px;  
			    height: 30px;  
			    border: none;  
			    border-radius: 3px;  
			    padding-left: 8px;  
			      
			}  
			#log{  
			    width: 300px;  
			    height: 30px;  
			    border: none;  
			    border-radius: 17px;  
			    padding-left: 7px;  
			    color: blue;  
			  
			  
			}  
			span{  
			    color: red;  
			    font-size: 17px;  
			    padding-top:20px;
			}  
			a{  
			    float: right;  
			    background-color: grey;  
			}  
    
    </style>   
</head>    
<body>    
    <h2>Login Page</h2><br>    
    <div class="login">    
    <form id="login" method="post" action="login">    
        <label><b>User Name     
        </b>    
        </label>    
        <input type="text" name="username" id="username" placeholder="Username">    
        <br><br>    
        <label><b>Password     
        </b>    
        </label>    
        <input type="Password" name="password" id="password" placeholder="Password">    
        <br><br>    
        <input type="submit" name="log" id="log" value="Log In">       
        <br><br>    
 
        <span><% if(request.getAttribute("status")!=null){%>
        	
        	***<%= request.getAttribute("status") %>***
        	
        <% } %></span>    
        <br>   
    </form>     
</div>    
</body>    
</html>     