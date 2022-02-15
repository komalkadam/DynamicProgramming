/**
 * 
 */
package com.komal.studytest;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kkadam
 *
 */
public class DirectoryWatcherExample {
	 
    public static void main(String[] args) throws IOException, InterruptedException {
        /*WatchService watchService
          = FileSystems.getDefault().newWatchService();
 
        Path path = Paths.get(System.getProperty("user.home")+"/test");
 
        path.register(
          watchService, 
            StandardWatchEventKinds.ENTRY_CREATE, 
              StandardWatchEventKinds.ENTRY_DELETE, 
                StandardWatchEventKinds.ENTRY_MODIFY);
 
        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(
                  "Event kind:" + event.kind() 
                    + ". File affected: " + event.context() + ".");
            }
            key.reset();
        }*/
    	Connection conn = null;
    	try {
    	    // db parameters
    	    //String url       = "jdbc:mysql://35.175.111.214:3306/demodb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=EST5EDT\"";
    		String url       = "jdbc:mysql://35.175.111.214:3306/demodb?serverTimezone=UTC&dummyparam=";
    	    String user      = "root";
    	    String password  = "password@123";
    	 
    	    // create a connection to the database
    	    conn = DriverManager.getConnection(url, user, password);
    	    // more processing here
    	    // ... 
    	} catch(SQLException e) {
    	   System.out.println(e.getMessage());
    	   e.printStackTrace();
    	} finally {
    	 try{
    	           if(conn != null)
    	             conn.close();
    	 }catch(SQLException ex){
    	           System.out.println(ex.getMessage());
    	 }
    	}
    }
}

