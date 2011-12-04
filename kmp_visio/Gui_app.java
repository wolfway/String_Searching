package kmp_visio;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;


/**
 *  This class creates and maintains the Graphic user interface throughout the excecution of the applet.
 * 
 * @author Dimitar Jordanov
 *
 */
public class Gui_app extends JApplet {

	// Flags
	private static boolean stop_flag = false;
	private static boolean pause_flag = false;
	private static boolean back_flag = false;
	private static boolean forward_flag = false;
	
	private static int index_len = 10;
	private static int pattern_len  = 10;
	private static int border_len = 10;
	private static int text_len = 23;
	private static int patt_len = 23;
	
	private static int patt_real_len = 0;
	private static int text_real_len = 0;
	
	private JPanel jContentPane = null;
	private JLabel jLabel = null;  
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;

    // Arrays of Labels	
	private static LabelArray index_arr = null;  //   index Label Array
	private static LabelArray pattern_arr = null;  //  Pattern Label Array Static 
	private static LabelArray borders_arr = null;  //  Next - Table
	private static LabelArray text_arr = null;  //     Text Label Aray
	private static LabelArray patt_arr = null;  //     Pattern Labal Array Dynamic  //  @jve:decl-index=0:
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private static JLabel jLabel9 = null;
	private static JLabel jLabel10 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private static JButton jButton = null;
	private static JButton jButton1 = null;
	private static JButton jButton2 = null;
	private static JButton jButton3 = null;
	private static JButton jButton4 = null;
	private static JLabel jLabel13 = null;
	private JLabel jLabel14 = null;
	private static JComboBox jComboBox = null;
	private static JComboBox jComboBox1 = null;
	/**
	 * This is the default constructor
	 */
	public Gui_app() {
		super();
	}

	/**
	 * This method initializes the Applet each time it is laoded.
	 * 
	 *  Init
	 */
	public void init() {
		// Init Array Labels
		index_arr = new LabelArray(index_len,new Point(120,45));
		pattern_arr = new LabelArray(pattern_len ,new Point(120,75));
		borders_arr = new LabelArray(border_len,new Point(120,105));
		text_arr = new LabelArray(text_len,new Point(120,165));
		patt_arr = new LabelArray(patt_len ,new Point(120,195));
		
		this.setSize(600, 360);
		this.setContentPane(getJContentPane());
		//jTextField.requestFocus();	
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * 
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getjLabel1(), null);
			jContentPane.add(getjLabel2(), null);
			jContentPane.add(getjLabel3(), null);
			jContentPane.add(getjLabel4(), null);
			jContentPane.add(getjLabel5(), null);
			jContentPane.add(getjLabel6(), null);
			jContentPane.add(getjLabel7(), null);
			jContentPane.add(getjLabel8(), null);
			jContentPane.add(getjLabel9(), null);
			jContentPane.add(getjLabel10(), null);
			jContentPane.add(getjLabel11(), null);
			jContentPane.add(getjLabel12(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getjLabel(), null);
			jContentPane.add(getjLabel14(), null);
			jContentPane.add(getjLabel13(), null);
			jContentPane.add(getJButton4(), null);
			jContentPane.add(getJComboBox(), null);
			jContentPane.add(getJComboBox1(), null);
			
			
			// add Index
			for(int i=0;i<index_len;i++){
			  jContentPane.add(index_arr.getLabel(i), null);	
			}
            // add  Pattern
			for(int i=0;i<pattern_len ;i++){
			  jContentPane.add(pattern_arr.getLabel(i), null);	
			}
            // add  Borders
			for(int i=0;i<border_len;i++){
			  jContentPane.add(borders_arr.getLabel(i), null);	
			}
            //			 add  Text
			for(int i=0;i<text_len;i++){
			  jContentPane.add(text_arr.getLabel(i), null);	
			}
            //			 add  moving Pattern 
			for(int i=0;i<patt_len;i++){
			  jContentPane.add(patt_arr.getLabel(i), null);	
			}
			
		}
		return jContentPane;
	}
	
    /**
     * 	 Get jLabel  Knuth Morris Pratt
     * 
     * @return
     */
    private JLabel getjLabel(){
   	 if (jLabel == null){
   		 	jLabel = new JLabel();
   		 	jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
   		 	jLabel.setForeground(new Color(0, 204, 204));
   		 	jLabel.setFont(new Font("Dialog", Font.BOLD, 18));
   		 	jLabel.setHorizontalAlignment(SwingConstants.CENTER);
   		 	jLabel.setBounds(new Rectangle(5, 5, 590, 34));
   		 	jLabel.setText("Knuth - Moriss -  Paratt String Searching Algorithm");
   	 }
   	 return jLabel;
    }    
    
	 /**
	  *  Get jLabel 1 INDEX
	  * 
	  * @return
	  */
     private JLabel getjLabel1(){
    	 if (jLabel1 == null){
    		 jLabel1 = new JLabel();
 			 jLabel1.setText("Index");
 			 jLabel1.setSize(new Dimension(90, 15));
 			 jLabel1.setLocation(new Point(15, 45));  
    	 }
    	 return jLabel1;
     }    
     
     /** 
      * Get jLabel2  PATTERN
      * 
      * @return
      */
     private JLabel getjLabel2(){
    	 if (jLabel2 == null){
    		 jLabel2 = new JLabel();
 			 jLabel2.setText("Pattern");
 			 jLabel2.setSize(new Dimension(90, 15));
 			 jLabel2.setLocation(new Point(15, 75));
    	 }
    	 return jLabel2;
     }    
     
     /**
      *    Get jLabel 3 Borders
      * 
      * @return
      */
     private JLabel getjLabel3(){
    	 if (jLabel3 == null){
    		 jLabel3 = new JLabel();
 			 jLabel3.setText("Borders");
 			 jLabel3.setSize(new Dimension(90, 15));
 			 jLabel3.setLocation(new Point(15, 105));
    	 } 
    	 return jLabel3;
     }    
     /**
      *    Get jLabel 4 Results
      * 
      * @return
      */
     private JLabel getjLabel4(){
    	 if (jLabel4 == null){
    		 jLabel4 = new JLabel();
 			 jLabel4.setText("Result");
 			 jLabel4.setSize(new Dimension(90, 15));
 			 jLabel4.setForeground(new Color(255, 0, 51));
 			 jLabel4.setLocation(new Point(15, 135));
    	 } 
    	 return jLabel4;
     }    
     /**
      *    Get jLabel 5 TEXT
      * 
      * @return
      */
     private JLabel getjLabel5(){
    	 if (jLabel5 == null){
    		 jLabel5 = new JLabel();
 			 jLabel5.setText("Text");
 			 jLabel5.setSize(new Dimension(90, 15));
 			 jLabel5.setLocation(new Point(15, 165));
    	 } 
    	 return jLabel5;
     }    
     /** 
      * Get jLabel 6 PATTERN
      * 
      * @return
      */
     private JLabel getjLabel6(){
    	 if (jLabel6 == null){
    		jLabel6 = new JLabel();
 			jLabel6.setText("Pattern");
 			jLabel6.setSize(new Dimension(90, 15));
 			jLabel6.setLocation(new Point(15, 195));
    	 } 
    	 return jLabel6;
     }    
     /**
      *    Get jLabel 7 Number of Attempts
      * 
      * @return
      */
     private JLabel getjLabel7(){
    	 if (jLabel7 == null){
    		 jLabel7 = new JLabel();
 			 jLabel7.setText("Number of Attempts ");
 		     jLabel7.setLocation(new Point(15, 225));
 		     jLabel7.setSize(new Dimension(124, 15));
    	 } 
    	 return jLabel7;
     }  
     /**
      *     Get jLabel 8 Character comparisons
      * 
      * @return
      */
     private JLabel getjLabel8(){
    	 if (jLabel8 == null){
    		 jLabel8 = new JLabel();
 			jLabel8.setText("Character comparisons");
 			jLabel8.setLocation(new Point(15, 255));
 			jLabel8.setSize(new Dimension(142, 15));
    	 } 
    	 return jLabel8;
     }    
     /**
      *    Get jLabel 9 Number of Attempts
      * 
      * @return
      */
     private static JLabel getjLabel9(){
    	 if (jLabel9 == null){
    		jLabel9 = new JLabel();
 			jLabel9.setText("");
 			jLabel9.setLocation(new Point(165, 225));
 			jLabel9.setSize(new Dimension(76, 15));
    	 } 
    	 return jLabel9;
     }    
     /**
      *  Get jLabel 10 Character comparisons
      * 
      * @return
      */
     private static JLabel getjLabel10(){
    	 if (jLabel10 == null){
    		jLabel10 = new JLabel();
 		    jLabel10.setText("");
 			jLabel10.setSize(new Dimension(77, 15));
 			jLabel10.setLocation(new Point(165, 255));
    	 } 
    	 return jLabel10;
     }    
     //   Get jLabel 11 Pattern
     private JLabel getjLabel11(){
    	 if (jLabel11 == null){
    		 jLabel11 = new JLabel();
 			 jLabel11.setText("Pattern");
 			 jLabel11.setSize(new Dimension(73, 15));
 		     jLabel11.setLocation(new Point(30, 285));
    	 } 
    	 return jLabel11;
     }    
     /**
      *    Get jLabel 12 Text
      * 
      * @return
      */
     private JLabel getjLabel12(){
    	 if (jLabel12 == null){
    		 jLabel12 = new JLabel();
 		     jLabel12.setText("Text");
 			 jLabel12.setSize(new Dimension(83, 15));
 			 jLabel12.setLocation(new Point(182, 285));
    	 } 
    	 return jLabel12;
     }  
     /**
      *    Get jLabel 13  Errors
      * 
      * @return
      */
     private JLabel getjLabel13(){
       if (jLabel13 == null){
        jLabel13 = new JLabel();
	   	jLabel13.setForeground(new Color(247, 17, 17));
		jLabel13.setLocation(new Point(284, 285));
		jLabel13.setSize(new Dimension(286, 15));
		jLabel13.setHorizontalTextPosition(SwingConstants.TRAILING);
		jLabel13.setHorizontalAlignment(SwingConstants.TRAILING);
		jLabel13.setText("");
       }  
	   return jLabel13;
     }    	
		
     /**
      *  Get jLabel 14  Author
      * 
      * @return
      */
     private JLabel getjLabel14(){
       if (jLabel14 == null){	  
        jLabel14 = new JLabel();
		jLabel14.setBounds(new Rectangle(361, 45, 225, 16));
		jLabel14.setPreferredSize(new Dimension(40, 15));
		jLabel14.setForeground(new Color(0, 204, 204));
		jLabel14.setText("Disigned by Dimitar Jordanov - xjorda01");
       }  
	   return jLabel14;
     }    	

    /**
     * The method maintains a history record of previously used couples pattern-text. Each new pair is added 
     * to the ComboBox item list.
     * @param jCombo   - Pattern ComboBox
     * @param item     - current pattern sample
     * @param jCombo1  - Text ComboBox
     * @param item1    - current taxt sample
     */ 
    protected static void addToComboBoxList(JComboBox jCombo,
    		                                String item,
    		                                JComboBox jCombo1,
    		                                String item1
    		                                ){
    	int flag =0;
    	int i = 0;
    	if ( jCombo.getItemCount() == 0 ){
    		jCombo.insertItemAt(item,0);
        }
        else{
     	   for( i=jCombo.getItemCount()-1;i>-1;i--){
     		   	if (item.equals(jCombo.getItemAt(i))){
     		   	break;
     	        }
     	  } // end of for   	
     	        // the new string is not found, add it
     	        if(i == -1){
     	        	flag++; 
     	        }
            
     	   
     	  for( i=jCombo1.getItemCount()-1;i>-1;i--){
   		   	if (item1.equals(jCombo1.getItemAt(i))){
   		   	break;
   	        }
     	  } // end of for
     	  
   	        // the new string is not found, add it
   	        if(i == -1 && flag == 1){
   	         jCombo.insertItemAt(item,0);
   	         jCombo1.insertItemAt(item1,0);
   	        }     	  
        } //else
    } 
	/**
	 * This method initializes the "Start" button	
	 * 	
	 * Start Button	
	 */
	private static JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Start");
			jButton.setLocation(new Point(30, 330));
			jButton.setSize(new Dimension(151, 20));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					// Check Stop Flag
					
					if( jButton.getText().equals("Stop")){
						stop_flag = true;
						return;
					}
					
					if(getJComboBox().getEditor().getItem().equals("") ||
							getJComboBox1().getEditor().getItem().equals("")){
						
					    jLabel13.setText("Error - Empty Input Field!");
						return;
					}
					
					// get the Pattern and the Text and Convert it to Lower Case
					//String pattern = ( (String) getJComboBox().getSelectedItem()).trim().toLowerCase();
					//String text = ( (String) getJComboBox1().getSelectedItem()).trim().toLowerCase();
					
					String pattern = ( (String) getJComboBox().getEditor().getItem()).trim().toLowerCase();
					String text = ( (String) getJComboBox1().getEditor().getItem()).trim().toLowerCase();
					
					// Check if the Text and Pattern are fine
					if( text.length() < pattern.length()){
					    jLabel13.setText("Error - Inappropriate Text Length!");
					  return; 
					}
					if(pattern.length() == 0 ){
						jLabel13.setText("Error - Empty Input Field!");
						return;
					}
						
					// add the new string to the ComboBox's list
					addToComboBoxList(getJComboBox(),pattern,getJComboBox1(),text);

					
					//Change the name of the Button
					jButton.setText("Stop");
					//  Clean
					Clean();
					
					 //Enable Pause Button
				    jButton3.setEnabled(true);
				    
					
					// init the lenght variables
					patt_real_len = pattern.length();
					text_real_len = text.length();
					
					// Set Index Label Array
					setIndexArray(pattern.length());
					// Set Pattern
					setPatternArray(pattern);
					// Set Text
					setTextArray(text);
					// Ccreate Thread
					create_thread(pattern, text,patt_arr);
					
				}
			});
		}
		return jButton;
	}
	
	/**
	 *  Set Index Label Array
	 * 
	 * @param len
	 */
	private static void setIndexArray(int len){
	
	  for(int i = 0;i<=len;i++){	 
	    index_arr.setLabel(i, new Integer(i).toString());
	  } 
	}
	/**
	 *  Set Pattern Label Array
	 * 
	 * @param patt
	 */
	private static void setPatternArray(String patt){
		
		int len = patt.length();
		  for(int i = 0;i<=len-1;i++){	 
		    pattern_arr.setLabel(i,Character.toString(patt.charAt(i)));
		  } 
	}
	/**
	 *  Set Text Labale Array
	 * 
	 * @param patt
	 */
    private static void setTextArray(String patt){
		
		int len = patt.length();
		  for(int i = 0;i<len;i++){	 
		    text_arr.setLabel(i,Character.toString(patt.charAt(i)));
		  } 
	}
    /**
     *  Create Thread
     * 
     * @param pattern
     * @param text
     * @param patt_mv
     */
    private static void create_thread(String pattern,String text,LabelArray patt_mv){
		 kmp_thread thread = new kmp_thread(pattern,text);
		  
	 }
	/**
	 * This method initializes jButton1	
	 * 	
	 * Backward
	 */
	private static JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("<<");
			jButton1.setSize(new Dimension(61, 20));
			jButton1.setLocation(new Point(300, 330));
			jButton1.setEnabled(false);
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getPauseFlag()){
						back_flag=true;
					}
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * Forward
	 */
	 private static JButton getJButton4() {
		 if (jButton4 == null) {
				jButton4 = new JButton();
				jButton4.setText(">>");
				jButton4.setSize(new Dimension(61, 20));
				jButton4.setLocation(new Point(360, 330));
				jButton4.setEnabled(false);
				jButton4.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						if(getPauseFlag()){
							forward_flag=true;
						}
					}
				});
			}
			return jButton4;
		}
	
	/**
	 * This method initializes jButton2	
	 * 	
	 * Clear	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Clear");
			jButton2.setSize(new Dimension(151, 20));
			jButton2.setLocation(new Point(420, 330));
			jButton2.setEnabled(false);
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (getJButton().getText().equals("Start")){
					  Clean();
                     //	clean Pattern Edit Field
					   jComboBox.setSelectedIndex(-1);
					 //clean Text Edint Field
					   jComboBox1.setSelectedIndex(-1);
					}		   
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * Pause
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Pause");
			jButton3.setLocation(new Point(180, 330));
			jButton3.setSize(new Dimension(121, 20));
			jButton3.setEnabled(false);
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					if(jButton3.getText().equals("Pause")){
					   jButton3.setText("Continue");
					   pause_flag = true;
					   // Enable Back and Forward Buttons
					   getJButton4().setEnabled(true);
					   getJButton1().setEnabled(true);
					   
					}
					else{
					   jButton3.setText("Pause");
					   // Disable Back and Forward Buttons
					   getJButton4().setEnabled(false);
					   getJButton1().setEnabled(false);
					   pause_flag = false;
					}
				}
			});
		}
		return jButton3;
	}
	
	/**
	 *  Convert the borrder values for all ellements from the pattern to Label Array
	 * 
	 * @param borderArr - An array that comprise the barder values of the pattern items.
	 */
    protected  static void  printBorderArr(int [] borderArr){
    	for(int i = 0;i<= patt_real_len;i++){	 
    		borders_arr.setLabel(i, new Integer(borderArr[i]).toString());
    	  } 	
    }  
     
    /**
     *   Load  a string to the Label Array. Used by the thread that provide the visualization.
     * 
     * @param str - the pattern string that is to be displayed.
     */
    protected static void printPattString(String str){
 	  
 	  for(int i=0;i<str.length();i++){
 		  
 		if(i >=  patt_len){
 		   return;
 		}  
 	    if(str.charAt(i) == '_'){	  
 	    	patt_arr.setLabel(i,"");
 	    }
 	    else{
 	    	  // if the letter does not  fit, mark it in different color
 	    	  if(Character.isLowerCase(str.charAt(i))){
 	    	     Gui_app.setColorPatternLabel(i,Color.BLUE);	 
 	    	     patt_arr.setLabel(i,Character.toString(str.charAt(i)));
 	    	  }
 	    	  // if Big letter
 	    	  if(Character.isUpperCase(str.charAt(i))){
 	    	     Gui_app.setColorPatternLabel(i,Color.red);	 
 	    	     patt_arr.setLabel(i,Character.toString(str.charAt(i)));
 	    	  }
 	    	   // Print Dost in Black
 	    	  if ( str.charAt(i) == '.'){
 	    		 Gui_app.setColorPatternLabel(i,Color.black);	
 	    		 patt_arr.setLabel(i,Character.toString(str.charAt(i)));
 	    	  }
 	    	
 	    }
 	  } 
 	   
    }	
    /** 
     *  Load  the Attempts Level Lable with the number of attemptets that were made during the execution of the search process. 
     * @param str - the string that represent the value of the number of attempts that have made.
     */
    protected static void setAttemptsLabel(String str){
    	// Attempts Label
    	
    	getjLabel9().setText(str);
    	
    }
    /**
     * Load  the  Comparisons Label Lable with the number of comparisons that were made during the execution of the search process.
     * 
     * @param str - the string that represent the value of the number of comparisons that have made.
     */
    protected static void setCharacterComparisonsCountLabel(String str){
    	
    	// Comparisons Label
    	getjLabel10().setText(str);
    	
    }
   /**
    *  Clean Function
    * 
    *
    */
   private static void Clean(){
	 // clean Index
	   for(int i=0; i<index_len;i++)
		  index_arr.setLabel(i,""); 
	 // clean Pattern
	   for(int i=0; i<pattern_len;i++)
			  pattern_arr.setLabel(i,""); 
	 // clean Borders
	   for(int i=0; i<border_len;i++)
		  borders_arr.setLabel(i,""); 
	 // Claen Text
	   for(int i=0; i<text_len;i++)
			  text_arr.setLabel(i,"");
     //  Clean Moving Patt
	   patternMoveField();
	// Set Puase Button
	   jButton3.setText("Pause");
	// Clean Attempts Field
	   jLabel9.setText("");
	// Claet Character Comparisons Fiels
	   jLabel10.setText("");
	// Set all Labels to black Color
	  for(int i=0;i<text_len;i++){
		  setColorTextLabel(i,Color.BLACK);
	  } 
	  // Diable the Back and Forward Buttons
	   getJButton4().setEnabled(false);
	   getJButton1().setEnabled(false);
	   // Clean the Error Label
	    jLabel13.setText("");
	    
	 // Clean Flags
	   pause_flag = false;
	   back_flag = false;
	   forward_flag = false;
	   stop_flag = false;
	 //  Disable the Clean Button
	   jButton2.setEnabled(false); 
	   
   }
   /**
    *  This method clean the Pattern Move Field.The function is used by the thread that provide the visualization.  
    *
    */
   protected static void  patternMoveField(){ 
   //  Clean Moving Patt
	   for(int i=0; i<patt_len;i++)
			  patt_arr.setLabel(i,""); 
   }
   /**
    *  This method set all used flags to the initial state.
    *   
    *
    */
   protected static void threadClean(){
	   getJButton().setText("Start");  
       //  Disable the Clean Button
	    jButton2.setEnabled(true);
	   //Disable Pause Button
	    jButton3.setEnabled(false);
      // Diable the Back and Forward Buttons
		 getJButton4().setEnabled(false);
		 getJButton1().setEnabled(false);
	   
	   
   }
   
   /**
    *   This method returns the value of the Stop Flag.
    * 
    * @return  The method returns the current value of the "Stop" flag.
    */
   protected static boolean getStopFlag(){
	   return stop_flag;
   }
   /**
    *  This method returns the value of the Pause Flag.
    * 
    * @return The method returns the current value of the "Pause" flag.
    */
   protected static boolean getPauseFlag(){
	   return pause_flag;
   }
   /** 
    *  This method retuns the value of the  Back Flag.
    * 
    * 
    * @return The method returns the current value of the "Back" flag.
    */
   protected static boolean getBackFlag(){
	   return back_flag;
   }
   /**
    *   This method set a value of the  Back Flag.
    * 
    * @param b The new Boolean valuse of the Back flag.
    */
   protected static void  setBackFlag(boolean b){
	    back_flag = b;
   }
   
   /**
    *  This method set a value of the Forward Flag.
    * 
    * @return  The method returns the current value of the "Forward" flag.
    */
   protected static boolean getForwardFlag(){
	   return forward_flag;
   }
   /** 
    *  This method set a value of the Forward Flag.
    * @param b The new Boolean valuse of the Forward flag.
    */
   protected static void  setForwardFlag(boolean b){
	    forward_flag = b;
   }
   /**
    * This method change the color of a single Letter from the text.
    * 
    * @param index - The index of the Label item
    * @param color - The color desired
    */
   protected static void setColorTextLabel(int index,Color color){
	   text_arr.getLabel(index).setForeground(color);
   }
  /**
   *  This method change the color of a single Letter from the text.
   * @param index - The index of the Label item
   * @param color - The color desired
   */
   protected static void setColorPatternLabel(int index,Color color){
	   patt_arr.getLabel(index).setForeground(color);
   }

/**
 * This method initializes jComboBox	
 * 	
 * @return javax.swing.JComboBox	
 */
private static JComboBox getJComboBox() {
	if (jComboBox == null) {
		jComboBox = new JComboBox();
		jComboBox.setLocation(new Point(30, 305));
		jComboBox.setSize(new Dimension(145, 20));
		jComboBox.setEditable(true);
		jComboBox.setMaximumRowCount(2);
		jComboBox.setEditor(new FormattedComboBoxEditor("*********"));
		// Add Example Pattern
		jComboBox.addItem("cdcacdcp");
		jComboBox.addItem("ccc");
		jComboBox.setSelectedIndex(-1);
		jComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (jComboBox.getSelectedIndex() != -1 ){
				   jComboBox1.getEditor().setItem(jComboBox1.getItemAt(jComboBox.getSelectedIndex()));
				   System.out.println("Pattern" + jComboBox.getSelectedIndex());
				}
			}
		});
		
	}
	return jComboBox;
}

/**
 * This method initializes jComboBox1	
 * 	
 * @return javax.swing.JComboBox	
 */
private static JComboBox getJComboBox1() {
	if (jComboBox1 == null) {
		jComboBox1 = new JComboBox();
		jComboBox1.setSize(new Dimension(392, 20));
		jComboBox1.setLocation(new Point(180, 305));
		jComboBox1.setEditable(true);
		jComboBox1.setMaximumRowCount(2);
		jComboBox1.setEditor(new FormattedComboBoxEditor("***********************"));
        // Add Example Text
		jComboBox1.addItem("cdcacdcacdcpaccad");
		jComboBox1.addItem("accacccacccbccaa");
		jComboBox1.setSelectedIndex(-1);
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (jComboBox1.getSelectedIndex() != -1 ){
				  jComboBox.getEditor().setItem(jComboBox.getItemAt(jComboBox1.getSelectedIndex()));
				}  
			}
		});
	}
	return jComboBox1;
}

  
}
