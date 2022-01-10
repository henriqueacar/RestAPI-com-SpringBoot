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

import br.com.henriqueacar.config.SwaggerConfig;
import br.com.henriqueacar.data.vo.BookVO;
import br.com.henriqueacar.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {SwaggerConfig.BOOK_TAG})
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService services;
	
	@ApiOperation(value ="Book/findAll - Find all books")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll() throws Exception{
		List<BookVO> books = services.findAll();

		books
		.stream()
		.forEach(p -> {
			try {
				p.add(
						linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()
						);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return books;
	}
	
	@ApiOperation(value ="Book/findById - Find specific book by ID")
	@GetMapping(value ="/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id) throws Exception {
		BookVO bookVO = services.findById(id);
		
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		
		return bookVO;
	}
	
	@ApiOperation(value ="Book/create - Create new book on DB")
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			 	 consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO book) throws Exception {
		BookVO bookVO = services.create(book);
		
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		
		return bookVO;
	}
	
	@ApiOperation(value ="Book/update - Update specific book")
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
		    	consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO book) throws Exception{
		BookVO bookVO = services.update(book);
		
		bookVO.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
		
		return bookVO;
	}
	
	@ApiOperation(value ="Book/delete - Deleta specific book by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
