<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>display users</title>
  </head>
  
  <body>
  	<s:iterator value="users" >  
                            <tr align="center">  
                                <td>  
                                    <s:property value="username" />  
                                </td>  
                                <td>  
                                    <s:property value="password" />                  
                                </td>  
                             
                            </tr>  
                            <br>
	</s:iterator>
  </body>
</html>
