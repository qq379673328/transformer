package cn.com.sinosoft.tbf.config.app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 自定义json转换
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年8月4日
 */
@Configuration
public class JsonConfig extends WebMvcConfigurerAdapter {

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();
		setObjectMapper(objectMapper);
		// 放到第一个
		converters.add(0, jackson2HttpMessageConverter);
	}

	private void setObjectMapper(ObjectMapper om) {
		om.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);

		om.getDeserializationConfig()
				// 启用
				// 禁用
				.without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)// 未知属性不失败
				.without(MapperFeature.DEFAULT_VIEW_INCLUSION);

		// 自定义转换
		om.registerModule(new SimpleModule()
				// 自定义转换
				.addSerializer(BigDecimal.class, ToStringSerializer.instance)
				.addSerializer(Long.class, ToStringSerializer.instance)
				.addSerializer(Long.TYPE, ToStringSerializer.instance)
				.addSerializer(Float.class, ToStringSerializer.instance)
				.addSerializer(Float.TYPE, ToStringSerializer.instance)
				.addSerializer(Double.class, ToStringSerializer.instance)
				.addSerializer(Double.TYPE, ToStringSerializer.instance)
				.addSerializer(Integer.class, ToStringSerializer.instance)
				.addSerializer(Integer.TYPE, ToStringSerializer.instance)
				.addSerializer(BigDecimal.class, new JsonSerializer<BigDecimal>() {

					@Override
					public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers)
							throws IOException, JsonProcessingException {
						if (value == null)
							gen.writeString("");
						gen.writeString(value.toPlainString());
					}

				}));
		// 空值处理
		om.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
					throws IOException, JsonProcessingException {
				gen.writeString("");
			}

		});

	}

}
