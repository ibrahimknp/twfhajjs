package com.plus.app.shared;

import com.plus.app.client.util.MyTextBox;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to ensure
	 * that usernames, passwords, email addresses, URLs, and other fields have the
	 * proper syntax.
	 * 
	 * @param name the name to validate
	 * @return true if valid, false if invalid
	 */
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
	
	public static boolean isPhone(MyTextBox val) throws MyExceptions
	{
	  String str="0123456789";
	  if(val.getText()!=null && val.getText().trim().length()>0)
	  {
		  int len=val.getText().length();
		  boolean bool=false;
		  String errorVal="";
		  if(len<7)
		  {
			  val.setFocus(true);
			  throw new NullPointerException("Invalid "+val.getNameValue()+" Number");  
		  }
	      for(int a=0;a<len;a++)
	      {
	          if(str.indexOf(val.getText().charAt(a))==-1)
	          {
	        	bool=true;
	          	Character ch=val.getText().charAt(a);
	          	errorVal=errorVal+ch.toString()+",";
	          }
	          
	       }
	      if(bool)
          {
        	 val.setFocus(true);
	         errorVal=errorVal.substring(0,errorVal.length()-1);
        	 throw new NullPointerException(errorVal+" "+"Invalid character is not allowed");
          }
	  }
        return true;
	}
	
	public static boolean isMobile(MyTextBox val) throws MyExceptions
	{
	  String str="0123456789";
	  if(val.getText()!=null && val.getText().trim().length()>0)
	  {
		  int len=val.getText().length();
		  boolean bool=false;
		  String errorVal="";
		  if(len<10 || len>10)
		  {
			  val.setFocus(true);
			  throw new NullPointerException("Invalid "+val.getNameValue()+" Number");  
		  }
	      for(int a=0;a<len;a++)
	      {
	          if(str.indexOf(val.getText().charAt(a))==-1)
	          {
	        	bool=true;
	          	Character ch=val.getText().charAt(a);
	          	errorVal=errorVal+ch.toString()+",";
	          }
	          
	       }
	      if(bool)
          {
        	 val.setFocus(true);
	         errorVal=errorVal.substring(0,errorVal.length()-1);
        	 throw new NullPointerException(errorVal+" "+"Invalid character is not allowed");
          }
	  }
        return true;
	}
	public static boolean isMobilePak(MyTextBox val) throws MyExceptions
	{
	  String str="0123456789";
	  if(val.getText()!=null && val.getText().trim().length()>0)
	  {
		  int len=val.getText().length();
		  boolean bool=false;
		  String errorVal="";
		  if(len<12 || len>12)
		  {
			  val.setFocus(true);
			  throw new NullPointerException("Invalid "+val.getNameValue()+" Number");  
		  }
	      for(int a=0;a<len;a++)
	      {
	          if(str.indexOf(val.getText().charAt(a))==-1)
	          {
	        	bool=true;
	          	Character ch=val.getText().charAt(a);
	          	errorVal=errorVal+ch.toString()+",";
	          }
	          
	       }
	      if(bool)
          {
        	 val.setFocus(true);
	         errorVal=errorVal.substring(0,errorVal.length()-1);
        	 throw new NullPointerException(errorVal+" "+"Invalid character is not allowed");
          }
	  }
        return true;
	}
	
	public static boolean isEmail(MyTextBox val) throws MyExceptions
	{
	  String str= val.getText();
	  if(val.getText()!=null && val.getText().trim().length()>0)
	  {
		  int len=val.getText().length();
		  boolean bool=false;
		  String errorVal="";
		  if(!(str.matches("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$")))
		  {
			  throw new NullPointerException(errorVal+" "+"Invalid email address");
          }
	  }
        return true;
	}
	
	public static boolean isTime(MyTextBox val) throws MyExceptions
	{
		  String str="0123456789";
		  if(val.getText()!=null && val.getText().trim().length()>0)
		  {
			  int len=val.getText().length();
			  
			  if(len<4 || len>4)
			  {
				  val.setFocus(true);
				  throw new NullPointerException("Invalid "+val.getNameValue());  
			  }
			  String HH = val.getText().substring(0,2);
			  String MM = val.getText().substring(2,4);
			
			  if(Integer.parseInt(HH)>24)
			  {
				  val.setFocus(true);
				  throw new NullPointerException("Invalid Hours");
			  }
					
			  if(Integer.parseInt(MM)>59)
			  {
				  val.setFocus(true);
				  throw new NullPointerException("Invalid Minutes");
			  }
			  
		      
		  }
		  return true;
	}
	
	public static boolean isValidCarrier(MyTextBox val) throws MyExceptions
	{
		  String str="0123456789";
		  if(val.getText()!=null && val.getText().trim().length()>0)
		  {
			  int len=val.getText().length();
			  
			  if(len<4 || len>6)
			  {
				  val.setFocus(true);
				  throw new NullPointerException("Invalid "+val.getNameValue());  
			  }
			  String carrier = val.getText().substring(0,1);		  
			 // String no = val.getText().substring(2,5);
			  
			  if(!(carrier.matches("[a-zA-Z]+")))
			  {
				  throw new NullPointerException("Invalid Flight Name.. plz check the format i.e. SV878");
	          }
			 /* if(!(no.matches("[0-9]+")))
			  {
				  throw new NullPointerException("Invalid Flight Name.. plz check the number format i.e. SV878");
	          }
	          */
		  }
		  return true;
	}
}
