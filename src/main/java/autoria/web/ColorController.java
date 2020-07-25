package autoria.web;

import autoria.entities.Color;
import autoria.repositories.ColorRepository;
import autoria.services.ColorService;
import autoria.services.ColorServiseImpl;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.lang.model.type.ErrorType;
import java.util.List;
import java.util.Optional;


@Controller
public class ColorController {
    //private final ColorService service;

//    public ColorController(ColorService service) {
//        this.service = service;
//    }

    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ColorServiseImpl colorService;

    @GetMapping("/color")
    public String index(Model model)
    {
//        List<Color> colors = colorRepository.findAll();
//        try {
//            Optional<Color> col = colorRepository.findById(3);
//            Color cols = col.get();
//        }
//        catch (Exception ex){
//            return null;
//        }
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
        //colorService.save(color);
        return "deletecolor";
    }

    @PostMapping("/deletecolor/{id}")
    public String deleteColor(@PathVariable("id") Integer id, Color color){
        colorService.deleteById(id);
        return "redirect:/color";
    }

}
