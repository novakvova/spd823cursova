package autoria.services;

import autoria.entities.Gallery;
import autoria.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryServiceImpl {
    @Autowired
    public GalleryRepository galleryRepository;


//    public Gallery findByName(String image) {
//        return galleryRepository.findByName(image);
//    }

    public List<Gallery> findAll() {
        return galleryRepository.findAll();
    }

    public Optional<Gallery> findById(Integer id) {
        return galleryRepository.findById(id);
    }

    public Gallery save(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public void deleteById(Integer id) {
        galleryRepository.deleteById(id);
    }
}
