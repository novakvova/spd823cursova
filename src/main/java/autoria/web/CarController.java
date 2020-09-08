package autoria.web;

import autoria.entities.Car;
import autoria.entities.Color;
import autoria.repositories.CarRepository;
import autoria.repositories.ColorRepository;
import autoria.services.CarServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        List<Car> cars=carRepository.findAll();
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
    public String create(Car car, int color_id){
        Color color=colorRepository.findById(color_id).get();
        car.setColor(color);
        carRepository.save(car);
        return "redirect:/cars";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        try {
            Optional<Car> car = carRepository.findById(id);
            model.addAttribute("car", car.get());
        }
        catch (Exception ex){
            return null;
        }
        return "cars/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Integer id){
        carService.deleteById(id);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        try {
            Optional<Car> car = carRepository.findById(id);
            model.addAttribute("car", car.get());
            model.addAttribute("colors", colorRepository.findAll());
        }
        catch (Exception ex){
            return null;
        }
        return "cars/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, Car car, int color_id, @RequestParam("images[]") MultipartFile[] files) {
        Car update=carRepository.findById(id).get();
        update.setModel(car.getModel());
        update.setVendor(car.getVendor());
        Color color=colorRepository.findById(color_id).get();
        update.setColor(color);
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
            try {
                byte[] bytes = file.getBytes();
                String rootPath =  "src/main/resources/templates/cars/uploads";
                System.out.println(rootPath);
                File dir = new File(rootPath + File.separator);
                if (!dir.exists())
                    dir.mkdirs();
                if(i==0)
                    update.setImage_1(name);
                if(i==1)
                    update.setImage_2(name);
                if(i==2)
                    update.setImage_3(name);
                if(i==3)
                    update.setImage_4(name);
                if(i==4)
                    update.setImage_5(name);
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        carService.save(update);
        return "redirect:/cars";
    }
}
