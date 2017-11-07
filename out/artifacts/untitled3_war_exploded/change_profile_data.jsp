<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %><%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/7/17
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//    OjekWSImplService service = new OjekWSImplService();
//    OjekWS eif = service.getPort(OjekWS.class);
    ArrayList<String> parameterNames = new ArrayList<String>();
    Enumeration enumeration = request.getParameterNames();
    while (enumeration.hasMoreElements()) {
        String parameterName = (String) enumeration.nextElement();
        parameterNames.add(parameterName);
        out.print(parameterName + "<br>");
    }



    String ID = "1";
    String Name = "";
    String Phone = "";
    String driver;
    String[] drivers = request.getParameterValues("driver_stat");

    if (drivers != null)
    {
       driver = "1";
    }
    else {
        driver = "0";
    }

%>

<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>


<%
    File file ;
    int maxFileSize = 5000 * 1024;
    int maxMemSize = 5000 * 1024;
    ServletContext context = pageContext.getServletContext();
    String filePath = pageContext.getServletContext().getRealPath("/").replace('\\', '/')+ "img/";

    // Verify the content type
    String contentType = request.getContentType();

    if (contentType.contains("multipart/form-data")) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("/img"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );

        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>JSP File upload</title>");
            out.println("</head>");
            out.println("<body>");

            while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () ) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = "profile-" + ID +".jpg";
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    // Write the file
                    if( fileName.lastIndexOf("\\") >= 0 ) {
                        file = new File( filePath +
                                fileName.substring( fileName.lastIndexOf("\\"))) ;
                    } else {
                        file = new File( filePath +
                                fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                    }
                    fi.write( file ) ;
                    out.println("Uploaded Filename: " + filePath +
                            fileName + "<br>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch(Exception ex) {
            System.out.println(ex);
        }
    } else {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet upload</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>No file uploaded</p>");
        out.println("</body>");
        out.println("</html>");
    }
%>