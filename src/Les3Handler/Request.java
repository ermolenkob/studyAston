package Les3Handler;

public class Request {
    private String type;
    private String content;
    private int severity; // уровень серьезности: 1 - низкий, 2 - средний, 3 - высокий

    public Request(String type, String content, int severity) {
        this.type = type;
        this.content = content;
        this.severity = severity;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getSeverity() {
        return severity;
    }
}
