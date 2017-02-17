package spwrap.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spwrap.CallException;
import spwrap.Caller.ResultSetMapper;
import spwrap.Tuple;

class ResultSetMapperBinder {

	private static Logger log = LoggerFactory.getLogger(ResultSetMapperBinder.class);

	static void overrideFromAnnotation(Method method, MetaData metadata, Class<ResultSetMapper<?>> rsMapperClass) {

		if (rsMapperClass == null) {
			return;
		}
		try {
			ResultSetMapper<?> resultSetMapper = rsMapperClass.newInstance();
			metadata.rsMapper = resultSetMapper;

			log.debug("overrideFromAnnotation:: ResultSetMapper overridden from @Mapper is: {} for method: {}",
					resultSetMapper, method.getName());
		} catch (Exception e) {
			throw new CallException("cannot create resultSet Mapper", e);
		}
	}

	static void setFromReturnType(Method method, MetaData metadata) {

		if (List.class.isAssignableFrom(method.getReturnType())
				|| Tuple.class.isAssignableFrom(method.getReturnType())) {

			ParameterizedType listType = (ParameterizedType) method.getGenericReturnType();
			Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];

			if (ResultSetMapper.class.isAssignableFrom(listClass)) {

				@SuppressWarnings("unchecked")
				Class<ResultSetMapper<?>> rsMapperClass = (Class<ResultSetMapper<?>>) listClass;

				try {
					ResultSetMapper<?> resultSetMapper = rsMapperClass.newInstance();
					metadata.rsMapper = resultSetMapper;

					log.debug("setFromReturnType:: ResultSetMapper from Method return type is: {} for method: {}",
							resultSetMapper, method.getName());
				} catch (Exception e) {
					throw new CallException("cannot create resultSet Mapper", e);
				}
			}
		}
	}
}
