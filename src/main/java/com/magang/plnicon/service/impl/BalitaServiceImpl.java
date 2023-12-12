package com.magang.plnicon.service.impl;


import com.magang.plnicon.dto.BalitaDTO;
import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.entity.mapper.balita.BalitaMapper;
import com.magang.plnicon.exception.balita.BalitaNotFoundException;
import com.magang.plnicon.payload.request.balita.BalitaCreateRequest;
import com.magang.plnicon.payload.request.balita.BalitaUpdateRequest;
import com.magang.plnicon.repository.BalitaRepository;
import com.magang.plnicon.service.BalitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BalitaServiceImpl implements BalitaService {

    private final BalitaRepository balitaRepository;

    /**
     * Creates a new balita based on the provided request.
     *
     * @param request The request containing balita information.
     * @return A {@link BalitaDTO} representing the newly created balita.
     */
    public BalitaDTO createBalita(BalitaCreateRequest request) {

        final Balita balitaEntityToBeSaved = BalitaMapper.mapForSaving(request);

        return BalitaMapper.toDTO(balitaRepository.save(balitaEntityToBeSaved));
    }

    /**
     * Retrieves a book by its unique identifier.
     *
     * @param balitaId The unique identifier of the book.
     * @return A {@link BalitaDTO} representing the requested book.
     */
    @Transactional
    public BalitaDTO getBalitaById(final String balitaId) {

        Balita balita = balitaRepository.findById(balitaId)
                .orElseThrow(
                        () -> new BalitaNotFoundException(balitaId)
                );

        return BalitaMapper.toDTO(balita);
    }


    /**
     * Retrieves a paginated list of all books based on the provided request.
     *
     * @param paginationRequest The request containing pagination information.
     * @return A {@link Page} of {@link BalitaDTO} objects representing the list of books.
     */
    @Override
    public Page<BalitaDTO> getAllBalitas(PaginationRequest paginationRequest) {

        return balitaRepository
                .findAll(paginationRequest.toPageable())
                .map(BalitaMapper::toDTO);
    }

    /**
     * Updates a book by its unique identifier.
     *
     * @param balitaId The unique identifier of the book.
     * @param request The request containing the updated book information.
     * @return A {@link BalitaDTO} representing the book after the update.
     */
    @Override
    @Transactional
    public BalitaDTO updateBalitaById(final String balitaId, final BalitaUpdateRequest request) {
        final Balita balitaEntityToBeUpdate = balitaRepository
                .findById(balitaId)
                .orElseThrow(() -> new BalitaNotFoundException(balitaId));

        BalitaMapper.mapForUpdating(balitaEntityToBeUpdate, request);

        return BalitaMapper.toDTO(balitaRepository.save(balitaEntityToBeUpdate));
    }
}
