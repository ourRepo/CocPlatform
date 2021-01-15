<%@ page import="com.platform.entity.Users" %>
<%@ page import="com.platform.entity.Topic" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhanghe
  Date: 2021/1/14
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Users user = (Users) request.getSession().getAttribute("user");
    List<Topic> allTopicList = (List<Topic>)request.getSession().getAttribute("allTopicList");
    List<Users> userList = (List<Users>)request.getSession().getAttribute("userList");
%>
<html>
<head>
    <title>CocPlatform</title>
    <script type="text/javascript">
        function topicManage(){
            document.getElementById("userArea").style.display="none";
            document.getElementById("topicArea").style.display="";
        }

        function userManage(){
            document.getElementById("topicArea").style.display="none";
            document.getElementById("userArea").style.display="";
        }
    </script>
</head>
<body>
<div  style="width:500px;margin:auto;">
    <table border="1">
        <tr>
            <td colspan="5">
                <img src="images/mainPage_background.jpg" />
            </td>
        </tr>
        <tr>
            <td style=" width:100px;" align="center">
                <a href="MainPageController">主页</a>
            </td>

            <td style=" width:100px;" align="center">
                <span>VIP</span>
            </td>
            <td style=" width:100px;" align="center">
                <span>个人信息</span>
            </td>
            <td style=" width:200px;" align="center">
                <font size="2" color="#5f9ea0">欢迎 :<%=user.getUserName() %></font>
                <%if(user.getUserStatus().equals("0")||user.getUserStatus().equals("1")||user.getUserStatus().equals("2")){%>
                <font size="1"><a href="ManagePageController">管理</a></font>
                <%}%>
            </td>
        </tr>
        <tr>
            <td align="center" colspan="5">
                <button id="topicManageBtn" name="topicManageBtn" onclick="topicManage()">话题管理</button>
                ****************************
                <button id="userManageBtn" name="userManageBtn" onclick="userManage()">用户管理</button>
            </td>
        </tr>
    </table>
</div>

<!--话题管理区域-->
<div style="width:508px;height:500px;margin:auto;" id="topicArea">
    -------------------------------------------------------------------------
    <table border="1" width="508px">
        <tr>
            <td colspan="2">题目</td><td>作者</td><td>日期</td><td>操作</td>
        </tr>
        <%for(int i=0;i<allTopicList.size();i++){%>
        <tr>
            <td colspan="2"><%=allTopicList.get(i).getTitle()%></td><td><%=allTopicList.get(i).getUserName()%></td><td><%=allTopicList.get(i).getDate()%></td><td><a href="">删除</a> <a href="">置顶</a></td>
        </tr>
        <%}%>
    </table>
</div>

<!--用户管理区域-->
<div style="width:508px;height:500px;margin:auto;display: none;" id="userArea">
    -------------------------------------------------------------------------
    <table border="1" width="508px">
        <tr>
            <td colspan="2">用户名</td><td>账号</td><td>等级</td><td>操作</td>
        </tr>
        <%for(int i=0;i<userList.size();i++){%>
        <tr>
            <td colspan="2"><%=userList.get(i).getUserName()%></td><td><%=userList.get(i).account%></td><td><%=userList.get(i).getUserStatus()%></td><td><a href="">删除</a> <a href="">升级</a></td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
