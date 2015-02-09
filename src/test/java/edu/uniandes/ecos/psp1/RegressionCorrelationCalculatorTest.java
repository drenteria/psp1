package edu.uniandes.ecos.psp1;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.uniandes.ecos.psp1.model.RegressionCorrelationCalculator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Regression and Correlation
 * calculations
 * @author drenteria
 *
 */
public class RegressionCorrelationCalculatorTest
	extends TestCase{
	
	private RegressionCorrelationCalculator theCalc;
	
	public RegressionCorrelationCalculatorTest (String testName){
		super(testName);
		theCalc = new RegressionCorrelationCalculator();
	}
	
	public static Test suite(){
		return new TestSuite(RegressionCorrelationCalculatorTest.class);
	}
	
	/**
	 * Creates the List for Estimated Proxy Size (List 1)
	 * @return Estimated Proxy Size values list
	 */
	private ArrayList<Double> loadEstimatedProxySize(){
		ArrayList<Double> list01 = new ArrayList<Double>();
		list01.add(130.0);
		list01.add(650.0);
		list01.add(99.0);
		list01.add(150.0);
		list01.add(128.0);
		list01.add(302.0);
		list01.add(95.0);
		list01.add(945.0);
		list01.add(368.0);
		list01.add(961.0);
		return list01;
	}
	
	private ArrayList<Double> loadPlanAddedModifiedSize(){
		ArrayList<Double> list02 = new ArrayList<Double>();
		list02.add(163.0);
		list02.add(765.0);
		list02.add(141.0);
		list02.add(166.0);
		list02.add(137.0);
		list02.add(355.0);
		list02.add(136.0);
		list02.add(1206.0);
		list02.add(433.0);
		list02.add(1130.0);
		return list02;
	}
	
	public void test01(){
		System.out.println("Running Test Case 01");
		theCalc.setInputSetX(loadEstimatedProxySize());
		theCalc.setInputSetY(loadPlanAddedModifiedSize());
		System.out.println("X Set: " + loadEstimatedProxySize().toString());
		System.out.println("Y Set: " + loadPlanAddedModifiedSize().toString());
		
		double yk = theCalc.calculateImprovedPredictionYk(386.0);
		
		System.out.println("B0: " + theCalc.getB0RegressionParameter());
		System.out.println("B1: " + theCalc.getB1RegressionParameter());
		System.out.println("Rxy: " + theCalc.getRXYCoeficcient());
		System.out.println("R2: " + theCalc.getRSquaredCoefficient());
		
		assertEquals(1.7279, theCalc.getB1RegressionParameter(), 0.0001);
		assertEquals(-22.55, theCalc.getB0RegressionParameter(), 0.01);
		assertEquals(0.9545, theCalc.getRXYCoeficcient(), 0.0001);
		assertEquals(0.9111, theCalc.getRSquaredCoefficient(), 0.0001);
		assertEquals(644.429, yk, 0.0001);
		
	}

}
