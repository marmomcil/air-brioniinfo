package hr.foi.air.brioniinfo.ws;

/**
 * The interface that should be implemented in order to receive a callback from asynchronous web service connection.
 * The reference on object implementing this interface should be forwarded through the asynchronous task execution call. 
 *  
 */
public interface WebServiceResultHandler {
	/**
	 * The asynchronous web service call will always result in callback to this method.
	 * The requested web service result will be available in result parameter if everything is ok. 
	 * 
	 * @param result The requested parameter from web service result. This does not contain whole service result.
	 * @param ok	 True when the web service request is complete and response is positive. False otherwise.
	 */
	public void handleResult(String result, boolean ok);
}
