package br.senac.tads.dsw.exemplospringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static PasswordEncoder plainPasswordEncoder() {
        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence cs) {
                return cs.toString();
            }

            @Override
            public boolean matches(CharSequence cs, String hashSenha) {
                return hashSenha
                        != null && hashSenha.equals(cs.toString());
            }
        };
    }

    public static PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.headers()
                .cacheControl().disable() // Desabilita controle de cache
                .frameOptions().sameOrigin() // evita problema ao abrir console do H2
            .and().csrf().disable()
                // 
                .authorizeRequests()
                    .antMatchers("/favicon/**", "/webjars/**", "/css/**", "/js/**", 
                            "/font/**", "/", "/index.html", "/h2-console/**").permitAll()
                    .antMatchers("/sessao/**").permitAll()
                    //.antMatchers("/protegido/peao").hasRole("PEAO") // OU .hasAuthority("ROLE_PEAO")
                    //.antMatchers("/protegido/fodon").hasRole("FODON")
                    //.antMatchers("/protegido/god").hasRole("GOD")
                    .anyRequest().authenticated()
            .and()
                .exceptionHandling()
                    .accessDeniedPage("/erro/403")
            .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("senha")
                    .defaultSuccessUrl("/home")
                    .permitAll()
            .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true);
        // @formatter:on
    }

}
