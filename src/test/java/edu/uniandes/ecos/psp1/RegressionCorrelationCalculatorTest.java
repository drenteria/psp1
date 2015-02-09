package edu.uniandes.ecos.psp1;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.uniandes.ecos.psp1.model.RegressionCorrelationCalculator;

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
	
	private ArrayList<Double> loadActualAddedModifiedSize(){
		ArrayList<Double> list03 = new ArrayList<Double>();
		list03.add(186.0);
		list03.add(699.0);
		list03.add(132.0);
		list03.add(272.0);
		list03.add(291.0);
		list03.add(331.0);
		list03.add(199.0);
		list03.add(1890.0);
		list03.add(788.0);
		list03.add(1601.0);
		return list03;
	}
	
	private ArrayList<Double> loadActualDevelopmentHours(){
		ArrayList<Double> list04 = new ArrayList<Double>();
		list04.add(15.0);
		list04.add(69.9);
		list04.add(6.5);
		list04.add(22.4);
		list04.add(28.4);
		list04.add(65.9);
		list04.add(19.4);
		list04.add(198.7);
		list04.add(38.8);
		list04.add(138.2);
		return list04;
	}
	
	public void test01(){
		System.out.println("Running Test Case 01");
		theCalc.setInputSetX(loadEstimatedProxySize());
		theCalc.setInputSetY(loadActualAddedModifiedSize());
		System.out.println("X Set: " + loadEstimatedProxySize().toString());
		System.out.println("Y Set: " + loadActualAddedModifiedSize().toString());
		
		double yk = theCalc.calculateImprovedPredictionYk(386.0);
		
		System.out.println("B0: " + theCalc.getB0RegressionParameter());
		System.out.println("B1: " + theCalc.getB1RegressionParameter());
		System.out.println("Rxy: " + theCalc.getRXYCoeficcient());
		System.out.println("R2: " + theCalc.getRSquaredCoefficient());
		System.out.println("Xk: 386.0");
		System.out.println("Yk: " + yk);
		
		assertEquals(-22.55, theCalc.getB0RegressionParameter(), 0.01);
		assertEquals(1.7279, theCalc.getB1RegressionParameter(), 0.0001);
		assertEquals(0.9545, theCalc.getRXYCoeficcient(), 0.0001);
		assertEquals(0.9111, theCalc.getRSquaredCoefficient(), 0.0001);
		assertEquals(644.429, yk, 0.001);
	}
	
	public void test02(){
		System.out.println("Running Test Case 02");
		theCalc.setInputSetX(loadEstimatedProxySize());
		theCalc.setInputSetY(loadActualDevelopmentHours());
		System.out.println("X Set: " + loadEstimatedProxySize().toString());
		System.out.println("Y Set: " + loadActualDevelopmentHours().toString());
		
		double yk = theCalc.calculateImprovedPredictionYk(386.0);
		
		System.out.println("B0: " + theCalc.getB0RegressionParameter());
		System.out.println("B1: " + theCalc.getB1RegressionParameter());
		System.out.println("Rxy: " + theCalc.getRXYCoeficcient());
		System.out.println("R2: " + theCalc.getRSquaredCoefficient());
		System.out.println("Xk: 386.0");
		System.out.println("Yk: " + yk);
		
		assertEquals(-4.039, theCalc.getB0RegressionParameter(), 0.001);
		assertEquals(0.1681, theCalc.getB1RegressionParameter(), 0.0001);
		assertEquals(0.9333, theCalc.getRXYCoeficcient(), 0.0001);
		assertEquals(0.8711, theCalc.getRSquaredCoefficient(), 0.0001);
		assertEquals(60.858, yk, 0.001);
	}
	
	public void test03(){
		System.out.println("Running Test Case 03");
		theCalc.setInputSetX(loadPlanAddedModifiedSize());
		theCalc.setInputSetY(loadActualAddedModifiedSize());
		System.out.println("X Set: " + loadEstimatedProxySize().toString());
		System.out.println("Y Set: " + loadActualAddedModifiedSize().toString());
		
		double yk = theCalc.calculateImprovedPredictionYk(386.0);
		
		System.out.println("B0: " + theCalc.getB0RegressionParameter());
		System.out.println("B1: " + theCalc.getB1RegressionParameter());
		System.out.println("Rxy: " + theCalc.getRXYCoeficcient());
		System.out.println("R2: " + theCalc.getRSquaredCoefficient());
		System.out.println("Xk: 386.0");
		System.out.println("Yk: " + yk);
		
		assertEquals(-23.92, theCalc.getB0RegressionParameter(), 0.01);
		assertEquals(1.43097, theCalc.getB1RegressionParameter(), 0.0001);
		assertEquals(0.9631, theCalc.getRXYCoeficcient(), 0.0001);
		assertEquals(0.9276, theCalc.getRSquaredCoefficient(), 0.0001);
		assertEquals(528.4294, yk, 0.001);
	}
	
	public void test04(){
		System.out.println("Running Test Case 04");
		theCalc.setInputSetX(loadPlanAddedModifiedSize());
		theCalc.setInputSetY(loadActualDevelopmentHours());
		System.out.println("X Set: " + loadEstimatedProxySize().toString());
		System.out.println("Y Set: " + loadActualDevelopmentHours().toString());
		
		double yk = theCalc.calculateImprovedPredictionYk(386.0);
		
		System.out.println("B0: " + theCalc.getB0RegressionParameter());
		System.out.println("B1: " + theCalc.getB1RegressionParameter());
		System.out.println("Rxy: " + theCalc.getRXYCoeficcient());
		System.out.println("R2: " + theCalc.getRSquaredCoefficient());
		System.out.println("Xk: 386.0");
		System.out.println("Yk: " + yk);
		
		assertEquals(-4.604, theCalc.getB0RegressionParameter(), 0.001);
		assertEquals(0.140164, theCalc.getB1RegressionParameter(), 0.0001);
		assertEquals(0.9480, theCalc.getRXYCoeficcient(), 0.0001);
		assertEquals(0.8988, theCalc.getRSquaredCoefficient(), 0.0001);
		assertEquals(49.4994, yk, 0.001);
	}

}
