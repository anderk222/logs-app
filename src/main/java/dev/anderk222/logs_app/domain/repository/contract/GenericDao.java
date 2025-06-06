package dev.anderk222.logs_app.domain.repository.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

public  interface  GenericDao<T, D> {
    
    public List<T> findAll();

    public Optional<T> findById(Long id);

    public List<T> match(T catalogue, Pageable pageable);

    public List<T> search(D searchModel, Pageable pageable);

    public T save(T catalogue);

    public void deleteById(Long id);
}
