import java.util.*;

public class RoomPricing {
    private static final Map<Integer, Double> BASE = new HashMap<>();
    static {
        BASE.put(LegacyRoomTypes.SINGLE, 14000.0);
        BASE.put(LegacyRoomTypes.DOUBLE, 15000.0);
        BASE.put(LegacyRoomTypes.TRIPLE, 12000.0);
        BASE.put(LegacyRoomTypes.DELUXE, 16000.0);
    }

    public static Money baseFor(int roomType) {
        return new Money(BASE.getOrDefault(roomType, 16000.0));
    }
}
