package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.ShowSeatType;
import com.example.BookMyShowBackend.Repositories.ShowSeatTypeRepository;
import com.example.BookMyShowBackend.Services.ShowSeatTypeService;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatTypeServiceImpl implements ShowSeatTypeService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public ShowSeatTypeServiceImpl(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    @Override
    public ShowSeatType saveShowSeatType(ShowSeatType showSeatType) {
        return showSeatTypeRepository.saveShowSeatType(showSeatType);
    }
}
