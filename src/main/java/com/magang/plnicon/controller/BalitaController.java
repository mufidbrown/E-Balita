package com.magang.plnicon.controller;

import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.entity.mapper.balita.BalitaMapper;
import com.magang.plnicon.payload.request.balita.BalitaCreateRequest;
import com.magang.plnicon.payload.response.CustomResponse;
import com.magang.plnicon.payload.response.balita.BalitaCreatedResponse;
import com.magang.plnicon.payload.response.balita.BalitaGetResponse;
import com.magang.plnicon.service.BalitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/api/v1/balitas")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class BalitaController {

    private final BalitaService balitaService;

    /**
     * Creates a new Balita entity.
     *
     * @param request The request body containing information for creating the Book.
     * @return Response containing information about the created Book.
     */
    @PostMapping()
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponse<BalitaCreatedResponse> createBalita(
            @RequestBody @Valid final BalitaCreateRequest request
    ) {
        final BalitaDTO createdBalitaEntity = balitaService.createBalita(request);
        final BalitaCreatedResponse response = BalitaMapper.toCreatedResponse(createdBalitaEntity);

        return CustomResponse.created(response);
    }


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
