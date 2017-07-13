package com.library.main;

import com.library.view.LoadingView;
import com.library.view.LoginView;

public class main {
	public static void main(String[] args) {
		new Thread(new LoadingView()).start();
		

	}
}
