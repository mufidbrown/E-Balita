package com.magang.plnicon.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopikForumRequest {

    @NotBlank
    private String judul;

    @NotBlank
    private String keterangan;
}
