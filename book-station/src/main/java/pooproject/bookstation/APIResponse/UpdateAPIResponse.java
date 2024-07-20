package pooproject.bookstation.APIResponse;

public class UpdateAPIResponse {
    private String message;
    private String id;

    public UpdateAPIResponse(String message,  String data) {
        this.message = message;
        this.id = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return id;
    }

    public void setData(String data) {
        this.id = data;
    }
}
