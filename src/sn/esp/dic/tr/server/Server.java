package sn.esp.dic.tr.server;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Server {

	public static void main(String[] args) {
		int PORT = 8585;
	    byte[] buf = new byte[1000];
	    DatagramPacket dgp = new DatagramPacket(buf, buf.length);
	    DatagramSocket sk;

	    try {
			sk = new DatagramSocket(PORT);
			System.out.println("Server started");
	    while (true) {
	      sk.receive(dgp);
	      String text = new String(dgp.getData(), 0, dgp.getLength());
	      String rcvd =  text+ ", from address: "
	          + dgp.getAddress() + ", port: " + dgp.getPort();
	      System.out.println(rcvd);
	      Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
	      StringSelection testData = new StringSelection(text);
	      c.setContents(testData, testData);

	     
	    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

	}

}
