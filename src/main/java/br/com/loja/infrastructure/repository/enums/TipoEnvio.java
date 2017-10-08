package br.com.loja.infrastructure.repository.enums;

/**
 * Enum tipo envio
 *
 * @author smaylle
 *
 */
public enum TipoEnvio {

	CADASTRO(0),
	SMS(1),
	EMAIL(2);

	/**
	 * value.
	 */
	private int value;

	/**
	 * Construtor tipo envio
	 *
	 * @param val the val
	 */
	private TipoEnvio(final int val) {
		value = val;
	}

	/**
	 * Obter o valor int do enum.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Obter o enum apartir de um int.
	 *
	 * @param id the id
	 * @return TipoEnvio
	 */
	public static TipoEnvio getValue(final Integer id) {
		if (id != null) {
			final TipoEnvio[] values = TipoEnvio.values();
			for (final TipoEnvio value2 : values) {
				if (value2.compare(id)) {
					return value2;
				}
			}
		}

		return null;
	}

	/**
	 * Compare.
	 *
	 * @param i the i
	 * @return value
	 */
	private boolean compare(final Integer i) {
		return value == i.intValue();
	}

}
