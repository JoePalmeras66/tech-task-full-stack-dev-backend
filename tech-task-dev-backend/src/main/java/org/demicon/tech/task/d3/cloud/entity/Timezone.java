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
@Table(name="timezone")
public class Timezone extends Base implements Serializable {
    @CreatedDate
    private OffsetDateTime createdOn;

    @Column(nullable=false)
    @NotNull(message="Offset is mandatory")
    private String timezone_offset;

    @Column(nullable=false)
    @NotNull(message="Description is mandatory")
    private String description;

    @PrePersist
    public void onPrePersist() {
        createdOn = OffsetDateTime.now(ZoneOffset.UTC);
    }
}