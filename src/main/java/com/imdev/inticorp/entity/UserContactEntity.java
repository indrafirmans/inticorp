package com.imdev.inticorp.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_user_contact")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserContactEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = 36, name = "id_user_contact")
    private String idUserContact;

    @Column(name = "address")
    private String address;

    @Column(name = "id_user")
    private String idUser;
}
