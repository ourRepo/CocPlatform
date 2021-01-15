<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/1/11
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CocPlatform</title>
    <script type="text/javascript">
        var url = location.search;
        if(url.indexOf("?")!=-1){
            alert("当前输入的账号重复 请重新输入");
        }

        //校验账号
        function accountCheck(){
            var account = document.getElementById("account").value;
            if(account.length>=16){
                alert("账号输入过长，请重新输入");
                document.getElementById("account").value = "";
            }
        }
        //校验密码
        function passWordCheck(){
            var pass = document.getElementById("password").value;
            if(pass.length>=16){
                alert("密码输入过长，请重新输入");
                document.getElementById("password").value = "";
            }
        }
        //校验再次输入密码
        function passWordAgainCheck(){
            var passAgain = document.getElementById("passwordAgain").value;
            if(passAgain.length>=16){
                alert("密码输入过长，请重新输入");
                document.getElementById("passwordAgain").value = "";
            }
            var pass = document.getElementById("password").value;
            if(pass != passAgain){
                alert("两次输入密码不一致，请重新输入");
                document.getElementById("passwordAgain").value = "";
            }
        }
        //校验姓名
        function userNameCheck(){
            var username = document.getElementById("userName").value;
            if(username.length>=16){
                alert("姓名输入过长，请重新输入");
                document.getElementById("userName").value = "";
            }
        }
        //校验部分内容不能为空
        function checkArea(){
            var account = document.getElementById("account");
            var password = document.getElementById("password");
            var passwordAgain = document.getElementById("passwordAgain");
            var userName = document.getElementById("userName");

            if(account.value==""){
                alert("账号不能为空");
                account.focus();
                return false;
            }
            if(password.value==""){
                alert("密码不能为空");
                password.focus();
                return false;
            }
            if(passwordAgain.value==""){
                alert("再次输入密码不能为空");
                passwordAgain.focus();
                return false;
            }
            if(userName.value==""){
                alert("姓名不能为空");
                userName.focus();
                return false;
            }
        }
    </script>
</head>
<body>
    <div style="width:500px;height:500px;margin:auto;">
        <form method="post" action="RegisterController" onsubmit="return checkArea()">
            <table>
                <tr>
                    <td>
                        <font color="#a52a2a" size="4">请填写以下信息</font>
                    </td>
                    <td>

                    </td>
                    <td>
                        <image src="images/login_background.jpg"></image>
                    </td>
                </tr>
                <tr>
                    <td>
                        请输入账号<font color="red">*</font>：
                    </td>
                    <td>
                        <input type="text" name="account" id="account" onblur="accountCheck()" />
                    </td>
                    <td>
                        <font size="2" color="red">长度小于等于16</font>
                    </td>
                </tr>
                <tr>
                    <td>
                        请输入密码<font color="red">*</font>：
                    </td>
                    <td>
                        <input type="password" name="password" id="password" onblur="passWordCheck()"/>
                    </td>
                    <td>
                        <font size="2" color="red">长度小于等于16</font>
                    </td>
                </tr>
                <tr>
                    <td>
                        请再次输入密码<font color="red">*</font>：
                    </td>
                    <td>
                        <input type="password" name="passwordAgain" id="passwordAgain" onblur="passWordAgainCheck()"/>
                    </td>
                    <td>

                    </td>
                </tr>
                <tr>
                    <td>
                        请输入姓名<font color="red">*</font>：
                    </td>
                    <td>
                        <input type="text" name="userName" id="userName" onblur="userNameCheck()" />
                    </td>
                    <td>
                        <font size="2" color="red">长度小于等于16</font>
                    </td>
                </tr>
                <tr>
                    <td>
                        请选择性别：
                    </td>
                    <td>
                        男<input type="radio" name="gender"  value="1" />
                        女<input type="radio" name="gender"  value="2" />
                    </td>
                    <td>

                    </td>
                </tr>
                <tr>
                    <td>
                        请输入生日：
                    </td>
                    <td>
                        <input type="text" name="birthDay" id="birthDay" />
                    </td>
                    <td>

                    </td>
                </tr>
                <tr>
                    <td>
                        请输入手机号：
                    </td>
                    <td>
                        <input type="text" name="phoneNumber" id="phoneNumber" />
                    </td>
                    <td>

                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="提交" />
                    </td>
                    <td>

                    </td>
                    <td>
                        <input type="reset" value="重置" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
