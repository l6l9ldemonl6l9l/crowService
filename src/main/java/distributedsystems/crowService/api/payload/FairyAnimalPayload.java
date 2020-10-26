package distributedsystems.crowService.api.payload;

import java.util.Date;

public class FairyAnimalPayload {

    private String name;
    private Date lastLunchTime;
    private int energy;

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
