package com.magang.plnicon.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String pending;

    @NotBlank
    @Size(min = 3, max = 20)
    private String approved;

    @NotBlank
    @Size(min = 3, max = 20)
    private String rejected;

}
