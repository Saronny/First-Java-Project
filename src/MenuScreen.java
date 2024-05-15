public class MenuScreen {
    public void showMenu() {
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
    }

    public void selectOption() {
        Calculator calc = new Calculator();
        showMenu();
        System.out.print("Enter your choice: ");
        String choice = System.console().readLine();
        int num1 = 0;
        int num2 = 0;
        if (filterNumber(choice) == 5) {
            System.out.println("Exiting...");
            return;
        }
        if (filterNumber(choice) < 1 || filterNumber(choice) > 5) {
            System.out.println("Invalid choice");
            return;
        }
        System.out.print("Enter first number: ");
        String number1 = System.console().readLine();
        num1 = filterNumber(number1);
        System.out.print("Enter second number: ");
        String number2 = System.console().readLine();
        num2 = filterNumber(number2);
        switch (filterNumber(choice)) {
            case 1:
                System.out.println("Result: " + calc.add(num1, num2));
                break;
            case 2:
                System.out.println("Result: " + calc.sub(num1, num2));
                break;
            case 3:
                System.out.println("Result: " + calc.mul(num1, num2));
                break;
            case 4:
                System.out.println("Result: " + calc.div(num1, num2));
                break;
            default:
                break;
        }
    }

    public void run() {
        if (System.console() == null) {
            System.out.println("No console available");
            return;
        }
        selectOption();
    }

    public int filterNumber(String number)
    {
        int num = 0;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
            selectOption();
        }
        return num;
    }
}
