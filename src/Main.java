import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while(true){
            System.out.print("Digite o CPF: ");
            String cpfInformado = teclado.nextLine();
            if (cpfCorreto(cpfInformado)) {
                System.out.println("CPF válido");
                break;
            }
            else {
                System.out.println("CPF inválido");
            }
        }
    }
    public static boolean cpfCorreto(String cpf) {
        if (cpf.length() != 14 || cpf.charAt(3) != '.' || cpf.charAt(7) != '.' || cpf.charAt(11) != '-') {
            return false;
        }
        int[] num = new int[11];
        int[] posicao = {0,1,2,4,5,6,8,9,10,12,13};
        for (int i = 0; i < 11; i++) {
            char c = cpf.charAt(posicao[i]);
            if (!Character.isDigit(c))
                return false;
            num[i] = c - '0';
        }

        int soma = 0;
        int peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += num[i] * peso;
            peso--;
        }
        int resto = (soma * 10) % 11;
        if (resto == 10) resto = 0;

        if (resto != num[9]) return false;
        int soma2 = 0;
        int peso2 = 11;
        for (int i = 0; i < 10; i++) {
            soma2 += num[i] * peso2;
            peso2--;
        }
        int resto2 = (soma2 * 10) % 11;
        if (resto2 == 10) resto2 = 0;

        if (resto2 != num[10]) return false;
        return true;
    }
}