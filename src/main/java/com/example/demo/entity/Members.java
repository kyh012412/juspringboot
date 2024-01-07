package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue
    private Long m_idx;

    @Column
    private String m_username;

    @Column
    private String m_password;

    @Column
    private String m_id;

    @Column
    private String m_name;

    @Column
    private String m_tel;

    @Column
    private String m_email;

    @Column
    private String m_user_photo;

    @Column
    private String m_is_master;

    @Column
    private String m_is_membership;

    @Column
    private String m_valid_date;

    @Column
    private String m_addr1;

    @Column
    private String m_addr2;

    @Column
    private String m_addr3;

    @Column
    private String m_date_of_birth;
}
