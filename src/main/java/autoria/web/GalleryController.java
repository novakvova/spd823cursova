package autoria.web;


import autoria.entities.Gallery;
import autoria.repositories.GalleryRepository;
import autoria.services.GalleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/gallery")
public class GalleryController
{
    @Autowired
    private GalleryRepository galleryRepository;
    @Autowired
    private GalleryServiceImpl galleryService;
    @GetMapping("")
    public String index(Model model)
    {
        model.addAttribute("list", galleryRepository.findAll());
        return "gallery/index";
    }

    @GetMapping("/create")
    public String create() {
         return "gallery/create";
    }

    @PostMapping("/create")
    public String create(Gallery color){
        galleryRepository.save(color);
        return "redirect:/gallery";
    }
    @GetMapping("/delete/{id}")
    public String deleteGallery(@PathVariable("id") Integer id, Model model){
        try {
            Optional<Gallery> gall = galleryRepository.findById(id);
            model.addAttribute("gallery", gall.get());
        }
        catch (Exception ex){
            return null;
        }
        return "gallery/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteGallery(@PathVariable("id") Integer id, Gallery gallery){
        galleryService.deleteById(id);
        return "redirect:/gallery";
    }

    @GetMapping("/edit/{id}")
    public String updateGallery(@PathVariable("id") Integer id, Model model){
        try {
            Optional<Gallery> gall = galleryRepository.findById(id);
            model.addAttribute("gallery", gall.get());
        }
        catch (Exception ex){
            return null;
        }
        return "gallery/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateGallery(@PathVariable("id") Integer id, Gallery gallery){
        galleryService.save(gallery);
        return "redirect:/gallery";
    }
}
