package com.twinfrozr.shorturl.common.exception;

/**
 * NullPointerBusinessException
 *
 * @author marvin
 */
public class NullPointerBusinessException extends BusinessException {

	private static final long serialVersionUID = 9139615775289217643L;

	public NullPointerBusinessException(LocalError localError) {
		super(localError);
	}

}
