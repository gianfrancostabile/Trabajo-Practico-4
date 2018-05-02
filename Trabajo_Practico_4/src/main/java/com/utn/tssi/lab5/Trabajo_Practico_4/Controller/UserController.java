package com.utn.tssi.lab5.Trabajo_Practico_4.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utn.tssi.lab5.Trabajo_Practico_4.Model.User;
import com.utn.tssi.lab5.Trabajo_Practico_4.Repository.UserRepository;

import net.sf.uadetector.OperatingSystem;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    
    private String getCurrentDate() {
    	String date = "";
    	
    	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	date = sdf.format(new Date());
    	
    	return date;
    }
    
    @RequestMapping(value = "/find/all")
    @ResponseBody
    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    @RequestMapping(value = "/find/date")
    @ResponseBody
    public List<User> findByDate() {
    	String date = getCurrentDate();
    	
        return this.userRepository.findByDate(date);
    }

    @RequestMapping(value = "/find/browser")
    @ResponseBody
    public List<?> findByBrowser() {
    	String date = getCurrentDate();
    	
        return this.userRepository.findByBrowser(date);
    }

    @RequestMapping(value = "/find/os")
    @ResponseBody
    public List<?> findByOS() {
    	String date = getCurrentDate();
    	
        return this.userRepository.findByOS(date);
    }

    @RequestMapping(value = "/find/browser-os")
    @ResponseBody
    public List<?> findByBrowserOS() {
    	String date = getCurrentDate();
    	
        return this.userRepository.findByBrowserOS(date);
    }

    /* @param request me va a traer la informacion del usuario tales como el browser y el sistema operativo
     * utilizo una libreria externa que me da exactamente que sistema operativo y que browser utiliza el usuario
     * leyendo el user agent.
     */
    @RequestMapping(value = "")
    @ResponseBody
    public String readme(@RequestHeader("user-agent")String userAgent) {

        UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();

        String browser = getBrowser(parser.parse(userAgent));
        String os = getOperatingSystem(parser.parse(userAgent));

        User user = new User(browser, os);

        return this.userRepository.save(user).toString();
    }

    // el readableuseragent tiene toda la informacion sobre el browser del usuario y retorno el nombre del mismo.
    private String getBrowser(ReadableUserAgent agent){
        return agent.getName();
    }

    // al readableuseragent lo utilizo para obtener el sistema operativo y retorno su nombre.
    private String getOperatingSystem(ReadableUserAgent agent) {
        OperatingSystem os = agent.getOperatingSystem();
        return os.getName();
    }

}
