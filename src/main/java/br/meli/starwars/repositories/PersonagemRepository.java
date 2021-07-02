package br.meli.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.meli.starwars.entities.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class PersonagemRepository {
    private static final File FILE = new File("starwars.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Personagem> findAll() {
        return getDb();
    }

    public List<Personagem> getPerName(String name) {
        List<Personagem> db = getDb();
        List<Personagem> personagens = new ArrayList<>();

        for (Personagem personagem : db) {
            if (personagem.getName().toLowerCase(Locale.ROOT).contains(name)) {
                personagens.add(personagem);
            }
        }

        return personagens;

    }

    public List<Personagem> getDb() {
        List<Personagem> personagens = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Personagem>> typeReference = new TypeReference<>() {};
            personagens = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personagens;
    }
}
