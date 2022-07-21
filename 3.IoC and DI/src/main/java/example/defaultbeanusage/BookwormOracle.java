package example.defaultbeanusage;

import lombok.Setter;

public class BookwormOracle implements Oracle {
    @Setter
    private Encyclopedia encyclopedia;

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - go see the world instead";
    }
}

