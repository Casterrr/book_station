package pooproject.bookstation.APIResponse;

public class UpdateAPIResponse {
    private String message;
    private String data;

    public UpdateAPIResponse(String message,  String data) {
        this.message = message;
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
