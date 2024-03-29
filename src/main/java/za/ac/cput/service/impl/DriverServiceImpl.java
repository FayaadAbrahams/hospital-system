package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepository;
import za.ac.cput.service.DriverService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/*
    DriverServiceImpl.java
    Services Implementation for Driver
    Author: Nonzwakazi Mgxaji
    Student number: 213181584
    Date: 16 August 2022
*/

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public  DriverServiceImpl (DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }



    public Driver getDriver(String id) {
        return driverRepository.findById(id).orElse(null);
    }


    @Override
    public List<Driver> getAll() {
        return this.driverRepository.findAll();
    }

    @Override
    public Driver findById(String id) {
        return driverRepository.findById(id).orElse(new Driver());
    }

    public List listDriver()
    {
        return driverRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Driver> read(String s) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        if (this.driverRepository.existsById(id)) {
            this.driverRepository.deleteById(id);
            return true;
        }
        return false;
    }
}