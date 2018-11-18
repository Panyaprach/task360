package com.asg360;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Panyaprach Tularak
 */
@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    @NotEmpty
    private String subject;

    @Column(length = 100)
    private String detail;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Task() {
        this.status = Status.PENDING;
    }

    public enum Status {
        PENDING, DONE
    }

}
