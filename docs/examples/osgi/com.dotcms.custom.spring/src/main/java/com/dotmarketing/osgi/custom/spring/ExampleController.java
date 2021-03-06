package com.dotmarketing.osgi.custom.spring;

import com.dotmarketing.util.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Jonathan Gamba
 *         Date: 4/15/13
 */

@EnableWebMvc
@Configuration
@RequestMapping ("/examplecontroller")
@Controller
public class ExampleController {

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public ModelAndView helloWorld () {
        Logger.info( this.getClass(), "Received request to hello" );
        String myMessage = "Hello World, Spring 4.1.1 and dotCMS!";
        // This will resolve to /application/spring/helloworld.html, and put the String myMessage in the map with key "message"
        return new ModelAndView( "helloworld", "message", myMessage );
    }


    @RequestMapping (value = "/{userName}", method = RequestMethod.GET)
    public String getHello ( @PathVariable String userName, Model model ) {

        Logger.info( this.getClass(), "Received request to hello user" );

        // set the message
        String aMessage = (userName != null)
                ? "Hello EDIT " + userName + ", welcome to Spring 4.1.1 and dotCMS!  "
                : "Hello Total Stranger, welcome to Spring 4.1.1 and dotCMS!  ";

        // Attach message to the Model
        model.addAttribute( "message", aMessage );

        // This will resolve to /application/spring/helloworld.html
        return "helloworld";
    }

}
