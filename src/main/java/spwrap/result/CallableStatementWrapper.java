package spwrap.result;

import spwrap.CallException;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;

final class CallableStatementWrapper extends Result<CallableStatement> {

	private int outSIndex;

	CallableStatementWrapper(CallableStatement cstmt, int outParamStartIndex) {
		super(cstmt);
		this.outSIndex = outParamStartIndex;
	}

	@Override
	public String getString(int columnIndex) {
		try {
			return wrappedObject.getString(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public boolean getBoolean(int columnIndex) {
		try {
			return wrappedObject.getBoolean(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public byte getByte(int columnIndex) {
		try {
			return wrappedObject.getByte(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public short getShort(int columnIndex) {
		try {
			return wrappedObject.getShort(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public int getInt(int columnIndex) {
		try {
			return wrappedObject.getInt(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public long getLong(int columnIndex) {
		try {
			return wrappedObject.getLong(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public float getFloat(int columnIndex) {
		try {
			return wrappedObject.getFloat(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public double getDouble(int columnIndex) {
		try {
			return wrappedObject.getDouble(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public byte[] getBytes(int columnIndex) {
		try {
			return wrappedObject.getBytes(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Date getDate(int columnIndex) {
		try {
			return wrappedObject.getDate(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Time getTime(int columnIndex) {
		try {
			return wrappedObject.getTime(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) {
		try {
			return wrappedObject.getTimestamp(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Object getObject(int columnIndex) {
		try {
			return wrappedObject.getObject(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) {
		try {
			return wrappedObject.getBigDecimal(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Ref getRef(int columnIndex) {
		try {
			return wrappedObject.getRef(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Blob getBlob(int columnIndex) {
		try {
			return wrappedObject.getBlob(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Clob getClob(int columnIndex) {
		try {
			return wrappedObject.getClob(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Array getArray(int columnIndex) {
		try {
			return wrappedObject.getArray(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public URL getURL(int columnIndex) {
		try {
			return wrappedObject.getURL(outSIndex + columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public String getString(String parameterName) {
		try {
			return wrappedObject.getString(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public boolean getBoolean(String parameterName) {
		try {
			return wrappedObject.getBoolean(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public byte getByte(String parameterName) {
		try {
			return wrappedObject.getByte(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public short getShort(String parameterName) {
		try {
			return wrappedObject.getShort(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public int getInt(String parameterName) {
		try {
			return wrappedObject.getInt(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public long getLong(String parameterName) {
		try {
			return wrappedObject.getLong(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public float getFloat(String parameterName) {
		try {
			return wrappedObject.getFloat(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public double getDouble(String parameterName) {
		try {
			return wrappedObject.getDouble(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public byte[] getBytes(String parameterName) {
		try {
			return wrappedObject.getBytes(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Date getDate(String parameterName) {
		try {
			return wrappedObject.getDate(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Time getTime(String parameterName) {
		try {
			return wrappedObject.getTime(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Timestamp getTimestamp(String parameterName) {
		try {
			return wrappedObject.getTimestamp(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Object getObject(String parameterName) {
		try {
			return wrappedObject.getObject(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public BigDecimal getBigDecimal(String parameterName) {
		try {
			return wrappedObject.getBigDecimal(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Ref getRef(String parameterName) {
		try {
			return wrappedObject.getRef(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Blob getBlob(String parameterName) {
		try {
			return wrappedObject.getBlob(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Clob getClob(String parameterName) {
		try {
			return wrappedObject.getClob(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Array getArray(String parameterName) {
		try {
			return wrappedObject.getArray(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public URL getURL(String parameterName) {
		try {
			return wrappedObject.getURL(parameterName);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}
}
