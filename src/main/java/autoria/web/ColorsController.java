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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/colors")
public class ColorsController {

    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ColorServiseImpl colorService;

    @GetMapping("")
    public String index(Model model)
    {
        model.addAttribute("colors", colorRepository.findAll());
        return "colors/index";
    }

    @GetMapping("/create")
    public String addColor() {
        //colorService.save(color);
        return "colors/create";
    }

    @PostMapping("/create")
    public String addColor(Color color){
        colorService.save(color);
        return "redirect:/colors";
    }

    @GetMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Integer id, Model model){
        try {
            Optional<Color> col = colorRepository.findById(id);
            model.addAttribute("color", col.get());
        }
        catch (Exception ex){
            return null;
        }
        return "colors/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Integer id, Color color){
        colorService.deleteById(id);
        return "redirect:/colors";
    }

    @GetMapping("/edit/{id}")
    public String updateColor(@PathVariable("id") Integer id, Model model){
        try {
            Optional<Color> col = colorRepository.findById(id);
            model.addAttribute("color", col.get());
        }
        catch (Exception ex){
            return null;
        }
        return "colors/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateColor(@PathVariable("id") Integer id, Color color){
        colorService.save(color);
        return "redirect:/colors";
    }

}
