package org.demicon.tech.task.d3.cloud.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Entity
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="street")
public class Street extends Base implements Serializable {
    @CreatedDate
    private OffsetDateTime createdOn;

    @Column(nullable=false)
    @NotNull(message="Number is mandatory")
    private Integer number;

    @Column(nullable=false)
    @NotNull(message="Name is mandatory")
    private String name;

    @PrePersist
    public void onPrePersist() {
        createdOn = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
