<html>
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
        out.println("<h3>"+new User("Zhangsan", 3)+"</h3>");
    %>
</body>
</html>
