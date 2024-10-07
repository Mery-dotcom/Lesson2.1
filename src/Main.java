public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(15000);
        System.out.println("Остаток на счете: " + bankAccount.getAmount() + " сом.");

        while (true){
            try {
                bankAccount.withDraw(6000);
                System.out.println("Снято 6000 сом. Остаток на счете: " + bankAccount.getAmount() + " сом.");
            }catch (LimitException le) {
                double remaining = le.getRemainingAmount();
                System.out.println("Недостаточно средств для снятия 6000 сом. Снятие остатка: " + remaining + " сом.");
                try {
                    bankAccount.withDraw (remaining);
                } catch (LimitException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Остаток на счете: " + bankAccount.getAmount() + " сом.");
                break;
            }
        }
    }
}
/*a)  Написать класс проверяемого исключения LimitException, с конструктором LimitException(String message,
double remainingAmount) и методом getRemainingAmount().
b)  Написать класс BankAccount с 1 полем double amount - остаток на счете и методами getAmount() -
возвращает текущий остаток на счете, deposit(double sum) - положить деньги на счет, withDraw(int sum) - снимает указанную сумму со счета.
c)  Также метод withDraw() может сгенерировать исключение в том случае если запрашиваемая сумма на снятие больше чем остаток денег на счете.
d)  Написать Main класс где бы создавался счет клиента. Положить 15 000 сом на счет.
e)  Затем попытаться снять через бесконечный цикл, каждую итерацию по 6000 сом, при этом отлавливать исключение
LimitException и при возникновении такого исключения снимать только ту сумму, которая осталась на счете и завершать бесконечный цикл*/