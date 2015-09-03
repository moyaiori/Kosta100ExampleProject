package kr.or.kosta.objectstream;

import java.net.*;

/**
 * 객체(Object) 단위의 네트워크 입출력
 * @author 김기정
 */
public class ObjectStreamServer{
   
   public static void main(String[] args){
    boolean stop = false;  
   	int port = 5400;
   	ServerSocket serverSocket = null;
   	
   	Socket clientSocket = null;
   	EchoThread echoT = null;
 
   	System.out.println("Server Start!!!");
   	
   	try{
   		serverSocket = new ServerSocket(port);
   		
		while(!stop){
   			clientSocket = serverSocket.accept();
   			System.out.println("["+clientSocket.getInetAddress() + "] Connected...");
			System.out.println("================================================");
   			
   			echoT = new EchoThread(clientSocket);
   			echoT.start();
   		}
   	}
   	catch (Exception ex){
   		ex.printStackTrace();
   	}
   }
}




