package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.UPI;
import com.example.BookMyShowBackend.Repositories.UPIRepository;
import com.example.BookMyShowBackend.Services.UPIService;
import org.springframework.stereotype.Service;

@Service
public class UPIServiceImpl implements UPIService {
    private UPIRepository upiRepository;
    public UPIServiceImpl(UPIRepository upiRepository){
        this.upiRepository = upiRepository;
    }

    @Override
    public UPI saveUPI(UPI upi) {
        return upiRepository.saveUPI(upi);
    }
}
