package br.com.henriqueacar.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.henriqueacar.converter.mocks.MockPerson;
import br.com.henriqueacar.data.model.Person;
import br.com.henriqueacar.data.vo.PersonVO;

public class DozerConverterTest {
	
    MockPerson inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("PrimeiroNome", output.getFirstName());
        Assert.assertEquals("Sobrenome", output.getLastName());
        Assert.assertEquals("Endereço teste0", output.getAddress());
        Assert.assertEquals("Masculino", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("PrimeiroNome", outputZero.getFirstName());
        Assert.assertEquals("Sobrenome", outputZero.getLastName());
        Assert.assertEquals("Endereço teste0", outputZero.getAddress());
        Assert.assertEquals("Masculino", outputZero.getGender());
        
        PersonVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("PrimeiroNome", outputSeven.getFirstName());
        Assert.assertEquals("Sobrenome", outputSeven.getLastName());
        Assert.assertEquals("Endereço teste7", outputSeven.getAddress());
        Assert.assertEquals("Feminino", outputSeven.getGender());
        
        PersonVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("PrimeiroNome", outputTwelve.getFirstName());
        Assert.assertEquals("Sobrenome", outputTwelve.getLastName());
        Assert.assertEquals("Endereço teste12", outputTwelve.getAddress());
        Assert.assertEquals("Masculino", outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("PrimeiroNome", output.getFirstName());
        Assert.assertEquals("Sobrenome", output.getLastName());
        Assert.assertEquals("Endereço teste0", output.getAddress());
        Assert.assertEquals("Masculino", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("PrimeiroNome", outputZero.getFirstName());
        Assert.assertEquals("Sobrenome", outputZero.getLastName());
        Assert.assertEquals("Endereço teste0", outputZero.getAddress());
        Assert.assertEquals("Masculino", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("PrimeiroNome", outputSeven.getFirstName());
        Assert.assertEquals("Sobrenome", outputSeven.getLastName());
        Assert.assertEquals("Endereço teste7", outputSeven.getAddress());
        Assert.assertEquals("Feminino", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("PrimeiroNome", outputTwelve.getFirstName());
        Assert.assertEquals("Sobrenome", outputTwelve.getLastName());
        Assert.assertEquals("Endereço teste12", outputTwelve.getAddress());
        Assert.assertEquals("Masculino", outputTwelve.getGender());
    }
}