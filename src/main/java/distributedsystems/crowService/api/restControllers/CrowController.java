package distributedsystems.crowService.api.restControllers;

import distributedsystems.crowService.api.payload.CrowPayload;
import distributedsystems.crowService.services.models.Crow;
import distributedsystems.crowService.services.IService.CrowIService;
import distributedsystems.crowService.CrowApplication;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/crow")
@AllArgsConstructor
@NoArgsConstructor
public final class CrowController {

    static final Logger log = LoggerFactory.getLogger(CrowApplication.class);

    @Autowired
    private CrowIService CrowService;

    @GetMapping
    public ResponseEntity<List<Crow>> index() {
        return ResponseEntity.ok(CrowService.findAll());
    }

    @PostMapping
    public ResponseEntity<Crow> create(@RequestBody CrowPayload payload) {
        Crow newCrow = new Crow(payload.getName(),
                payload.getLastLunchTime(),payload.getEnergy(),
                payload.getSizeMind());
        return ResponseEntity.ok(CrowService.save(newCrow));
    }

    @GetMapping("{CrowId}")
    public ResponseEntity<Crow> show(@PathVariable UUID CrowId) throws NotFoundException {
        return ResponseEntity.ok(CrowService.getById(CrowId));
    }

    @DeleteMapping("{CrowId}")
    public ResponseEntity<Void> delete(@PathVariable UUID CrowId) throws NotFoundException {
        CrowService.deleteById(CrowId);
        return ResponseEntity.noContent().build();
    }
}