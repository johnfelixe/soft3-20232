package co.com.uniquindio.config.auth;

import co.com.uniquindio.model.usuario.Usuario;
import co.com.uniquindio.model.usuario.gateways.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Usuario user = usuarioRepository.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("userName", authentication.getName());
        info.put("usuario_id", user.getId());


        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
