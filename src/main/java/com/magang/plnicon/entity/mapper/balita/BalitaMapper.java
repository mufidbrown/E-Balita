package com.magang.plnicon.entity.mapper.balita;

import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.payload.request.balita.BalitaCreateRequest;
import com.magang.plnicon.payload.request.balita.BalitaUpdateRequest;
import com.magang.plnicon.payload.response.CustomPageResponse;
import com.magang.plnicon.payload.response.balita.BalitaCreatedResponse;
import com.magang.plnicon.payload.response.balita.BalitaGetResponse;
import com.magang.plnicon.payload.response.balita.BalitaUpdatedResponse;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;


/**
 * Utility class for mapping between {@link Balita} entities and DTOs.
 */
@UtilityClass
public class BalitaMapper {

    /**
     * Maps a {@link BalitaCreateRequest} to a {@link Balita} entity for saving.
     *
     * @param request The {@link BalitaCreateRequest} to be mapped.
     * @return A new {@link Balita} entity populated with data from the request.
     */
    public static Balita mapForSaving(BalitaCreateRequest request) {
        return Balita.builder()
                .namaLengkap(request.getNamaLengkap())
                .umur(request.getUmur())
                .namaAyah(request.getNamaAyah())
                .namaIbu(request.getNamaIbu())
                .telepon(request.getTelepon())
                .alamat(request.getAlamat())
                .build();
    }

    /**
     * Updates the {@link Balita} entity given as a parameter using the
     * {@link BalitaUpdateRequest} DTO object given as a parameter. <br>
     * This method has no return, the update operation is performed through
     * the reference of the object.
     *
     * @param balitaEntityToBeUpdate {@link Balita} entity to be updated
     * @param request              {@link BalitaUpdateRequest} request DTO object containing update details
     */
    public static void mapForUpdating(Balita balitaEntityToBeUpdate, BalitaUpdateRequest request) {
        balitaEntityToBeUpdate.setNamaLengkap(request.getNamaLengkap());
        balitaEntityToBeUpdate.setUmur(request.getUmur());
        balitaEntityToBeUpdate.setNamaAyah(request.getNamaAyah());
        balitaEntityToBeUpdate.setNamaIbu(request.getNamaIbu());
        balitaEntityToBeUpdate.setTelepon(request.getTelepon());
        balitaEntityToBeUpdate.setAlamat(request.getAlamat());

        balitaEntityToBeUpdate.setNamaLengkap(request.getNamaLengkap());
    }

    /**
     * Converts a {@link BalitaDTO} to a {@link BalitaCreatedResponse}.
     *
     * @param source The source {@link BalitaDTO} to be converted.
     * @return A {@link BalitaCreatedResponse} containing data from the source DTO.
     */
    public static BalitaCreatedResponse toCreatedResponse(BalitaDTO source) {
        return BalitaCreatedResponse.builder()
                .id(source.getId())
                .namaLengkap(source.getNamaLengkap())
                .umur(source.getUmur())
                .namaAyah(source.getNamaAyah())
                .namaIbu(source.getNamaIbu())
                .telepon(source.getTelepon())
                .build();
    }

    /**
     * Converts a {@link BalitaDTO} to a {@link BalitaGetResponse}.
     *
     * @param source The source {@link BalitaDTO} to be converted.
     * @return A {@link BalitaGetResponse} containing data from the source DTO.
     */
    public static BalitaGetResponse toGetResponse(BalitaDTO source) {
        if (source == null) {
            return null;
        }

        return BalitaGetResponse.builder()
                .id(source.getId())
                .namaLengkap(source.getNamaLengkap())
                .umur(source.getUmur())
                .namaAyah(source.getNamaAyah())
                .namaIbu(source.getNamaIbu())
                .telepon(source.getTelepon())
                .alamat(source.getAlamat())
                .build();

    }

    /**
     * Converts a {@link Page <BalitaDTO>} to a {@link CustomPageResponse <BalitaGetResponse>}.
     *
     * @param sources The source {@link Page<BalitaDTO>} to be converted.
     * @return A {@link CustomPageResponse<BalitaGetResponse>} containing converted data.
     */
    public static CustomPageResponse<BalitaGetResponse> toGetResponse(Page<BalitaDTO> sources) {

        return CustomPageResponse.of(sources.map(BalitaMapper::toGetResponse));
    }

    /**
     * Converts a {@link BalitaDTO} to a {@link BalitaUpdatedResponse}.
     *
     * @param source The source {@link BalitaDTO} to be converted.
     * @return A {@link BalitaUpdatedResponse} containing data from the source DTO.
     */
    public static BalitaUpdatedResponse toUpdatedResponse(BalitaDTO source) {
        if (source == null) {
            return null;
        }

        return BalitaUpdatedResponse.builder()
                .id(source.getId())
                .namaLengkap(source.getNamaLengkap())
                .umur(source.getUmur())
                .namaAyah(source.getNamaAyah())
                .namaIbu(source.getNamaIbu())
                .telepon(source.getTelepon())
                .alamat(source.getAlamat())
                .build();
    }

    /**
     * Converts a {@link Balita} entity to a {@link BalitaDTO}.
     *
     * @param balita The {@link Balita} entity to be converted.
     * @return A {@link BalitaDTO} containing data from the source entity.
     */
    public static BalitaDTO toDTO(Balita balita) {
        return BalitaDTO.builder()
                .id(balita.getId())
                .namaLengkap(balita.getNamaLengkap())
                .umur(balita.getUmur())
                .namaAyah(balita.getNamaAyah())
                .namaIbu(balita.getNamaIbu())
                .telepon(balita.getTelepon())
                .alamat(balita.getAlamat())
                .namaLengkap(balita.getNamaLengkap())
                .build();
    }

    /**
     * Converts a {@link BalitaDTO} to a {@link Balita} entity.
     *
     * @param balitaDTO The {@link BalitaDTO} to be converted.
     * @return A {@link Balita} entity containing data from the source DTO.
     */
    public static Balita toBalita(BalitaDTO balitaDTO) {
        return Balita.builder()
                .id(balitaDTO.getId())
                .namaLengkap(balitaDTO.getNamaLengkap())
                .umur(balitaDTO.getUmur())
                .namaAyah(balitaDTO.getNamaAyah())
                .namaIbu(balitaDTO.getNamaIbu())
                .telepon(balitaDTO.getTelepon())
                .alamat(balitaDTO.getAlamat())
                .namaLengkap(balitaDTO.getNamaLengkap())
                .build();

    }

}









