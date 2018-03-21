package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="easybuy_client_info")
public class ClientInfo {

//    发送方ID
    @Id@NotNull
    private String clientId;
    private short connected;
    private UUID sessiongId;
//    private List friendClients;
    private Date leastconnectedDate;

//    public List getFriendClients() {
//        return friendClients;
//    }
//
//    public void setFriendClients(List friendClients) {
//        this.friendClients = friendClients;
//    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public short getConnected() {
        return connected;
    }

    public void setConnected(short connected) {
        this.connected = connected;
    }

    public UUID getSessiongId() {
        return sessiongId;
    }

    public void setSessiongId(UUID sessiongId) {
        this.sessiongId = sessiongId;
    }

    public Date getLeastconnectedDate() {
        return leastconnectedDate;
    }

    public void setLeastconnectedDate(Date leastconnectedDate) {
        this.leastconnectedDate = leastconnectedDate;
    }


    @Override
    public String toString() {
        return "ClientInfo{" +
                "clientId='" + clientId + '\'' +
                ", connected=" + connected +
                ", leastconnectedDate=" + leastconnectedDate +
                '}';
    }
}
