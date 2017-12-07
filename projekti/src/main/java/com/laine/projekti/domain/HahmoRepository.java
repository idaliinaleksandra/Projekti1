package com.laine.projekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HahmoRepository extends CrudRepository<Hahmo, Long>{
	List<Hahmo> findByNimi(String nimi);

}
