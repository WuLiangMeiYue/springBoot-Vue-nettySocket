package com.test.repository;

import com.test.entity.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientInfoDao extends JpaRepository<ClientInfo,String> {

    ClientInfo findClientInfoByClientId(String clientId);
}
