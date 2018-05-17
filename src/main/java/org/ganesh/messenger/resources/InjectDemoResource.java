package org.ganesh.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	@GET
	@Path("/annotations")
	public String getParaUsingAnnotations(@MatrixParam("param") String matrixParam,
										  @HeaderParam("authSessionID") String header,
										  @CookieParam("_xsrf") String cookie) {
		return "Matrix Param : "+ matrixParam + " Header Param: "+ header + " Cookie Param: "+ cookie;
		
	}
	/*public String Test() {
		return "Test";
	}*/
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders header) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = header.getCookies().toString();
		return "Path : "+path+ "    Cookies : "+cookies;
	}
	
}
