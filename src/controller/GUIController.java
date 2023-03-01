package controller;

import javax.swing.JOptionPane;

public class GUIController {

	public static void makeGUI() {
		int option = 0;
		
		ProcessController pCont = new ProcessController();
		
		do {
			option = GUIController.showOptions();
			
			switch (option) {
				case 1:
					pCont.listProcess();
				break;
				case 2:
					try {
						int pid = Integer.parseInt(JOptionPane.showInputDialog("Qual o número do PID?"));
						pCont.killByPid(pid);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				break;
				
				case 3:
					String nome = JOptionPane.showInputDialog("Qual o nome do processo?");
					pCont.killByName(nome);
				break;
				
				case 9:
					System.exit(0);
				break;
				
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida");
			}
			
		} while(option != 9);
	}
	
	public static int showOptions() {
		
		int optionNumber = 0;
		
		String option = JOptionPane.showInputDialog(null, "Sistema operacional: " +System.getProperty("os.name") +"\nMenu de opções\n 1 - Listar processos \n 2 - Matar processo por PID \n 3 - Matar processo por nome\n 9 - Sair", "ProcessManager", JOptionPane.QUESTION_MESSAGE);
		
		if (option == null) {
			System.exit(0);
		}
		
		try {
			optionNumber = Integer.parseInt(option);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Número inválido");
		}
		
		return optionNumber;
	}
	
}
