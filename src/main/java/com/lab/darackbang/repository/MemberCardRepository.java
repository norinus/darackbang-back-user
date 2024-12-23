package com.lab.darackbang.repository;

import com.lab.darackbang.entity.MemberCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCardRepository extends JpaRepository<MemberCard, Long>,
        JpaSpecificationExecutor<MemberCard> {
}