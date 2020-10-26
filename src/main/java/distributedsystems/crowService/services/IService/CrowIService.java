package distributedsystems.crowService.services.IService;

import distributedsystems.crowService.services.models.Crow;
import javassist.NotFoundException;
import java.util.List;
import java.util.UUID;

public interface CrowIService{
    List<Crow> findAll();

    Crow save(Crow crowForSave);

    Crow getById(UUID id) throws NotFoundException;

    void deleteById(UUID id) throws NotFoundException;
}
