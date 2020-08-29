package autoria.web;

import autoria.entities.Color;
import autoria.entities.Gallery;
import autoria.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController
{
    @Autowired
    private GalleryRepository galleryRepository;
    @GetMapping("")
    public String index(Model model)
    {
        model.addAttribute("list", galleryRepository.findAll());
        return "gallery/index";
    }

    @GetMapping("/create")
    public String create() {
        //colorService.save(color);
        return "gallery/create";
    }

    @PostMapping("/create")
    public String create(Gallery color){
        galleryRepository.save(color);
        return "redirect:/gallery";
    }

}
