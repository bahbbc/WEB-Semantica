package trab2;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

public class readRDF {

	public static void main (String[] args){
		// create an empty model
		 Model model1 = ModelFactory.createDefaultModel();
		 Model model2 = ModelFactory.createDefaultModel();
		 // use the FileManager to find the input file
		 InputStream in1 = FileManager.get().open( "D:\\eclipse\\carta-de-exigencia-cetesb.rdf" );
		 InputStream in2 = FileManager.get().open( "D:\\eclipse\\liminar-contra-a-usp.rdf" );
		if (in1 == null || in2 ==null) {
		    throw new IllegalArgumentException(
		                                 "File: " + "D:\\eclipse\\carta-de-exigencia-cetesb.rdf" + " not found");
		}

		// read the RDF/XML file
		model1.read(in1, null);
		model2.read(new InputStreamReader (in2), "");
		Model model = model1.union(model2);

		model.write(System.out);
		// write it to standard out
		//model1.write(System.out);
		//model1.read(new InputStreamReader(in1 ), "");      
	}
}
