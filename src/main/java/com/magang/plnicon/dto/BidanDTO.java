package com.magang.plnicon.dto;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing bidan information.
 */
@Getter
@Builder
@EqualsAndHashCode
public class BidanDTO {

    private Long id;
    private UserDTO user;
    private LocalDateTime createdAt;
    private List<CatatanBalitaDTO> catatanBalita;

}
