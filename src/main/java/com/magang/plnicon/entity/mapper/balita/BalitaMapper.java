package com.magang.plnicon.entity.mapper.balita;

import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.payload.request.balita.BalitaCreateRequest;
import com.magang.plnicon.payload.request.balita.BalitaUpdateRequest;
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

        bookEntityToBeUpdate.setPrice(request.getPrice());
    }

    /**
     * Converts a {@link BookDTO} to a {@link BookCreatedResponse}.
     *
     * @param source The source {@link BookDTO} to be converted.
     * @return A {@link BookCreatedResponse} containing data from the source DTO.
     */
    public static BookCreatedResponse toCreatedResponse(BookDTO source) {
        return BookCreatedResponse.builder()
                .id(source.getId())
                .isbn(source.getIsbn())
                .name(source.getName())
                .authorFullName(source.getAuthorFullName())
                .stock(source.getStock())
                .price(source.getPrice())
                .build();
    }

    /**
     * Converts a {@link BookDTO} to a {@link BookGetResponse}.
     *
     * @param source The source {@link BookDTO} to be converted.
     * @return A {@link BookGetResponse} containing data from the source DTO.
     */
    public static BookGetResponse toGetResponse(BookDTO source) {
        if (source == null) {
            return null;
        }

        return BookGetResponse.builder()
                .id(source.getId())
                .isbn(source.getIsbn())
                .name(source.getName())
                .authorFullName(source.getAuthorFullName())
                .stock(source.getStock())
                .price(source.getPrice())
                .build();

    }

    /**
     * Converts a {@link Page <BookDTO>} to a {@link CustomPageResponse<BookGetResponse>}.
     *
     * @param sources The source {@link Page<BookDTO>} to be converted.
     * @return A {@link CustomPageResponse<BookGetResponse>} containing converted data.
     */
    public static CustomPageResponse<BookGetResponse> toGetResponse(Page<BookDTO> sources) {

        return CustomPageResponse.of(sources.map(BookMapper::toGetResponse));
    }

    /**
     * Converts a {@link BookDTO} to a {@link BookUpdatedResponse}.
     *
     * @param source The source {@link BookDTO} to be converted.
     * @return A {@link BookUpdatedResponse} containing data from the source DTO.
     */
    public static BookUpdatedResponse toUpdatedResponse(BookDTO source) {
        if (source == null) {
            return null;
        }

        return BookUpdatedResponse.builder()
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









