package com.lab.darackbang.mapper.member;

import com.lab.darackbang.dto.member.MemberDTO;
import com.lab.darackbang.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MemberRoleMapper.class)
public interface MemberMapper {

    MemberDTO toDTO(Member member);

    @Mapping(target = "memberRoles", ignore = true)
    @Mapping(target = "memberCard", ignore = true)
    @Mapping(target = "subscribes", ignore = true)
    @Mapping(target = "orderHistories", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "qandas", ignore = true)
    @Mapping(target = "wishlists", ignore = true)
    @Mapping(target = "productReviews", ignore = true)
    @Mapping(target = "orders", ignore = true)
    Member toEntity(MemberDTO memberDTO);
}

