

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFMergerUtility;

public class test
{

	 public static void main(String[] args) throws Exception {

			 final String[] files = new String[2];
				files[0] = args[0];
				files[1] = args[1];

		  // Get the byte streams from any source (maintain order)
		  List<InputStream> sourcePDFs = new ArrayList<InputStream>();
		  sourcePDFs.add(new FileInputStream(new File(files[0])));
		  sourcePDFs.add(new FileInputStream(new File(files[1])));
		 // sourcePDFs.add(new FileInputStream(new File("pdf3.pdf")));
		 
		  // initialize the Merger utility and add pdfs to be merged
		  PDFMergerUtility mergerUtility = new PDFMergerUtility();
		  mergerUtility.addSources(sourcePDFs);
		  // set the destination pdf name and merge input pdfs
		  mergerUtility.setDestinationFileName("merged.pdf");
		  mergerUtility.mergeDocuments();
		 }

}

