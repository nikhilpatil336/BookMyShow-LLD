package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Model.UPI;
import com.example.BookMyShowBackend.Repositories.UPIRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryUPIRepository implements UPIRepository {

    Map<Long, UPI> UPIMap = new HashMap<>();

    @Override
    public UPI saveUPI(UPI upi) {
        UPIMap.put(upi.getId(), upi);
        return UPIMap.get(upi.getId());
    }
}
