package autoria.web;

import autoria.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
