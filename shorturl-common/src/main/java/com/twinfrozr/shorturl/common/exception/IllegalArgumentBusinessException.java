package com.twinfrozr.shorturl.common.exception;

/**
 * IllegalArgumentBusinessException
 *
 * @author mavin
 */
public class IllegalArgumentBusinessException extends BusinessException {

	private static final long serialVersionUID = 642314156929936520L;

	public IllegalArgumentBusinessException(LocalError localError) {
		super(localError);
	}
}
