package kmp_visio;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.MaskFormatter;


/**
 * An instance of this class replace the notmal editor of a ComboBox with JFormattedTextField.
 *  
 * @author Dimitar Jordanov
 *
 */
public class FormattedComboBoxEditor implements ComboBoxEditor {
	
    JFormattedTextField  jTextField;
    
    
    public FormattedComboBoxEditor(String format){
    	jTextField =  new JFormattedTextField(createFormatter(format));
    } 
    
	public void addActionListener(ActionListener l) {
		jTextField.addActionListener(l);
		
	}
    
	/** 
	 * @see javax.swing.ComboBoxEditor#getEditorComponent()
	 */
	public Component getEditorComponent() {
		// TODO Auto-generated method stub
		return jTextField;
	}

	/** 
	 * @see javax.swing.ComboBoxEditor#getItem()
	 */
	public Object getItem() {
		// TODO Auto-generated method stub
		return jTextField.getText();
	}

	/** 
	 * @see javax.swing.ComboBoxEditor#removeActionListener(java.awt.event.ActionListener)
	 */
	public void removeActionListener(ActionListener l) {
		jTextField.removeActionListener(l);
		
	}

	/**
	 * @see javax.swing.ComboBoxEditor#selectAll()
	 */
	public void selectAll() {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * @see javax.swing.ComboBoxEditor#setItem(java.lang.Object)
	 */
	public void setItem(Object anObject) {
		jTextField.setText((String)anObject);
		
 	}
    
    /**
     *  This method creates a MaskFormatter instance that define the string format in the ComboBoxEditor.
     *  
     *  @param String s - a string that present the data format.
     */ 
    private MaskFormatter createFormatter(String s) {
   	    MaskFormatter formatter = null;
   	   // try {
   	     try {
					formatter = new MaskFormatter(s);
   	    } catch (java.text.ParseException exc) {
   	       System.err.println("formatter is bad: " + exc.getMessage());
   	       System.exit(-1);
   	    }
   	    return formatter;
    } 	    
}
