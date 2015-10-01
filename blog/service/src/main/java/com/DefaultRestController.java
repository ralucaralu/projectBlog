package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.*;

import javax.sound.midi.ControllerEventListener;

/**
 * Created by Raluca on 01.10.2015.
 */
@Controller
public class DefaultRestController {
    @RequestMapping("/")
    public String handlesRequest(){
        return "index.jsp";
    }
}
