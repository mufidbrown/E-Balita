package com.magang.plnicon.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeRequest {

    @NotBlank
    private String topik;

    @NotBlank
    private String keterangan;

    @NotBlank
    private String deskripsi;
}
