package br.com.henriqueacar.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.henriqueacar.data.vo.BookVO;
import br.com.henriqueacar.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService services;
	
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll() throws Exception{
		List<BookVO> books = services.findAll();
		//adicionar HATEOAS
		return books;
	}
	
	@GetMapping(value ="/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id) throws Exception {
		BookVO bookVO = services.findById(id);
		//adicionar HATEOAS
		return bookVO;
	}
	
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			 	 consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO book) throws Exception {
		BookVO bookVO = services.create(book);
		//adicionar HATEOAS
		return bookVO;
	}
	
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
		    	consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO book) throws Exception{
		BookVO bookVO = services.update(book);
		//adicionar HATEOAS
		return bookVO;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
