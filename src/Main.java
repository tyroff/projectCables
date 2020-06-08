

import java.util.Scanner;

import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.ui.CommandManager;

public class Main {

	public static void main(String[] args) {
		System.out.println("Введите \"menu\" и нажмите ввод.");
		try(Scanner scanner = new Scanner(System.in)) {
			Class.forName("org.postgresql.Driver");
			try(CommandManager commandManager = new CommandManager()) {
				boolean goOn = true;
				while(goOn) {
					System.out.print("=> ");
					String command = scanner.nextLine();
					goOn = commandManager.execute(command);
				}
			} catch(LogicException e) {
				System.out.println("Ошибка доступа к базе данных!");
			}
		} catch(ClassNotFoundException e) {
			System.out.println("Ошибка запуска приложения!");
		}
	}
}