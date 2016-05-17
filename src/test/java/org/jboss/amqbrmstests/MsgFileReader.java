package org.jboss.amqbrmstests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jboss.amqconnector.KieProcessor;
import org.jboss.amqconnector.RuleProcessor;
import org.kie.api.runtime.KieSession;

public class MsgFileReader {
	
	public static void main (String[] args) throws IOException {
		// Open the file
		FileInputStream fstream = new FileInputStream("test.out");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
        KieSession kSession = KieProcessor.getKieSession();
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  System.out.println (strLine);
		  if (strLine.contains("Customer is Moving")) {
			  RuleProcessor.invokeRules(strLine);
		  }
		 
		}

		//Close the input stream
		br.close();

	}

}
