package br.com.alura.springdata.service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private FuncionarioRepository funcionarioRepository;
    boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação desejo executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionario por nome");
            System.out.println("2 - Busca funcionario por nome, salario maior e data de contratacao");
            System.out.println("3 - Busca funcionario por maior data de contratacao");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                case 2:
                    buscaNomeSalarioMaiorDataContratacao(scanner);
                    break;
                case 3:
                    buscaMaiorDataContratacao(scanner);
                    break;
                default:
                    system = false;
                    break;

            }
        }
    }

    private void buscaFuncionarioNome(Scanner scanner) {
        System.out.println("Informe o nome:");
        String nome = scanner.next();
        List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
        funcionarios.forEach(System.out::println);
    }
    private void buscaNomeSalarioMaiorDataContratacao(Scanner scanner){
        System.out.println("Informe o nome:");
        String nome = scanner.next();
        System.out.println("Informe o salario:");
        Double salario = scanner.nextDouble();
        System.out.println("Informe a data de contratacao:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data,formatter);

        List<Funcionario> funcionarios = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome,salario,localDate);
        funcionarios.forEach(System.out::println);
    }
    private void buscaMaiorDataContratacao(Scanner scanner) {
        System.out.println("Informe a data:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> funcionarios = funcionarioRepository.findMaiorDataContratacao(localDate);
        funcionarios.forEach(System.out::println);
    }

}

