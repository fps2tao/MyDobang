package com.cc8w;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cc8w.view.GobangView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	//Test01 tt01 = (Test01) context.getBean("Test01");
    	//System.out.println(tt01);
    	GobangView gv = new GobangView();
    }
}
