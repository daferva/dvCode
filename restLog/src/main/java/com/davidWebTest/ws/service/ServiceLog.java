package com.davidWebTest.ws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.davidjpa.model.Log;
import com.davidjpa.test.TestLog;
/**
 * 
 * @author DavidFernando
 *
 */

@Path("/DavidWebTestService")
public class ServiceLog {
	
	@POST
	@Path("/retornaLog")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Log> retornaLog(int top) {
		
		return TestLog.getLog();
		
	}

}
