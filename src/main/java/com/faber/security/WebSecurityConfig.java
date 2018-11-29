package com.faber.security;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.connection.EnvironmentVariable;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable();//enable CORS
        http.csrf().disable();//enable CORS
        
//        http.addFilterAfter(new CustomSecurityFilter(), CsrfFilter.class);//Add custom security filter
//        http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());//Add custom access denied handler
//        http.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000);
//        http.headers().contentSecurityPolicy("default-src 'self' 'unsafe-inline'; img-src 'self' data:; media-src localhost; script-src 'self' 'unsafe-inline'; font-src 'self' fonts.gstatic.com; style-src 'self' 'unsafe-inline'  fonts.googleapis.com");//Add csp
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://" + EnvironmentVariable.getDomainAllowCORS(), "http://" + EnvironmentVariable.getDomainAllowCORS()));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
