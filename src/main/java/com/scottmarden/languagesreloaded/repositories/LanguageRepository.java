package com.scottmarden.languagesreloaded.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottmarden.languagesreloaded.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	
}
