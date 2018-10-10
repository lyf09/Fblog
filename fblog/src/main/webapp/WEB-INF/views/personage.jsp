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
		<div class="index_div">
			<div class="index_div1">
				<a href="index.do"><font size="5px" color="#7fffd4" class="threed">FBLOG</font></a>
			</div>
			<div class="menu" id="index_div2">
				<ul>
					<li><a href="index.do">主页</a></li>
					<li><a href="personage.do">个人</a></li>
					<li><a href="single.html">About</a></li>
					<li><a href="User.do">用户</a></li>
				</ul>
				</table>
			</div>
			<div class="index_div3"></div>
			<div class="t1" id="t2" onclick="(dd(-1))"></div>
			<div class="t1" id="t3" onclick="(dd(+1))"></div>
			
			<div
				style="position: absolute;background-image: url('images/${user.username}.jpg');background-position:center center; top: 100px; left: 10%; width: 80%; height: 200px;">
				<img src="images/${user.username}.jpg" style="width: 100%; height: 100%;">
			</div>
			
			<!--个人博客-->
			<div class="personage_foreach">
				<c:forEach items="${user.names}" var="name" varStatus="status">
					<div class="index_div_tuijian">
						<div id="roll" class="tdiv1">
							<image src="images/10.jpg"></image>
							<a class="a1" href="#">${name[0]}</a>
							<p class="p1">9-20 12:20:30</p>
							<a style="position: absolute; top: 20px; left: 90%;"
								class="button white medium" href="delblog.do?bid=${name[3]}">删除</a>
						</div>
						<div class="tdiv2">
							<div class="tdiv2_1" id="tdiv2_1">
								<span>${name[1] } </span>
							</div>
							<div class="tdiv2_2">
								<image class="image" src="images/${name[2]}.jpg"></image>
							</div>
						</div>
						<div class="tdiv3">
							<table rules="cols">
								<tr>
									<td><a href="#"><image src="images/collect.png"></image>收藏</a></td>
									<td><a href="#"><image src="images/transmit.png"></image>转发</a></td>
									<td><a href="#"><image src="images/comment.png"></image>评论</a></td>
									<td><a href="#"><image src="images/good.png"></image>赞</a></td>
								</tr>
							</table>
						</div>
					</div>
				</c:forEach>
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
	var kj = document.getElementById("kuangjia");/*<!--获取框架div的标签，在下面进行更改背景-->*/
	var x = 0;/*<!--定义变量x，建立索引-->*/
	function dd(m) {
		x = x + m;
		if (x == -1) {
			x = 2;
		} else if (x == 3) {
			x = 0;
		}
		kj.style.backgroundImage = jh[x];
	}
	window.setTimeout("kj.style.backgroundImage=jh[0]", 0);

	/* 输入框获取到焦点 表示用户正在输入 */
	$("#word").focusin(function() {
		$(".search-row").addClass("active iconfont icon-sousuo");
	});
	/* 输入框失去焦点 表示用户输入完毕 */
	$("#word").focusout(function() {
		/* 判断用户是否有内容输入 */
		if ($(this).val() == "") {
			/* 没有内容输入 改变样式 */
			$(".search-row").removeClass("active iconfont icon-sousuo");
		} else {
			/* 有内容输入 保持样式 并提交表单 */
			$("#search").submit();
		}
	});

	//  隐藏显示
	function show() {
		var box = document.getElementById("tdiv2_1");
		var text = box.innerHTML;
		var newBox = document.createElement("div");
		var btn = document.createElement("a");
		newBox.innerHTML = text.substring(0, 200);
		btn.innerHTML = text.length > 200 ? "...显示全部" : "";
		btn.href = "###";
		btn.onclick = function() {
			if (btn.innerHTML == "...显示全部") {
				btn.innerHTML = "收起";
				newBox.innerHTML = text;
			} else {
				btn.innerHTML = "...显示全部";
				newBox.innerHTML = text.substring(0, 200);
			}
		}
		box.innerHTML = "";
		box.appendChild(newBox);
		box.appendChild(btn);
	}
	show();
</script>
