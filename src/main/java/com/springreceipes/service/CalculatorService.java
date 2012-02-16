package com.springreceipes.service;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 13/01/2012
 * Time: 21:27
 * To change this template use File | Settings | File Templates.
 */
public interface CalculatorService {

    BigDecimal addNumbers(BigDecimal number1, BigDecimal number2);
    BigDecimal subtractNumbers(BigDecimal number1, BigDecimal number2);
    
}
