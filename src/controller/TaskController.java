package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskController {
	
	public String so() {
		return System.getProperty("os.name");
	}
	
	public void process(String so) {
		try {
			String command = "TASKLIST /FO TABLE";
			Process process = Runtime.getRuntime().exec(command);
			InputStream fluxo = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			
			while(linha!=null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void kill(String command) {
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void killPid(String so, int pid) {
		String command;
		if(so.equals("Windows 10")) {
			command = "TASKKILL /PID "+pid;
			kill(command);
		}else {
			command = "kill -9 "+pid;
			kill(command);
		}
	}
	
	public void killName(String so, String name) {
		String command;
		if(so.equals("Windows 10")) {
			command = "TASKKILL /IM "+name;
			kill(command);
		}else {
			command = "pkill -f "+name;
			kill(command);
		}
	}
	
}
