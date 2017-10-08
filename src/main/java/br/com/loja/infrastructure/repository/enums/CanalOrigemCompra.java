package br.com.loja.infrastructure.repository.enums;

/**
 * Enum canal de origem.
 *
 * @author smaylle
 *
 */
public enum CanalOrigemCompra {

	BANCO_DO_BRASIL(1),
	BRADESCO(341),
	CIELO(99999),
	STELO(88888);

	/**
	 * value.
	 */
	private int value;

	/**
	 * Construtor canal origem.
	 *
	 * @param val the val
	 */
	private CanalOrigemCompra(final int val) {
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
	 * @return CanalOrigem
	 */
	public static CanalOrigemCompra getValue(final Integer id) {
		if (id != null) {
			final CanalOrigemCompra[] values = CanalOrigemCompra.values();
			for (final CanalOrigemCompra value2 : values) {
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
