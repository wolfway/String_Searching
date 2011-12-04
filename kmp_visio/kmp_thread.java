package kmp_visio;

import java.awt.Color;

/**
 *  The methods of this class implement an approach for visual representation of the Knuth-Morris-Pratt
 *  string searching algorithm.
 *  The computation process can be devided on five main stages:
 *  <ul>
 *    <li>Initialization</li>
 *    <li>KMP PreProcess</li>
 *    <li>KMP Search</li>
 *    <li>Create the result strings</li>
 *    <li>Print the result strings</li>
 *  </ul> 
 *  
 * @author Dimitar Jordanov
 * @see Gui_app
 *  
 */
public class kmp_thread extends Thread {
	// Varriables
	 private String text = null;    // Text
	 private String patt = null;    // Pattern
	 private  int [] borderArr;     // Border Values - KMP Algorithm
	 private  int [] resultArr;     // Array that comprise the results from the search
	 private  int  resultArr_len;  // Comprise the size of resultArr acording to Text length and Pattern Length
	 
	 private String [] ResultStrings ;   //  Comprise a litst of the strings that are to be printed in the Parr move field.
	 private int [] matchesArr;           // Comprise the match posisions
	/**
	 * This method is the constructor of the class with two parameters.
	 * The thread is started at the end of this method when all the field of
	 * the class are initialized. Field's list follow :
	 * <ul>
	 *   <li>Text - The text sample </li>
	 *   <li>patt - The Pattern sample</li>
	 *   <li>borderArr - An array that will hold the border table with lentgh the Pattern lentgh plus one </li>
	 *   <li>resultArr_len - Max Number of Comparisons according to KMP algorithm </li>
	 *   <li>resultArr - Is to hold a track of the KMP algorithm computation </li>
	 *   <li>ResultStrings - A String array that will hold the result string from the KMP algorithm</li>
	 *   <li>matchesArr - Will save the position of the mattches if any</li>
	 * </ul> 
	 * @param pattern - The Pattern that will look for.
	 * @param Text    - The text sample to look in.
	 */
	public kmp_thread(String pattern, String Text){
		text = new String(Text);
		this.patt = new String(pattern);
		// Border Array
		borderArr = new int[this.patt.length()+1];
		// Compute the Length of the resultArr;
		resultArr_len = ( 2 * text.length() - 1 )* 2 ; // Max Number of Comparisons according to KMP algorithm
        //	 Init  ResultStrings
		ResultStrings = new String[( 2 * text.length() - 1 )* 4];
		// Init Resulr Array Max size 
		init_resultArr();
		// Init  Marches Array
		 matchesArr = new int[text.length()];
		 for(int i=0;i<text.length();i++){
			 matchesArr[i] = 666;
		 }
		 // Start the Tread
		start();
	}
	/**
	 *  The method Run is executed when the theread is started.
	 *  The order of methods called in this method follows the 
	 *  program logic. The only called method  with a loop is the 
	 *  the  "print_moving_patt" in witch is implemented the visialisation of
	 *  the algorithem process. 
	 *
	 */
	public void run() {
		// Local Variables
		int numberOfComp = 0;
		int numberofAttempts = 0;
		
		// KMP Preprocess
		 kmpPreprocess();
		// Put the Border table on the screen - to Label Array
		   Gui_app.printBorderArr(borderArr);
		// Search - Fill the Result Array
		   numberofAttempts = kmpSearch();
		// Compute the result - moving pattern
		 numberOfComp = moving_patt();
		 // Real Moving Pattern Print
		   print_moving_patt(numberOfComp,numberofAttempts);
		// Clean before leave
		 Gui_app.threadClean();
	}
	
	/**
	 *  This method use the prepared string array and print its items on the 
	 *  screen using  static function from Gui_app class. The printig process flow
	 *  is manages by flags that are obtained again from the Gui_app class via static
	 *  methods.
	 *   
	 *   
	 */	
	private void  print_moving_patt(int res_index,int attemptsCount){
	 int index =0;
	 boolean  move_ones_flag = false;
	 
	 while (ResultStrings[index] != null){
		
		if(! Gui_app.getPauseFlag() || move_ones_flag){
			
			 
			 move_ones_flag = false; 
		     Gui_app.printPattString(ResultStrings[index]);
		     colorMatchesInTextFiesld(ResultStrings[index]);
		 	 try {
				    sleep(1000);
		       } catch (InterruptedException e) {
   				e.printStackTrace();
             }
		     // Increase the counter   
		     index++;
		     
            //   Check if Stop
				if(Gui_app.getStopFlag()){
					return;
				}
		} // if
		else{
			
			if (Gui_app.getBackFlag()){
        		// set the index to the previous possition
				index-=2;
        		//check if not negative
        		if (index < 0)  index = 0;
        		// set flag in orde the to move the string ones back
        		move_ones_flag = true;
        		// Clean the Back Flag
        		Gui_app.setBackFlag(false);
        		// Clean the Pattern Move Field
        		Gui_app.patternMoveField();	
		     } //if
			if (Gui_app.getForwardFlag()){
        		//check if not negative
        		if (ResultStrings[index] == null) index-- ;
        		// set flag in orde the to move the string ones back
        		move_ones_flag = true;
        		// Clean the Back Flag
        		Gui_app.setForwardFlag(false);
        		// Clean the Pattern Move Field
        		Gui_app.patternMoveField();	
		     }//if
			
		   // Check if Stop
			if(Gui_app.getStopFlag()){
				return;
			}
		}//else
			
	 } // while
	 
		 // Set the Attemps count Field
        printNumberOfAttempts(attemptsCount);
		// Show the number of comparisons
        printCompCount(new String(""+ res_index ));
	
}		
	
	/**
	 *  This method reads the "resultArr"  array created by the "kmpSearch" method and 
	 *  writes the result strings to the String Result Array that is to be used
	 *  by "print_moving_patt" method.
	 * 
	 * @return  int - The number of records in Result Array that is equal to the number of comparisons.
	 * 
	 * @see run()
	 * @see kmpSearch()
	 * @see wtire_to_res(int,int,int) 
	 */ 
	private int  moving_patt(){
		
	//	boolean move_ones_back_flag = false;
		int res_index =0;
        int ii = 0, jj = 0;
        int str_index = 0;
        StringBuffer pattern_b = new StringBuffer("");
        
        while( res_index < resultArr_len && resultArr[res_index] != 555 ){ // end of the Result Array or End of records
			
        	 
          	 ii = resultArr[res_index];
          	 jj = resultArr[res_index+1];
          	 res_index+=2;
          	 
          		 
             // clear the Buffer 
     		   pattern_b.setLength(0);
     		   
             // add "_" before the pattern
     		  for(int i=ii-jj;i>0;i--){
     			 pattern_b.append('_'); 
     		  } //for
     		 //add the part of the pattern in the stirng
     		  for(int i=0;i<=jj;i++ ){
             //	add new Letter
          	    if (patt.charAt(i) != text.charAt(ii) && i == jj ){
          	    	pattern_b.append(patt.charAt(i));
          	   }
          	    else{
          	        pattern_b.append(Character.toUpperCase(patt.charAt(i)));
          	    	
          	     }
     		  } 
          	 // add Dots
          	   for(int i=1;i<patt.length()-jj ;i++ ){
          		 pattern_b.append('.');
     		  } //for 
     		  
     		  
           // Put the result to the result string
       	    ResultStrings[str_index]= new String(pattern_b.toString());
       	    str_index++;
        
             } // while
     		
     	   return res_index/2;  // Return the number of Records in Result Array == Number of Comparisons
             
     		
   } // end of Function
	
	/** 
	 * The Knuth - Morris - Pratt  algorithm requires preprocessing of the pattern
	 * sample that calculate a border value for each char element of the pattern.  
	 * The result is provided in "borderArr" class field.
	 * @see run()  
	 * @see kmpSearch()
	 */ 
    private void kmpPreprocess()
	    {
		    
	        int i=0, j=-1;
	        borderArr[i]=j;
	        while (i<patt.length())
	        {
	            while (j > -1 && patt.charAt(i)!= patt.charAt(j))
	                j=borderArr[j];
	            i++;
	            j++;
	            
	            if( i<patt.length() && patt.charAt(i) == patt.charAt(j)){
	                 borderArr[i]=borderArr[j];
	            }
	            else
	            	borderArr[i]=j;
	        }   
     }
    /**
     * This method implement the searching part of teh KMP algorithm and set up
     * entry in the "resultArr" array for each comparioson that has been made. 
     * @return int  - Return the numner of attempts that has been made.
     * @see  write_to_res 
     */
    private  int kmpSearch()
    {
    	
        int i=0, j=0, res_i=0;
        int attepmsCount = 1;
        while ( i < text.length())
        {
         	
            //  No sence to continue...no chance for match
          	  if(i + patt.length()  > text.length() && j==0)
          		 break;
        	
        	// write to the results
        	write_to_res(i,j,res_i);
        	res_i+=2;  // go to next free record
            while (j>=0 && text.charAt(i)!= patt.charAt(j)){
            	 // value from the last compute.
            	j=borderArr[j]; //new begining
               
            	 if(j>=0 &&  (i + patt.length()  <= text.length() ) ){
 	            //	write to the results
     	           write_to_res(i,j,res_i);
     	       	   res_i+=2;  // go to next free record
            		 
           	 	}
               
            }
            i++;
            j++;
            if (j==patt.length()) // a match is found
            {
            	 report(i-patt.length());
                j=borderArr[j]; // new begining 
            }
        }
        // Count the number of Attempts
        int m = 3;
        while( m < resultArr_len && resultArr[m] != 555 ){
        	if(resultArr[m] <= resultArr[m-2])
        		attepmsCount++;	
        	m+=2;
        }
        return attepmsCount;
    }
    /**
     *  This method create a record in the "matchesArr" class field for each 
     *  substring in the text sample that is equal to the pattern sample.
     * @param pos - The possition of the first character of the pattern string that 
     * has been found in the text sample.
     * @see kmpSerch() 
     */
    private void report(int pos){
    	int i =  0;
    	// Record the new match in the first free position
       while(matchesArr[i]!= 666 ) i++;
       matchesArr[i]=pos;
    	    
    }
    /**
     *  This method retrieve the position of the pattern to the text sample.
     *  
     * @param str
     * @return - return the position of the pattern to the text sample
     */
    private int currentStrIndex(String str){
    	int i = 0;
    	while( str.charAt(i) == '_')i++;
    	 return i;
    }
    /**
     *  This method sets a differnt color to show the matches.
     *  @see print_moving_patt(int,int)
     */
    private void colorMatchesInTextFiesld(String str){
    	int index = currentStrIndex(str);
    	int i = 0;
    	while(matchesArr[i]!=666 && i < text.length()-1 ){
    		if(( matchesArr[i]+ patt.length() -1 ) < index ||
    				  (  index == matchesArr[i] && 
    				   (matchesArr[i]+ patt.length() -1 ) == ( str.length()-1 ) ) &&
    				    str.charAt(str.length()-1) != '.' ){
    			// The index has passed the match or the match is in the last possible pos.
    			for(int j=0;j<patt.length();j++){
    				Gui_app.setColorTextLabel(matchesArr[i]+j,Color.RED);
    			}
    		}
    		else{
    			for(int j=0;j<patt.length();j++){
    			   Gui_app.setColorTextLabel(matchesArr[i]+j,Color.BLACK);
    			}
    		}
    		i++;
    	}// while
    	    		
   	}
    
    /**  
     * The method create a record in the  "resultArr" array for
     * each comparison that has been accomplised during the search part of the
     * algorithm.
     * 
     * @param ii - Index in the thext.
     * @param jj - Index in the pattern.
     * @param index - Index in the "resultArr" class field.
     * 
     * @see kmpSearch()
     */
    private void write_to_res(int ii, int jj,int index){
	 resultArr[index]=ii;
	 resultArr[index+1]=jj;
 }
    /** 
     * This method inisialize the "resultArr" class field to initial state (filled with 555)
     *
     * @see kmp_thresd(String,String).
     */
    private void init_resultArr(){
    	//results=new int[text_len]; // init Result array
    	resultArr=new int[resultArr_len]; // init Result array  - Can not be longer than the text lenght.
        for (int index = 0;index<resultArr_len;index++){
          resultArr[index]=555;		 
        }
    }
    /**
     *  
     *  This method prints the number of attempts useing a static function from the
     *  Gui_app class. 
     *  
     *  @see kmpSearch(). 
     *  @see print_moving_patt().
     *  @see Class Gui_app.
     */
     
    private void printNumberOfAttempts(int numAttempts){
    	Gui_app.setAttemptsLabel("" + numAttempts);
    }
    
    /**
     *  This method prints the number of comparisons useing a static function from the
     *  Gui_app class. 
     *  
     *  @see print_moving_patt().
     *  @see Class Gui_app.
     */
    private void printCompCount(String str){
      Gui_app.setCharacterComparisonsCountLabel(str);
    }
}
