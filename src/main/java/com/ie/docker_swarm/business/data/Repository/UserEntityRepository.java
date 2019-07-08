package com.ie.docker_swarm.business.data.Repository;

import com.ie.docker_swarm.business.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUsername(String username);

}