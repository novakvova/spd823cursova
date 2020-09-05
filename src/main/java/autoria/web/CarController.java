package autoria.web;

import autoria.entities.Car;
import autoria.entities.Color;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public String index(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "cars/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("colors", colorRepository.findAll());
        model.addAttribute("color_id", 1);
        return "cars/create";
    }

    @PostMapping("/create")
    public String create(Car car, int color_id) {
        Color color = colorRepository.findById(color_id).get();
        car.setColor(color);
        carRepository.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        try {
            Optional<Car> car = carRepository.findById(id);
            model.addAttribute("car", car.get());
        } catch (Exception ex) {
            return null;
        }
        return "cars/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        carRepository.deleteById(id);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        try {
            Optional<Car> car = carRepository.findById(id);
            model.addAttribute("car", car.get());
            model.addAttribute("colors", colorRepository.findAll());
        } catch (Exception ex) {
            return null;
        }
        return "cars/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, Car car,  int color_id) {
        Car newCar=carRepository.findById(id).get();
        newCar.setModel(car.getModel());
        newCar.setVendor(car.getVendor());
        Color color = colorRepository.findById(color_id).get();
        newCar.setColor(color);
        carService.save(newCar);
        return "redirect:/cars";
    }
}