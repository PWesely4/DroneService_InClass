package com.dronerecon.ws;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 *
 * @author Your Name Here :-)
 */
public class DroneDataService extends HttpServlet{


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

        // ##############################
        // 1. Get params passed in.

        // Get the following parameters from the request object and put them into strings:
        // area_id
        // tilex
        // tiley
        // totalcols
        // totalrows
        // ##############################

        String area_id = request.getParameter("area_id");
        String tilex = request.getParameter("tilex");
        String tiley = request.getParameter("tiley");
        String totalcols = request.getParameter("totalcols");
        String totalrows = request.getParameter("totalrows");

        int r = request.getParameter("r");
        int g = request.getParameter("g");
        // get r and g from request.getParameter();


        try {

            // Call weather API.
            URL url = new URL("http://127.0.0.1:8080/dronereconportal/PortalDBService?area_id=" + area_id + "&tilex=" + tilex + "&tiley=" + tiley + "&r=" + r + "&g=" + g);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("An error occurred in doGet() in DroneDataService: " + ex.toString());
        }






        // ##############################
        // 2. Default value of beginning direction.

        // Set a string called sDirection to "right".
        // ##############################
        String sDirection = "right";



        // ##############################
        // 3. Calculate next drone move.

        // Determine next tile to move to.
        // Base this on current x and y.
        // Change sDirection if necessary.
        // Drone must serpentine from top left of grid back and forth down.
        // If rows are done, change sDirection to "stop".
        // ##############################

//check if on even row
        //if(iTileY % 2 == 0){
        // move right currently
        // if tile X equals total cols minus 1 {
        // incraese Y by  1
        // set sDirection to left}
        //
        // esle {
        //incraree x by 1
        //set sDirection to "right"
        //}
        // }


        //else{

// moving left currently
        //{if tile x equals 0 {
        //incraese y by 1
        //set sDiurection to "right"
        //else {
        //decrease X by 1
        //set sDirection to "left"
        // }
        // }
// check if should dbe stopped
        // if Y is now equal to total rows{
        // set sDirectioon to "stop"
        //}


        // ##############################
        // 4. Format & Return JSON string to caller.

        /* Return via out.println() a JSON string like this:
        {"area_id":"[area id from above]", "nextTileX":"[next tile x]", "nextTileY":"[next tile y]", "direction":"[direction string from above]"}
        */
        // ##############################
        String sReturnJson = "{\"area_id\":\"" + area_id + "\", \"nextTileX\":\"" + tilex + "\", \"nextTileY\":\"" + tilex + "\", \"direction\":\"" + sDirection + "\"}\n";



    }
}

