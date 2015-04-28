/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deprecatedSourceCode;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.jdom2.JDOMException;

import compareUML.AssessmentMark;
import compareUML.Diagram;
import compareUML.GUIForAssessmentTool;

import fileHandler.*;

/**
 *
 * @author Paul
 */
public class ggg extends javax.swing.JFrame {

	private boolean lecturerFileIsSelected = false;
	private boolean studentFileIsSelected = false;
	private String studentFilePath;
	private String lecturerFilePath;
	
    /**
     * Creates new form GUIForAssessmentTool
     */
    public ggg() {
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
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaForLog = new javax.swing.JTextArea();
        jButtonForOutput = new javax.swing.JButton();

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
        jTextAreaForLog.setLineWrap(true);
        jTextAreaForLog.setWrapStyleWord(true);
        jTextAreaForLog.setEditable(false);
        jScrollPane3.setViewportView(jTextAreaForLog);

        jButtonForOutput.setText("Output");
        jButtonForOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForOutputActionPerformed(evt);
            }
        });

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(144, 144, 144)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelForStudents)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonForStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelForLecturer)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonForLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(167, 167, 167)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, 0)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButtonForStartAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jButtonForOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jLabelForLecturer))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonForStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelForStudents))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonForStartAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonForOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonForStartAssessmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForStartAssessmentActionPerformed
    	if (!this.studentFileIsSelected) {
			this.jTextAreaForLog.append("Students' file is not selected.\n");
		}
    	if (!this.lecturerFileIsSelected) {
			this.jTextAreaForLog.append("Lecturer's file is not selected.\n");
		}
    	if (this.studentFileIsSelected && this.lecturerFileIsSelected) {
    		this.jTextAreaForLog.append("Start Assessment.\n");
    		// start assessment
//    		ZipFileHandler zipFileHandler = new ZipFileHandler();
//    		zipFileHandler.extractFile(studentFilePath);
    		AssessXMIFiles();
    		this.jTextAreaForLog.append("Finished Assessment.\n");
		}
        
    	// TODO add your handling code here:
    }//GEN-LAST:event_jButtonForStartAssessmentActionPerformed

    private void jButtonForLecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForLecturerActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new javax.swing.JFileChooser();
        jFileChooser.setDialogTitle("Choose a file");
        int fileIsChosen = jFileChooser.showOpenDialog(null);
        if (fileIsChosen == JFileChooser.APPROVE_OPTION) {
        	String path = jFileChooser.getSelectedFile().getAbsolutePath();
			String name = jFileChooser.getSelectedFile().getName();
			path = path.replace('\\', '/');
			lecturerFilePath = path;
			this.jTextAreaForLog.append("current path:" + path
					+ ";\ncurrent name:" + name + "\n");
			this.lecturerFileIsSelected = true;
		} else {
			this.jTextAreaForLog.append("Lecture File not chosen.\n");
			this.lecturerFileIsSelected = false;
			this.lecturerFilePath = null;
		}
    }//GEN-LAST:event_jButtonForLecturerActionPerformed

    private void jButtonForStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForStudentsActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new javax.swing.JFileChooser();
        jFileChooser.setDialogTitle("Choose a file");
        int fileIsChosen = jFileChooser.showOpenDialog(null);
        if (fileIsChosen == JFileChooser.APPROVE_OPTION) {
        	String path = jFileChooser.getSelectedFile().getAbsolutePath();
			String name = jFileChooser.getSelectedFile().getName();
			path = path.replace('\\', '/');
			studentFilePath = path;
			this.jTextAreaForLog.append("current path:" + path
					+ ";\ncurrent name:" + name + "\n");
			this.studentFileIsSelected = true;
		} else {
			this.jTextAreaForLog.append("Student File not chosen.\n");
			this.studentFileIsSelected = false;
			this.studentFilePath = null;
		}
    }//GEN-LAST:event_jButtonForStudentsActionPerformed
    
    private void jButtonForOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonForOutputActionPerformed

    private void AssessXMIFiles() {
    	XMIFileParser xmiFileParser = new XMIFileParser();
    		
    		Diagram lecturerDiagram = xmiFileParser.readXMIFile(lecturerFilePath);
    		System.out.println(lecturerDiagram);
    		Diagram studentDigram = xmiFileParser.readXMIFile(studentFilePath);
    		System.out.println(studentDigram);
    		AssessmentMark xmiAssessor = new AssessmentMark(studentDigram, lecturerDiagram);
    		ArrayList<String[]> f = xmiAssessor.getFeedBack();
    		for (String[] ss : f) {
				for (String s : ss) {
					System.out.println(s);
				}
			}
    		
    		this.jTextAreaForLog.append("The student final mark for this diagram is " + xmiAssessor.getFinalMarks() + "%\n");

    	
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonForLecturer;
    private javax.swing.JButton jButtonForOutput;
    private javax.swing.JButton jButtonForStartAssessment;
    private javax.swing.JButton jButtonForStudents;
    private javax.swing.JLabel jLabelForLecturer;
    private javax.swing.JLabel jLabelForStudents;
    private javax.swing.JLabel jLabelForTitle;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaForLog;
    // End of variables declaration//GEN-END:variables
}