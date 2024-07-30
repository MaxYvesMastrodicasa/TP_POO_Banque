import java.util.Date;

public class Transaction {
        private String type;
        private double montant;
        private Date date;
        private String description;

        public Transaction(String type, double montant, Date date, String description) {
            this.type = type;
            this.montant = montant;
            this.date = date;
            this.description = description;
        }

        public String getType() {return type;}
        public double getMontant() {return montant;}
        public Date getDate() {return date;}
        public String getDescription() {return description;}

    @Override
    public String toString() {
        return "Transaction { " +
                "type = " + type +
                ", montant = " + montant +
                ", date = " + date +
                ", description = '" + description + '\'' +
                " }";
    }
}
