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
@Table(name="coordinates")
public class Coordinates extends Base implements Serializable {
    @CreatedDate
    private OffsetDateTime createdOn;

    @Column(nullable=false)
    @NotNull(message="Latitute is mandatory")
    private String latitute;

    @Column(nullable=false)
    @NotNull(message="Longitute is mandatory")
    private String longitute;

    @PrePersist
    public void onPrePersist() {
        createdOn = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
