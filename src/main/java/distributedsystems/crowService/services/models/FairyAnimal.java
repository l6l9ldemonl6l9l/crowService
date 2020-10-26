package distributedsystems.crowService.services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@EnableAutoConfiguration
@MappedSuperclass
public class FairyAnimal {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String name;
    private Date lastLunchTime;
    private int energy;

    public FairyAnimal() {
    }

    public FairyAnimal(String name, Date lastLunchTime, int energy) {
        this.name = name;
        this.lastLunchTime = lastLunchTime;
        this.energy = energy;
        this.id = UUID.randomUUID();
    }

    public void fatigue() {
        if (energy > 5) {
            this.energy -= 5;
        }
    }

    public void eat() {
        this.lastLunchTime = new Date();
        this.energy += 20;
    }

    public void hunting() {
        if (energy > 10) {
            this.energy -= 10;
        }
    }

    public void showInformation() {
        System.out.print(name + ". Животное ело последний раз: " + lastLunchTime + ". Текущая енергия: " + energy + ".");
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastLunchTime() {
        return lastLunchTime;
    }

    public int getEnergy() {
        return energy;
    }
}
