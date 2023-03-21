package Examples.CustomException;

public class CustomException extends Exception {
    private String additionalInfo;

    public CustomException(String message, String additionalInfo) {
        super(message);
        this.additionalInfo = additionalInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println(result);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getAdditionalInfo());
        }
    }

    public static int divide(int num, int den) throws CustomException {
        if (den == 0) {
            throw new CustomException("Cannot divide by zero!", "Try not dividing by zero");
        }
        return num / den;
    }
}