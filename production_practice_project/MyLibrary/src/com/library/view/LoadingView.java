package com.library.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class LoadingView extends JWindow implements Runnable  {
    /**
	 * 
	 */
	private static LoadingView loadingview;
	
	public static LoadingView instance() {
		if (loadingview == null)
			loadingview = new LoadingView();
		return loadingview;
	}
	
	private static final long serialVersionUID = -5835557380233128776L;
	Thread splashThread; // ����������߳�  
    JProgressBar progress; // �����  
  
    public LoadingView() {  
        Container container = getContentPane(); // �õ�����  
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); //  ���ù�� 
        URL url = getClass().getResource("LibraryImagine.png"); //  ͼƬ��λ��  
        if (url != null) {  
            container.add(new JLabel(new ImageIcon(url)), BorderLayout.CENTER); // 增加图片  
        }  
        progress = new JProgressBar(1, 100); // ʵ������   
        progress.setStringPainted(true); // �������   
        progress.setString("图书馆管理系统登录中....."); // ������ʾ����  
        progress.setBackground(Color.white); // ���ñ���ɫ
        container.add(progress, BorderLayout.SOUTH); // ���ӽ������������ 
  
        Dimension screen = getToolkit().getScreenSize(); //�õ���Ļ�ߴ篸  
        pack(); // ������Ӧ����ߴ� ��  
        setLocation((screen.width - getSize().width) / 2,  
                (screen.height - getSize().height) / 2); // ���ô���λ��   
    }  
  
    public void start() {  
        this.toFront(); // ����ǰ����ʾ
        splashThread = new Thread(this); //  ʵ���߳� 
        splashThread.start(); // ��ʼ�����߳�   
    }  
  
    public void run() {  
    	instance();
        setVisible(true); //��ʾ����
        try {  
            for (int i = 0; i < 100; i++) {  
                Thread.sleep(30); // �߳����� 
                progress.setValue(progress.getValue() + 1); // ��ʼ�����߳�  
            }  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
        dispose(); // �ͷŴ���
        LoginView login=new LoginView(); 
    }  
  
    static void showFrame() {  
        JFrame frame = new JFrame("图书馆管理系统"); //ʵ��JFrame����  
        frame.setSize(300, 200); // ���ô�����ʾ  
        frame.setVisible(true); //��ʾ���گ视  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �رմ���ʱ�˳����� 
    }  
  

}  
