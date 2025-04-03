package cz.slothbytes;

public class Main {
    public static void main(String[] args) {
        Decryptor decryptor = new Decryptor();

        System.out.println(decryptor.spaceMessage("ABCD"));
        System.out.println(decryptor.spaceMessage("AB[3CD]"));
        System.out.println(decryptor.spaceMessage("IF[2E]LG[5O]D"));
    }
}
