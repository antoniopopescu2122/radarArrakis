
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import ro.uvt.info.services.AtreidesHouse;
import ro.uvt.info.services.HarkonnenHouse;
import ro.uvt.info.services.HouseStrategy;

import java.util.Date;

public class Message implements Visitee {

    @JsonProperty("date")
    @JsonSetter
    @Getter
    private Date Date;
    @JsonProperty("message")
    @JsonSetter
    @Getter
    private String Message;

    @JsonProperty("house")
    @JsonSetter()
    @Getter
    private String House;
    private HouseStrategy HouseStrategy;

    private HouseStrategy getHouseStrategy(){
        return switch (House) {
            case "atreides" -> new AtreidesHouse();
            case "harkonnen" -> new HarkonnenHouse();
            default -> null;
        };
    }
    public void print(){
        if(this.HouseStrategy == null )
            this.HouseStrategy = getHouseStrategy();
        this.HouseStrategy.printMessage(Message);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMessage(this);
    }
}