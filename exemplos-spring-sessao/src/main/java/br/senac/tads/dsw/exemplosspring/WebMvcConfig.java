package br.senac.tads.dsw.exemplosspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    public MessageSource messageSource;
   
    /*
     * Configura as mensagens para serem usadas com Bean Validation<br>
     * Referência:
     * https://www.baeldung.com/spring-custom-validation-message-source
     */
//    @Bean(name = "messageSource")
//    public ReloadableResourceBundleMessageSource messageSource() {
//        ReloadableResourceBundleMessageSource source
//                = new ReloadableResourceBundleMessageSource();
//        source.setBasename("classpath:i18n/mensagens");
//        source.setDefaultEncoding("UTF-8");
//        source.setCacheSeconds(0);
//        return source;
//    }

    @Bean
    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
    
//    @Bean(name = "localeResolver")
//    public CookieLocaleResolver localeResolver() {
//        CookieLocaleResolver clr = new CookieLocaleResolver();
//        clr.setDefaultLocale(new Locale("pt", "BR"));
//        return clr;
//    }
//
//    // Interceptador que permite trocar manualmente o idioma usado
//    @Bean(name = "localeChangeInterceptor")
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        return lci;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }
    
    
    /**
     * Define uma URL para acessar um diretório contendo as imagens<br>
     * Criar o diretório configurado no sistema.<br>
     * Referência: https://www.baeldung.com/spring-mvc-static-resources
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/arquivos-upload/**")
                .addResourceLocations("file:///C:/senac/servidor-upload/");
    }



}
