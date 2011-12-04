package kmp_visio;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;

/**
 *  Creates an Array of collocated lable items.
 * 
 * @author Dimitar Jordanov
 * @see Gui_App
 *
 */
public class LabelArray {
  private JLabel[] jLarray;
  /**
   *  
   * 
   * @param Lnum  - The number of the labels that are in demand.
   * @param point - the desired location of the first element.
   */
  public LabelArray(int Lnum ,Point point){
	 
	jLarray = new JLabel[Lnum];  
	for(int i=0;i<Lnum;i++){
		jLarray[i]= new JLabel();
		jLarray[i].setText("");
		jLarray[i].setSize(new Dimension(20, 15));
		jLarray[i].setLocation(new Point(point.x +(20*i),point.y));  
	}  
	  
  }
  /**
   *  This method returns a single label from the set.
   * 
   * @param i - the order number of the desired lable.
   * @return  return the desired lable instance.
   */
  protected JLabel getLabel(int i){
	  return jLarray[i];
  }
  /** 
   *  This method set a valsue to a single lable.
   * @param i - The order number of the lable. 
   * @param str - The new value of the lable.
   */
  protected void setLabel(int i,String str){
	  jLarray[i].setText(str);
  }
  
}
