<%@ page import="com.platform.entity.Users" %>
<%@ page import="com.platform.entity.Topic" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanghe
  Date: 2021/1/11
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Users user = (Users) request.getSession().getAttribute("user");
    List<Topic> specialTopicList = (List<Topic>)request.getSession().getAttribute("specialTopicList");
    List<Topic> normalTopicList = (List<Topic>)request.getSession().getAttribute("normalTopicList");
%>
<html>
<head>
    <title>CocPlatform</title>
    <script type="text/javascript">
        // var url = location.search;
        // if(url.indexOf("?")!=-1){
        //     alert("添加话题成功");
        // }
        //显示添加新话题框
        function showNewTopic(){
            document.getElementById("newTopicArea").style.display="";
        }
        //判空校验
        function checkArea(){
            var title = document.getElementById("title");
            var content = document.getElementById("content");
            if(title.value==""){
                alert("题目不能为空");
                title.focus();
                return false;
            }
            if(content.value==""){
                alert("内容不能为空");
                content.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<center>
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

    <!-- 置顶话题 -->
    <tr>
        <td colspan="5" align="center">
            <font size="5" color="#a52a2a" face="楷体">****************置顶话题****************</font>
        </td>
    </tr>
    <%if(specialTopicList.size()==0){%>
    <tr>
        <td colspan="5" align="center">暂无重要话题</td>
    </tr>
    <%}else{%>
    <% for(int i=0;i<specialTopicList.size();i++){%>
    <tr>
        <td colspan="5">
            <font face="楷体">题目：</font><font size="4" color="#ff8c00"><%=specialTopicList.get(i).getTitle()%></font>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <font face="楷体">日期：</font><font size="2"><%=specialTopicList.get(i).getDate()%></font>
        </td>
        <td>
            <font face="楷体">浏览量：</font><font size="2"><%=specialTopicList.get(i).getViewNum()%></font>
        </td>
        <td colspan="2">
            <font face="楷体">作者：</font><font size="2"><%=specialTopicList.get(i).getUserName()%></font>
        </td>
    </tr>
    <% } }%>

    <!-- 普通话题 -->
    <tr>
        <td colspan="5" align="center">
            <font size="5" color="#a52a2a" face="楷体">****************日常话题****************</font>
        </td>
    </tr>
    <%if(normalTopicList.size()==0){%>
    <tr>
        <td colspan="5" align="center">暂无话题</td>
    </tr>
    <%}else{%>
    <% for(int i=0;i<normalTopicList.size();i++){%>
    <tr>
        <td colspan="5">
            <font face="楷体">题目：</font><font size="4" color="#ff8c00"><%=normalTopicList.get(i).getTitle()%></font>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <font face="楷体">日期：</font><font size="2"><%=normalTopicList.get(i).getDate()%></font>
        </td>
        <td>
            <font face="楷体">浏览量：</font><font size="2"><%=normalTopicList.get(i).getViewNum()%></font>
        </td>
        <td colspan="2">
            <font face="楷体">作者：</font><font size="2"><%=normalTopicList.get(i).getUserName()%></font>
        </td>
    </tr>
    <% } }%>

    <tr>
        <td colspan="5" align="center">
            <button id="newTopic" name="newTopic" onclick="showNewTopic()">＋新增话题＋</button>
        </td>
    </tr>
</table>
</div>
</center>
<center>
<div style="width:508px;height:500px;margin-top:1px;background: darkgray;display: none;" id="newTopicArea">
    <form method="post" action="TopicController" onsubmit="return checkArea()">
        <table border="1" width="508px">
            <tr>
                <td colspan="5" align="center">
                    <font size="5" color="#a52a2a" face="楷体">****************新增话题****************</font>
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    <font size="2" color="#8a2be2">请输入题目：</font>
                </td>
                <td colspan="4">
                    <input type="text" id="title" name="title" style="width: 350px">
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <font size="2" color="#8a2be2">请输入内容：</font><font size="1" color="red">（请注意您的内容输入是否合理，您输入的内容将会受到审核）</font>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <textarea rows="10" cols="60" id="content" name="content"></textarea>
                    <input type="text" value="<%=user.getUserId()%>" hidden="hidden" id="userId" name="userId">
                    <input type="text" value="<%=user.getUserName()%>" hidden="hidden" id="userName" name="userName">
                </td>

            </tr>
            <tr>
                <td colspan="3">
                    <font size="1">按右方按钮进行下一步操作</font>
                </td>
                <td align="center">
                    <input type="submit" value="提交">
                </td>
                <td align="center">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</div>
</center>
</body>
</html>
