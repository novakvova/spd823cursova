package autoria.services;

import autoria.entities.Color;
import autoria.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiseImpl {
    @Autowired
    public ColorRepository colorRepository;


    public Color findByName(String name) {
        return colorRepository.findByName(name);
    }

    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    public Optional<Color> findById(Integer id) {
        return colorRepository.findById(id);
    }

    public Color save(Color color) {
        return colorRepository.save(color);
    }

    public void deleteById(Integer id) {
        colorRepository.deleteById(id);
    }
}
