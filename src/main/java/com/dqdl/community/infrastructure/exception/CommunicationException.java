package com.dqdl.community.infrastructure.exception;

/**
 * 通信异常
 * @author daoqidelv
 * @createdate 2017年9月23日
 */
public class CommunicationException extends Exception{

	private static final long serialVersionUID = 718730704092783634L;

	public CommunicationException(String message){		
		super(message);
	}
	
	public CommunicationException(String message,Throwable cause){		
		super(message,cause);
	}
	
	public CommunicationException(Throwable cause){		
		super(cause);
	}
}
