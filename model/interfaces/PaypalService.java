package model.interfaces;

public class PaypalService implements OnlinePaymentService{
    @Override
    public Double interest(Double amount, Integer months) {
        return amount + (amount * 0.02) * months;
    }

    @Override
    public Double paymentFee(Double amount) {
        return amount + (amount * 0.02);
    }
}