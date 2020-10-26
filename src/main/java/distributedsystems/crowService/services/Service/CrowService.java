package distributedsystems.crowService.services.Service;

import distributedsystems.crowService.services.models.Crow;
import distributedsystems.crowService.services.repository.CrowRepository;
import distributedsystems.crowService.services.IService.CrowIService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CrowService implements CrowIService {

    @Autowired
    private CrowRepository repository;

    @Override
    public List<Crow> findAll() {
        return (List<Crow>) repository.findAll();
    }

    @Override
    public Crow save(Crow CrowForSave) {
        return repository.save(CrowForSave);
    }

    @Override
    public Crow getById(UUID id) throws NotFoundException {
        Optional<Crow> tempCrow = repository.findById(id);
        if (tempCrow.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Crow with id %s does not exist", id));
    }

    @Override
    public void deleteById(UUID id) throws NotFoundException {
        repository.delete(getById(id));
    }
}