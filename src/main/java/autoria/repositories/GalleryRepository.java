package autoria.repositories;

import autoria.entities.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Integer>
{
    //public Gallery findByName(String image);
}
