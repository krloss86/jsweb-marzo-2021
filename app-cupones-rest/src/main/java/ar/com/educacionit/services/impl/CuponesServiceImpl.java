package ar.com.educacionit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Cupones;
import ar.com.educacionit.repository.CuponesReposiroty;
import ar.com.educacionit.services.CuponesService;

@Service
public class CuponesServiceImpl implements CuponesService {

	@Autowired
	private CuponesReposiroty repository;
	
	public List<Cupones> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Cupones getById(Long id) {
		return this.repository.getOne(id);
	}

	@Override
	public void update(Cupones cupon) {
		this.repository.save(cupon);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
