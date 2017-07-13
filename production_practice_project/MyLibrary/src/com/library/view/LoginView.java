package com.library.view;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.library.dao.ReaderDaoImpl;
import com.library.model.Reader;
  
 
public class LoginView extends JFrame  
{  
	ReaderDaoImpl rs=new ReaderDaoImpl();
	
    private static final long serialVersionUID = -3374450823823567437L;  
  
   
    private static final JLabel usernameLabel = new JLabel("用户名");  
    private static final JTextField usernameInput = new JTextField();  
      
   
    private static final JLabel passwordLabel = new JLabel("密码");  
    private static final JTextField passwordInput = new JPasswordField();  
      
    
    private static final JButton loginButton = new JButton("确定");  
    private static final JButton exitButton = new JButton("退出");  
    
    
    private static final Checkbox usingAdmin = new Checkbox("Administrator",false);
    
    
    
    
     public LoginView()  
    {  
        setSize(new Dimension(380, 180));  
        setTitle("登录系统");  
        setLayout(null);  
          
        //初始化  
        initUI();  
          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
          
        //登陆按钮监听
        loginButton.addActionListener(new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)  
            {  
                String userName = usernameInput.getText().trim(); 
                String password = passwordInput.getText().trim();              
                //若没有输入
                if (userName.equals(""))  
                {  
                    JOptionPane.showMessageDialog(LoginView.this, "请输入用户名！");  
                    return;  
                }  //若管理员选项为真
                else if(usingAdmin.getState()){
                	if(userName.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")){
                		dispose();
                		new Test();		
                	}else{//若输入信息错误
                        JOptionPane.showMessageDialog(null,"管理员输入信息错误","登录系统ʾ",JOptionPane.ERROR_MESSAGE);
                        usernameInput.setText("");
                        passwordInput.setText("");
                	}
                	
                	
                }else{
                	//若能找到该读者名
                	if(rs.findByUserid(userName)!=null){
                		Reader entiy;
                		entiy=rs.findByUserid(userName);
                		if(password.equalsIgnoreCase(entiy.getPassword())){
                			//显示读者界面
                			
                			new FrmReaderFeature(); 
                			dispose();
                		}else{//若输入失败
                			JOptionPane.showMessageDialog(null,"密码输入错误","登录系统",JOptionPane.ERROR_MESSAGE);
                              passwordInput.setText("");
                		}
                	}else{//若输入
                		JOptionPane.showMessageDialog(null,"没有该读者信息！","登录系统",JOptionPane.ERROR_MESSAGE);
                		usernameInput.setText("");
                	}
                	
                }
                  

            }  
        });  
          
          
        exitButton.addActionListener(new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)  
            {  
                System.exit(0);  
            }  
        });  
    }  
  

    private void initUI()  
    {  
        // TODO Auto-generated method stub  
        usernameLabel.setBounds(10, 10, 100, 21);  
        usernameInput.setBounds(150, 10, 200, 21);  
        passwordLabel.setBounds(10, 40, 100, 21);  
        passwordInput.setBounds(150, 40, 200, 21);  
        loginButton.setBounds(190, 100, 60, 21);  
        exitButton.setBounds(290, 100, 60, 21);  
        usingAdmin.setBounds(50, 100, 100, 33);
        this.setLocationRelativeTo(null);


        add(usernameLabel);  
        add(usernameInput);  
        add(passwordLabel);  
        add(passwordInput);  
        add(loginButton);  
        add(exitButton);  
        this.add(usingAdmin);

    }  
    static void showFrame() {  
        JFrame frame = new JFrame("图书管理系统"); 
        frame.setSize(300, 200); 
        frame.setVisible(true); //
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }  
      
    public static void main(String[] args)  
    {  
        new LoginView();  
    }  
}  
