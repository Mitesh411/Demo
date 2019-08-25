package com.demo.test;
import javax.swing.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.event.*;

// https://www.javatpoint.com/ip-finder-in-java



public class IPFinder extends JFrame implements ActionListener {

	JLabel l;
	JTextField tf;
	JButton b;
	
	public IPFinder() {
	super(" URL SCRAPPER ");
	l = new JLabel(" Enter URL ");
	l.setBounds(50, 70, 200, 20);
	
	tf = new JTextField();
	tf.setBounds(50, 100, 200, 30);
	
	b = new JButton(" FIND URL ");
	b.setBounds(50, 150, 150, 30);
	b.addActionListener(this);
	add(l);
	add(tf);
	add(b);
	setSize(300, 300);
	setLayout(null);
	setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String url =tf.getText();
		try {
			WebDriver driver = new ChromeDriver();
			java.util.List<WebElement> link = driver.findElements(By.tagName("a"));
			System.out.println("\n \t Total Links Available in Webpage :--> "+link.size());
			
			for(WebElement link2: link) {
				
				
				System.out.println("<=====================================>");
				System.out.println(link2.getText());
				System.out.println(link2.getAttribute("href"));
				
				System.out.println("<=====================================>");
			
			}
		}
		catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IPFinder();
		
	}

}
