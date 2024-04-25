package application;

import model.entities.Contract;
import model.interfaces.ContractService;
import model.interfaces.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entre com os dados do contrato:");
        System.out.print("Numero: ");
        Integer numero = ler.nextInt(); ler.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dt2 = LocalDate.parse(ler.nextLine(), formato);
        System.out.print("Valor do contrato: ");
        Double valorTotal = ler.nextDouble(); ler.nextLine();
        System.out.print("Entre com o numero de parcelas: ");
        Integer parcelas = ler.nextInt(); ler.nextLine();
        Contract ct = new Contract(numero, dt2, valorTotal);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(ct, parcelas);
        System.out.println("\nParcelas: ");
        System.out.print(ct);
    }
}