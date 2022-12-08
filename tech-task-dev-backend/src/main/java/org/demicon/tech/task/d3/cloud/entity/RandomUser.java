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
@Table(name="randomuser")
public class RandomUser extends Base implements Serializable {
    @CreatedDate
    private OffsetDateTime createdOn;

    @Column(nullable=false)
    @NotNull(message="Gender is mandatory")
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    private Name name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Column(nullable=false)
    @NotNull(message="E-Mail is mandatory")
    private String email;

    @PrePersist
    public void onPrePersist() {
        createdOn = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
