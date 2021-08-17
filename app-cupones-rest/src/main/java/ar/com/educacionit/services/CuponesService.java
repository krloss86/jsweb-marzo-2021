package ar.com.educacionit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Cupones;

@Service
public interface CuponesService {

	public List<Cupones> findAll();
	
	public Cupones getById(Long id);

	public void update(Cupones cupon);

	public void delete(Long id);
}
