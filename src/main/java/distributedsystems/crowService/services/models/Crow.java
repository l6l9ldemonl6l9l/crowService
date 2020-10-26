package distributedsystems.crowService.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import java.util.Date;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Crow extends FairyAnimal {
    @Column(unique = true)
    private int sizeMind;

    public Crow(String name, Date lastLunchTime, int energy, int sizeMind) {
        super(name, lastLunchTime, energy);
        this.sizeMind = sizeMind;
    }

    public void training() {
        fatigue();
        sizeMind += 2;
    }

    public void voiceVin() {
        System.out.println("Ворнона:...");
    }

    public void voiceFail() {
        System.out.println("Ворона:Kaaaaaaaaaap");
    }

    public void showInformationAboutCrow() {
        System.out.print("Ворнона ");
        showInformation();
        System.out.println(" Текущий ум: " + sizeMind + ".");
    }

    public int getSizeMind() {
        return sizeMind;
    }

}
