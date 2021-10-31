package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BbsController {

    @GetMapping("/")
    public String hello(){
        return "bbs";
    }
}
