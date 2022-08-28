package chapter6;

public class Month {

  //  public static void main(String args[]){
        public static String getMonth(int month){
            switch (month){
                case 1: return "Jan";
                case 2: return "Feb";
                case 3: return "Mar";
                case 4: return "Apr";
                case 5: return "Mai";
                case 6: return "Jun";
                case 7: return "Jul";
                case 8: return "Aug";
                case 9: return "Sep";
                case 10: return "Okt";
                case 11: return "Nov";
                case 12: return "Des";
                default: return "Invalid month. Please enter a value between 1 and 12";
            }
            }
            public static int getMonth(String month){
                switch (month){
                    case "Jan": return 1;
                    case "Feb": return 2;
                    case "Mar": return 3;
                    case "Apr": return 4;
                    case "Mai": return 5;
                    case "Jun": return 6;
                    case "Jul": return 7;
                    case "Aug": return 8;
                    case "Sep": return 9;
                    case "Okt": return 10;
                    case "Nov": return 11;
                    case "Des": return 12;
                    default: return -1;
                }
                }
}
