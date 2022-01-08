package br.com.henriqueacar.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id", "title", "author", "date", "price"})
public class BookVO extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	
	@JsonProperty("Autor")
	private String author;
	
	@JsonProperty("Titulo")
	private String title;
	
	@JsonProperty("Preco")
	private Double price;
	
	@JsonProperty("Data de lancamento")
	private Date date;

	public BookVO() {

	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(author, date, key, price, title);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVO other = (BookVO) obj;
		return Objects.equals(author, other.author) && Objects.equals(date, other.date)
				&& Objects.equals(key, other.key) && Objects.equals(price, other.price)
				&& Objects.equals(title, other.title);
	}

}
