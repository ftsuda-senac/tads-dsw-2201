package br.senac.tads.dsw.exemplospost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

// https://www.baeldung.com/spring-bean-scopes
@Service
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DadosPessoaisServiceMock implements DadosPessoaisService {

    private Map<Integer, DadosPessoais> dados = new ConcurrentHashMap<>();

    private int currentId = 0;

    @Override
    public List<DadosPessoais> findAll() {
        return new ArrayList<>(dados.values());
    }

    @Override
    public DadosPessoais findById(Integer id) {
        return dados.get(id);
    }

    @Override
    public synchronized void save(DadosPessoais d) {
        d.setId(++currentId);
        dados.put(d.getId(), d);
    }

}
