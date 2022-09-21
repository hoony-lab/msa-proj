package team.domain;

import java.util.*;
import lombok.*;
import team.domain.*;
import team.infra.AbstractEvent;

@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private Integer paymentAmount;
    private Date paymentDate;
    private String paymentStatus;

    public Paid(Payment aggregate) {
        super(aggregate);
    }

    public Paid() {
        super();
    }
    // keep

}