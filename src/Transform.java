public class Transform {
    TransformType type;
    int startPoint;
    int endPoint;

    public Transform(TransformType type, int startPoint, int endPoint) {
        this.type = type;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }
}
