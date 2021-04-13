package com.zetcode.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import static com.zetcode.util.ReadData.getFile;;

public class SecurityTag extends SimpleTagSupport {
	
   private String id = "_____security";
   private float minutes = .25f;
     
   public void setId(String id) {
	this.id = id;
}
   
   public void setMinutes(float minutes) {
	this.minutes = minutes;
}



public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      
      String js = getFile(SecurityTag.class,"SecurityTag.js");
      js = js.replace("$id$", id)
    		  .replace("$minutes$", String.valueOf(minutes));
      
      out.println(js);
   }
}