package com.lab.darackbang.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_age_month_stat")
public class AgeMonthStat extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // 월별아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 연령대
    @Column(name = "age_group", nullable = false, length = 2)
    private String ageGroup;

    // 년
    @Column(name = "year", nullable = false, length = 4)
    private String year;

    // 월
    @Column(name = "month", nullable = false, length = 2)
    private String month;

    // 판매액
    @Column(name = "sale_total_price", nullable = false)
    private Integer saleTotalPrice;
}