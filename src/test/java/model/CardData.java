package model;

public class CardData {
        String cardNumber;
        String expiryData;
        String cvc;

        public CardData(String cardNumber, String expiryData, String cvc) {
            this.cardNumber = cardNumber;
            this.expiryData = expiryData;
            this.cvc = cvc;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public void setExpiryData(String expiryData) {
            this.expiryData = expiryData;
        }

        public void setCvc(String cvc) {
            this.cvc = cvc;
        }

        public String getCardNumber() {
            return this.cardNumber;
        }

        public String getExpiryData() {
            return this.expiryData;
        }

        public String getCvc() {
            return this.cvc;
        }
}