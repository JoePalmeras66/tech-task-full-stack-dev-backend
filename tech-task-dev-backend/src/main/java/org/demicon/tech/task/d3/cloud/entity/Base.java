package org.demicon.tech.task.d3.cloud.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class Base {
    @Id
    @Column(name="id", updatable=false)
    @GenericGenerator(name="uuid-gen", strategy="uuid2")
    @GeneratedValue(generator="uuid-gen")
    @Type(type="pg-uuid")
    private UUID id;
}
