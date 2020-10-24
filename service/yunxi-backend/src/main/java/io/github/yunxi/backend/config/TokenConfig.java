package io.github.yunxi.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    private String key="uaa123";
         /* @Bean
         public TokenStore tokenStore()
          {
              return new InMemoryTokenStore();
          }*/
         @Bean
         public TokenStore tokenStore(){
             return new JwtTokenStore(accessTokenConverter());
         }
         @Bean
    public JwtAccessTokenConverter accessTokenConverter()
         {
             JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
             jwtAccessTokenConverter.setSigningKey(key);
             return jwtAccessTokenConverter;
         }
}
