package model.interfaces;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    OnlinePaymentService onlinePaymentService;

    public ContractService() {}

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        for (Integer i = 1; i <= months; i++) {
            // Adiciona-se 1 mês a data
            LocalDate dateToInsert = contract.getDate().plusMonths(i);

            // Divido o valor total pela quantidade de meses e calculo o juro
            Double interest = onlinePaymentService.interest((contract.getTotalValue() / months), i);

            // Calculo a taxa de pagemento
            Double amount = onlinePaymentService.paymentFee(interest);

            // Crio uma nova parcela
            contract.addInstallment(new Installment(dateToInsert, amount));
        }
    }
}