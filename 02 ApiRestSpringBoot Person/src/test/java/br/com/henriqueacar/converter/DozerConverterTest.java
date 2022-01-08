package br.com.henriqueacar.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.henriqueacar.converter.mocks.MockBook;
import br.com.henriqueacar.converter.mocks.MockPerson;
import br.com.henriqueacar.data.model.Book;
import br.com.henriqueacar.data.model.Person;
import br.com.henriqueacar.data.vo.BookVO;
import br.com.henriqueacar.data.vo.PersonVO;

public class DozerConverterTest {
	
    MockPerson inputObject;
    MockBook inputObjectBook;

    @Before
    public void setUp() {
        inputObject = new MockPerson();
        inputObjectBook = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        BookVO bookOutput = DozerConverter.parseObject(inputObjectBook.mockEntity(), BookVO.class);
        
        //Person
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("PrimeiroNome", output.getFirstName());
        Assert.assertEquals("Sobrenome", output.getLastName());
        Assert.assertEquals("Endereço teste0", output.getAddress());
        Assert.assertEquals("Masculino", output.getGender());
        
        //Book
        Assert.assertEquals(Long.valueOf(0L), bookOutput.getKey());
        Assert.assertEquals("Autor", bookOutput.getAuthor());
        Assert.assertEquals("Titulo", bookOutput.getTitle());
        Assert.assertEquals(Double.valueOf(0D), bookOutput.getPrice());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        List<BookVO> bookOutputList = DozerConverter.parseListObjects(inputObjectBook.mockEntityList(), BookVO.class);
        
        PersonVO outputZero = outputList.get(0);
        BookVO bookOutputZero = bookOutputList.get(0);
        
        //Person
        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("PrimeiroNome", outputZero.getFirstName());
        Assert.assertEquals("Sobrenome", outputZero.getLastName());
        Assert.assertEquals("Endereço teste0", outputZero.getAddress());
        Assert.assertEquals("Masculino", outputZero.getGender());
        
        //Book
        Assert.assertEquals(Long.valueOf(0L), bookOutputZero.getKey());
        Assert.assertEquals("Autor", bookOutputZero.getAuthor());
        Assert.assertEquals("Titulo", bookOutputZero.getTitle());
        Assert.assertEquals(Double.valueOf(0D), bookOutputZero.getPrice());
        
        PersonVO outputSeven = outputList.get(7);
        BookVO bookOutputSeven = bookOutputList.get(7);
        
        //Person
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("PrimeiroNome", outputSeven.getFirstName());
        Assert.assertEquals("Sobrenome", outputSeven.getLastName());
        Assert.assertEquals("Endereço teste7", outputSeven.getAddress());
        Assert.assertEquals("Feminino", outputSeven.getGender());
        
        //Book
        Assert.assertEquals(Long.valueOf(7L), bookOutputSeven.getKey());
        Assert.assertEquals("Autor", bookOutputSeven.getAuthor());
        Assert.assertEquals("Titulo", bookOutputSeven.getTitle());
        Assert.assertEquals(Double.valueOf(14D), bookOutputSeven.getPrice());
        
        PersonVO outputTwelve = outputList.get(12);
        BookVO bookOutputTwelve = bookOutputList.get(12);
        
        //Person
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("PrimeiroNome", outputTwelve.getFirstName());
        Assert.assertEquals("Sobrenome", outputTwelve.getLastName());
        Assert.assertEquals("Endereço teste12", outputTwelve.getAddress());
        Assert.assertEquals("Masculino", outputTwelve.getGender());
        
        //Book
        Assert.assertEquals(Long.valueOf(12L), bookOutputTwelve.getKey());
        Assert.assertEquals("Autor", bookOutputTwelve.getAuthor());
        Assert.assertEquals("Titulo", bookOutputTwelve.getTitle());
        Assert.assertEquals(Double.valueOf(24D), bookOutputTwelve.getPrice());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
        Book bookOutput = DozerConverter.parseObject(inputObjectBook.mockVO(), Book.class);
        
        //Person
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("PrimeiroNome", output.getFirstName());
        Assert.assertEquals("Sobrenome", output.getLastName());
        Assert.assertEquals("Endereço teste0", output.getAddress());
        Assert.assertEquals("Masculino", output.getGender());
        
        //Book
        Assert.assertEquals(Long.valueOf(0L), bookOutput.getId());
        Assert.assertEquals("Autor", bookOutput.getAuthor());
        Assert.assertEquals("Titulo", bookOutput.getTitle());
        Assert.assertEquals(Double.valueOf(0D), bookOutput.getPrice());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
        List<Book> bookOutputList = DozerConverter.parseListObjects(inputObjectBook.mockVOList(), Book.class);
        
        Person outputZero = outputList.get(0);
        Book bookOutputZero = bookOutputList.get(0);
        
        //Person
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("PrimeiroNome", outputZero.getFirstName());
        Assert.assertEquals("Sobrenome", outputZero.getLastName());
        Assert.assertEquals("Endereço teste0", outputZero.getAddress());
        Assert.assertEquals("Masculino", outputZero.getGender());
        
        //Book
        Assert.assertEquals(Long.valueOf(0L), bookOutputZero.getId());
        Assert.assertEquals("Autor", bookOutputZero.getAuthor());
        Assert.assertEquals("Titulo", bookOutputZero.getTitle());
        Assert.assertEquals(Double.valueOf(0D), bookOutputZero.getPrice());
        
        Person outputSeven = outputList.get(7);
        Book bookOutputSeven = bookOutputList.get(7);
        
        //Person
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("PrimeiroNome", outputSeven.getFirstName());
        Assert.assertEquals("Sobrenome", outputSeven.getLastName());
        Assert.assertEquals("Endereço teste7", outputSeven.getAddress());
        Assert.assertEquals("Feminino", outputSeven.getGender());
        
        //Book
        Assert.assertEquals(Long.valueOf(7L), bookOutputSeven.getId());
        Assert.assertEquals("Autor", bookOutputSeven.getAuthor());
        Assert.assertEquals("Titulo", bookOutputSeven.getTitle());
        Assert.assertEquals(Double.valueOf(14D), bookOutputSeven.getPrice());
        
        Person outputTwelve = outputList.get(12);
        Book bookOutputTwelve = bookOutputList.get(12);
        
        //Person
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("PrimeiroNome", outputTwelve.getFirstName());
        Assert.assertEquals("Sobrenome", outputTwelve.getLastName());
        Assert.assertEquals("Endereço teste12", outputTwelve.getAddress());
        Assert.assertEquals("Masculino", outputTwelve.getGender());
        
        //Book
        Assert.assertEquals(Long.valueOf(12L), bookOutputTwelve.getId());
        Assert.assertEquals("Autor", bookOutputTwelve.getAuthor());
        Assert.assertEquals("Titulo", bookOutputTwelve.getTitle());
        Assert.assertEquals(Double.valueOf(24D), bookOutputTwelve.getPrice());
    }
}