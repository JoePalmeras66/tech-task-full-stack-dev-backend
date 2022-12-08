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
@Table(name="name")
public class Name extends Base implements Serializable {
    @CreatedDate
    private OffsetDateTime createdOn;

    @Column(nullable=false)
    @NotNull(message="Title is mandatory")
    private String title;

    @Column(nullable=false)
    @NotNull(message="First is mandatory")
    private String first;

    @Column(nullable=false)
    @NotNull(message="Last is mandatory")
    private String last;

    @PrePersist
    public void onPrePersist() {
        createdOn = OffsetDateTime.now(ZoneOffset.UTC);
    }
}