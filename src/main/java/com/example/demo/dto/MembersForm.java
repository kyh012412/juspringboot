package com.example.demo.dto;

import com.example.demo.entity.Members;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MembersForm {
    private Long m_idx;
    private String m_username;
    private String m_password;
    private String m_id;
    private String m_name;
    private String m_tel;
    private String m_email;
    private String m_user_photo;
    private String m_is_master;
    private String m_is_membership;
    private String m_valid_date;
    private String m_addr1;
    private String m_addr2;
    private String m_addr3;
    private String m_date_of_birth;

    public Members toEntity(){
        return new Members(m_idx,m_username,m_password,m_id,m_name,m_tel,m_email,m_user_photo,m_is_master,
                m_is_membership,m_valid_date,m_addr1,m_addr2,m_addr3,m_date_of_birth);
    }
}
