package antrob.santacasa.tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import antrob.santacasa.Acertos;
import antrob.santacasa.ApostaEuromilhoes;

class ApostaEuroMilhoesTest 
{

	@Test
	void ApostaEuromilhoesTest() 
	{
		int[] numeros = {0,5,7,10,11};
		int[] estrelas = {1,2};
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{new ApostaEuromilhoes(numeros,estrelas);});
	}
	
	@Test
	void AcertosTest() 
	{
		int[] numerosSorteio = {1,5,7,10,11};
		int[] estrelasSorteio = {1,2};
		
		int[] numerosAposta = {1,5,7,10,11};
		int[] estrelasAposta = {1,2};
		
		//Assertions.assertArrayEquals(numerosSorteio, numerosAposta);
		
		ApostaEuromilhoes chaveSorteio = new ApostaEuromilhoes(numerosSorteio,estrelasSorteio);
		
		ApostaEuromilhoes chaveAposta = new ApostaEuromilhoes(numerosAposta,estrelasAposta);
		Acertos resultado = chaveAposta.getAcertos(chaveSorteio);
		Acertos nossoResultado = new Acertos(5,2);
		
		Assertions.assertEquals(nossoResultado.numeros, resultado.numeros);
		Assertions.assertEquals(nossoResultado.estrelas, resultado.estrelas);
	}

	@RepeatedTest(1000)
	void ApostaEuromilhoesStressTest()
	{
		try
		{
			ApostaEuromilhoes chaveSorteio = new ApostaEuromilhoes();
		}
		catch(Exception ex)
		{
			fail("Exception!");
		}
	}
}
