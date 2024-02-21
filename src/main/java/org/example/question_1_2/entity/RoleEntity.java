package org.example.question_1_2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(name = "UNIQUE_ROLE_NAME", columnNames = "role_name") })
public class RoleEntity extends BaseEntity{
    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;


}
