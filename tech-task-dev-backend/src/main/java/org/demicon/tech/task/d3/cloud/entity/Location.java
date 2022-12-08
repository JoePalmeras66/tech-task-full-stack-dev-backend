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
@Table(name="location")
public class Location extends Base implements Serializable {
    @CreatedDate
    private OffsetDateTime createdOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    private Street street;

    @Column(nullable=false)
    @NotNull(message="City is mandatory")
    private String city;

    @Column(nullable=false)
    @NotNull(message="State is mandatory")
    private String state;

    @Column(nullable=false)
    @NotNull(message="Country is mandatory")
    private String country;

    @Column(nullable=false)
    @NotNull(message="Postcode is mandatory")
    private String postcode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id", referencedColumnName = "id")
    private Coordinates coordinates;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timezone_id", referencedColumnName = "id")
    private Timezone timezone;

    @PrePersist
    public void onPrePersist() {
        createdOn = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
