import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.*;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

public class Main extends JFrame {

	private InputStream is1;
	private InputStream is2; 
	
	public Main()  {
	
		super("pdfUnion : GeekNepal");
	    setSize(300, 200);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	   this.setLocationRelativeTo(null);
		
	    Container c = getContentPane();
	    c.setLayout(new FlowLayout());
	    
		JButton firstBtn = new JButton("Select first file");
		JButton secBtn = new JButton("Select second file");
		JButton mergeBtn = new JButton("Unite pdf");
		
		final JLabel statusbar = new JLabel("Status :");
		 c.add(firstBtn);
		 c.add(secBtn);
		 c.add(mergeBtn);
		 c.add(statusbar);
		 
		 //final String[] files = new String[2];
		 //convert String into InputStream
	
		 
		 
		 firstBtn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent ae) {
			        JFileChooser chooser = new JFileChooser();
			        chooser.setMultiSelectionEnabled(true);
			        int option = chooser.showOpenDialog(Main.this);
			        if (option == JFileChooser.APPROVE_OPTION) {
			          File[] sf = chooser.getSelectedFiles();
			          String filelist = "nothing";
			          if (sf.length > 0) filelist = sf[0].getName();
			          for (int i = 1; i < sf.length; i++) {
			            filelist += ", " + sf[i].getName();
			            //files[0] = sf[0].getName();
			          }
			          statusbar.setText("You chose " + filelist);
			        // is1 = new ByteArrayInputStream(filelist.getBytes());
			         
			        }
			        else {
			          statusbar.setText("You canceled.");
			        }
			      }
		 });
		 
		 secBtn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent ae) {
			        JFileChooser chooser = new JFileChooser();
			        chooser.setMultiSelectionEnabled(true);
			        int option = chooser.showOpenDialog(Main.this);
			        if (option == JFileChooser.APPROVE_OPTION) {
			          File[] sf = chooser.getSelectedFiles();
			          String filelist = "nothing";
			          if (sf.length > 0) filelist = sf[0].getName();
			          for (int i = 1; i < sf.length; i++) {
			            filelist += ", " + sf[i].getName();
			           // files[1] = sf[0].getName();
			            //is2 = new ByteArrayInputStream();
			          }
			        statusbar.setText("You chose " + filelist);
			       is2 = new ByteArrayInputStream(filelist.getBytes());
			          //statusbar.setText("You chose " + files[0]);
			       
			        }
			        else {
			          statusbar.setText("You canceled.");
			        }
			      }
		 });
		 
		
		
			
		
	
		 mergeBtn.addActionListener(new ActionListener(){
			
			 public void actionPerformed(ActionEvent ae) {
			       
			    List<InputStream> sourcePDFs = new ArrayList<InputStream>();
		  		//sourcePDFs.add(is1);
		  		//sourcePDFs.add(is2);
			    
			    final String[] files = new String[2];
				files[0] = "pdf1.pdf";
				files[1] = "pdf2.pdf";
				  // Get the byte streams from any source (maintain order)
				  //List<InputStream> sourcePDFs = new ArrayList<InputStream>();
				  try {
					sourcePDFs.add(new FileInputStream(new File(files[0])));
					sourcePDFs.add(new FileInputStream(new File(files[1])));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				
				  // initialize the Merger utility and add pdfs to be merged
				  PDFMergerUtility mergerUtility = new PDFMergerUtility();
				  mergerUtility.addSources(sourcePDFs);
				  // set the destination pdf name and merge input pdfs
				  mergerUtility.setDestinationFileName("merged.pdf");
				  try {
					mergerUtility.mergeDocuments();
				} catch (COSVisitorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			 }
			 
		 });
		
		
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Main m = new Main();
		m.setVisible(true);
		/*
		JFrame frame = new JFrame();
		frame.setSize(200,300);
		frame.setTitle("pdfUnion : GeekNepal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		*/
		
		
		
		
	}

}
