package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Model.UPI;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryUPIRepository {

    Map<Long, UPI> UPIMap = new HashMap<>();
}
