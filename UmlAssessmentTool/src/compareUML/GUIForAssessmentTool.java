/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compareUML;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


import fileHandler.SynonymDictionary;
import fileHandler.XMIFileParser;
import fileHandler.ZipFileHandler;


public class GUIForAssessmentTool extends javax.swing.JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form GUIForAssessmentTool
     */
    public GUIForAssessmentTool() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonForLecturer = new javax.swing.JButton();
        jLabelForTitle = new javax.swing.JLabel();
        jLabelForLecturer = new javax.swing.JLabel();
        jLabelForStudents = new javax.swing.JLabel();
        jButtonForStudents = new javax.swing.JButton();
        jButtonForStartAssessment = new javax.swing.JButton();
        jProgressBar = new javax.swing.JProgressBar();
        jProgressBar.setStringPainted(true);
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaForLog = new javax.swing.JTextArea();
        jButtonForFeedback = new javax.swing.JButton();
        jButtonForXML = new javax.swing.JButton();
        jLabelForXML = new javax.swing.JLabel();
        jLabelForLectureFile = new javax.swing.JLabel();
        jLabelForStudentFile = new javax.swing.JLabel();
        jLabelForXMLFile = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jButtonForLecturer.setText("Upload");
        jButtonForLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForLecturerActionPerformed(evt);
            }
        });

        jLabelForTitle.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabelForTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelForTitle.setText("UML Assessment Tool");

        jLabelForLecturer.setText("Lecturer");

        jLabelForStudents.setText("Students");

        jButtonForStudents.setText("Upload");
        jButtonForStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForStudentsActionPerformed(evt);
            }
        });

        jButtonForStartAssessment.setText("Start Assessment");
        jButtonForStartAssessment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForStartAssessmentActionPerformed(evt);
            }
        });

        jTextAreaForLog.setColumns(20);
        jTextAreaForLog.setRows(5);
        
        // automatic change line for textfield
        jTextAreaForLog.setLineWrap(true);
        jTextAreaForLog.setWrapStyleWord(true);
        jTextAreaForLog.setEditable(false);
        jScrollPane3.setViewportView(jTextAreaForLog);

        jButtonForFeedback.setText("Feedback");
        jButtonForFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForFeedbackActionPerformed(evt);
            }
        });

        jButtonForXML.setText("Upload");
        jButtonForXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForXMLActionPerformed(evt);
            }
        });

        jLabelForXML.setText("XML Config");

        jLabelForLectureFile.setText("Not Chosen");

        jLabelForStudentFile.setText("Not Chosen");

        jLabelForXMLFile.setText("Not Chosen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelForTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonForStartAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(jButtonForFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelForLecturer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonForLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelForLectureFile))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelForStudents)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonForStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelForXML)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonForXML)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelForXMLFile)
                                    .addComponent(jLabelForStudentFile))))
                        .addGap(80, 80, 80)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelForTitle)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonForLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelForLecturer)
                            .addComponent(jLabelForLectureFile))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonForStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelForStudents)
                            .addComponent(jLabelForStudentFile))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonForXML)
                            .addComponent(jLabelForXML)
                            .addComponent(jLabelForXMLFile))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonForStartAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonForFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    // main method for assessment
    private void jButtonForStartAssessmentActionPerformed(java.awt.event.ActionEvent evt) {
        
    	if (this.studentFilePath == null) {
			this.jTextAreaForLog.append("Students' file is not selected.\n");
		}
    	if (this.studentFilePath == null) {
			this.jTextAreaForLog.append("Lecturer's file is not selected.\n");
		}
    	
		if (studentFilePath
				.substring(studentFilePath.lastIndexOf("."))
				.equalsIgnoreCase(
						lecturerFilePath.substring(lecturerFilePath.lastIndexOf(".")))) {
			// zip files only
			if (studentFilePath.toLowerCase().endsWith(".zip")) {
				this.zipFileHandler = new ZipFileHandler();
				this.AssessZipFiles();
			} 
			// xmi files only
			else if (studentFilePath.toLowerCase().endsWith(".xmi")){
				this.jTextAreaForLog.append("Start Assessment.\n");
				this.AssessXMIFiles();
				this.jTextAreaForLog.append("Finished Assessment.\n");
			}
		}
    }
    
    // assess method for XMI files
	private void AssessXMIFiles() {
		XMIFileParser xmiFileParser = new XMIFileParser();
		jProgressBar.setToolTipText("Assessing");
		Diagram lecturerDiagram = xmiFileParser.readXMIFile(lecturerFilePath);
		System.out.println(lecturerDiagram);
		Diagram studentDigram = xmiFileParser.readXMIFile(studentFilePath);
		System.out.println(studentDigram);
		AssessmentMark xmiAssessor = new AssessmentMark(studentDigram,
				lecturerDiagram);
		this.jTextAreaForLog
				.append("The student final mark for this diagram is "
						+ xmiAssessor.getFinalMarks() + "%\n");
		jProgressBar.setToolTipText("Finish assessment.");
	}
	
	// assess method for ZIP files
	private void AssessZipFiles() {
		// get lecturer's diagrams
		List<Diagram> lecturerDiagrams = new ArrayList<Diagram>();
		// NOT FINISHED.
		
		// use dictionary
		if (this.dictionary != null && this.dictionary.checkDictionary()) {
			// multiple word 
		}
		
		// get students' diagrams
		Map<String, List<String>> studentFiles = zipFileHandler.getStudentFiles(studentFilePath);
		Map<String, String> studentInfo = zipFileHandler.getStudentInfoMap();
		Set<String> studUsernames = studentFiles.keySet();
		for (String username : studUsernames) {
			DiagramAssignment assignment = new DiagramAssignment(username, studentInfo.get(username), studentFiles.get(username));
			assignment.markAssignment(lecturerDiagrams);
		}
				
	}
    
    private void jButtonForLecturerActionPerformed(java.awt.event.ActionEvent evt) {
    	// set file chooser
    	// accept zip and xmi only
    	JFileChooser jFileChooser = new javax.swing.JFileChooser();
    	FileFilter zipFileFilter = new FileNameExtensionFilter("Zip Files", "zip");
    	FileFilter xmiFileFilter = new FileNameExtensionFilter("XML Metadata Interchange", "xmi");
    	jFileChooser.setAcceptAllFileFilterUsed(false);
    	jFileChooser.setFileFilter(zipFileFilter);
    	jFileChooser.addChoosableFileFilter(xmiFileFilter);
        jFileChooser.setDialogTitle("Choose a file");  
        
        // open file
        int fileIsChosen = jFileChooser.showOpenDialog(null);
        if (fileIsChosen == JFileChooser.APPROVE_OPTION) {
        	String path = jFileChooser.getSelectedFile().getAbsolutePath();
			String name = jFileChooser.getSelectedFile().getName();
			path = path.replace('\\', '/');
			lecturerFilePath = path;
			this.jLabelForLectureFile.setText(name);
			this.jTextAreaForLog.append("Lecturer's file : " + name + "\n");
			this.jProgressBar.setValue(0);
		}
    }

    private void jButtonForStudentsActionPerformed(java.awt.event.ActionEvent evt) {
    	// set file chooser
    	// accept zip and xmi only
    	JFileChooser jFileChooser = new javax.swing.JFileChooser();
    	FileFilter zipFileFilter = new FileNameExtensionFilter("Zip Files", "zip");
    	FileFilter xmiFileFilter = new FileNameExtensionFilter("XML Metadata Interchange", "xmi");
    	jFileChooser.setAcceptAllFileFilterUsed(false);
    	jFileChooser.setFileFilter(zipFileFilter);
    	jFileChooser.addChoosableFileFilter(xmiFileFilter);
        jFileChooser.setDialogTitle("Choose a file");
     
        // open file
        int fileIsChosen = jFileChooser.showOpenDialog(null);
        if (fileIsChosen == JFileChooser.APPROVE_OPTION) {
        	String path = jFileChooser.getSelectedFile().getAbsolutePath();
			String name = jFileChooser.getSelectedFile().getName();
			path = path.replace('\\', '/');
			studentFilePath = path;
			this.jLabelForStudentFile.setText(name);
			this.jTextAreaForLog.append("Students' file : " + name + "\n");
			this.jProgressBar.setValue(0);
		}
    }

    private void jButtonForFeedbackActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO output feedback to user and student
    }

    private void jButtonForXMLActionPerformed(java.awt.event.ActionEvent evt) {
    	// set file chooser
    	// accept XML only
    	JFileChooser jFileChooser = new javax.swing.JFileChooser();
    	jFileChooser.setAcceptAllFileFilterUsed(false);
    	FileFilter fileFilter = new FileNameExtensionFilter("Extensible Markup Language", "xml");
    	jFileChooser.setFileFilter(fileFilter);
        jFileChooser.setDialogTitle("Choose a file");
        
        // open file
        int fileIsChosen = jFileChooser.showOpenDialog(null);
        if (fileIsChosen == JFileChooser.APPROVE_OPTION) {
        	String path = jFileChooser.getSelectedFile().getAbsolutePath();
			String name = jFileChooser.getSelectedFile().getName();
			this.dictionary = new SynonymDictionary(path);
			if (this.dictionary.checkDictionary()) {
				path = path.replace('\\', '/');
				this.jLabelForXMLFile.setText(name);
				this.jTextAreaForLog.append("XML file : " + name + "\n");
			} else {
				this.dictionary = null;
				this.jLabelForXMLFile.setText("Not Chosen");
				this.jTextAreaForLog.append("XML file : " + name + " has error.\n");
			}
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set look and feel */

        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIForAssessmentTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIForAssessmentTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIForAssessmentTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIForAssessmentTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIForAssessmentTool().setVisible(true);
            }
        });
    }

	private String studentFilePath = null;
	private String lecturerFilePath = null;
	private SynonymDictionary dictionary = null;
	private ZipFileHandler zipFileHandler = null;

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonForFeedback;
    private javax.swing.JButton jButtonForLecturer;
    private javax.swing.JButton jButtonForStartAssessment;
    private javax.swing.JButton jButtonForStudents;
    private javax.swing.JButton jButtonForXML;
    private javax.swing.JLabel jLabelForLectureFile;
    private javax.swing.JLabel jLabelForLecturer;
    private javax.swing.JLabel jLabelForStudentFile;
    private javax.swing.JLabel jLabelForStudents;
    private javax.swing.JLabel jLabelForTitle;
    private javax.swing.JLabel jLabelForXML;
    private javax.swing.JLabel jLabelForXMLFile;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaForLog;
    // End of variables declaration//GEN-END:variables
}
