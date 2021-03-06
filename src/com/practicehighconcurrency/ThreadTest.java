/**  
 * FileName:     
 * @Description: 
 * Company       rongji
 * @version      1.0
 * @author:      Eg 
 * @version:     1.0
 * Createdate:   2018年3月19日 下午3:52:59  
 *  
 */  

package com.practicehighconcurrency;

/**  
 * Description:   
 * Copyright:   Copyright (c)2017 
 * Company:     
 * @author:     Eg  
 * @version:    1.0  
 * Create at:   2018年3月19日 下午3:52:59  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2018年3月19日      Eg          1.0         1.0 Version  
 */

public class ThreadTest {
	
	
	private int count=0;
	private void add() {
		for(int i=0;i<10000;i++) {
			count++;
		}
	}
	
	public static int calc() throws InterruptedException {
		ThreadTest test=new ThreadTest();
		Thread t1=new Thread() {
			@Override
			public void run() {
				test.add();
			}
		};
		
		Thread t2=new Thread() {
			@Override
			public void run() {
				test.add();
			}
		};
		
		
		//启动线程
		t1.start();
		t2.start();
		
		//等待两个线程执行结束
		t1.join();
		t2.join();
		
		return test.count;
		
	}
	
	
	public static void main(String[] args) throws InterruptedException  {
		int c=calc();
		System.out.println(c);
	}

}
