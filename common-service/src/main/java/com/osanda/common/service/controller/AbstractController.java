package com.osanda.common.service.controller;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;

import com.osanda.common.service.AbstractService;

public abstract class AbstractController<D extends Serializable, I extends Serializable> {

	public abstract Logger getLogger();

	public abstract AbstractService<D, I> getAbstractService();

	@PostMapping
	public ResponseEntity<D> save(@Valid @RequestBody D dto) throws Exception {
		getLogger().info("Save ",dto);
		D responce = getAbstractService().save(dto);
		return new ResponseEntity<>(responce, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<D> update(@Valid @RequestBody D dto) throws Exception {
		getLogger().info("Update ",dto);
		D responce = getAbstractService().update(dto);
		return new ResponseEntity<>(responce, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<D> delete(@PathVariable I id) throws Exception {
		getLogger().info("Delete ",id);
		getAbstractService().delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<D>> get() {
		getLogger().info("Get All objects");
		List<D> responce = getAbstractService().get();
		return new ResponseEntity<>(responce, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<D> get(@PathVariable("id") I id) {
		getLogger().info("Get object by id %d",id);
		D responce = getAbstractService().get(id);
		return new ResponseEntity<>(responce, HttpStatus.OK);
	}

}