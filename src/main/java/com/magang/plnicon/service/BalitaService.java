package com.magang.plnicon.service;

import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.payload.request.balita.BalitaCreateRequest;
import com.magang.plnicon.payload.request.balita.BalitaUpdateRequest;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * This interface defines a service for managing books.
 */
public interface BalitaService {

    /**
     * Creates a new book based on the provided request.
     *
     * @param request The request containing book information.
     * @return A {@link BalitaDTO} representing the newly created book.
     */
    BalitaDTO createBalita(BalitaCreateRequest request);

    /**
     * Retrieves a book by its unique identifier.
     *
     * @param balitaId The unique identifier of the book.
     * @return A {@link BalitaDTO} representing the requested book.
     */
    BalitaDTO getBalitaById(String balitaId);



    /**
     * Retrieves a paginated list of all books based on the provided request.
     *
     * @param paginationRequest The request containing pagination information.
     * @return A {@link Page} of {@link BalitaDTO} objects representing the list of books.
     */
    Page<BalitaDTO> getAllBalitas(PaginationRequest paginationRequest);

    /**
     * Updates a book by its unique identifier.
     *
     * @param balitaId The unique identifier of the book.
     * @param request The request containing the updated book information.
     * @return A {@link BalitaDTO} representing the book after the update.
     */
    BalitaDTO updateBalitaById(String bookId, BalitaUpdateRequest request);

    /**
     * Checks if a given amount of a book is available in stock.
     *
     * @param balitaDTO The {@link BalitaDTO} representing the book to check.
     * @param amount The amount of the book to check for availability.
     * @return {@code true} if the specified amount is available in stock, {@code false} otherwise.
     */
    boolean isStockAvailable(BalitaDTO balitaDTO, int amount);

}