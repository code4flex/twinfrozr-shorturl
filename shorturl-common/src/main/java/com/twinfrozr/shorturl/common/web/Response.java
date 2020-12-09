package com.twinfrozr.shorturl.common.web;

import com.twinfrozr.shorturl.common.exception.LocalError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Response
 *
 * @author marvin
 */
public class Response {


    private final static String ERROR_CODE = "code";
    private final static String MSG_KEY = "message";
    private final static String SUCCESS_KEY = "success";

    /**
     * @return ResponseEntity type value includes default Map data
     *         {"success":true} and http code 200
     */
    public static ResponseEntity<Object> success(Object object) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(SUCCESS_KEY, true);
        result.put(MSG_KEY, object);
        return getEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Object> fail() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(SUCCESS_KEY, false);
        return getEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Object> fail(Object object) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(SUCCESS_KEY, false);
        result.put(MSG_KEY, object);
        return getEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity<Object> success() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(SUCCESS_KEY, true);
        return getEntity(result, HttpStatus.OK);
    }

    /**
     * @param object
     *            the main value object which return to the invoker with json
     *            type
     * @return ResponseEntity type object includes the main value and http code
     *         200
     */
//	public static ResponseEntity<Object> success(Object object) {
//		return getEntity(object, HttpStatus.OK);
//	}

    public static Map<String, Object> getErrorBody(LocalError localError) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(MSG_KEY, localError.getMessage());
        result.put(ERROR_CODE, localError.getCode());
        return result;
    }

    /**
     * @param errorCode
     *            customization error code
     * @param msg
     *            customization error description
     * @return ResponseEntity type object includes a Map object of error and
     *         HTTP code 404
     */
    public static ResponseEntity<Object> notFound(String errorCode, String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(MSG_KEY, msg);
        result.put(ERROR_CODE, errorCode);
        return getEntity(result, HttpStatus.NOT_FOUND);
    }

    /**
     * @param errorCode
     *            customization error code
     * @param msg
     *            customization error description
     * @return ResponseEntity type object includes a Map object of error and
     *         HTTP code 403
     */
    public static ResponseEntity<Object> authorityFailed(String errorCode,
                                                         String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(MSG_KEY, msg);
        result.put(ERROR_CODE, errorCode);
        return getEntity(result, HttpStatus.FORBIDDEN);
    }

    /**
     * @param errorCode
     *            customization error code
     * @param msg
     *            customization error description
     * @return ResponseEntity type object includes a Map object of error and
     *         HTTP code 422
     */
    public static ResponseEntity<Object> illegalArgument(String errorCode,
                                                         String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(MSG_KEY, msg);
        result.put(ERROR_CODE, errorCode);
        return getEntity(result, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * @param localError
     *            user defined {@link LocalError}
     * @return ResponseEntity type object includes a Map object of error and
     *         HTTP code 422
     */
    public static ResponseEntity<Object> illegalArgument(LocalError localError) {
        return illegalArgument(localError.getCode(), localError.getMessage());
    }

    /**
     * @param code
     *            customization error code
     * @param msg
     *            customization error description
     * @return ResponseEntity type object includes a Map object of error and
     *         HTTP code 500
     */
    public static ResponseEntity<Object> serverLocalErrorMsg(String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(MSG_KEY, msg);
        return getEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param code
     *            customization error code
     * @param msg
     *            customization error description
     * @return ResponseEntity type object includes a Map object of error and
     *         HTTP code 500
     */
    public static ResponseEntity<Object> serverLocalError(String errorCode,
                                                          String msg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(MSG_KEY, msg);
        result.put(ERROR_CODE, errorCode);
        return getEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param localError
     *            user defined {@link LocalError}
     * @return ResponseEntity type object includes a Map object of error and
     *         HTTP code 500
     */
    public static ResponseEntity<Object> serverLocalError(LocalError LocalError) {
        return serverLocalError(LocalError.getCode(), LocalError.getMessage());
    }

    /**
     * @param response
     *            application server's HttpServletResponse object
     * @param localError
     *            user defined {@link LocalError}
     * @return ResponseEntity type object includes a Map object of error and
     *         HTTP code 422
     */

    /**
     * get a new entity.
     */
    protected static ResponseEntity<Object> getEntity(Object body,
                                                      HttpStatus statusCode) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        List<String> contentType = new ArrayList<String>();
        contentType.add("application/json;charset=utf-8");
        headers.put("Content-Type", contentType);
        return new ResponseEntity<Object>(body, headers, statusCode);
    }
}
