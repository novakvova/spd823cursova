package autoria.web;

import autoria.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ColorController {
    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("/color")
    public String index(Model model)
    {
        //Long col = colorRepository.count();
        model.addAttribute("colors", colorRepository.findAll());

        return "color";
    }



}
