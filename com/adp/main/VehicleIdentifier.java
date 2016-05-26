package com.adp.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VehicleIdentifier {

	
	public String determineVehicleType(String frameMaterial, int numberOfWheel, String materialOfWheel, String powerTrain){
		
		String vehicleType = "";
		Boolean inValidFlag = false;
		
		if(frameMaterial.equalsIgnoreCase("plastic")){
			
			if(powerTrain.equalsIgnoreCase("Human") || numberOfWheel==3){
				vehicleType ="Big Wheel";
			}
			else if(powerTrain.equalsIgnoreCase("Bernoulli") || numberOfWheel==0){
				vehicleType ="Hang Glider";
			}
			else{
				inValidFlag = true;
			}
		}
		else if(frameMaterial.equalsIgnoreCase("metal")){
			
			if(powerTrain.equalsIgnoreCase("Internal Combustion")){
				
				if(numberOfWheel==2){
					vehicleType ="Motorcycle";
				}else if(numberOfWheel==4){
					vehicleType = "Car";
				}
				else{
					inValidFlag = true;
				}
			}
			else if(powerTrain.equalsIgnoreCase("Human")){
				if(numberOfWheel==2){
					vehicleType ="Bicycle";
				}else  {
					inValidFlag = true;
				}
			}
			else{
				vehicleType = "Invalid Type";
			}
		}else{
			inValidFlag = true;
		}
		
		
		
		if(inValidFlag)
			vehicleType="Invalid Type";
		
		return vehicleType;
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
	/*	  try {	
		         File inputFile = new File("D:\\in.txt");
		         DocumentBuilderFactory dbFactory 
		            = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
		         doc.getDocumentElement().normalize();
		         System.out.println("Root element :" 
		            + doc.getDocumentElement().getNodeName());
		       //  NodeList nList = doc.getElementsByTagName("student");
		         NodeList nList = doc.getElementsByTagName("vehicle");
		         System.out.println("----------------------------");
		         for (int temp = 0; temp < nList.getLength(); temp++) {
		            Node nNode = nList.item(temp);
		            System.out.println("\nCurrent Element :" 
		               + nNode.getNodeName());
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		               Element eElement = (Element) nNode;
		               System.out.println("Student roll no : " 
		                  + eElement.getAttribute("rollno"));
		               System.out.println("First Name : " 
		                  + eElement
		                  .getElementsByTagName("firstname")
		                  .item(0)
		                  .getTextContent());
		               System.out.println("Last Name : " 
		               + eElement
		                  .getElementsByTagName("lastname")
		                  .item(0)
		                  .getTextContent());
		               System.out.println("Nick Name : " 
		               + eElement
		                  .getElementsByTagName("nickname")
		                  .item(0)
		                  .getTextContent());
		               System.out.println("Marks : " 
		               + eElement
		                  .getElementsByTagName("marks")
		                  .item(0)
		                  .getTextContent());
		            }
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
*/

	
		  try {	
		         File inputFile = new File("D:\\in.txt");
		         DocumentBuilderFactory dbFactory 
		            = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
		         doc.getDocumentElement().normalize();
		         System.out.println("Root element :" 
		            + doc.getDocumentElement().getNodeName());
		         NodeList nList = doc.getElementsByTagName("vehicle");
		         System.out.println("----------------------------");
		         for (int temp = 0; temp < nList.getLength(); temp++) {
		            Node nNode = nList.item(temp);
		            System.out.println("\nCurrent Element :" 
		               + nNode.getNodeName());
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		               Element eElement = (Element) nNode;
		               
		               System.out.println("ID : " 
				                  + eElement
				                  .getElementsByTagName("id")
				                  .item(0)
				                  .getTextContent());
		               System.out.println("Frame :"+ eElement
		                  .getElementsByTagName("frame")
		                  .item(0).getChildNodes().item(1).getTextContent());
		              System.out.println("Wheels : " 
		               + eElement
		                  .getElementsByTagName("wheel").getLength());
		                  
		              System.out.println("Powertrain : " 
				               + eElement
				                  .getElementsByTagName("powertrain") .item(0).getChildNodes().item(1).getNodeName());
		               
		              
		              
		              
		              String vehicleId= eElement.getElementsByTagName("id").item(0) .getTextContent();
		              String frameMaterial = eElement.getElementsByTagName("frame").item(0)
		            		  .getChildNodes().item(1).getTextContent();
		              Integer numberOfWheels  =  eElement.getElementsByTagName("wheel").getLength();
		              String materialOfWheels  =  eElement.getElementsByTagName("wheel").item(1).getChildNodes().item(2).getTextContent();
		              String powerTrain = eElement.getElementsByTagName("powertrain").item(0)
		            		  .getChildNodes().item(1).getNodeName();
		              
		              System.out.println("Vehicle Id: "+vehicleId);
		              System.out.println("Frame Material: "+frameMaterial);
		              System.out.println("WheelMaterial :"+materialOfWheels);
		              System.out.println("NumberOfVehicle :"+numberOfWheels);
		              System.out.println("PowerTrain: "+powerTrain);
		              
		              
		              Vehicle vehicle = new Vehicle();
		              vehicle.setFrameMaterial(frameMaterial);
		              
		            }
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }

	}
	
}
