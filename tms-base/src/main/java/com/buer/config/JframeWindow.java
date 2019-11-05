package com.buer.config;

import com.buer.autoRun.CodeGenerator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;


public class JframeWindow {
	public static void newWindow() {
		JFrame f = new JFrame();
		f.setTitle("示例");
		f.setSize(500,410);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(3);
		FlowLayout lay = new FlowLayout(FlowLayout.CENTER);
		f.setLayout(lay);
		setJLabel(f, "标题");
		
		setJLabel(f, "路径:",60,20);
		final JTextField windowUrl = setTextField(f,35,20,Catalogautocreate.windowUrl);
		setJLabel(f, "包名:",60,20);
		final JTextField packageUrl = setTextField(f,35,20,Catalogautocreate.PACKAGENAME);
//		setJLabel(f, "模块名:",60,20);
//		final JTextField mk = setTextField(f,35,20,Catalogautocreate.MK);
		setJLabel(f, "作者:",60,20);
		final JTextField author = setTextField(f,35,20,Catalogautocreate.AUTHOR);
		setJLabel(f, "表名:",60,20);
		final JTextArea gnEnName = setTextArea(f,380,50,Catalogautocreate.TABLENAMES);
		setJLabel(f, "TIP:",60,20);
		final JTextArea tip = setTextArea(f,380,100,"待执行");
		JButton bu = new JButton("确定");
		setJLabel(f, "请勿重复点击按钮",200,20);
		bu.setPreferredSize(new Dimension(80,30));
		bu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent newE) {
				Catalogautocreate.windowUrl = windowUrl.getText().replaceAll("\\\\","/");
				Catalogautocreate.PACKAGENAME = packageUrl.getText().replaceAll("\\\\","/");
				Catalogautocreate.TABLENAMES = gnEnName.getText();
				Catalogautocreate.AUTHOR = author.getText();
//				Catalogautocreate.MK = mk.getText();

				System.out.println("==============开始执行写入文件============");
				try {

					new CodeGenerator().execute();
					tip.setText("执行成功."+new Date().toLocaleString());
					tip.setBackground(Color.cyan);
				} catch (Exception e){
					e.printStackTrace();
					tip.setText("执行失败."+new Date().toLocaleString()+e.getLocalizedMessage());
					tip.setBackground(Color.LIGHT_GRAY);
				}

			}
		});
		f.add(bu);

		f.setVisible(true);
	}
	/**
	 * 添加标题
	 * @param f
	 * @param name
	 */
	private static void setJLabel(final JFrame f,final String name){
		JLabel name2 = new JLabel(name,SwingConstants.CENTER);
		name2.setPreferredSize(new Dimension(500,30));
		f.add(name2);
	}
	
	/**
	 * 添加文字
	 * @param f
	 * @param name
	 */
	private static void setJLabel(final JFrame f,final String name,final int c, final int k){
		JLabel name2 = new JLabel(name);
		name2.setPreferredSize(new Dimension(c,k));
		f.add(name2);
	}
	/**
	 * 添加文本域
	 * @param f
	 * @return
	 */
	private static JTextField setTextField(final JFrame f,final int zd,final int hi,final String mrz){
		JTextField text2 = new JTextField(mrz,zd);
		JTextArea jTextArea = new JTextArea();
		text2.setPreferredSize(new Dimension(zd, hi));
		f.add(text2);
		return text2;
	}
	/**
	 * 添加文本域
	 * @param f
	 * @return
	 */
	private static JTextArea setTextArea(final JFrame f,final int zd,final int hi,final String mrz){
		JTextArea jTextArea = new JTextArea(mrz);
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		jTextArea.setPreferredSize(new Dimension(zd, hi));
		f.add(jTextArea);
		return jTextArea;
	}
}
