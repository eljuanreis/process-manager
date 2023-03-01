package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessController {
	
	static String soWindowLabel = "windows";
	static String soLinuxLabel = "linux";
	
	private String getOS() {
		return System.getProperty("os.name");
	}
	
	public void listProcess() {
		String so = this.getOS().toLowerCase();
		
		try {
			if (so.contains(soWindowLabel)) {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();

				while (linha != null) {
					System.out.println(linha);
					
					linha = buffer.readLine();
				}
			}
			
			if (so.contains(soLinuxLabel)) {
				Process p = Runtime.getRuntime().exec("ps -ef");
				
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();

				while (linha != null) {
					System.out.println(linha);
					
					linha = buffer.readLine();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void killByPid(int pid) {
		String so = this.getOS().toLowerCase();

		try {
			if (so.contains(soWindowLabel)) {
				Runtime.getRuntime().exec("TASKKILL /PID " + pid);
			}
			
			if (so.contains(soLinuxLabel)) {
				Runtime.getRuntime().exec("kill -9 " + pid);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void killByName(String ProcessName) {
		String so = this.getOS().toLowerCase();

		try {
			if (so.contains(soWindowLabel)) {
				Runtime.getRuntime().exec("TASKKILL /IM " + ProcessName);
			}
			
			if (so.contains(soLinuxLabel)) {
				Runtime.getRuntime().exec("pkill -f " + ProcessName);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
