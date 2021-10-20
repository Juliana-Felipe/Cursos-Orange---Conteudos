package br.com.alura.springdata;


import br.com.alura.springdata.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadesTrabalhoervice unidadesTrabalhoervice;
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamicoService relatorioFuncionarioDinamicoService;

	private boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadesTrabalhoervice unidadesTrabalhoervice, RelatoriosService relatoriosService, RelatorioFuncionarioDinamicoService relatorioFuncionarioDinamicoService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadesTrabalhoervice = unidadesTrabalhoervice;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamicoService = relatorioFuncionarioDinamicoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("qual a ação você quer?");
			System.out.println("0-sair");
			System.out.println("1-Cargos");
			System.out.println("2-Funcionarios");
			System.out.println("3-Unidades de trabalho");
			System.out.println("4-Relatórios");
			System.out.println("5-Relatório dinâmico");
			int action = scanner.nextInt();
			switch (action){
				case 1: cargoService.inicial(scanner);
					break;
				case 2: funcionarioService.inicial(scanner);
					break;
				case 3: unidadesTrabalhoervice.inicial(scanner);
					break;
				case 4: relatoriosService.inicial(scanner);
					break;
				case 5: relatorioFuncionarioDinamicoService.inicial(scanner);
					break;
				default:
					system = false;
					break;
			}
		}
	}
}
