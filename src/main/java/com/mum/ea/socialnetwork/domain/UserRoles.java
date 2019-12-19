package com.mum.ea.socialnetwork.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UserRoles {
        @Id
        private long userId;
        private long roleId;
}
