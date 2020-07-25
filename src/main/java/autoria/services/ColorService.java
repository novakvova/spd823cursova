package autoria.services;

import autoria.entities.Color;
import autoria.repositories.ColorRepository;

public interface ColorService {
    Color findByName(String name);

    Color save(ColorRepository repository);
}
