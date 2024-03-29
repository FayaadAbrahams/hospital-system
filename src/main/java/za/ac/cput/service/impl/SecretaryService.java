package za.ac.cput.service.impl;

//Sinenhlanhla Zondi

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Secretary;
import za.ac.cput.repository.SecretaryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class SecretaryService {

    private final SecretaryRepository secretaryRepository;

    @Autowired
    public SecretaryService(SecretaryRepository secretaryRepository)
    {
        this.secretaryRepository = secretaryRepository;
    }

    public Secretary save(Secretary secretary)
    {
        return secretaryRepository.save(secretary);
    }

    public Secretary get(String id)
    {
        return secretaryRepository.findById(id).orElse(null);
    }

    public boolean delete(String id)
    {
        if(secretaryRepository.existsById(id))
        {
            secretaryRepository.deleteById(id);
            return true;
        }
        System.out.println("Secretary ID not found.");
        return false;
    }

    public List listSecretaries()
    {
        return secretaryRepository.findAll()
                .stream().collect(Collectors.toList());
    }

}
