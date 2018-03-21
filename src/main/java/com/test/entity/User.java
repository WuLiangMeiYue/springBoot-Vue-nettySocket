package com.test.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "login_user")
@Table(name = "easybuy_login_user")
public class User {
    @Id
    @Column(name = "login_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name="login_user_name")
    private String name;
    @Column(name="login_user_password")
    private String password;
    @Column(name="connected")
    private short connected;
    @Column(name="sessiong_id")
    private UUID sessionId;
    @Column(name="leastconnected_date")
    private Date leastconnectedDate;

    public short getConnected() {
        return connected;
    }

    public void setConnected(short connected) {
        this.connected = connected;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public Date getLeastconnectedDate() {
        return leastconnectedDate;
    }

    public void setLeastconnectedDate(Date leastconnectedDate) {
        this.leastconnectedDate = leastconnectedDate;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
