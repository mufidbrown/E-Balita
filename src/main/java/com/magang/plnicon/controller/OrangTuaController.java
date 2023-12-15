package com.magang.plnicon.controller;

import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.entity.mapper.balita.BalitaMapper;
import com.magang.plnicon.payload.response.CustomResponse;
import com.magang.plnicon.payload.response.balita.BalitaGetResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class OrangTuaController {

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
