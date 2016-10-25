package org.bjason.cxfdemo.hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

import org.apache.log4j.Logger;

@WebService(targetNamespace = "http://org.bjason.cxfdemo.hello/", name = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    
	Logger log = Logger.getLogger(getClass().getName());

    public String sayHi(String text) {
        log.info("sayHi called");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        
        return "Hello " + text+" time is now "+sdf.format(new Date());
    }

	public String banner(String name) {
		log.info("Make a nice banner for "+name);
		StringBuffer sb = new StringBuffer();
		StringBuffer max = new StringBuffer();
		for(int i=0 ; i < name.length()*3 ; i++ ) {
			max.append("*");
		}
		sb.append("enjoy....\n"+max+"\n");
		sb.append("*"+ xChars(name.length()*3-2 , ' ')+"*\n");
		sb.append("*"+ xChars(name.length()-1,' ')+name+ xChars(name.length()-1,' ')+"*\n");
		sb.append("*"+ xChars(name.length()*3-2 , ' ')+"*\n");
		sb.append(max+"\n");
				
		return sb.toString();
	}
	private String xChars(int length,char c) {
		StringBuffer sb = new StringBuffer(length);
		for(int i=0 ; i < length ; i++ ) {
			sb.append(c);			
		}
		return sb.toString();
	}

}
