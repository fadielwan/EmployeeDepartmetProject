package net.fadi.deptemp.controller;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {
	
	
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	@RequestMapping("/main")
	public String showMain(ModelMap model, HttpServletRequest request) {		
		logger.warn("MAIN()");
		return "welcome";
		
	}
}
