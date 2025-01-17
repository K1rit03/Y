package com.buildrun.Y.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    private String name;

    public Role() {
        // No-argument constructor for JPA
    }

    public Role(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public enum Values {
        BASIC(1L),
        ADMIN(2L);

        private final Long roleId;

        Values(Long roleId) {
            this.roleId = roleId;
        }

        public Long getRoleId() {
            return roleId;
        }
    }
}