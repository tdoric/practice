package practice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "app")
@PropertySource("classpath:application.properties")
@Configuration("appProperties")
public class AppProperties {
	
	int cordinate_x_max ;
	int cordinate_y_max ;
	int value_miliseconds;
	String msg_on_route;
	String msg_wrong_way;
	
	
	
	public int getCordinate_x_max() {
		return cordinate_x_max;
	}
	public void setCordinate_x_max(int cordinate_x_max) {
		this.cordinate_x_max = cordinate_x_max;
	}
	public int getCordinate_y_max() {
		return cordinate_y_max;
	}
	public void setCordinate_y_max(int cordinate_y_max) {
		this.cordinate_y_max = cordinate_y_max;
	}
	public int getValue_miliseconds() {
		return value_miliseconds;
	}
	public void setValue_miliseconds(int value_miliseconds) {
		this.value_miliseconds = value_miliseconds;
	}
	public String getMsg_on_route() {
		return msg_on_route;
	}
	public void setMsg_on_route(String msg_on_route) {
		this.msg_on_route = msg_on_route;
	}
	public String getMsg_wrong_way() {
		return msg_wrong_way;
	}
	public void setMsg_wrong_way(String msg_wrong_way) {
		this.msg_wrong_way = msg_wrong_way;
	}
	
	
	
	
	
	
	

}
