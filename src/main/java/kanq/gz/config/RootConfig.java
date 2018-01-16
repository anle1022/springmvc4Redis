package kanq.gz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * 应用上下文
 * @author andy
 *
 */
@Configuration
@ComponentScan(basePackages={"kanq.gz"},excludeFilters={
		@Filter(type=FilterType.ANNOTATION,value=Controller.class),
		@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
})
@ImportResource("classpath:spring-*.xml")
@Order(1)
public class RootConfig {

}
