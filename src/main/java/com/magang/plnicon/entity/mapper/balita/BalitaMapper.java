package com.magang.plnicon.entity.mapper.balita;

import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.payload.request.balita.BalitaCreateRequest;
import com.magang.plnicon.payload.request.balita.BalitaUpdateRequest;
import com.magang.plnicon.payload.response.CustomPageResponse;
import com.magang.plnicon.payload.response.balita.BalitaCreatedResponse;
import com.magang.plnicon.payload.response.balita.BalitaGetResponse;
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
                .isbn(source.getIsbn())
                .name(source.getName())
                .authorFullName(source.getAuthorFullName())
                .stock(source.getStock())
                .price(source.getPrice())
                .build();
    }

    /**
     * Converts a {@link Book} entity to a {@link BookDTO}.
     *
     * @param book The {@link Book} entity to be converted.
     * @return A {@link BookDTO} containing data from the source entity.
     */
    public static BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .authorFullName(book.getAuthorFullName())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .stock(book.getStock())
                .build();
    }

    /**
     * Converts a {@link BookDTO} to a {@link Book} entity.
     *
     * @param bookDTO The {@link BookDTO} to be converted.
     * @return A {@link Book} entity containing data from the source DTO.
     */
    public static Book toBook(BookDTO bookDTO) {
        return Book.builder()
                .id(bookDTO.getId())
                .name(bookDTO.getName())
                .authorFullName(bookDTO.getAuthorFullName())
                .isbn(bookDTO.getIsbn())
                .price(bookDTO.getPrice())
                .stock(bookDTO.getStock())
                .build();

    }

}









