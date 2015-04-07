/**
 * @author Kevin Bohinski <bohinsk1@tcnj.edu>
 * For TrentonWorks
 * @version 1.0
 * @since 2015-4-06
 * 
 * BrokenLights
 * Driver.java
 */

/* Setting Package */
package org.trentonworks.brokenlights;

/* Setting Imports */
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Defines urls that can access this servlet. */
@SuppressWarnings("serial")
@WebServlet({ "/driver", "/" })
public class Driver extends HttpServlet {    
	
	/* 
	 * Example URL in:
	 * http://45.56.104.253:8080/lightReq/?bl|Light|40.268835|-74.78091|https://i.imgur.com/57YvXwt.jpg|The light is broken|Kevin|Bohinski|5555555555
	 * 
	 * PSE&G Security email:
	 * PSEG-BAandR@pseg.com
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Writes out our html page */
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
        out.println("<head><title>BrokenLights HttpRequest</title>");
        out.println("<meta charset=\"utf-8\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\"></head>");
		out.println("<body><div class=\"container\">");
		
		/* Obtains the incoming url */
        String[] urlin = getUrlIn(request);
        
        /* Makes a new BrokenLightEntry */
        BrokenLightEntry entryIn = null;
        
        if (urlin.length == 2) {
        	/* There are url args */
            String url = "" + urlin[0] + "?" + urlin[1];
            String[] temp = urlin[1].split("\\|");            
            if (temp[0].equals("bl") && temp.length == 9) {
                entryIn = new BrokenLightEntry(temp[1], Double.parseDouble(temp[2]), Double.parseDouble(temp[3]), temp[4], temp[5], temp[6], temp[7], temp[8]);
                out.println("<h1>Success: Entry Stored</h1>");
                out.println("We think you came from: " + url + " </br>");
                out.println("<p class=\"bg-success\"><b><i>This appears to be a valid BrokenLights entry.</i></b></p></br></br>");
                out.println("Here is your message:</br>");
                out.println(entryIn.toString());
            } else {
                out.println("<h1>Error: Unexpected Message</h1>");
                out.println("We think you came from: " + url + " </br>");
                out.println("<p class=\"bg-danger\"><b><i>This does not appear to be a valid BrokenLights entry.</i></b></p>");
            }
        } else if (urlin.length == 1) {
            String url = "" + urlin[0];
            out.println("<h1>Error: Unexpected Message</h1>");
            out.println("We think you came from: " + url + " </br>");
            out.println("<p class=\"bg-danger\"><b><i>This does not appear to be a valid BrokenLights entry.</i></b></p>");
        }
        
        out.println("</br><h2>If there is an emergency or crime in progress, dial 911.</h2>");
		out.println("</div>");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>");
		out.println("</body></html>");
        
        out.close();
        
	} /* end doGet() */
	
	/**
	 * This method obtains the url inputed by the user.
	 * 
	 * @param httpReqIn : The incoming http request
	 * @return          : String of the full url
	 */
	public String[] getUrlIn(HttpServletRequest httpReqIn) {
		
		/* getRequestURL() returns the part of the url before "?" */
		StringBuffer urlIn = httpReqIn.getRequestURL();
		/* getQueryString() returns the part of the url after "?" */
		String urlArg = httpReqIn.getQueryString();
		
		if (urlArg == null) {
			String[] toreturn = new String[1];
			toreturn[0] = urlIn.toString();
			return toreturn;
		} else {
			String[] toreturn = new String[2];
			toreturn[0] = urlIn.toString();
			toreturn[1] = urlArg;
			return toreturn;
		}
		
	} /* end getUrlIn() */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

} /* end servlet driver */
