<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>demo</title>
    <link rel="stylesheet"  type= "text/css" href="css/register.css">
</head>
<body>
	
    <div class="dowebok">
        <form action="register.do" id="myForm" method="post">
			<div class="form-item"></div>
			<div class="form-item">
				<h2 align="center" style="color:white ; font-size:30px">欢&nbsp;迎&nbsp;注&nbsp;册</h2>
			</div>
			<div class="form-item"></div>	
			<center>
	        	<div class="form-item">
	            	<input id="username1" type="text" style="color:black" autocomplete="off" placeholder="用户名" name="username">
					<font color="red" > <%-- 提示信息--%>
						<span id="message">${msg}</span>
					</font>
	            	<p class="tip1" >请输入长度为4至8的登录账号</p>
	        	</div>
				<div class="form-item"></div>
	        	<div class="form-item">
	            	<input id="password1" type="password" autocomplete="off" placeholder="密码" name="password">
	            	<p class="tip2">请输入长度为4至8的登录密码</p>
	        	</div>
				<div class="form-item"></div>
	
			 	<div class="form-item">
	            	<input id="tel1" type="text" autocomplete="off" placeholder="手机号码" name="tel">
	            	<p class="tip3">手机号码长度不合法！</p>
	        	</div>	
			</center>
         
			<div style="margin-left:20%">
				<input type="button" class="register" value="注 册" onclick="rigist();">
			</div>
        	<div class="reg-bar"></div>
		</form>
    </div>
	
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            
			var userName = document.getElementById("username1");
			var password = document.getElementById("password1");
			var tel = document.getElementById("tel1");
            $('#submit').on('click', function () {
				if(userName.value.length<4||userName.value.length>8){
					$('.tip1').show()
					return;
				}
				
				if(password.value.length<4||password.value.length>8){
					$('.tip2').show()
					return;
				
				}

				if(tel.value.length != 11){
					$('.tip3').show()
					return;
				
				}
				$('.myform').submit();
            })
        })
		function rigist(){
				var userName = document.getElementById("username1");
			var password = document.getElementById("password1");
			var tel = document.getElementById("tel1");
			if(userName.value.length<4||userName.value.length>8){
					$('.tip1').show()
					return;
				}
				
				if(password.value.length<4||password.value.length>8){
					$('.tip2').show()
					return;
				
				}

				if(tel.value.length != 11){
					$('.tip3').show()
					return;
				
				}
				myForm.submit();
		}
 
    </script>
		
</body>
</html>