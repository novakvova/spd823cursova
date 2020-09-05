package autoria.web;

import autoria.entities.Car;
import autoria.repositories.CarRepository;
import autoria.repositories.ColorRepository;
import autoria.services.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private CarServiceImpl carService;
    @GetMapping("")
    public String index(Model model)
    {
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("colors", colorRepository.findAll());
        return "cars/index";
    }
    @GetMapping("/create")
    public String create() {
        return "cars/create";
    }

    @PostMapping("/create")
    public String create(Car car){
        carRepository.save(car);
        return "redirect:/cars";
    }
}
