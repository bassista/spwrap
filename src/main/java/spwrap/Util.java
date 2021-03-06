package spwrap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

    private static final int NUM_OF_STATUS_FIELDS = 2;
    private static Logger log = LoggerFactory.getLogger(Util.class);
    // from java.sql.Types
    private static Map<Integer, String> TYPES_STRING_MAP = new HashMap<Integer, String>();

    static {
        TYPES_STRING_MAP.put(-7, "BIT");
        TYPES_STRING_MAP.put(-6, "TINYINT");
        TYPES_STRING_MAP.put(5, "SMALLINT");
        TYPES_STRING_MAP.put(4, "INTEGER");
        TYPES_STRING_MAP.put(-5, "BIGINT");
        TYPES_STRING_MAP.put(6, "FLOAT");
        TYPES_STRING_MAP.put(7, "REAL");
        TYPES_STRING_MAP.put(8, "DOUBLE");
        TYPES_STRING_MAP.put(2, "NUMERIC");
        TYPES_STRING_MAP.put(3, "DECIMAL");
        TYPES_STRING_MAP.put(1, "CHAR");
        TYPES_STRING_MAP.put(12, "VARCHAR");
        TYPES_STRING_MAP.put(-1, "LONGVARCHAR");
        TYPES_STRING_MAP.put(91, "DATE");
        TYPES_STRING_MAP.put(92, "TIME");
        TYPES_STRING_MAP.put(93, "TIMESTAMP");
        TYPES_STRING_MAP.put(-2, "BINARY");
        TYPES_STRING_MAP.put(-3, "VARBINARY");
        TYPES_STRING_MAP.put(-4, "LONGVARBINARY");
        TYPES_STRING_MAP.put(0, "NULL");
        TYPES_STRING_MAP.put(1111, "OTHER");
        TYPES_STRING_MAP.put(2000, "JAVA_OBJECT");
        TYPES_STRING_MAP.put(2001, "DISTINCT");
        TYPES_STRING_MAP.put(2002, "STRUCT ");
        TYPES_STRING_MAP.put(2003, "ARRAY");
        TYPES_STRING_MAP.put(2004, "BLOB");
        TYPES_STRING_MAP.put(2005, "CLOB ");
        TYPES_STRING_MAP.put(2006, "REF");
        TYPES_STRING_MAP.put(70, "DATALINK");
        TYPES_STRING_MAP.put(16, "BOOLEAN");
        TYPES_STRING_MAP.put(-8, "ROWID");
        TYPES_STRING_MAP.put(-15, "NCHAR");
        TYPES_STRING_MAP.put(-9, "NVARCHAR");
        TYPES_STRING_MAP.put(-16, "LONGNVARCHAR");
        TYPES_STRING_MAP.put(2011, "NCLOB");
        TYPES_STRING_MAP.put(2009, "SQLXML");
        TYPES_STRING_MAP.put(2012, "REF_CURSOR");
        TYPES_STRING_MAP.put(2013, "TIME_WITH_TIMEZONE");
        TYPES_STRING_MAP.put(2014, "TIMESTAMP_WITH_TIMEZONE");
    }

    static String listToString(List<?> list) {
        StringBuilder ret = new StringBuilder();

        if (list != null) {
            for (Object o : list) {
                ret.append(o).append("\n");
            }
        }

        return ret.toString();
    }

    public static int length(List<?> list) {
        return list == null ? 0 : list.size();
    }

    public static int getParamsCount(Config config, List<Caller.Param> inParams, List<Caller.ParamType> outParamsTypes) {
        return (config.useStatusFields() ? NUM_OF_STATUS_FIELDS : 0) + length(inParams) + length(outParamsTypes);
    }

    public static String createCallableString(String procName, int paramsCount) {
        StringBuilder call = new StringBuilder();

        call.append("{call ").append(procName).append("(");

        for (int i = 0; i < paramsCount; i++) {
            if (i > 0) {
                call.append(", ");
            }
            call.append("?");
        }

        call.append(")}");

        return call.toString();
    }

    static void closeDBObjects(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            log.trace("Could not close ResultSet", e);
        } catch (Throwable e) {
            log.trace("Unexpected exception on closing ResultSet", e);
        }

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            log.trace("Could not close Statement", e);
        } catch (Throwable e) {
            log.trace("Unexpected exception on closing Statement", e);
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            log.error("Could not close Connection", e);
        } catch (Throwable e) {
            log.error("Unexpected exception on closing Connection", e);
        }
    }

    public static boolean isClassPresent(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }

    // this method should be used in logging only to print the type name instead of its integer value
    static String getAsString(int sqlType) {
        return TYPES_STRING_MAP.get(sqlType);
    }
}
