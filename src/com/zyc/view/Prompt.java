package com.zyc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prompt {

	private JFrame frame;
	private String error;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prompt window = new Prompt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prompt() {
		initialize();
	}
	
	/**
	 * @param error
	 */
	public Prompt(String error) {
		super();
		this.error = error;
		System.out.println(this.error);
		initialize();
	}
	public void show(){
		final String error1 = this.error;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prompt window = new Prompt(error1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("提示");
		frame.setBounds(100, 100, 315, 198);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(this.error);
		lblNewLabel.setBounds(21, 21, 247, 72);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(98, 116, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
