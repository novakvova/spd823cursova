package autoria.services;

import autoria.entities.Gallery;
import autoria.repositories.GalleryRepository;

public interface GalleryService {
    Gallery findByName(String name);
    Gallery save(GalleryRepository repository);
}
