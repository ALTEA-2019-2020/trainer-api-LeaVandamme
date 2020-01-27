package com.miage.altea.trainer_api.repository;

import com.miage.altea.trainer_api.bo.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, String> {

    @Override
    <S extends Trainer> S save(S s);

    @Override
    <S extends Trainer> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Trainer> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    Iterable<Trainer> findAll();

    @Override
    Iterable<Trainer> findAllById(Iterable<String> iterable);

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    void delete(Trainer trainer);

    @Override
    void deleteAll(Iterable<? extends Trainer> iterable);

    @Override
    void deleteAll();
}
