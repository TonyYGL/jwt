package com.tutorabc.jwt.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "t_setting")
public class Setting {

    @Id
    @GeneratedValue
    private Long id;

    private String settingKey;
    private String settingValue;
    private int isDel;

}
