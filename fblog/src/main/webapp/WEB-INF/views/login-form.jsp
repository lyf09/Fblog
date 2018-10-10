<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://www.springframework.org/tags" prefix="st" %>   --%>
  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>test</title>  
    <link rel="stylesheet"  type= "text/css" href="css/login.css">
	<script src="js/jquery.min.js"></script> 
	<script>
		// 判断是账号和密码是否为空
		function check(){
		    var usercode = $("#username").val();
		    var password = $("#password").val();
		    if(username=="" || password==""){
		    	//$("#message").text("账号或密码不能为空！");
		    	alert("账号或密码不能为空！");
		        return false;
		    }  
		    return true;
		}
	</script>

</head>
<body>

<div class="dowebok">
        <div class="logo"></div>
	        <form action="${pageContext.request.contextPath}/login.do" method="post" onsubmit="return check()">
	        	<div class="form-item" >
	        	
		            <input id="username" type="text" autocomplete="off" placeholder="用户名/手机" name="username" />
		        </div>
		        <div class="form-item">
		            <input id="password" type="password" autocomplete="off" placeholder="密码"  name="password"/>
		        </div>
		        <div class="form-item">
		        	 <div class="form-item1">
		                <font color="red" >
							 <%-- 提示信息--%>
							 <span id="message">${msg}</span>
						</font>
					</div>
		        	<button id="submit" autocomplete="off">登录</button><br>
		        	
		        </div>  
	        </form>
	         <div class="form-item">
	       	 	<a href="register.do"><button>注册</button></a>
	       	</div>
    </div>
</body>
</html>