/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author Sahil
 */
public class Start extends javax.swing.JFrame {
    File[] files;
    File f= null;
    String nm;
    //String result="";
    String destp="";
    String fresult="";
    String resultcheck="";
    String path;
    String filename;
    String fdest="";
    private String destinationDir;
   
    /**
     * Creates new form Start
     */
    //This is the method to get the extension of a file name
    public String getExtension(String str){
        int n= str.length();
        String nm="";
        for(int i=0;i<n; i++){
            String c= ""+str.charAt(i);
            if(c.equals(".")){
                for(int j=i+1;j<str.length();j++){
                    nm=nm+str.charAt(j);
                }
            }
        }
        return nm;
    }
    //-------------------------end of method
    // This method will extract the text from the file
    public String ocr(File f){
    Tesseract instance = new Tesseract();
    instance.setPageSegMode(11);
    //instance.setHocr(true);//
    String result="";
    try {
        instance.setDatapath("C:\\Tess4J-3.4.8-src\\Tess4J");
        result = instance.doOCR(f);
    } 
    catch (TesseractException e) {
        System.err.println(e.getMessage());
    }
    return result;
}
//------end of method
//This method will get the extension of the file
   
//--------End of the method
//This method will detect the tokens and make the key value pair for parsing
    
    public String detect(String result,String token){
        Scanner scanner = new Scanner(result);
        String fresult="";
        //test t= new test();
        //double d=t.check(result);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] s=line.split(token); 
            if(fhir.isSelected() || ccd.isSelected()){
                if(s.length>=2){
                    fresult=fresult+"\t<"+s[0]+">\n\t\t"+s[1]+"\n\t</"+s[0]+">\n";
                    System.out.println(s[0].trim()+" "+s[1].trim());  
                    
                }   
            }
            else if(hl7.isSelected()){
                if(s.length>=2)
                fresult=fresult+line.replace(token,"^").replace(" ","|");
            }
        }
        return fresult;
    }
    //----------------------
    //This method will save the file content and open it in wordpad
    public void savenopen(File file1,String fresult){
        try {
        FileWriter writer = new FileWriter(file1);
        writer.write(fresult);
        writer.close();
        String wordPadExecutable = "C:\\Program Files\\Windows NT\\Accessories\\wordpad.exe";
        String fileName = file1.getParent()+"\\"+file1.getName();
        System.out.println(fileName);
        // create a process builder that executes wordpad and passes filename as parameter
        ProcessBuilder pb = new ProcessBuilder(wordPadExecutable, fileName);
        try {
            // start
            pb.start();
        } 
        catch (IOException ex) {
            //Logger.getLogger(Open1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("done");
    } 
    catch (Exception ex) {
        //Logger.getLogger(Open1.class.getName()).log(Level.SEVERE, null, ex);
    }
    //-----------------
    }
    
    public Start() {
        initComponents();
        this.setBounds(100, 0, 1650, 1100);
        
        //setExtendedState(this.MAXIMIZED_BOTH); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        p = new javax.swing.JLabel();
        fhir = new javax.swing.JToggleButton();
        hl7 = new javax.swing.JToggleButton();
        ccd = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Select File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 220, 160, 40);

        p.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(p);
        p.setBounds(340, 220, 620, 40);

        fhir.setBackground(new java.awt.Color(0, 102, 102));
        buttonGroup1.add(fhir);
        fhir.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        fhir.setForeground(new java.awt.Color(255, 255, 255));
        fhir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/FHIRi.png"))); // NOI18N
        fhir.setSelected(true);
        fhir.setText("FHIR");
        fhir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fhir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(fhir);
        fhir.setBounds(290, 440, 260, 220);

        hl7.setBackground(new java.awt.Color(0, 102, 102));
        buttonGroup1.add(hl7);
        hl7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        hl7.setForeground(new java.awt.Color(255, 255, 255));
        hl7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/hl7.png"))); // NOI18N
        hl7.setText("HL7");
        hl7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hl7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(hl7);
        hl7.setBounds(700, 440, 250, 220);

        ccd.setBackground(new java.awt.Color(0, 102, 102));
        buttonGroup1.add(ccd);
        ccd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ccd.setForeground(new java.awt.Color(255, 255, 255));
        ccd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/CCDi.png"))); // NOI18N
        ccd.setText("CCD");
        ccd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ccd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(ccd);
        ccd.setBounds(1070, 440, 250, 220);

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Convert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(540, 760, 160, 40);

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("                                           FORM HUNTER (OCR)");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 20, 1600, 60);

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" DASHBOARD");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 100, 350, 60);

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Select a format");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 328, 350, 60);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/solutions_ocr.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(960, 140, 560, 160);

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Open Folder");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(930, 760, 170, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/Capture.PNG"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1470, 850, 110, 110);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/Capture3.PNG"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 840, 110, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/ws_Green_Gradient_Background_1600x1200.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1600, 1220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        JFileChooser fc=new JFileChooser(); 
        fc.setMultiSelectionEnabled(true);
    int i=fc.showOpenDialog(this);    
    if(i==JFileChooser.APPROVE_OPTION){ 
        files = fc.getSelectedFiles();
    //f = fc.getSelectedFile();
    int c=0;
    for(File ff : files){
        c++;
    }
    p.setText(c+" Files selected");
    
   FileDemo fil= new FileDemo();
   destp=fil.create();
    }
    
    else if(i==JFileChooser.CANCEL_OPTION || i==JFileChooser.ABORT){
        JOptionPane.showMessageDialog(null, "Please select a file");
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

     if(p.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Please Select a File");
}
else{
         for(File f: files){
             
                     
             filename= f.getName();
             
             nm= getExtension(f.getName());
         
    if(nm.equalsIgnoreCase("pdf")){
    String result="";
    int pagenumber=0;
    String s1= f.getPath();
    String s2=f.getName().replace(".pdf","");
    String s3=f.getParent();
    File imageFile=new File(s1);
    try {
        String sourceDir = s1; // Pdf files are read from this folder
        destinationDir = s3+"/"; // converted images from pdf document are saved here
        File sourceFile = new File(sourceDir);
        File destinationFile = new File(destinationDir);
        if (!destinationFile.exists()) {
            destinationFile.mkdir();
            System.out.println("Folder Created -> "+ destinationFile.getAbsolutePath());
        }
        if (sourceFile.exists()) {
            System.out.println("Images copied to Folder: "+ destinationFile.getName());             
            org.apache.pdfbox.pdmodel.PDDocument document = org.apache.pdfbox.pdmodel.PDDocument.load(sourceDir);
            List<PDPage> list = document.getDocumentCatalog().getAllPages();
            System.out.println("Total files to be converted -> "+ list.size());

            String fileName = sourceFile.getName().replace(".pdf", "");             
            int pageNumber = 1;
            for (PDPage page : list) {
                BufferedImage image = page.convertToImage();
                File outputfile = new File(destinationDir + fileName +"_"+ pageNumber +".png");
                System.out.println("Image Created -> "+ outputfile.getName());
                ImageIO.write(image, "png", outputfile);
                result=result+"\n"+ocr(outputfile);
                pageNumber++;
            }
            document.close();
            pagenumber=pageNumber;
            System.out.println("Converted Images are saved at -> "+ destinationFile.getAbsolutePath());
            //destp=destinationFile.getAbsolutePath();
        } 
        else {
            System.err.println(sourceFile.getName() +" File not exists");
        }

    } 
    catch (Exception e) {
        e.printStackTrace();
     // TODO add your handling code here:
    }
    fresult=detect(result,":");
    if(fresult.equals(""))
        fresult=detect(result,"-");
    if(fresult.equals(""))
        fresult=detect(result,":-");
    if(fresult.equals(""))
        fresult=detect(result,".");
    //System.out.println(d);
    
    File file1 = new File(destp+filename.replace(".pdf","")+".xml");
    if(fhir.isSelected())
        fresult="<Patient xmlns=\"http://hl7.org/fhir\">\n "+fresult+"</Patient>";
    if(ccd.isSelected())
        fresult="<Result>\n "+fresult+"</Result>";
    savenopen(file1,fresult);
    
    
}
        
else if(nm.equalsIgnoreCase("jpg") || nm.equalsIgnoreCase("png") || nm.equalsIgnoreCase("JPEG") || nm.equalsIgnoreCase("gif")  ){
    String result="";
    result=result+ocr(f);
    String s1= f.getPath();
    String s2=f.getName().replace(".pdf","");
    String s3=f.getParent();
    destinationDir = s3+"//";
    fresult=detect(result,":");
    File file = new File(destp+filename.replace(".png","").replace(".jpg","").replace(".jpeg","").replace(".gif","")+".xml");
    if(fhir.isSelected())
        fresult="<Patient xmlns=\"http://hl7.org/fhir\">\n "+fresult+"</Patient>";
    if(ccd.isSelected())
        fresult="<Result>\n "+fresult+"</Result>";
    savenopen(file,fresult);
}
else{
    JOptionPane.showMessageDialog(null,"Unsupported File Format");
}
    
}

System.out.println("hello");

JOptionPane.showMessageDialog(null, "Processing completed"); 
// TODO add your handling code here:        // TODO add your handling code here:
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
if(p.getText().equals("")){
    JOptionPane.showMessageDialog(null,"Please select the destination folder");
}
else{
try {
            Desktop.getDesktop().open(new File(destp));        // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton ccd;
    private javax.swing.JToggleButton fhir;
    private javax.swing.JToggleButton hl7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel p;
    // End of variables declaration//GEN-END:variables
}
