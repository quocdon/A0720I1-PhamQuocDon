package controllers;

public class ServiceValidate {
    private static String regex = "";
    public static boolean checkVillaId(String str){
        regex = "^SVVL-[\\d]{4}$";
        return str.matches(regex);
    }

    public static boolean checkHouseId(String str){
        regex = "^SVHO-[\\d]{4}$";
        return str.matches(regex);
    }

    public static boolean checkRoomId(String str){
        regex = "^SVRO-[\\d]{4}$";
        return str.matches(regex);
    }

    public static boolean checkServiceName(String str){
        regex = "^[A-Z][\\w\\s]{1,}$";
        return str.matches(regex);
    }

    public static boolean checkArea(String area){
        double areaNumber;
        try {
            areaNumber = Double.parseDouble(area);
            if (areaNumber > 0){
                return true;
            } else return false;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean checkPoolArea(String area){
        double areaNumber;
        try {
            areaNumber = Double.parseDouble(area);
            if (areaNumber > 30){
                return true;
            } else return false;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean checkRate(String rate){
        double rateNumber;
        try {
            rateNumber = Double.parseDouble(rate);
            if (rateNumber > 0){
                return true;
            } else return false;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean checkMaxCapacity(String capacity){
        int capacityNumber;
        try {
            capacityNumber = Integer.parseInt(capacity);
            if (capacityNumber > 0 && capacityNumber < 20){
                return true;
            } else return false;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean checkCompService(String service){
        regex = "^(Massage)|(Karaoke)|(Food)|(Drink)|(Car)$";
        return service.matches(regex);
    }
}
