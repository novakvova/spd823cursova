package autoria.services;

import autoria.entities.Color;
import autoria.repositories.ColorRepository;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    Color findByName(String name);

    Color save(ColorRepository repository);
}
