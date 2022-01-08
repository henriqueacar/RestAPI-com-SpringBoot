package br.com.henriqueacar.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueacar.data.model.Book;
import br.com.henriqueacar.data.vo.BookVO;


public class MockBook {
	
	public Book mockEntity() {
		return mockEntity(0);
	}
	
	public BookVO mockVO() {
		return mockVO(0);
	}
	
	public List<Book> mockEntityList(){
		List<Book> books = new ArrayList<Book>();
		for(int i = 0; i < 14; i++) {
			books.add(mockEntity(i));
			
		}
		return books;
	}
	
	public List<BookVO> mockVOList(){
		List<BookVO> books = new ArrayList<BookVO>();
		for(int i = 0; i < 14; i++) {
			books.add(mockVO(i));	
		}
		return books; 
	}
	
	private Book mockEntity(Integer number) {
		Book books= new Book();
		books.setAuthor("Autor");
		books.setId(number.longValue());
		books.setPrice(number*2.0);
		books.setTitle("Titulo");
		return books;
	}
	
	private BookVO mockVO(Integer number) {
		BookVO books = new BookVO();
		books.setAuthor("Autor");
		books.setKey(number.longValue());
		books.setPrice(number*2.0);
		books.setTitle("Titulo");
		return books;
	}
	
	

}
