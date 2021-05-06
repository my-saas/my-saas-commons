package com.stef.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author stef
 */
@Data
public class RespBean<T>  implements Serializable {

	/**
	 * 0为成功,非0则失败
	 */
	private int code;
	private String message;
	private T data;

	public static <T> RespBean<T> ok() {
		return restResult(null, CommonConstants.SUCCESS, null);
	}

	public static <T> RespBean<T> ok(T data) {
		return restResult(data, CommonConstants.SUCCESS, null);
	}

	public static <T> RespBean<T> ok(T data, String msg) {
		return restResult(data, CommonConstants.SUCCESS, msg);
	}

	public static <T> RespBean<T> error() {
		return restResult(null, CommonConstants.FAIL, null);
	}

	public static <T> RespBean<T> error(String msg) {
		return restResult(null, CommonConstants.FAIL, msg);
	}

	public static <T> RespBean<T> error(T data) {
		return restResult(data, CommonConstants.FAIL, null);
	}

	public static <T> RespBean<T> error(T data, String msg) {
		return restResult(data, CommonConstants.FAIL, msg);
	}

	private static <T> RespBean<T> restResult(T data, int code, String msg) {
		RespBean<T> apiResult = new RespBean<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMessage(msg);
		return apiResult;
	}

}
