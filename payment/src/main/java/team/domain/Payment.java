package team.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import team.PaymentApplication;
import team.domain.Paid;
import team.domain.PaymentCanceled;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long reservationId;

    private Integer paymentAmount;

    private Date paymentDate;

    private String paymentStatus;

    @PostPersist
    public void onPostPersist() {
        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();

        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void cancelPayment(
        ReservationCancelRequested reservationCancelRequested
    ) {
        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        PaymentCanceled paymentCanceled = new PaymentCanceled(payment);
        paymentCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCancelRequested.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);

            PaymentCanceled paymentCanceled = new PaymentCanceled(payment);
            paymentCanceled.publishAfterCommit();

         });
        */

    }
}