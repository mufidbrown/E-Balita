package com.magang.plnicon.controller;

import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.entity.mapper.balita.BalitaMapper;
import com.magang.plnicon.payload.response.CustomResponse;
import com.magang.plnicon.payload.response.balita.BalitaGetResponse;
import com.magang.plnicon.service.BalitaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/orangtuas")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class OrangTuaController {

    private final BalitaService balitaService;


    /**
     * Retrieves a Balita by its ID.
     *
     * @param balitaId The ID of the Book to retrieve.
     * @return Response containing information about the requested Book.
     */
    @GetMapping("/{balitaId}")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_ORANG_TUA')")
    public CustomResponse<BalitaGetResponse> getBalitaById(@PathVariable("balitaId") final String balitaId) {
        final BalitaDTO bookEntityFromDb = balitaService.getBalitaById(balitaId);
        final BalitaGetResponse response = BalitaMapper.toGetResponse(bookEntityFromDb);

        return CustomResponse.ok(response);
    }

}
