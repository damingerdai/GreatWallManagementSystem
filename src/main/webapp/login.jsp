<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/login" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>长城内部管理系统——登录</title>
    <tags:style></tags:style>
</head>
<body style="margin: 0"  >
    <div id="bj">
        <div id="login_bj">
            <div id="loginback_up">
                <div id="login_title">
                    <h2>长城计算机软件与系统有限公司</h2>
                </div>
                <div id="login_logo">
                    <img src="${pageContext.request.contextPath}/img/LoginImg/logo.jpg"/>
                </div>
                <div id="login_login">
                    <div align="center">
                        <span id="errorMsg" style="color: red">
                            <c:if test="${!empty requestScope.error}">
                                ${requestScope.error}
                            </c:if>
                        </span>
                    </div>
                    <form id="login" name="login" action="${pageContext.request.contextPath}/LoginServlet?method=verify" method="post">
                        <table align="center" width="533">
                            <tr>
                                <td width="98" height="24px" align="right" class="txtname">员工号</td>
                                <td width="152">
                                    <input name="empid" type="text" id="empid" class="textfield" required/>
                                </td>
                            </tr>
                            <tr>
                                <td width="98" heigth="24px" align="right" class="txtname" >密&nbsp;&nbsp;码</td>
                                <td>
                                    <input name="password" type="password" id="psw" class="textfield" required/>
                                </td>
                            </tr>
                             <tr height="38">
                                <td height="38" colspan="2" align="center">
                                    <img src="${pageContext.request.contextPath}/img/LoginImg/button_login.jpg" onclick="LoginIn()">
						            <img src="${pageContext.request.contextPath}/img/LoginImg/botton_close.jpg"/>
						        </td>
				             </tr>
                        </table>
                    </form>
                </div>
            </div>
            <div id="loginback_down"></div>
        </div>
    </div>
</body>
    <tags:js></tags:js>
</html>
