package seedu.address.model.person;

/**
 * Supported workout exercise categories for plan entries.
 */
public enum PlanCategoryEnum {
    PUSH,
    PULL,
    LEGS,
    CORE,
    CARDIO,
    MOBILITY,
    FULL_BODY,
    CONDITIONING,
    UNASSIGNED;

    /**
     * Returns true if the raw category maps to a valid enum constant.
     */
    public static boolean isKnownCategory(String rawCategory) {
        String normalized = normalize(rawCategory);
        for (PlanCategoryEnum category : PlanCategoryEnum.values()) {
            if (category.name().equals(normalized)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Parses a category in a case-insensitive manner.
     */
    public static PlanCategoryEnum fromString(String rawCategory) {
        String normalized = normalize(rawCategory);
        if (UNASSIGNED.name().equals(normalized)) {
            return UNASSIGNED;
        }
        return PlanCategoryEnum.valueOf(normalized);
    }

    private static String normalize(String rawCategory) {
        return rawCategory.trim()
                .replaceAll("[\\s_-]+", "_")
                .toUpperCase();
    }
}



