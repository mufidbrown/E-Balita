package com.magang.plnicon.service.impl;


import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.entity.mapper.balita.BalitaMapper;
import com.magang.plnicon.repository.BalitaRepository;
import com.magang.plnicon.service.BalitaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BalitaServiceImpl implements BalitaService {

    private final BalitaRepository balitaRepository;

    /**
     * Creates a new book based on the provided request.
     *
     * @param request The request containing book information.
     * @return A {@link BalitaDTO} representing the newly created book.
     */
    public BalitaDTO createBalita(BalitaCreateRequest request) {

        final Balita balitaEntityToBeSaved = BalitaMapper.mapForSaving(request);

        return BalitaMapper.toDTO(balitaRepository.save(balitaEntityToBeSaved));
    }

    /**
     * Retrieves a book by its unique identifier.
     *
     * @param bookId The unique identifier of the book.
     * @return A {@link BookDTO} representing the requested book.
     */
    @Transactional
    public BookDTO getBookById(final String bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(
                        () -> new BookNotFoundException(bookId)
                );

        return BookMapper.toDTO(book);
    }

    /**
     * Updates the stock quantity of a book by its unique identifier.
     *
     * @param bookId The unique identifier of the book.
     * @param request The request containing the updated stock information.
     * @return A {@link BookDTO} representing the book after the stock update.
     */
    @Override
    @Transactional
    public BookDTO updateBookStockById(String bookId, BookUpdateStockRequest request) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        book.setStock(request.getStock());

        return BookMapper.toDTO(bookRepository.save(book));
    }

    /**
     * Retrieves a paginated list of all books based on the provided request.
     *
     * @param paginationRequest The request containing pagination information.
     * @return A {@link Page} of {@link BookDTO} objects representing the list of books.
     */
    @Override
    public Page<BookDTO> getAllBooks(PaginationRequest paginationRequest) {

        return bookRepository
                .findAll(paginationRequest.toPageable())
                .map(BookMapper::toDTO);
    }

    /**
     * Updates a book by its unique identifier.
     *
     * @param bookId The unique identifier of the book.
     * @param request The request containing the updated book information.
     * @return A {@link BookDTO} representing the book after the update.
     */
    @Override
    @Transactional
    public BookDTO updateBookById(final String bookId, final BookUpdateRequest request) {
        final Book bookEntityToBeUpdate = bookRepository
                .findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        BookMapper.mapForUpdating(bookEntityToBeUpdate, request);

        return BookMapper.toDTO(bookRepository.save(bookEntityToBeUpdate));
    }

    /**
     * Checks if a given amount of a book is available in stock.
     *
     * @param bookDTO The {@link BookDTO} representing the book to check.
     * @param amount The amount of the book to check for availability.
     * @return {@code true} if the specified amount is available in stock, {@code false} otherwise.
     */
    @Override
    public boolean isStockAvailable(BookDTO bookDTO, int amount) {
        if (bookDTO.getStock() < amount) {
            throw new NoAvailableStockException(amount);
        } else {
            return true;
        }

    }

}
