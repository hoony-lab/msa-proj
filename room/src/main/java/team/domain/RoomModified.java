package team.domain;

import java.util.*;
import lombok.*;
import team.domain.*;
import team.infra.AbstractEvent;

@Data
@ToString
public class RoomModified extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private String status;
    private Double price;
    private Long reviewCnt;

    public RoomModified(Room aggregate) {
        super(aggregate);
    }

    public RoomModified() {
        super();
    }
    // keep

}
