package view;

import java.util.Scanner;

import controller.TaskController;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		TaskController tc = new TaskController();
		String so = tc.so();
		
		int option;
		
		do {
			System.out.println("1 - Processos\n"
							+"2 - Matar por PID\n"
							+"3 - Matar por Nome\n"
							+"0 - Sair");
			option = in.nextInt();
			
			if(option==1) {
				tc.process(so);
			}else if(option==2) {
				System.out.println("Digite o PID:");
				tc.killPid(so, in.nextInt());
			}else if(option==3) {
				System.out.println("Digite o Nome do Processo:");
				tc.killName(so, in.next());
			}
			
		}while(option!=0);
	}

}
