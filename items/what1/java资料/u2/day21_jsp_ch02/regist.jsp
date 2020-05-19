<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

<body>
<FORM action="info.jsp" method="post" name="myform">
<TABLE   border="0" cellpadding="0" cellspacing="0" align="center" width="530">
  <TR>
    <TD height="108" colspan="2"><IMG src="images/top.jpg"></TD>
  </TR>
  <TR>
    <TD width="107" height="36">用户名：</TD>
    <TD width="524"><INPUT name="txtUser" type="text" maxlength="16">只能输入字母或数字，4-16个字符</TD>
  </TR>
    <TR>
    <TD width="107" height="36">密码：</TD>
    <TD width="524"><INPUT name="txtPass" type="password">密码长度6-12位</TD>
  </TR>
    <TR>
    <TD width="107" height="36">确认密码：</TD>
    <TD width="524"><INPUT name="txtRPass" type="password"></TD>
  </TR>
    <TR>
    <TD width="107" height="36">性别：</TD>
    <TD width="524">
		<INPUT name="gen" type="radio"   value="男" checked>男&nbsp; 
	    <INPUT name="gen" type="radio" value="女" class="input">女
	</TD>
  </TR>
    <TR>
    <TD width="117" height="36">电子邮件地址：</TD>
    <TD width="524"><INPUT name="txtEmail" type="text">
    输入正确的Email地址</TD>
  </TR>
    <TR>
    <TD width="107" height="36">出生日期：</TD>
    <TD width="524">
	<INPUT name="year" id="year" size="4" maxlength="4" >&nbsp;年&nbsp;&nbsp;
		   <SELECT name="month"  >
		     <OPTION value=1>一月</OPTION>
		     <OPTION value=2>二月</OPTION>
		     <OPTION value=3>三月</OPTION>
		     <OPTION value=4>四月</OPTION>
		     <OPTION value=5>五月</OPTION>
		     <OPTION value=6>六月</OPTION>
		     <OPTION value=7>七月</OPTION>
		     <OPTION value=8>八月</OPTION>
		     <OPTION value=9>九月</OPTION>
		     <OPTION value=10>十月</OPTION>
		     <OPTION value=11>十一月</OPTION>
		     <OPTION value=12>十二月 </OPTION>
		  </SELECT>&nbsp;月&nbsp;&nbsp;
		  	  <SELECT name="day"  >
		     <OPTION value=1>1</OPTION><OPTION value=2>2</OPTION><OPTION value=3>3</OPTION><OPTION value=4>4</OPTION>
			 <OPTION value=5>5</OPTION><OPTION value=6>6</OPTION><OPTION value=7>7</OPTION><OPTION value=8>8</OPTION>
		     <OPTION value=9>9</OPTION><OPTION value=10>10</OPTION><OPTION value=11>11</OPTION><OPTION value=12>12 </OPTION>
			 <OPTION value=13>13</OPTION><OPTION value=14>14</OPTION><OPTION value=15>15</OPTION><OPTION value=16>16</OPTION>
			 <OPTION value=17>17</OPTION><OPTION value=18>18</OPTION><OPTION value=19>19</OPTION><OPTION value=20>20</OPTION>
		     <OPTION value=21>21</OPTION><OPTION value=22>22</OPTION><OPTION value=23>23</OPTION><OPTION value=24>24</OPTION>
			 <OPTION value=25>25</OPTION><OPTION value=26>26</OPTION><OPTION value=27>27</OPTION><OPTION value=28>28</OPTION>
			 <OPTION value=29>29</OPTION><OPTION value=30>30</OPTION><OPTION value=7>31</OPTION>
		  </SELECT>&nbsp;日 
</TD>
  </TR>
  <TR><TD colspan="2" align="center">
  <INPUT type="submit" value="同意以下协议条款并提交">
  </TD></TR>
  <TR><TD colspan="2">
  <TEXTAREA cols="" rows="" readonly="readonly" style="width:480px;height:110px;font-size:12px;color:#666">
一、总则

1．1　用户应当同意本协议的条款并按照页面上的提示完成全部的注册程序。用户在进行注册程序过程中点击"同意"按钮即表示用户与百度公司达成协议，完全接受本协议项下的全部条款。
1．2　用户注册成功后，百度将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。
1．3　用户可以使用百度各个频道单项服务，当用户使用百度各单项服务时，用户的使用行为视为其对该单项服务的服务条款以及百度在该单项服务中发出的各类公告的同意。
1．4　百度会员服务协议以及各个频道单项服务条款和公告可由百度公司随时更新，且无需另行通知。您在使用相关服务时,应关注并遵守其所适用的相关条款。
　　您在使用百度提供的各项服务之前，应仔细阅读本服务协议。如您不同意本服务协议及/或随时对其的修改，您可以主动取消百度提供的服务；您一旦使用百度服务，即视为您已了解并完全同意本服务协议各项内容，包括百度对服务协议随时所做的任何修改，并成为百度用户。
		</TEXTAREA>
  </TD>
  </TR>
</TABLE>
</FORM>
</body>
</HTML>
