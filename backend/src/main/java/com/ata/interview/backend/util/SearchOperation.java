package com.ata.interview.backend.util;

/**
 * 
 * @author dinhnn
 *
 */
public enum SearchOperation {
    EQUALITY, NEGATION, GREATER_THAN, GREATER_THAN_OR_EUQAL_TO, LESS_THAN, LESS_THAN_OR_EQUAL_TO, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS;

    public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", ">=", "<", "<=", "~" };

    public static final String OR_PREDICATE_FLAG = "'";

    public static final String ZERO_OR_MORE_REGEX = "*";

    public static final String OR_OPERATOR = "OR";

    public static final String AND_OPERATOR = "AND";

    public static final String LEFT_PARANTHESIS = "(";

    public static final String RIGHT_PARANTHESIS = ")";

    public static SearchOperation getSimpleOperation(final String str) {
        switch (str) {
        case ":":
            return EQUALITY;
        case "!":
            return NEGATION;
        case ">":
            return GREATER_THAN;
        case ">=":
            return GREATER_THAN_OR_EUQAL_TO;
        case "<":
            return LESS_THAN;
        case "<=":
            return LESS_THAN_OR_EQUAL_TO;
        case "~":
            return LIKE;
        default:
            return null;
        }
    }
}
