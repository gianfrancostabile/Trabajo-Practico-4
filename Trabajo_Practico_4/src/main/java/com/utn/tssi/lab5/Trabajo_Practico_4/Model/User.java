package com.utn.tssi.lab5.Trabajo_Practico_4.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id") private Long id;
    @Column(name = "browserName") private String browserName;
    @Column(name = "osName") private String osName;
    @Column(name = "date") private String date;

    public User(String browserName, String osName) {
        this.browserName = browserName;
        this.osName = osName;

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.date = df.format(new Date());
    }

    public User(Long id, String browserName, String osName, String date) {
        this.id = id;
        this.browserName = browserName;
        this.osName = osName;
        this.date = date;
    }

    @Override
    public String toString() {
        String chain = new String("El usuario " + this.id + " uso Browser: " + this.browserName + "; SO: " + this.osName + "; el dia " + this.date);
        return chain;
    }

}
