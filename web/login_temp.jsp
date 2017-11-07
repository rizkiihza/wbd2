<%--
  Created by IntelliJ IDEA.
  User: hilmi
  Date: 07/11/2017
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@page import="javax.servlet.http.Cookie"%>

<%
    Cookie[] cookielist = request.getCookies();

    for (int i = 0; i < cookielist.length ; i++) {
        if (cookielist[i].getName().equals("username")) {
            out.println("username : " + cookielist[i].getValue());
        } else if (cookielist[i].getName().equals("token")) {
            out.println("token : " + cookielist[i].getValue());
        }
    }

%>

<%--
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>

<%
    try {
        String strUrl = "http://localhost:8080/wbd_war_exploded/loginServlet";

        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;
        String result = "";

        try {
            // create the HttpURLConnection
            url = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");

            // uncomment this if you want to write output to this url
            //connection.setDoOutput(true);

            // give it 15 seconds to respond
            connection.setReadTimeout(15*1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null)
            {
                stringBuilder.append(line + "\n");
            }

            result = stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }

        System.out.println("hasil:");
        System.out.println(result);

    } catch (Exception e) {
        e.printStackTrace();
    }
%>


--%>