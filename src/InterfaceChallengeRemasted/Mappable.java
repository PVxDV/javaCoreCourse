package InterfaceChallengeRemasted;

enum Geometry {LINE, POINT, POLYGON}

enum Color {BLACK, BLUE, GREEN, ORANGE, RED}

enum PointMarker {CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE}

enum LineMarker {DASHED, DOTTED, SOLID}

public interface Mappable {
    String JSON_PROPERTY = """
            "properties": {%s} """;

    String getLabel(); // should return a label (how the item will be described on the map)
    Geometry getShape(); //should return a geometry type(POINT or LINE) which is what the type will look like
    String getMarker(); // should return an icon type (sometimes called a map marker)

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """.formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
