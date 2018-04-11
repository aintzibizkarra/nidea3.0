package com.ipartek.formacion.nidea.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class BebidaTest {

	@Test
	public void testValidar() {
		try {
			// Crear Factoria y Validador
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();

			// Crear Objeto a validar
			Bebida bebida = new Bebida();

			// Obtener las ConstrainViolation
			Set<ConstraintViolation<Bebida>> violations = validator.validate(bebida);

			assertTrue(violations.size() == 2);

			// Si ponemos precio correcto solo falla el nombre que es == "ab"
			bebida.setPrecio(0.2f);
			bebida.setNombre("ab");
			violations = validator.validate(bebida);
			assertTrue(violations.size() == 1);

			Iterator<ConstraintViolation<Bebida>> it = violations.iterator();
			ConstraintViolation<Bebida> violation = null;
			while (it.hasNext()) {
				violation = it.next();
				// Me devuelve el atributo que tiene el error
				assertEquals("nombre", violation.getPropertyPath().toString());
				// me devuelve el valor que viene
				assertEquals("ab", violation.getInvalidValue());
				// El mensaje la descripcion
				// violation.getMessage();

			}

		} catch (Exception e) {
			// trazas de la excepcion
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
