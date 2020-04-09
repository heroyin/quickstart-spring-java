package sh.devspace.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class RootController {
    @GetMapping(value = "/")
    @ResponseBody
    public String hello() {
        String response = "<html>" +  
			"<head>" +  
			"	<link rel=\"stylesheet\" href=\"https://devspace.cloud/quickstart.css\">" +  
			"</head>" +  
			"<body>" +  
			"	<img src=\"https://devspace.cloud/img/congrats.gif\" />" +  
			"	<h1>You deployed this project with DevSpace!</h1>" +  
			"	<div>" +  
			"		<h2>Now it's time to start the development mode: </h2>" +  
			"		<ol>" +  
			"			<li>Press CTRL+C or ENTER to terminate <code>devspace open</code></li>" +  
			"			<li>Run: <code>devspace dev</code></li>" +  
			"			<li>Edit this text in <code>main.go</code> and save the file</li>" +  
			"			<li>Check the logs to see how <code>CompileDaemon</code> recompiles and restarts this project</li>" +  
			"			<li>Reload browser to see the changes</li>" +  
			"		</ol>" +  
			"	</div>" +  
			"</body>" +  
			"</html>";

        return response;
    }

}