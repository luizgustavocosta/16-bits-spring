package com.costa.luiz.profile.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FictionalCharacterRepository extends JpaRepository<FictionalCharacter, Integer> {
}
