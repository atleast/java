<html>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--1,pageEncoding;2, UTF-8;3,contentType-->
<head>
    <title>Please login</title>
</head>
<body>
    <!--浏览器可见的注释-->
    <%--JSP中代码注释，浏览器中无法看见--%>
    <%
      //Java中提供的单行注释，客户端看不见
      /*
        Java中提供的多行注释，客户端看不见
      */
    %>
    <%--insert into user (id,name,password,avatar,email,gender,dept,inst,note) values (0,'lastone','A15','http://www.lastone.net/avatar/0.jpg','lastone@yeah.net',1,'tech','swim','nothing is impossible');--%>

    <%!
        //全局常量
        public static final String pageName="Login Page";
    %>
    <%!
        public String sayHello(String username) {
            return "Hello "+username+" ";
        }
    %>
    <%!
        class User{
            private String username;
            private int age;
            public User(String username, int age){
                this.username=username;
                this.age=age;
            }
            public String toString(){
                return "Your name is "+username+", and you are "+age+" years old.";
            }
        }
    %>
    <%
        out.println("<h1>"+sayHello(request.getParameter("username"))+", you are at "+pageName+".</h1>");
        out.println("<h3>"+new User(request.getParameter("username"), 3)+"</h3>");
    %>
<%--
    <%@page import="java.sql.*"%>
    <%!
	//数据库操作
        public static final String DBDRIVER="com.mysql.jdbc.Driver";
        public static final String DBURL="jdbc:mysql://www.lastone.net:3306/lastone?useSSL=true";
        public static final String DBUSER="root";
        public static final String DBPASSWORD="Atleast2015";
    %>
    <%
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
    %>
    <%
        try {
            Class.forName(DBDRIVER);
            conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
            String sql="select name, email, gender, dept, inst, note from user;";
            psmt=conn.prepareStatement(sql);
            rs=psmt.executeQuery();
    %>
    <table border="1" name="userInfo">
        <tr>
            <td>姓名</td>
            <td>邮箱</td>
            <td>性别</td>
            <td>部门</td>
            <td>兴趣</td>
            <td>宣言</td>
        </tr>
    <%
        while(rs.next()){
            String name=rs.getString(1);
            String email=rs.getString(2);
            int gender=rs.getInt(3);
            String dept=rs.getString(4);
            String inst=rs.getString(5);
            String note=rs.getString(6);

    %>
        <tr>
            <td><%=name%></td>
            <td><%=email%></td>
            <td><%=gender%></td>
            <td><%=dept%></td>
            <td><%=inst%></td>
            <td><%=note%></td>
        </tr>
    <%
        }
    %>
    </table>
    <%   }catch (Exception e){
          System.out.println(e);
        }finally {
            rs.close();
            psmt.close();
            conn.close();
        }
    %>
    <%
        //利用out.println输出9×9
        int row=9;
        int col=9;
        out.println("<table border=\"1\" width=\"100%\">");
        for(int i=1;i<=row;i++){
            out.println("<tr>");
            for(int j=1;j<=col;j++){
                if(i>=j){
                    out.println("<td>"+(i*j)+"</td>");
                }
            }
            out.println("</tr>");
        }
        out.println("</table>");
    %>

    <table border="1" width="100%">
    <%
        for(int i=1;i<=row;i++){
    %>
        <tr>
    <%
            for(int j=1;j<=9;j++){
    %>
    <%
                if(i>=j){
    %>
                    <td><%=i*j%></td>
    <%
                }
            }
    %>
        </tr>
    <%
        }
    %>
    </table>
--%>
</body>
</html>
