package com.library.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.library.dao.ReaderDaoImpl;
import com.library.model.Reader;
import com.library.service.BookServiceImpl;
import com.library.service.ReaderServiceImpl;

public class CountingView extends JPanel{
	BookServiceImpl bsi=new BookServiceImpl();
	ReaderDaoImpl rdi=new ReaderDaoImpl();
	ReaderServiceImpl rsi=new ReaderServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1691297130953805443L;
	//书库剩余数量面板
	JLabel jlRestNumOfBook;
	JPanel 	panel_rest;
	JLabel jtRestNumOfBook;
	
	//已借出书 的数量
	JLabel jlBrrowedNumOfBook;
	JLabel jtBrrowedNumOfBook;
	JPanel 	panel_brrowed;
	
	//读者数量
	JLabel jlNumOfReader;
	JLabel jtNumOfReader;
	JPanel 	panel_reader;
	
	//最近日期
	JLabel jlLatestDate;
	JLabel jtLatestDate;
	JPanel 	panel_date;
	
	
	JButton buttonRefresh;
	
	public CountingView(){
	
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.LEFT);	
		
		final BorderLayout borderlayout=new BorderLayout();
		
		//书库剩余面板
		jlRestNumOfBook = new JLabel("书库剩余数量:");
		panel_rest = new JPanel();
		jtRestNumOfBook = new JLabel(Integer.toString(bsi.bookNumber()));
		panel_rest.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		panel_rest.setLayout(flowLayout);	
		jlRestNumOfBook.setBounds(10, 10, 100, 21);
		jtRestNumOfBook.setBounds(100, 10, 200, 21);
		panel_rest.add(jlRestNumOfBook);
		panel_rest.add(jtRestNumOfBook);
		
		
		
		buttonRefresh = new JButton("刷新");
		
		buttonRefresh.addActionListener(new addBookActionListener());
		
		

		
		jlBrrowedNumOfBook = new JLabel("书借出数目:");
		panel_brrowed = new JPanel();
		ArrayList<Reader> readerList=rdi.findAll();
		int sum = 0;
		for(Reader r:readerList){
			sum+=r.getAmount();
		}
		jtBrrowedNumOfBook = new JLabel(Integer.toString(sum));
		panel_brrowed.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		panel_brrowed.setLayout(flowLayout);	
		jlBrrowedNumOfBook.setBounds(10, 10, 100, 21);
		jtBrrowedNumOfBook.setBounds(100, 10, 200, 21);
		panel_brrowed.add(jlBrrowedNumOfBook);
		panel_brrowed.add(jtBrrowedNumOfBook);		
		

		
		jlNumOfReader = new JLabel("读者注册数目:");
		panel_reader = new JPanel();

		
		String s=Integer.toString(rdi.findAll().size());
		jtNumOfReader = new JLabel(s);
		panel_reader.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		panel_brrowed.setLayout(flowLayout);	
		jlNumOfReader.setBounds(10, 10, 100, 21);
		jtNumOfReader.setBounds(100, 10, 200, 21);
		panel_reader.add(jlNumOfReader);
		panel_reader.add(jtNumOfReader);	
		
		
		jlLatestDate = new JLabel("最近日期:");
		panel_date = new JPanel();
		Date date = rsi.theLastBorrow() ;
		
		jtLatestDate = new JLabel(new SimpleDateFormat("yyyy-MM-dd").format(date));
		panel_date.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		panel_date.setLayout(flowLayout);	
		jlLatestDate.setBounds(10, 10, 100, 21);
		jtLatestDate.setBounds(100, 10, 200, 21);
		panel_date.add(jlLatestDate);
		panel_date.add(jtLatestDate);		
		
		JPanel panel_1=new JPanel();
		JPanel panel_2=new JPanel();
		
		//panel_1.setLayout(borderlayout);
		//panel_2.setLayout(borderlayout);
		
		panel_1.add(panel_rest);
		panel_1.add(panel_brrowed);

		
		
		panel_2.add(panel_reader);
		panel_2.add(panel_date);
		
		//panel_1.add(buttonRefresh);
		
		add(panel_1, BorderLayout.NORTH);
		add(panel_2, BorderLayout.CENTER);
		
		
		
		//getContentPane().add(panel_date,BorderLayout.EAST);
		//getContentPane().add(panel_brrowed, BorderLayout.WEST);
		add(buttonRefresh,BorderLayout.SOUTH);
		

		
		jlLatestDate = new JLabel("最近一次借书日期:");
		

		
		
		setSize(600, 200);		
		setVisible(true);
	}
	public static void main(String args[]){
		new CountingView();
	}

	class addBookActionListener implements ActionListener { // 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			jtRestNumOfBook.setText("");
			jtBrrowedNumOfBook.setText("");
			jtNumOfReader.setText("");
			jtLatestDate.setText("");
			
			ArrayList<Reader> readerList=rdi.findAll();
			int sum = 0;
			for(Reader r:readerList){
				sum+=r.getAmount();
			}
			
			Date date = rsi.theLastBorrow() ;
			
			
			jtRestNumOfBook.setText(Integer.toString(bsi.bookNumber()));
			jtBrrowedNumOfBook.setText(Integer.toString(sum));
			jtNumOfReader.setText(Integer.toString(rdi.findAll().size()));
			jtLatestDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
			
		}
	}
	


}
