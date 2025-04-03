package cz.slothbytes;

import java.util.HashMap;
import java.util.LinkedList;

public final class Decryptor {

    private LinkedList<HashMap<String, Object>> message = new LinkedList<>();

    public String spaceMessage(String encryptedMessage) {
        decryptMesageParts(encryptedMessage);
        String constructedMessage = constructMessage();
        message.clear();

        return constructedMessage;
    }

    private void decryptMesageParts(String message) {
        String currentPartString = "";
        int currentPartNumber = 0;
        boolean isEmbeded = false;

        for (Character c : message.toCharArray()) {
            if  (c == '[') {
                isEmbeded = true;
                currentPartString = "";
                currentPartNumber = 0;
            }
            else if (c == ']') {
                isEmbeded = false;
                storeMessagePart(currentPartString, currentPartNumber);
            }
            else if (Character.isDigit(c)) currentPartNumber = Integer.parseInt(currentPartString + "" + c);
            else currentPartString = currentPartString + c;

            if (!isEmbeded) {
                storeMessagePart(currentPartString, 1);
                currentPartString = "";
            }
        }
    }

    private String constructMessage() {
        String decryptedMessage = "";

        for (HashMap<String, Object> messagePart : message) {
            String currentPart = "";
            for (int i = 0; i < (int) messagePart.get("number"); i++) {
                currentPart += messagePart.get("message");
            }
            decryptedMessage += currentPart;
        }

        return decryptedMessage;
    }

    private void storeMessagePart(String messagePart, int number) {
        HashMap<String, Object> currentPart = new HashMap<>();
        currentPart.put("message", messagePart);
        currentPart.put("number", number);
        message.add(currentPart);
    }

    public Decryptor() {}
}
