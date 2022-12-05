package br.com.beganinha.cm;

/**
 * Para configurar o JUnit, use:
 * 1 - clicar no projeto > propriedades (Alt+enter)
 * 2 - Java Build Path > Libraries
 * 3 - Selectionar Classpath e depois, clicar em Add Library
 * 4 - Selecione JUnit (Next) e a última versão > Finish
 * 
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void testarSeIgualADois() {
		
		int a = 1 + 1;
		
		/*
		 * O primeiro parâmetro é o valor esperado
		 * O segundo parâmetro é variável ou método que contém o resultado do processamento
		 * 
		 * Em outras palavras, o assertEquals diz: verifique se o valor que eu te passei é o 
		 * mesmo que o método/variável retornou
		 */
		assertEquals(2, a);
	}
	
	@Test
	void testarSeIgualATres() {
		int x = 2 + 10 - 7;
		
		assertEquals(3, x);
	}
}
