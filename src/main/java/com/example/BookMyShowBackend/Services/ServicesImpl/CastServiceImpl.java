package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Repositories.CastRepository;
import com.example.BookMyShowBackend.Services.CastService;
import org.springframework.stereotype.Service;

@Service
public class CastServiceImpl implements CastService {

    private CastRepository castRepository;

    public CastServiceImpl(CastRepository castRepository) {
        this.castRepository = castRepository;
    }

    @Override
    public Cast saveCast(Cast cast) {
        return castRepository.saveCast(cast);
    }
}
