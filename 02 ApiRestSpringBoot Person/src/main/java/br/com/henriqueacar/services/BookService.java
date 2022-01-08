package br.com.henriqueacar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.henriqueacar.converter.DozerConverter;
import br.com.henriqueacar.data.model.Book;
import br.com.henriqueacar.data.vo.BookVO;
import br.com.henriqueacar.exception.ResourceNotFoundException;
import br.com.henriqueacar.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey()).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
		entity.setAuthor(book.getAuthor());
		entity.setDate(book.getDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		
		return vo;
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
		repository.delete(entity);
	}
	
	public BookVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
		
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	public List<BookVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
	}

}
