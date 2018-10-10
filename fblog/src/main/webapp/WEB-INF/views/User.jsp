<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title></title>
<link href="css/Site.css" rel="stylesheet" type="text/css" />
<link href="css/allcss.css" rel="stylesheet" type="text/css" />
<link href="css/button.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
</head>
<body>
	<div id="kuangjia">
		<!--大div作为框架-->
		<div style="position: relative">
			<div style="position: absolute; top: 6px; left: 8%;">
				<a href="index.do"><font size="5px" color="#7fffd4" class="threed">FBLOG</font></a>
			</div>
			<div class="menu" style="position: absolute; top: 20px; left: 70%;">
				<ul>
					<li><a href="index.do">主页</a></li>
					<li><a href="personage.do">个人</a></li>
					<li><a href="single.html">About</a></li>
					<li><a href="User.do">用户</a></li>
				</ul>
				</table>
			</div>
			<div
				style="position: absolute; top: 50px; left: 5%; width: 90%; border-bottom: 1px solid #000000"></div>
			<div class="t1" id="t2" onclick="(dd(-1))"></div>
			<div class="t1" id="t3" onclick="(dd(+1))"></div>

			<div
				style="position: absolute; top: 100px; left: 10%; width: 80%; height: 200px;">
				<img src="images/${user.username}.jpg" style="width: 100%; height: 100%;">
			</div>

			<div style="position: absolute; top: 320px; left: 10%;">
				<ul class="vertical-list">
					<li><a class="button" onclick="display('add')">添加好友</a></li>
					<li><a class="button" onclick="display('del')">删除好友</a></li>
					<li><a class="button" onclick="display('say')">发表说说</a></li>
					<li><a class="button"onclick="display('user')">个人信息</a></li>
					<li><a class="button" href="logout.do">退出登录</a></li>
				</ul>
			</div>

			<!--添加好友-->
			<div id="add"
				style="display: none; position: absolute; top: 320px; left: 35%; width: 30%; height: 300px;">
				<form action="addFriend.do" method="post">
					<font style="font-size: 20px">请输入添加好友的用户名:</font><br> <input
						type="text" name="fname"><br> <input type="submit"
						value="添加">
				</form>
			</div>
			<!--删除好友-->
			<div id="del"
				style="display: none; position: absolute; top: 320px; left: 35%; width: 30%;">
				<table border="1">
					<c:forEach items="${user.friends}" var="friend">
						<tr id="a1" style="display: block;">
							<td>好友 ${friend.fname }</td>
							<td>&#160&#160&#160&#160&#160&#160&#160&#160&#160&#160&#160</td>
							<td><font style="color: white; font-size: 20px"><a
									href="deleteFriend.do?fid= ${friend.id} ">删除</a> </font></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!--发表说说-->
			<div id="say"
				style="display: none; position: absolute; top: 320px; left: 35%; width: 30%; height: 300px;">

				<form id="textareaDem" action="sendBlog.do" method="post"
					enctype="multipart/form-data" style="position: relative">
					<textarea id="contactus" name="contactus"
						style="height: 260px; width: 99%; border: #9fa8b0 3px solid; caret-color: #bfcbd6;"></textarea>
					<div style="position: absolute; top: 265px; left: 5%">
						<image src="images/image2.png"></image>
						<label class="ui_button ui_button_primary" for="xFile"><image
								src="images/image1.png"></image></label> <input type="file" id="xFile"
							name="bimg" style="position: absolute; clip: rect(0, 0, 0, 0);">
					</div>
					<input type="submit" class="button blue medium"
						style="position: absolute; top: 265px; left: 85%; width: 15%; height: 35px;"
						value="发表">
				</form>
			</div>
			<!--个人信息-->
			<div id="user"
				style="display: none; position: absolute; top: 320px; left: 35%; width: 30%; height: 300px;">
				<form style="position: relative" action="updateUser.do" method="post" enctype="multipart/form-data">
					<table id="user_table">
						<tr>
							<td>用户名:<input type="text" name="username" value="${user.username }"></td>
						</tr>
						<tr>
							<td>密&nbsp&nbsp&nbsp码:<input type="text" name="password" value="${user.password }"></td>
						</tr>
						<tr>
							<td>昵&nbsp&nbsp&nbsp称:<input type="text" name="name" value="${user.name }"></td>
						</tr>
						<tr>
							<td>性&nbsp&nbsp&nbsp别:<input type="text" name="sex" value="${user.sex }"></td>
						</tr>
						<tr>
							<td>所在地:<input type="text" name="city" value="${user.city }"></td>
						</tr>
						<tr>
							<td>生&nbsp&nbsp&nbsp日:<input type="text" name="brithday" value="${user.brithday }"></td>
						</tr>
						<tr>
							<td>手机号:<input type="text" name="tel" value="${user.tel }"></td>
							<td><input type="text" name="id" value="${user.id }" style="display:none"></td>
						</tr>
						<tr>
							<td>上传头像<input type="file" id="yfile" name="fimg"
								style="width: 20%; height: 30px;" onclick="display_img()"></td>
						</tr>
					</table>
					<div id="show_img1"
						style="position: absolute; display: none; top: 2px; left: 65%; border: #ffffff 1px solid; width: 40%; height: 200px;">
						<img src="" style="width: 100%; height: 200px;" id="yimg">
					</div>
					<div id="show_img2"
						style="position: absolute; display: block; top: 2px; left: 65%; border: #ffffff 1px solid; width: 40%; height: 200px;">
						<img src="images/${user.username}.jpg" style="width: 100%; height: 200px;">
					</div>
					<input type="submit" class="button blue bigrounded"
						style="position: absolute; top: 240px; left: 35%; width: 30%; height: 30px;"
						value="提交信息">
				</form>
			</div>
		</div>


	</div>
</body>
</html>
<script>
	var jh = new Array();
	jh[0] = "url(images/bj1.jpg)";
	jh[1] = "url(images/bj2.jpg)";
	jh[2] = "url(images/bj3.jpg)";
	var kj = document.getElementById("kuangjia");/* <!--获取框架div的标签，在下面进行更改背景--> */
	var x = 0;/* <!--定义变量x，建立索引--> */
	function dd(m) {
		x = x + m;
		if (x == -1) {
			x = 1;
		} else if (x == 3) {
			x = 0;
		}
		kj.style.backgroundImage = jh[x];
	}

	window.setTimeout("kj.style.backgroundImage=jh[0]", 0);

    function display(id){
        var traget=document.getElementById('add');
        var traget1=document.getElementById('del');
        var traget2=document.getElementById('say');
        var traget3=document.getElementById('user');
        switch (id){
            case 'add':traget.style.display="";
                traget1.style.display="none";
                traget2.style.display="none";
                traget3.style.display="none";
                break;
            case 'del':traget.style.display="none";
                traget1.style.display="";
                traget2.style.display="none";
                traget3.style.display="none";
                break;
            case 'say':traget.style.display="none";
                traget1.style.display="none";
                traget2.style.display="";
                traget3.style.display="none";
                break;
            case 'user':traget.style.display="none";
                traget1.style.display="none";
                traget2.style.display="none";
                traget3.style.display="";
                break;
        }
    }

	function display_img() {
		var traget = document.getElementById('show_img1');
		var traget1 = document.getElementById('show_img2');
		traget1.style.display = "";
		traget1.style.display = "none";
	}
	
//  提交前预览图片
    $("#yfile").change(function(){
        var objUrl = getObjectURL(this.files[0]) ;
        console.log("objUrl = "+objUrl) ;
        if (objUrl) {
            $("#yimg").attr("src", objUrl) ;
        }
    }) ;
    //建立一個可存取到該file的url
    function getObjectURL(file) {
        var url = null ;
        if (window.createObjectURL!=undefined) { // basic
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }
</script>
