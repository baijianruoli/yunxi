package io.github.yunxi.backend.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;
    private final String id="res1";
    @Override
    public void configure(ResourceServerSecurityConfigurer configurer)
    {
        configurer.resourceId(id)
                /*.tokenServices(tokenServices())//验证令牌的服务*/
                .tokenStore(tokenStore)
                .stateless(true);
    }
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
           httpSecurity.authorizeRequests()
                   .antMatchers("/put","/list").access("#oauth2.hasScope('all')")
                   .and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    /*@Bean
    public ResourceServerTokenServices tokenServices()
    {
        RemoteTokenServices services=new RemoteTokenServices();
        services.setCheckTokenEndpointUrl("http://localhost:8888/oauth/check_token");
        services.setClientId("c1");
        services.setClientSecret("secret");
        return services;
    }*/

}
