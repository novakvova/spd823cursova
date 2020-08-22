package autoria.web;

import autoria.entities.Color;
import autoria.repositories.ColorRepository;
import autoria.services.ColorServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ColorServiseImpl colorService;

    @GetMapping("/color")
    public String index(Model model)
    {
        model.addAttribute("colors", colorRepository.findAll());
        return "color";
    }
    @GetMapping("/addcolor")
    public String addColor(){
        //colorService.save(color);
        return "addcolor";
            }

    @PostMapping("/addcolor")
    public String addColor(Color color){
        colorService.save(color);
        return "redirect:/color";
    }

    @GetMapping("/deletecolor/{id}")
    public String deleteColor(@PathVariable("id") Integer id, Model model){
        try {
            Optional<Color> col = colorRepository.findById(id);
            model.addAttribute("color", col.get());
        }
        catch (Exception ex){
            return null;
        }
        return "deletecolor";
    }

    @PostMapping("/deletecolor/{id}")
    public String deleteColor(@PathVariable("id") Integer id, Color color){
        colorService.deleteById(id);
        return "redirect:/color";
    }

    @GetMapping("/updatecolor/{id}")
    public String updateColor(@PathVariable("id") Integer id, Model model){
        try {
            Optional<Color> col = colorRepository.findById(id);
            model.addAttribute("color", col.get());
        }
        catch (Exception ex){
            return null;
        }
        return "updatecolor";
    }

    @PostMapping("/updatecolor/{id}")
    public String updateColor(@PathVariable("id") Integer id, Color color){
        colorService.save(color);
        return "redirect:/color";
    }

}
