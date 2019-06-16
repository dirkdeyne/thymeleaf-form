package wrk.esb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
  	http.csrf().disable()
  	  .authorizeRequests().anyRequest().authenticated()
  	  .and().httpBasic();
  	  //.and().addFilter(esbFilter());
  }
    
  @Bean
  public EsbFilter esbFilter() {
    return new EsbFilter();
  }
  
}
