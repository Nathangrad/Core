package com.above.interfaces;

/**
 * IDataProvider API interface for obtaining and setting data
 * 
 * @author NathanGrad
 * 
 * @usage Abstract classes not to be used implementing this
 *
 * @param <i>
 *            Data type of input required by API functions
 * @param <o>
 *            Data type of output provided by API functions
 */
public interface IDataProvider<i, o> {

	o get(i input);

	void set(i input, o setterVariable);

	void setup(i input, o setterVariable);

}
