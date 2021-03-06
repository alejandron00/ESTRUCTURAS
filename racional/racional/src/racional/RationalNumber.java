package racional;

public class RationalNumber<T extends Number> implements InterfaceNumeroRacional<RationalNumber<Number>> {
	private T numerador;
	private T denominador;

	public RationalNumber(T number1, T number2) {
		super();
		this.numerador = number1;
		this.denominador = number2;
	}

	public T resta(T number1, T number2) {
		T number = null;
		if (number1 instanceof Long) {
			number = (T) Long.valueOf(number1.longValue() - number2.longValue());
		} else if (number1 instanceof Integer) {
			number = (T) Integer.valueOf(number1.intValue() - number2.intValue());
		} else if (number1 instanceof Short) {
			number = (T) Short.valueOf((short) (number1.shortValue() - number2.shortValue()));
		}
		return number;
	}

	@Override
	public void addRational(RationalNumber<Number> c) {
		T ad = this.multiply(numerador, (T) c.getDenominator());
		T cb = this.multiply(denominador, (T) c.getNumerator());
		T cd = this.multiply(denominador, (T) c.getDenominator());
		this.numerador = this.suma(ad, cb);
		this.denominador = cd;
		this.simplifyRational();
		System.out.println("RESPUESTAS " + numerador + " " + denominador);
	}

	public T suma(T number1, T number2) {
		T number = null;
		if (number1 instanceof Long) {
			number = (T) Long.valueOf(number1.longValue() + number2.longValue());
		} else if (number1 instanceof Integer) {
			number = (T) Integer.valueOf(number1.intValue() + number2.intValue());
		} else if (number1 instanceof Short) {
			number = (T) Short.valueOf((short) (number1.shortValue() + number2.shortValue()));
		}
		return number;
	}

	@Override
	public void substractRational(RationalNumber<Number> rationalToBeSubstracted) {
		T ad = this.multiply(numerador, (T) rationalToBeSubstracted.getDenominator());
		T cb = this.multiply(denominador, (T) rationalToBeSubstracted.getNumerator());
		T cd = this.multiply(denominador, (T) rationalToBeSubstracted.getDenominator());
		this.numerador = this.resta(ad, cb);
		this.denominador = cd;
		this.simplifyRational();
	}

	@Override
	public void multiplyRational(RationalNumber<Number> rationalFactor) {
		this.numerador = this.multiply(numerador, (T) rationalFactor.getNumerator());
		this.denominador = this.multiply(denominador, (T) rationalFactor.getDenominator());
		this.simplifyRational();
		this.simplificar(numerador, denominador);
	}

	public T multiply(T number1, T number2) {
		T number = null;
		if (number1 instanceof Long) {
			number = (T) Long.valueOf(number1.longValue() * number2.longValue());
		} else if (number1 instanceof Integer) {
			number = (T) Integer.valueOf(number1.intValue() * number2.intValue());
		} else if (number1 instanceof Short) {
			number = (T) Short.valueOf((short) (number1.shortValue() * number2.shortValue()));
		}
		return number;
	}

	@Override
	public void divideRational(RationalNumber<Number> rationalQuocient) {
		this.numerador = this.divide(numerador, (T) rationalQuocient.getDenominator());
		this.denominador = this.divide(denominador, (T) rationalQuocient.getNumerator());
		this.simplifyRational();

	}

	public T divide(T number1, T number2) {
		T number = null;
		if (number1 instanceof Long) {
			number = (T) Long.valueOf(number1.longValue() * number2.longValue());
		} else if (number1 instanceof Integer) {
			number = (T) Integer.valueOf(number1.intValue() * number2.intValue());
		} else if (number1 instanceof Short) {
			number = (T) Short.valueOf((short) (number1.shortValue() * number2.shortValue()));

		}
		return number;
	}

	@Override
	public void simplifyRational() {
		this.simplificar(numerador, denominador);
	}

	public void simplificar(T numerador, T denominador) {

		String resp = null;
		int arr[] = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		double resp1 = 0;
		double resp2 = 0;
		int respEntera1 = 0;
		int respEntera2 = 0;
		double solucion1 = 0;
		double solucion2 = 0;
		boolean encontre = false;

		for (int i = arr.length - 1; i > 0 && !encontre; i--) {
			resp1 = numerador.doubleValue() / arr[i];
			resp2 = denominador.doubleValue() / arr[i];
			respEntera1 = numerador.intValue() / arr[i];
			respEntera2 = denominador.intValue() / arr[i];
			solucion1 = resp1 - respEntera1;
			solucion2 = resp2 - respEntera2;
			if (solucion1 == 0.0 && solucion2 == 0) {
				this.numerador = (T) Integer.valueOf(respEntera1);
				this.denominador = (T) Integer.valueOf(respEntera2);
				encontre = true;
			}
		}

	}

	@Override
	public void rationalInverse() {
		T aux = denominador;
		this.denominador = numerador;
		this.numerador = aux;
		if(denominador.intValue()==0) {
			denominador=numerador;
			numerador=(T) Integer.valueOf(0);
		}
		this.simplifyRational();

	}

	@Override
	public void squaredRational() {
		T aux = (T) Integer.valueOf(numerador.intValue() * numerador.intValue());
		T aux2 = (T) Integer.valueOf(denominador.intValue() * denominador.intValue());
		numerador = aux;
		denominador = aux2;
		this.simplifyRational();
	}

	@Override
	public Number getNumerator() {

		return numerador;
	}

	@Override
	public Number getDenominator() {

		return denominador;
	}

	public void setNumerador(T numerador) {
		this.numerador = numerador;
	}

	public void setDenominador(T denominador) {
		this.denominador = denominador;
	}

}
